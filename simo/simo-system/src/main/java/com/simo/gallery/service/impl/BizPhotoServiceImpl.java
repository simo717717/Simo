package com.simo.gallery.service.impl;

import java.util.List;
import com.simo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simo.gallery.mapper.BizPhotoMapper;
import com.simo.gallery.domain.BizPhoto;
import com.simo.gallery.service.IBizPhotoService;

/**
 * 图片核心信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@Service
public class BizPhotoServiceImpl implements IBizPhotoService 
{
    @Autowired
    private BizPhotoMapper bizPhotoMapper;

    /**
     * 查询图片核心信息
     * 
     * @param photoId 图片核心信息主键
     * @return 图片核心信息
     */
    @Override
    public BizPhoto selectBizPhotoByPhotoId(Long photoId)
    {
        return bizPhotoMapper.selectBizPhotoByPhotoId(photoId);
    }

    /**
     * 查询图片核心信息列表
     * 
     * @param bizPhoto 图片核心信息
     * @return 图片核心信息
     */
    @Override
    public List<BizPhoto> selectBizPhotoList(BizPhoto bizPhoto)
    {
        return bizPhotoMapper.selectBizPhotoList(bizPhoto);
    }

    /**
     * 新增图片核心信息
     * 
     * @param bizPhoto 图片核心信息
     * @return 结果
     */
    @Override
    public int insertBizPhoto(BizPhoto bizPhoto)
    {
        bizPhoto.setCreateTime(DateUtils.getNowDate());
        return bizPhotoMapper.insertBizPhoto(bizPhoto);
    }

    /**
     * 修改图片核心信息
     * 
     * @param bizPhoto 图片核心信息
     * @return 结果
     */
    @Override
    public int updateBizPhoto(BizPhoto bizPhoto)
    {
        bizPhoto.setUpdateTime(DateUtils.getNowDate());
        return bizPhotoMapper.updateBizPhoto(bizPhoto);
    }

    /**
     * 批量删除图片核心信息
     * 
     * @param photoIds 需要删除的图片核心信息主键
     * @return 结果
     */
    @Override
    public int deleteBizPhotoByPhotoIds(Long[] photoIds)
    {
        return bizPhotoMapper.deleteBizPhotoByPhotoIds(photoIds);
    }

    /**
     * 删除图片核心信息信息
     * 
     * @param photoId 图片核心信息主键
     * @return 结果
     */
    @Override
    public int deleteBizPhotoByPhotoId(Long photoId)
    {
        return bizPhotoMapper.deleteBizPhotoByPhotoId(photoId);
    }
}
