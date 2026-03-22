package com.simo.gallery.service.impl;

import java.util.List;
import com.simo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simo.gallery.mapper.BizAlbumMapper;
import com.simo.gallery.domain.BizAlbum;
import com.simo.gallery.service.IBizAlbumService;

/**
 * 相册管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@Service
public class BizAlbumServiceImpl implements IBizAlbumService 
{
    @Autowired
    private BizAlbumMapper bizAlbumMapper;

    /**
     * 查询相册管理
     * 
     * @param albumId 相册管理主键
     * @return 相册管理
     */
    @Override
    public BizAlbum selectBizAlbumByAlbumId(Long albumId)
    {
        return bizAlbumMapper.selectBizAlbumByAlbumId(albumId);
    }

    /**
     * 查询相册管理列表
     * 
     * @param bizAlbum 相册管理
     * @return 相册管理
     */
    @Override
    public List<BizAlbum> selectBizAlbumList(BizAlbum bizAlbum)
    {
        return bizAlbumMapper.selectBizAlbumList(bizAlbum);
    }

    /**
     * 新增相册管理
     * 
     * @param bizAlbum 相册管理
     * @return 结果
     */
    @Override
    public int insertBizAlbum(BizAlbum bizAlbum)
    {
        bizAlbum.setCreateTime(DateUtils.getNowDate());
        return bizAlbumMapper.insertBizAlbum(bizAlbum);
    }

    /**
     * 修改相册管理
     * 
     * @param bizAlbum 相册管理
     * @return 结果
     */
    @Override
    public int updateBizAlbum(BizAlbum bizAlbum)
    {
        bizAlbum.setUpdateTime(DateUtils.getNowDate());
        return bizAlbumMapper.updateBizAlbum(bizAlbum);
    }

    /**
     * 批量删除相册管理
     * 
     * @param albumIds 需要删除的相册管理主键
     * @return 结果
     */
    @Override
    public int deleteBizAlbumByAlbumIds(Long[] albumIds)
    {
        return bizAlbumMapper.deleteBizAlbumByAlbumIds(albumIds);
    }

    /**
     * 删除相册管理信息
     * 
     * @param albumId 相册管理主键
     * @return 结果
     */
    @Override
    public int deleteBizAlbumByAlbumId(Long albumId)
    {
        return bizAlbumMapper.deleteBizAlbumByAlbumId(albumId);
    }
}
