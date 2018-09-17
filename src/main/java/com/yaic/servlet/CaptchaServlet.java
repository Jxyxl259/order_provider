package com.yaic.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.yaic.servicelayer.random.RandomGenerator;
import com.yaic.servicelayer.util.RandomUtil;


/**
 * 创建验证码的servlet
 *
 * @author Qu Dihuai
 */
@WebServlet(urlPatterns =
{ "/servlet/captchaCode", "/common/captcha.jpg" })
public class CaptchaServlet extends HttpServlet
{
	private static final long serialVersionUID = 7427285854666759754L;

	private static final Logger LOG = LoggerFactory.getLogger(CaptchaServlet.class);

	private static final String KEY_CAPTCHA = "SE_KEY_MM_CODE";
	private static final String FONT_NAME = "Fixedsys";
	private static final int FONT_SIZE = 18;

	@Value("${user.servlet.captcha.width}")
	private int width;// 图片宽

	@Value("${user.servlet.captcha.height}")
	private int height;// 图片高

	@Value("${user.servlet.captcha.lineNum}")
	private int lineNum;// 干扰线数量

	@Value("${user.servlet.captcha.strNum}")
	private int strNum;// 随机产生字符数量

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
	{
		// 设置相应类型,告诉浏览器输出的内容为图片
		resp.setContentType("image/jpeg");
		// 不缓存此内容
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expire", 0);
		try
		{
			final HttpSession session = req.getSession();
			final StringBuffer code = new StringBuffer();
			final BufferedImage image = genRandomCodeImage(code);
			session.removeAttribute(KEY_CAPTCHA);
			session.setAttribute(KEY_CAPTCHA, code.toString());
			// 将内存中的图片通过流动形式输出到客户端
			ImageIO.write(image, "JPEG", resp.getOutputStream());
		}
		catch (final Exception e)
		{
			LOG.error("生成验证码出错", e);
		}

	}

	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req, resp);
	}

	/**
	 * 生成随机图片
	 *
	 * @param randomCode
	 * @return BufferedImage
	 */
	protected BufferedImage genRandomCodeImage(final StringBuffer randomCode)
	{
		// BufferedImage类是具有缓冲区的Image类
		final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 获取Graphics对象,便于对图像进行各种绘制操作
		final Graphics g = image.getGraphics();
		// 设置背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设置干扰线的颜色
		g.setColor(getRandColor(110, 120));

		// 绘制干扰线
		for (int i = 0; i <= lineNum; i++)
		{
			drowLine(g);
		}
		// 绘制随机字符
		g.setFont(new Font(FONT_NAME, Font.ROMAN_BASELINE, FONT_SIZE));
		for (int i = 1; i <= strNum; i++)
		{
			randomCode.append(drowString(g, i));
		}
		g.dispose();
		return image;
	}

	/**
	 * 给定范围获得随机颜色
	 */
	private Color getRandColor(int fc, int bc)
	{
		if (fc > 255)
		{
			fc = 255;
		}
		if (bc > 255)
		{
			bc = 255;
		}
		final int r = fc + RandomUtil.nextInt(bc - fc);
		final int g = fc + RandomUtil.nextInt(bc - fc);
		final int b = fc + RandomUtil.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * 绘制字符串
	 */
	private String drowString(final Graphics g, final int i)
	{
		g.setColor(new Color(RandomUtil.nextInt(101), RandomUtil.nextInt(111), RandomUtil.nextInt(121)));
		final String rand = RandomGenerator.getRandomChar();
		g.translate(RandomUtil.nextInt(3), RandomUtil.nextInt(3));
		g.drawString(rand, 13 * i, 16);
		return rand;
	}

	/**
	 * 绘制干扰线
	 */
	private void drowLine(final Graphics g)
	{
		final int x = RandomUtil.nextInt(width);
		final int y = RandomUtil.nextInt(height);
		final int x0 = RandomUtil.nextInt(16);
		final int y0 = RandomUtil.nextInt(16);
		g.drawLine(x, y, x + x0, y + y0);
	}

}
