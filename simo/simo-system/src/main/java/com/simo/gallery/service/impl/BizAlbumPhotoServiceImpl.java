package com.simo.gallery.service.impl;

import java.util.List;
import com.simo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simo.gallery.mapper.BizAlbumPhotoMapper;
import com.simo.gallery.domain.BizAlbumPhoto;
import com.simo.gallery.service.IBizAlbumPhotoService;

/**
 * 相册图片关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@Service
public class BizAlbumPhotoServiceImpl implements IBizAlbumPhotoService 
{
    @Autowired
    private BizAlbumPhotoMapper bizAlbumPhotoMapper;

    /**
     * 查询相册图片关联
     * 
     * @param albumId 相册图片关联主键
     * @return 相册图片关联
     */
    @Override
    public BizAlbumPhoto selectBizAlbumPhotoByAlbumId(Long albumId)
    {
        return bizAlbumPhotoMapper.selectBizAlbumPhotoByAlbumId(albumId);
    }

    /**
     * 查询相册图片关联列表
     * 
     * @param bizAlbumPhoto 相册图片关联
     * @return 相册图片关联
     */
    @Override
    public List<BizAlbumPhoto> selectBizAlbumPhotoList(BizAlbumPhoto bizAlbumPhoto)
    {
        return bizAlbumPhotoMapper.selectBizAlbumPhotoList(bizAlbumPhoto);
    }

    /**
     * 新增相册图片关联
     * 
     * @param bizAlbumPhoto 相册图片关联
     * @return 结果
     */
    @Override
    public int insertBizAlbumPhoto(BizAlbumPhoto bizAlbumPhoto)
    {
        bizAlbumPhoto.setCreateTime(DateUtils.getNowDate());
        return bizAlbumPhotoMapper.insertBizAlbumPhoto(bizAlbumPhoto);
    }

    /**
     * 修改相册图片关联
     * 
     * @param bizAlbumPhoto 相册图片关联
     * @return 结果
     */
    @Override
    public int updateBizAlbumPhoto(BizAlbumPhoto bizAlbumPhoto)
    {
        return bizAlbumPhotoMapper.updateBizAlbumPhoto(bizAlbumPhoto);
    }

    /**
     * 批量删除相册图片关联
     * 
     * @param albumIds 需要删除的相册图片关联主键
     * @return 结果
     */
    @Override
    public int deleteBizAlbumPhotoByAlbumIds(Long[] albumIds)
    {
        return bizAlbumPhotoMapper.deleteBizAlbumPhotoByAlbumIds(albumIds);
    }

    /**
     * 删除相册图片关联信息
     * 
     * @param albumId 相册图片关联主键
     * @return 结果
     */
    @Override
    public int deleteBizAlbumPhotoByAlbumId(Long albumId)
    {
        return bizAlbumPhotoMapper.deleteBizAlbumPhotoByAlbumId(albumId);
    }
}
