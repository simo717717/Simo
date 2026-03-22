package com.simo.gallery.service;

import java.util.List;
import com.simo.gallery.domain.BizAlbum;

/**
 * 相册管理Service接口
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public interface IBizAlbumService 
{
    /**
     * 查询相册管理
     * 
     * @param albumId 相册管理主键
     * @return 相册管理
     */
    public BizAlbum selectBizAlbumByAlbumId(Long albumId);

    /**
     * 查询相册管理列表
     * 
     * @param bizAlbum 相册管理
     * @return 相册管理集合
     */
    public List<BizAlbum> selectBizAlbumList(BizAlbum bizAlbum);

    /**
     * 新增相册管理
     * 
     * @param bizAlbum 相册管理
     * @return 结果
     */
    public int insertBizAlbum(BizAlbum bizAlbum);

    /**
     * 修改相册管理
     * 
     * @param bizAlbum 相册管理
     * @return 结果
     */
    public int updateBizAlbum(BizAlbum bizAlbum);

    /**
     * 批量删除相册管理
     * 
     * @param albumIds 需要删除的相册管理主键集合
     * @return 结果
     */
    public int deleteBizAlbumByAlbumIds(Long[] albumIds);

    /**
     * 删除相册管理信息
     * 
     * @param albumId 相册管理主键
     * @return 结果
     */
    public int deleteBizAlbumByAlbumId(Long albumId);
}
