package com.simo.gallery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.simo.common.annotation.Excel;
import com.simo.common.core.domain.BaseEntity;

/**
 * 论坛帖子管理对象 biz_forum_post
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public class BizForumPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 帖子ID */
    private Long postId;

    /** 发帖人ID */
    @Excel(name = "发帖人ID")
    private Long userId;

    /** 帖子标题 */
    @Excel(name = "帖子标题")
    private String title;

    /** 帖子正文(富文本) */
    @Excel(name = "帖子正文(富文本)")
    private String content;

    /** 关联分享的摄影作品ID(可选) */
    @Excel(name = "关联分享的摄影作品ID(可选)")
    private Long sharePhotoId;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long viewCount;

    /** 删除标志 (0代表存在 2代表删除) */
    private String delFlag;

    public void setPostId(Long postId) 
    {
        this.postId = postId;
    }

    public Long getPostId() 
    {
        return postId;
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

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setSharePhotoId(Long sharePhotoId) 
    {
        this.sharePhotoId = sharePhotoId;
    }

    public Long getSharePhotoId() 
    {
        return sharePhotoId;
    }

    public void setViewCount(Long viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount() 
    {
        return viewCount;
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
            .append("postId", getPostId())
            .append("userId", getUserId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("sharePhotoId", getSharePhotoId())
            .append("viewCount", getViewCount())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
