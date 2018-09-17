/************************************************************************
 * 描述 ：数据库表APP_ATTACHMENT对应的DTO，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-24 14:49:33
 *
 ************************************************************************/

package com.yaic.app.common.dto.domain;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "app_attachment")
public class AttachmentDto implements Serializable {

    private static final long serialVersionUID = AttachmentDto.class.getName().hashCode();

    /** 附件ID */
    @Id
    private String attachmentId;
 

    /** 创建日期 */
    private Date createdDate;

    /** 创建人 */
    private String createdBy;

    /** 更新日期 */
    private Date updatedDate;

    /** 更新人 */
    private String updatedBy;

    /** 附件组ID */
    private String attachmentGroupId;

    /** 附件名称 */
    private String attachmentName;

    /** 附件文件路径 */
    private String attachmentPath;

    /** 附件来源 */
    private String attachmentSource;

    /** 显示顺序 */
    private Integer displayOrder;

    /** 备注 */
    private String remark;

    /** 其他标志 */
    private String flag;

    /**
     * 设置属性附件ID的值
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * 获取属性附件ID的值
     */     
    public String getAttachmentId() {
        return this.attachmentId;
    }

    /**
     * 设置属性创建日期的值
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取属性创建日期的值
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * 设置属性创建人的值
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取属性创建人的值
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * 设置属性更新日期的值
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 获取属性更新日期的值
     */
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    /**
     * 设置属性更新人的值
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取属性更新人的值
     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /**
     * 设置属性附件组ID的值
     */
    public void setAttachmentGroupId(String attachmentGroupId) {
        this.attachmentGroupId = attachmentGroupId;
    }

    /**
     * 获取属性附件组ID的值
     */
    public String getAttachmentGroupId() {
        return this.attachmentGroupId;
    }

    /**
     * 设置属性附件名称的值
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    /**
     * 获取属性附件名称的值
     */
    public String getAttachmentName() {
        return this.attachmentName;
    }

    /**
     * 设置属性附件文件路径的值
     */
    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    /**
     * 获取属性附件文件路径的值
     */
    public String getAttachmentPath() {
        return this.attachmentPath;
    }

    /**
     * 设置属性附件来源的值
     */
    public void setAttachmentSource(String attachmentSource) {
        this.attachmentSource = attachmentSource;
    }

    /**
     * 获取属性附件来源的值
     */
    public String getAttachmentSource() {
        return this.attachmentSource;
    }

    /**
     * 设置属性显示顺序的值
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * 获取属性显示顺序的值
     */
    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    /**
     * 设置属性备注的值
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取属性备注的值
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置属性其他标志的值
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取属性其他标志的值
     */
    public String getFlag() {
        return this.flag;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}