package com.simo.gallery.mapper;

import java.util.List;
import com.simo.gallery.domain.BizPhotoTag;

/**
 * 图片标签关联Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface BizPhotoTagMapper 
{
    /**
     * 查询图片标签关联
     * 
     * @param photoId 图片标签关联主键
     * @return 图片标签关联
     */
    public BizPhotoTag selectBizPhotoTagByPhotoId(Long photoId);

    /**
     * 查询图片标签关联列表
     * 
     * @param bizPhotoTag 图片标签关联
     * @return 图片标签关联集合
     */
    public List<BizPhotoTag> selectBizPhotoTagList(BizPhotoTag bizPhotoTag);

    /**
     * 新增图片标签关联
     * 
     * @param bizPhotoTag 图片标签关联
     * @return 结果
     */
    public int insertBizPhotoTag(BizPhotoTag bizPhotoTag);

    /**
     * 修改图片标签关联
     * 
     * @param bizPhotoTag 图片标签关联
     * @return 结果
     */
    public int updateBizPhotoTag(BizPhotoTag bizPhotoTag);

    /**
     * 删除图片标签关联
     * 
     * @param photoId 图片标签关联主键
     * @return 结果
     */
    public int deleteBizPhotoTagByPhotoId(Long photoId);

    /**
     * 批量删除图片标签关联
     * 
     * @param photoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizPhotoTagByPhotoIds(Long[] photoIds);
}
