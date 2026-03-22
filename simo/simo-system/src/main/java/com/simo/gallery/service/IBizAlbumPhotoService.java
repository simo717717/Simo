package com.simo.gallery.service;

import java.util.List;
import com.simo.gallery.domain.BizAlbumPhoto;

/**
 * 相册图片关联Service接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface IBizAlbumPhotoService 
{
    /**
     * 查询相册图片关联
     * 
     * @param albumId 相册图片关联主键
     * @return 相册图片关联
     */
    public BizAlbumPhoto selectBizAlbumPhotoByAlbumId(Long albumId);

    /**
     * 查询相册图片关联列表
     * 
     * @param bizAlbumPhoto 相册图片关联
     * @return 相册图片关联集合
     */
    public List<BizAlbumPhoto> selectBizAlbumPhotoList(BizAlbumPhoto bizAlbumPhoto);

    /**
     * 新增相册图片关联
     * 
     * @param bizAlbumPhoto 相册图片关联
     * @return 结果
     */
    public int insertBizAlbumPhoto(BizAlbumPhoto bizAlbumPhoto);

    /**
     * 修改相册图片关联
     * 
     * @param bizAlbumPhoto 相册图片关联
     * @return 结果
     */
    public int updateBizAlbumPhoto(BizAlbumPhoto bizAlbumPhoto);

    /**
     * 批量删除相册图片关联
     * 
     * @param albumIds 需要删除的相册图片关联主键集合
     * @return 结果
     */
    public int deleteBizAlbumPhotoByAlbumIds(Long[] albumIds);

    /**
     * 删除相册图片关联信息
     * 
     * @param albumId 相册图片关联主键
     * @return 结果
     */
    public int deleteBizAlbumPhotoByAlbumId(Long albumId);
}
