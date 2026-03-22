package com.simo.gallery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.simo.common.annotation.Excel;
import com.simo.common.core.domain.BaseEntity;

/**
 * 相册图片关联对象 biz_album_photo
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public class BizAlbumPhoto extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 相册ID */
    private Long albumId;

    /** 图片ID */
    private Long photoId;

    public void setAlbumId(Long albumId) 
    {
        this.albumId = albumId;
    }

    public Long getAlbumId() 
    {
        return albumId;
    }

    public void setPhotoId(Long photoId) 
    {
        this.photoId = photoId;
    }

    public Long getPhotoId() 
    {
        return photoId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("albumId", getAlbumId())
            .append("photoId", getPhotoId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
