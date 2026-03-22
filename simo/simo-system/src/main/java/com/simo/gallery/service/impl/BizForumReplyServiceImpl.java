package com.simo.gallery.service.impl;

import java.util.List;
import com.simo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simo.gallery.mapper.BizForumReplyMapper;
import com.simo.gallery.domain.BizForumReply;
import com.simo.gallery.service.IBizForumReplyService;

/**
 * 论坛回复管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@Service
public class BizForumReplyServiceImpl implements IBizForumReplyService 
{
    @Autowired
    private BizForumReplyMapper bizForumReplyMapper;

    /**
     * 查询论坛回复管理
     * 
     * @param replyId 论坛回复管理主键
     * @return 论坛回复管理
     */
    @Override
    public BizForumReply selectBizForumReplyByReplyId(Long replyId)
    {
        return bizForumReplyMapper.selectBizForumReplyByReplyId(replyId);
    }

    /**
     * 查询论坛回复管理列表
     * 
     * @param bizForumReply 论坛回复管理
     * @return 论坛回复管理
     */
    @Override
    public List<BizForumReply> selectBizForumReplyList(BizForumReply bizForumReply)
    {
        return bizForumReplyMapper.selectBizForumReplyList(bizForumReply);
    }

    /**
     * 新增论坛回复管理
     * 
     * @param bizForumReply 论坛回复管理
     * @return 结果
     */
    @Override
    public int insertBizForumReply(BizForumReply bizForumReply)
    {
        bizForumReply.setCreateTime(DateUtils.getNowDate());
        return bizForumReplyMapper.insertBizForumReply(bizForumReply);
    }

    /**
     * 修改论坛回复管理
     * 
     * @param bizForumReply 论坛回复管理
     * @return 结果
     */
    @Override
    public int updateBizForumReply(BizForumReply bizForumReply)
    {
        return bizForumReplyMapper.updateBizForumReply(bizForumReply);
    }

    /**
     * 批量删除论坛回复管理
     * 
     * @param replyIds 需要删除的论坛回复管理主键
     * @return 结果
     */
    @Override
    public int deleteBizForumReplyByReplyIds(Long[] replyIds)
    {
        return bizForumReplyMapper.deleteBizForumReplyByReplyIds(replyIds);
    }

    /**
     * 删除论坛回复管理信息
     * 
     * @param replyId 论坛回复管理主键
     * @return 结果
     */
    @Override
    public int deleteBizForumReplyByReplyId(Long replyId)
    {
        return bizForumReplyMapper.deleteBizForumReplyByReplyId(replyId);
    }
}
