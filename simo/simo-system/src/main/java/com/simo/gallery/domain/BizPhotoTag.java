package com.simo.gallery.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.simo.common.annotation.Excel;
import com.simo.common.core.domain.BaseEntity;

/**
 * 图片标签关联对象 biz_photo_tag
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public class BizPhotoTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片ID */
    private Long photoId;

    /** 标签ID */
    private Long tagId;

    /** AI识别置信度 (0.0000-1.0000，手动打标默认为1) */
    @Excel(name = "AI识别置信度 (0.0000-1.0000，手动打标默认为1)")
    private BigDecimal confidence;

    public void setPhotoId(Long photoId) 
    {
        this.photoId = photoId;
    }

    public Long getPhotoId() 
    {
        return photoId;
    }

    public void setTagId(Long tagId) 
    {
        this.tagId = tagId;
    }

    public Long getTagId() 
    {
        return tagId;
    }

    public void setConfidence(BigDecimal confidence) 
    {
        this.confidence = confidence;
    }

    public BigDecimal getConfidence() 
    {
        return confidence;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("photoId", getPhotoId())
            .append("tagId", getTagId())
            .append("confidence", getConfidence())
            .append("createTime", getCreateTime())
            .toString();
    }
}
