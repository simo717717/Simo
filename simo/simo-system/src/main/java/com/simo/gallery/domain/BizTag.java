package com.simo.gallery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.simo.common.annotation.Excel;
import com.simo.common.core.domain.BaseEntity;

/**
 * 标签管理对象 biz_tag
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public class BizTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签ID */
    private Long tagId;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String tagName;

    /** 标签来源 (0:AI内容识别, 1:EXIF提取, 2:用户手动) */
    @Excel(name = "标签来源 (0:AI内容识别, 1:EXIF提取, 2:用户手动)")
    private String tagType;

    /** 删除标志 (0代表存在 2代表删除) */
    private String delFlag;

    public void setTagId(Long tagId) 
    {
        this.tagId = tagId;
    }

    public Long getTagId() 
    {
        return tagId;
    }

    public void setTagName(String tagName) 
    {
        this.tagName = tagName;
    }

    public String getTagName() 
    {
        return tagName;
    }

    public void setTagType(String tagType) 
    {
        this.tagType = tagType;
    }

    public String getTagType() 
    {
        return tagType;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tagId", getTagId())
            .append("tagName", getTagName())
            .append("tagType", getTagType())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
