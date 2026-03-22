package com.simo.gallery.service.impl;

import java.util.List;
import com.simo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simo.gallery.mapper.BizForumPostMapper;
import com.simo.gallery.domain.BizForumPost;
import com.simo.gallery.service.IBizForumPostService;

/**
 * 论坛帖子管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@Service
public class BizForumPostServiceImpl implements IBizForumPostService 
{
    @Autowired
    private BizForumPostMapper bizForumPostMapper;

    /**
     * 查询论坛帖子管理
     * 
     * @param postId 论坛帖子管理主键
     * @return 论坛帖子管理
     */
    @Override
    public BizForumPost selectBizForumPostByPostId(Long postId)
    {
        return bizForumPostMapper.selectBizForumPostByPostId(postId);
    }

    /**
     * 查询论坛帖子管理列表
     * 
     * @param bizForumPost 论坛帖子管理
     * @return 论坛帖子管理
     */
    @Override
    public List<BizForumPost> selectBizForumPostList(BizForumPost bizForumPost)
    {
        return bizForumPostMapper.selectBizForumPostList(bizForumPost);
    }

    /**
     * 新增论坛帖子管理
     * 
     * @param bizForumPost 论坛帖子管理
     * @return 结果
     */
    @Override
    public int insertBizForumPost(BizForumPost bizForumPost)
    {
        bizForumPost.setCreateTime(DateUtils.getNowDate());
        return bizForumPostMapper.insertBizForumPost(bizForumPost);
    }

    /**
     * 修改论坛帖子管理
     * 
     * @param bizForumPost 论坛帖子管理
     * @return 结果
     */
    @Override
    public int updateBizForumPost(BizForumPost bizForumPost)
    {
        bizForumPost.setUpdateTime(DateUtils.getNowDate());
        return bizForumPostMapper.updateBizForumPost(bizForumPost);
    }

    /**
     * 批量删除论坛帖子管理
     * 
     * @param postIds 需要删除的论坛帖子管理主键
     * @return 结果
     */
    @Override
    public int deleteBizForumPostByPostIds(Long[] postIds)
    {
        return bizForumPostMapper.deleteBizForumPostByPostIds(postIds);
    }

    /**
     * 删除论坛帖子管理信息
     * 
     * @param postId 论坛帖子管理主键
     * @return 结果
     */
    @Override
    public int deleteBizForumPostByPostId(Long postId)
    {
        return bizForumPostMapper.deleteBizForumPostByPostId(postId);
    }
}
