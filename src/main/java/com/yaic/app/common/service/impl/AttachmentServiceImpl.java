/************************************************************************
 * 描述 ：数据库表app_ATTACHMENT对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-24 14:49:33
 *
 ************************************************************************/

package com.yaic.app.common.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.yaic.app.Constants;
import com.yaic.app.common.dto.domain.AttachmentDto;
import com.yaic.app.common.service.AttachmentService;
import com.yaic.fa.service.BaseService;
import com.yaic.servicelayer.charset.StandardCharset;
import com.yaic.servicelayer.util.IOUtil;
import com.yaic.servicelayer.util.TimeUtil;

@Service("attachmentService")
public class AttachmentServiceImpl extends BaseService<AttachmentDto> implements AttachmentService {
	private static final Logger LOG = LoggerFactory.getLogger(AttachmentServiceImpl.class);
	
	private final String UPLOADFILEPATH = "fileUpload";

    /**
     * 上传附件返回方法 回调doCallBack(data)方法
     * 
     * @param response
     * @param object
     */
    @Override
    public void buildAndWriteUploadResponse(final HttpServletResponse response, Object object) {
        response.setContentType("text/html;charset=UTF-8");
        String responseJson = JSON.toJSONString(object);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            LOG.error("上传附件,回调方法时,发生异常!响应内容为{}", responseJson, e);
        }
        out.write("<script>window.parent.doCallBack(");
        out.write(responseJson.replaceAll("&quot;", "\\&quot;"));
        out.write(")</script>");
        out.flush();
        out.close();
    }

    /**
     * @Title: saveFiles
     * @Description: 保存附件
     * @param files
     * @param request
     * @param attachmentSource
     *            附件来源
     * @throws IllegalStateException
     * @throws IOException
     * @return String
     */
    @Override
    public String saveFiles(MultipartFile[] files, MultipartHttpServletRequest request, String attachmentSource) throws IllegalStateException,
            IOException {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute(Constants.LOGIN_USER_ID_KEY);

        String uploadPath = session.getServletContext().getRealPath(
                File.separator + UPLOADFILEPATH + File.separator + userId + File.separator + TimeUtil.format(new Date(),"yyyy-MM-dd"));
        File transFile = new File(uploadPath);
        // 判断文件路径 是否存在 不存在 则创建
        if (!transFile.exists()) {
            transFile.mkdirs();
        }
        int displayOrder = 1;
        String attachmentGroupId = UUID.randomUUID().toString().replaceAll("-", ""); // 保存一组附件的ID
        boolean retFlag = false;
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            // 过滤空附件
            if (file.getSize() <= 0) {
                continue;
            }
            // 附件上传
            file.transferTo(new File(uploadPath + File.separator + fileName));
            // 保存到附件表
            AttachmentDto attachmentDto = new AttachmentDto();
            attachmentDto.setAttachmentName(fileName);
            attachmentDto.setAttachmentPath(uploadPath + File.separator);
            attachmentDto.setAttachmentSource(attachmentSource);
            attachmentDto.setDisplayOrder(displayOrder);
            attachmentDto.setAttachmentGroupId(attachmentGroupId);
            attachmentDto.setCreatedBy(userId);
            attachmentDto.setUpdatedBy(userId);
            this.insertNotNull(attachmentDto);
            retFlag = true;
            displayOrder++;
        }

        if (retFlag) {
            return attachmentGroupId;
        } else {
            return null;
        }

    }

    /**
     * 下载单个附件
     * 
     * @param savePath
     * @param name
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @Override
    public String downSingle(String savePath, String name, String fileName, HttpServletRequest request, HttpServletResponse response) {
		InputStream fis = null;
		OutputStream bos = null;
		OutputStream toClient = null;
		
    	try {
            String path = savePath + File.separator + name;
            File file = new File(path);
            if (!file.exists()) {
                // 不存在
                LOG.error("File is not exist: {}", path);
                request.setAttribute("name", fileName);
                return "download_error";// 返回下载文件不存在
            }
            response.setContentType("application/octet-stream");
            // 根据不同浏览器 设置response的Header
            String userAgent = request.getHeader("User-Agent").toLowerCase();

            if (userAgent.indexOf("msie") != -1) {
                // ie浏览器
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, StandardCharset.UTF_8.name()));

            } else {
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes(StandardCharset.UTF_8), StandardCharset.ISO_8859_1));
            }

            response.addHeader("Content-Length", "" + file.length());
            // 以流的形式下载文件
            fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            toClient = response.getOutputStream();
            bos = new BufferedOutputStream(toClient);
            bos.write(buffer);
            return null;
        } catch (Exception e) {
			LOG.error("下载单个附件时发生异常, 请求信息为：savePath='{}', name='{}', requestURL='{}'.", savePath, name, request.getRequestURL());
			return "exception";// 返回异常页面
        } finally {
			IOUtil.closeQuietly(fis);
			IOUtil.closeQuietly(bos);
			IOUtil.closeQuietly(toClient);
		}
    }

}
