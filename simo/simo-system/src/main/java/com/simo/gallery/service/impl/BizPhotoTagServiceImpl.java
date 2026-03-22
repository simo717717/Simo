package com.simo.gallery.service.impl;

import java.util.List;
import com.simo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simo.gallery.mapper.BizPhotoTagMapper;
import com.simo.gallery.domain.BizPhotoTag;
import com.simo.gallery.service.IBizPhotoTagService;

/**
 * 图片标签关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@Service
public class BizPhotoTagServiceImpl implements IBizPhotoTagService 
{
    @Autowired
    private BizPhotoTagMapper bizPhotoTagMapper;

    /**
     * 查询图片标签关联
     * 
     * @param photoId 图片标签关联主键
     * @return 图片标签关联
     */
    @Override
    public BizPhotoTag selectBizPhotoTagByPhotoId(Long photoId)
    {
        return bizPhotoTagMapper.selectBizPhotoTagByPhotoId(photoId);
    }

    /**
     * 查询图片标签关联列表
     * 
     * @param bizPhotoTag 图片标签关联
     * @return 图片标签关联
     */
    @Override
    public List<BizPhotoTag> selectBizPhotoTagList(BizPhotoTag bizPhotoTag)
    {
        return bizPhotoTagMapper.selectBizPhotoTagList(bizPhotoTag);
    }

    /**
     * 新增图片标签关联
     * 
     * @param bizPhotoTag 图片标签关联
     * @return 结果
     */
    @Override
    public int insertBizPhotoTag(BizPhotoTag bizPhotoTag)
    {
        bizPhotoTag.setCreateTime(DateUtils.getNowDate());
        return bizPhotoTagMapper.insertBizPhotoTag(bizPhotoTag);
    }

    /**
     * 修改图片标签关联
     * 
     * @param bizPhotoTag 图片标签关联
     * @return 结果
     */
    @Override
    public int updateBizPhotoTag(BizPhotoTag bizPhotoTag)
    {
        return bizPhotoTagMapper.updateBizPhotoTag(bizPhotoTag);
    }

    /**
     * 批量删除图片标签关联
     * 
     * @param photoIds 需要删除的图片标签关联主键
     * @return 结果
     */
    @Override
    public int deleteBizPhotoTagByPhotoIds(Long[] photoIds)
    {
        return bizPhotoTagMapper.deleteBizPhotoTagByPhotoIds(photoIds);
    }

    /**
     * 删除图片标签关联信息
     * 
     * @param photoId 图片标签关联主键
     * @return 结果
     */
    @Override
    public int deleteBizPhotoTagByPhotoId(Long photoId)
    {
        return bizPhotoTagMapper.deleteBizPhotoTagByPhotoId(photoId);
    }
}
