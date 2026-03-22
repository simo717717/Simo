package com.simo.gallery.mapper;

import java.util.List;
import com.simo.gallery.domain.BizForumPost;

/**
 * 论坛帖子管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface BizForumPostMapper 
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
     * 删除论坛帖子管理
     * 
     * @param postId 论坛帖子管理主键
     * @return 结果
     */
    public int deleteBizForumPostByPostId(Long postId);

    /**
     * 批量删除论坛帖子管理
     * 
     * @param postIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizForumPostByPostIds(Long[] postIds);
}
