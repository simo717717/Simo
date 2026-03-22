package com.simo.gallery.service;

import java.util.List;
import com.simo.gallery.domain.BizPhoto;

/**
 * 图片核心信息Service接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface IBizPhotoService 
{
    /**
     * 查询图片核心信息
     * 
     * @param photoId 图片核心信息主键
     * @return 图片核心信息
     */
    public BizPhoto selectBizPhotoByPhotoId(Long photoId);

    /**
     * 查询图片核心信息列表
     * 
     * @param bizPhoto 图片核心信息
     * @return 图片核心信息集合
     */
    public List<BizPhoto> selectBizPhotoList(BizPhoto bizPhoto);

    /**
     * 新增图片核心信息
     * 
     * @param bizPhoto 图片核心信息
     * @return 结果
     */
    public int insertBizPhoto(BizPhoto bizPhoto);

    /**
     * 修改图片核心信息
     * 
     * @param bizPhoto 图片核心信息
     * @return 结果
     */
    public int updateBizPhoto(BizPhoto bizPhoto);

    /**
     * 批量删除图片核心信息
     * 
     * @param photoIds 需要删除的图片核心信息主键集合
     * @return 结果
     */
    public int deleteBizPhotoByPhotoIds(Long[] photoIds);

    /**
     * 删除图片核心信息信息
     * 
     * @param photoId 图片核心信息主键
     * @return 结果
     */
    public int deleteBizPhotoByPhotoId(Long photoId);
}
