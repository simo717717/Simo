package com.simo.gallery.service;

import java.util.List;
import com.simo.gallery.domain.BizForumPost;

/**
 * 论坛帖子管理Service接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface IBizForumPostService 
{
    /**
     * 查询论坛帖子管理
     * 
     * @param postId 论坛帖子管理主键
     * @return 论坛帖子管理
     */
    public BizForumPost selectBizForumPostByPostId(Long postId);

    /**
     * 查询论坛帖子管理列表
     * 
     * @param bizForumPost 论坛帖子管理
     * @return 论坛帖子管理集合
     */
    public List<BizForumPost> selectBizForumPostList(BizForumPost bizForumPost);

    /**
     * 新增论坛帖子管理
     * 
     * @param bizForumPost 论坛帖子管理
     * @return 结果
     */
    public int insertBizForumPost(BizForumPost bizForumPost);

    /**
     * 修改论坛帖子管理
     * 
     * @param bizForumPost 论坛帖子管理
     * @return 结果
     */
    public int updateBizForumPost(BizForumPost bizForumPost);

    /**
     * 批量删除论坛帖子管理
     * 
     * @param postIds 需要删除的论坛帖子管理主键集合
     * @return 结果
     */
    public int deleteBizForumPostByPostIds(Long[] postIds);

    /**
     * 删除论坛帖子管理信息
     * 
     * @param postId 论坛帖子管理主键
     * @return 结果
     */
    public int deleteBizForumPostByPostId(Long postId);
}
