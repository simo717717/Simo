package com.simo.gallery.service;

import java.util.List;
import com.simo.gallery.domain.BizForumReply;

/**
 * 论坛回复管理Service接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface IBizForumReplyService 
{
    /**
     * 查询论坛回复管理
     * 
     * @param replyId 论坛回复管理主键
     * @return 论坛回复管理
     */
    public BizForumReply selectBizForumReplyByReplyId(Long replyId);

    /**
     * 查询论坛回复管理列表
     * 
     * @param bizForumReply 论坛回复管理
     * @return 论坛回复管理集合
     */
    public List<BizForumReply> selectBizForumReplyList(BizForumReply bizForumReply);

    /**
     * 新增论坛回复管理
     * 
     * @param bizForumReply 论坛回复管理
     * @return 结果
     */
    public int insertBizForumReply(BizForumReply bizForumReply);

    /**
     * 修改论坛回复管理
     * 
     * @param bizForumReply 论坛回复管理
     * @return 结果
     */
    public int updateBizForumReply(BizForumReply bizForumReply);

    /**
     * 批量删除论坛回复管理
     * 
     * @param replyIds 需要删除的论坛回复管理主键集合
     * @return 结果
     */
    public int deleteBizForumReplyByReplyIds(Long[] replyIds);

    /**
     * 删除论坛回复管理信息
     * 
     * @param replyId 论坛回复管理主键
     * @return 结果
     */
    public int deleteBizForumReplyByReplyId(Long replyId);
}
