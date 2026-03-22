package com.simo.gallery.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simo.gallery.mapper.BizPhotoExifMapper;
import com.simo.gallery.domain.BizPhotoExif;
import com.simo.gallery.service.IBizPhotoExifService;

/**
 * 图片EXIF参数Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@Service
public class BizPhotoExifServiceImpl implements IBizPhotoExifService 
{
    @Autowired
    private BizPhotoExifMapper bizPhotoExifMapper;

    /**
     * 查询图片EXIF参数
     * 
     * @param photoId 图片EXIF参数主键
     * @return 图片EXIF参数
     */
    @Override
    public BizPhotoExif selectBizPhotoExifByPhotoId(Long photoId)
    {
        return bizPhotoExifMapper.selectBizPhotoExifByPhotoId(photoId);
    }

    /**
     * 查询图片EXIF参数列表
     * 
     * @param bizPhotoExif 图片EXIF参数
     * @return 图片EXIF参数
     */
    @Override
    public List<BizPhotoExif> selectBizPhotoExifList(BizPhotoExif bizPhotoExif)
    {
        return bizPhotoExifMapper.selectBizPhotoExifList(bizPhotoExif);
    }

    /**
     * 新增图片EXIF参数
     * 
     * @param bizPhotoExif 图片EXIF参数
     * @return 结果
     */
    @Override
    public int insertBizPhotoExif(BizPhotoExif bizPhotoExif)
    {
        return bizPhotoExifMapper.insertBizPhotoExif(bizPhotoExif);
    }

    /**
     * 修改图片EXIF参数
     * 
     * @param bizPhotoExif 图片EXIF参数
     * @return 结果
     */
    @Override
    public int updateBizPhotoExif(BizPhotoExif bizPhotoExif)
    {
        return bizPhotoExifMapper.updateBizPhotoExif(bizPhotoExif);
    }

    /**
     * 批量删除图片EXIF参数
     * 
     * @param photoIds 需要删除的图片EXIF参数主键
     * @return 结果
     */
    @Override
    public int deleteBizPhotoExifByPhotoIds(Long[] photoIds)
    {
        return bizPhotoExifMapper.deleteBizPhotoExifByPhotoIds(photoIds);
    }

    /**
     * 删除图片EXIF参数信息
     * 
     * @param photoId 图片EXIF参数主键
     * @return 结果
     */
    @Override
    public int deleteBizPhotoExifByPhotoId(Long photoId)
    {
        return bizPhotoExifMapper.deleteBizPhotoExifByPhotoId(photoId);
    }
}
