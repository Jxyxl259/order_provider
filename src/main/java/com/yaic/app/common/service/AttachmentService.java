/************************************************************************
 * 描述 ：数据库表app_ATTACHMENT对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-24 14:49:33
 *
 ************************************************************************/

package com.yaic.app.common.service;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yaic.app.common.dto.domain.AttachmentDto;
import com.yaic.fa.service.IBaseService;

public interface AttachmentService extends IBaseService<AttachmentDto> {

    /**
     * 上传附件返回方法
     * 回调doCallBack(data)方法
     * @param response
     * @param object
     */
    public void buildAndWriteUploadResponse(final HttpServletResponse response, Object object);

    /**
     * @Title: saveFiles 
     * @Description: 保存附件
     * @param files
     * @param request
     * @param attachmentSource 附件来源
     * @throws IllegalStateException
     * @throws IOException 
     * @return String   
     */
    public String saveFiles(MultipartFile[] files, MultipartHttpServletRequest request, String attachmentSource)
            throws IllegalStateException, IOException;

    /**
     * 下载单个附件
     * @param savePath
     * @param name
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    public String downSingle(String savePath, String name, String fileName, HttpServletRequest request,
            HttpServletResponse response);

}
