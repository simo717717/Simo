package com.simo.gallery.service;

import java.util.List;
import com.simo.gallery.domain.BizPhotoExif;

/**
 * 图片EXIF参数Service接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface IBizPhotoExifService 
{
    /**
     * 查询图片EXIF参数
     * 
     * @param photoId 图片EXIF参数主键
     * @return 图片EXIF参数
     */
    public BizPhotoExif selectBizPhotoExifByPhotoId(Long photoId);

    /**
     * 查询图片EXIF参数列表
     * 
     * @param bizPhotoExif 图片EXIF参数
     * @return 图片EXIF参数集合
     */
    public List<BizPhotoExif> selectBizPhotoExifList(BizPhotoExif bizPhotoExif);

    /**
     * 新增图片EXIF参数
     * 
     * @param bizPhotoExif 图片EXIF参数
     * @return 结果
     */
    public int insertBizPhotoExif(BizPhotoExif bizPhotoExif);

    /**
     * 修改图片EXIF参数
     * 
     * @param bizPhotoExif 图片EXIF参数
     * @return 结果
     */
    public int updateBizPhotoExif(BizPhotoExif bizPhotoExif);

    /**
     * 批量删除图片EXIF参数
     * 
     * @param photoIds 需要删除的图片EXIF参数主键集合
     * @return 结果
     */
    public int deleteBizPhotoExifByPhotoIds(Long[] photoIds);

    /**
     * 删除图片EXIF参数信息
     * 
     * @param photoId 图片EXIF参数主键
     * @return 结果
     */
    public int deleteBizPhotoExifByPhotoId(Long photoId);
}
