/************************************************************************
 * 描述 ：数据库表app_ATTACHMENT对应的表单对象，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-24 14:49:33
 *
 ************************************************************************/

package com.yaic.app.common.form;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yaic.app.common.dto.domain.AttachmentDto;

public class AttachmentForm extends AttachmentDto {

    private static final long serialVersionUID = AttachmentForm.class.getName().hashCode();
    
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
