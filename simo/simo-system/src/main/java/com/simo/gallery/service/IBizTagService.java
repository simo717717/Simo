package com.simo.gallery.service;

import java.util.List;
import com.simo.gallery.domain.BizTag;

/**
 * 标签管理Service接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface IBizTagService 
{
    /**
     * 查询标签管理
     * 
     * @param tagId 标签管理主键
     * @return 标签管理
     */
    public BizTag selectBizTagByTagId(Long tagId);

    /**
     * 查询标签管理列表
     * 
     * @param bizTag 标签管理
     * @return 标签管理集合
     */
    public List<BizTag> selectBizTagList(BizTag bizTag);

    /**
     * 新增标签管理
     * 
     * @param bizTag 标签管理
     * @return 结果
     */
    public int insertBizTag(BizTag bizTag);

    /**
     * 修改标签管理
     * 
     * @param bizTag 标签管理
     * @return 结果
     */
    public int updateBizTag(BizTag bizTag);

    /**
     * 批量删除标签管理
     * 
     * @param tagIds 需要删除的标签管理主键集合
     * @return 结果
     */
    public int deleteBizTagByTagIds(Long[] tagIds);

    /**
     * 删除标签管理信息
     * 
     * @param tagId 标签管理主键
     * @return 结果
     */
    public int deleteBizTagByTagId(Long tagId);
}
