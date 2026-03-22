package com.simo.gallery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.simo.common.annotation.Excel;
import com.simo.common.core.domain.BaseEntity;

/**
 * 图片核心信息对象 biz_photo
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public class BizPhoto extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片主键ID */
    private Long photoId;

    /** 上传者ID (关联系统表 sys_user) */
    @Excel(name = "上传者ID (关联系统表 sys_user)")
    private Long userId;

    /** 图片标题 */
    @Excel(name = "图片标题")
    private String title;

    /** 图片描述 */
    @Excel(name = "图片描述")
    private String description;

    /** 文件OSS或本地存储路径 */
    @Excel(name = "文件OSS或本地存储路径")
    private String filePath;

    /** 文件后缀格式 (JPG, PNG, RAW) */
    @Excel(name = "文件后缀格式 (JPG, PNG, RAW)")
    private String fileType;

    /** 文件大小(字节) */
    @Excel(name = "文件大小(字节)")
    private Long fileSize;

    /** 权限级别 (0:公开, 1:私有, 2:指定好友可见, 3:仅链接可见) */
    @Excel(name = "权限级别 (0:公开, 1:私有, 2:指定好友可见, 3:仅链接可见)")
    private String permissionLevel;

    /** AI处理状态 (0:未分析, 1:分析完成, 2:解析失败) */
    @Excel(name = "AI处理状态 (0:未分析, 1:分析完成, 2:解析失败)")
    private String aiStatus;

    /** 删除标志 (0代表存在 2代表删除) */
    private String delFlag;

    public void setPhotoId(Long photoId) 
    {
        this.photoId = photoId;
    }

    public Long getPhotoId() 
    {
        return photoId;
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

    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }

    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }

    public void setFileSize(Long fileSize) 
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize() 
    {
        return fileSize;
    }

    public void setPermissionLevel(String permissionLevel) 
    {
        this.permissionLevel = permissionLevel;
    }

    public String getPermissionLevel() 
    {
        return permissionLevel;
    }

    public void setAiStatus(String aiStatus) 
    {
        this.aiStatus = aiStatus;
    }

    public String getAiStatus() 
    {
        return aiStatus;
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
            .append("photoId", getPhotoId())
            .append("userId", getUserId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("filePath", getFilePath())
            .append("fileType", getFileType())
            .append("fileSize", getFileSize())
            .append("permissionLevel", getPermissionLevel())
            .append("aiStatus", getAiStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
