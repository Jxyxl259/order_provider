package com.yaic.app.pubs.dto.msg;

import java.util.List;
import java.util.Map;

public class MailRequestDto {

    /** 主键ID */
    private Integer emailId;

    /** 模块编号 */
    private String moduleId;

    /** 业务方式 */
    private String businessType;

    /** 业务单号 */
    private String businessNo;

    /** 业务单号2 */
    private String businessNo2;

    /** 业务单号3 */
    private String businessNo3;

    /** 业务单号4 */
    private String businessNo4;

    /** 业务单号5 */
    private String businessNo5;

    /** 是否即时发送 0:否,1:是 */
    private String isTime;

    /** 模板编号 */
    private String templateId;

    /** 模板MODEL(JSON格式) */
    private String templateModel;
    
    /** 模板内容 */
    private String templateContent;

    /** 发件人昵称 */
    private String emailNickName;

    /** 发件人 */
    private String emailFrom;

    /** 收件人 */
    private String emailTo;

    /** 抄送人 */
    private String emailCc;

    /** 密送人 */
    private String emailBcc;

    /** 主题 */
    private String subject;

    /** 邮件内容 */
    private String emailContent;

    /** 邮件配置(JSON格式) */
    private String emailConfig;

    /** 扩展字段AA */
    private String fieldAa;

    /** 扩展字段AB */
    private String fieldAb;

    /** 扩展字段AC */
    private String fieldAc;

    /** 图片数组 */
    private List<Map<String, String>> emailImages;

    /** 附件数组 */
    private List<Map<String, String>> emailFiles;

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBusinessNo2() {
        return businessNo2;
    }

    public void setBusinessNo2(String businessNo2) {
        this.businessNo2 = businessNo2;
    }

    public String getBusinessNo3() {
        return businessNo3;
    }

    public void setBusinessNo3(String businessNo3) {
        this.businessNo3 = businessNo3;
    }

    public String getBusinessNo4() {
        return businessNo4;
    }

    public void setBusinessNo4(String businessNo4) {
        this.businessNo4 = businessNo4;
    }

    public String getBusinessNo5() {
        return businessNo5;
    }

    public void setBusinessNo5(String businessNo5) {
        this.businessNo5 = businessNo5;
    }

    public String getIsTime() {
        return isTime;
    }

    public void setIsTime(String isTime) {
        this.isTime = isTime;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateModel() {
        return templateModel;
    }

    public void setTemplateModel(String templateModel) {
        this.templateModel = templateModel;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public String getEmailNickName() {
        return emailNickName;
    }

    public void setEmailNickName(String emailNickName) {
        this.emailNickName = emailNickName;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailCc() {
        return emailCc;
    }

    public void setEmailCc(String emailCc) {
        this.emailCc = emailCc;
    }

    public String getEmailBcc() {
        return emailBcc;
    }

    public void setEmailBcc(String emailBcc) {
        this.emailBcc = emailBcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getEmailConfig() {
        return emailConfig;
    }

    public void setEmailConfig(String emailConfig) {
        this.emailConfig = emailConfig;
    }

    public String getFieldAa() {
        return fieldAa;
    }

    public void setFieldAa(String fieldAa) {
        this.fieldAa = fieldAa;
    }

    public String getFieldAb() {
        return fieldAb;
    }

    public void setFieldAb(String fieldAb) {
        this.fieldAb = fieldAb;
    }

    public String getFieldAc() {
        return fieldAc;
    }

    public void setFieldAc(String fieldAc) {
        this.fieldAc = fieldAc;
    }

    public List<Map<String, String>> getEmailImages() {
        return emailImages;
    }

    public void setEmailImages(List<Map<String, String>> emailImages) {
        this.emailImages = emailImages;
    }

    public List<Map<String, String>> getEmailFiles() {
        return emailFiles;
    }

    public void setEmailFiles(List<Map<String, String>> emailFiles) {
        this.emailFiles = emailFiles;
    }

}
