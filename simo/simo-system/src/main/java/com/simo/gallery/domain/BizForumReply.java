package com.simo.gallery.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.simo.common.annotation.Excel;
import com.simo.common.core.domain.BaseEntity;

/**
 * 论坛回复管理对象 biz_forum_reply
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public class BizForumReply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 回复ID */
    private Long replyId;

    /** 所属帖子ID */
    @Excel(name = "所属帖子ID")
    private Long postId;

    /** 父回复ID(支持楼中楼，0为顶层回复) */
    @Excel(name = "父回复ID(支持楼中楼，0为顶层回复)")
    private Long parentId;

    /** 回复人ID */
    @Excel(name = "回复人ID")
    private Long userId;

    /** 回复内容 */
    @Excel(name = "回复内容")
    private String content;

    /** 删除标志 (0代表存在 2代表删除) */
    private String delFlag;

    public void setReplyId(Long replyId) 
    {
        this.replyId = replyId;
    }

    public Long getReplyId() 
    {
        return replyId;
    }

    public void setPostId(Long postId) 
    {
        this.postId = postId;
    }

    public Long getPostId() 
    {
        return postId;
    }

    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
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
            .append("replyId", getReplyId())
            .append("postId", getPostId())
            .append("parentId", getParentId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .toString();
    }
}
