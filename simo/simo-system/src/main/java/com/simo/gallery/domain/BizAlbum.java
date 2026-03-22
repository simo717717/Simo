package com.simo.gallery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.simo.common.annotation.Excel;
import com.simo.common.core.domain.BaseEntity;

/**
 * 相册管理对象 biz_album
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public class BizAlbum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 相册ID */
    private Long albumId;

    /** 所属用户ID */
    @Excel(name = "所属用户ID")
    private Long userId;

    /** 相册名称 */
    @Excel(name = "相册名称")
    private String title;

    /** 相册描述 */
    @Excel(name = "相册描述")
    private String description;

    /** 封面图片ID */
    @Excel(name = "封面图片ID")
    private Long coverPhotoId;

    /** 相册类型 (0:用户自建, 1:AI智能聚类) */
    @Excel(name = "相册类型 (0:用户自建, 1:AI智能聚类)")
    private String albumType;

    /** 删除标志 (0代表存在 2代表删除) */
    private String delFlag;

    public void setAlbumId(Long albumId) 
    {
        this.albumId = albumId;
    }

    public Long getAlbumId() 
    {
        return albumId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setCoverPhotoId(Long coverPhotoId) 
    {
        this.coverPhotoId = coverPhotoId;
    }

    public Long getCoverPhotoId() 
    {
        return coverPhotoId;
    }

    public void setAlbumType(String albumType) 
    {
        this.albumType = albumType;
    }

    public String getAlbumType() 
    {
        return albumType;
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
            .append("albumId", getAlbumId())
            .append("userId", getUserId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("coverPhotoId", getCoverPhotoId())
            .append("albumType", getAlbumType())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
