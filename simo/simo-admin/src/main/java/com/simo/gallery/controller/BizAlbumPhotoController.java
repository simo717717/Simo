package com.simo.gallery.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simo.common.annotation.Log;
import com.simo.common.core.controller.BaseController;
import com.simo.common.core.domain.AjaxResult;
import com.simo.common.enums.BusinessType;
import com.simo.gallery.domain.BizAlbumPhoto;
import com.simo.gallery.service.IBizAlbumPhotoService;
import com.simo.common.utils.poi.ExcelUtil;
import com.simo.common.core.page.TableDataInfo;

/**
 * 相册图片关联Controller
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@RestController
@RequestMapping("/gallery/albumPhoto")
public class BizAlbumPhotoController extends BaseController
{
    @Autowired
    private IBizAlbumPhotoService bizAlbumPhotoService;

    /**
     * 查询相册图片关联列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:albumPhoto:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizAlbumPhoto bizAlbumPhoto)
    {
        startPage();
        List<BizAlbumPhoto> list = bizAlbumPhotoService.selectBizAlbumPhotoList(bizAlbumPhoto);
        return getDataTable(list);
    }

    /**
     * 导出相册图片关联列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:albumPhoto:export')")
    @Log(title = "相册图片关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizAlbumPhoto bizAlbumPhoto)
    {
        List<BizAlbumPhoto> list = bizAlbumPhotoService.selectBizAlbumPhotoList(bizAlbumPhoto);
        ExcelUtil<BizAlbumPhoto> util = new ExcelUtil<BizAlbumPhoto>(BizAlbumPhoto.class);
        util.exportExcel(response, list, "相册图片关联数据");
    }

    /**
     * 获取相册图片关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:albumPhoto:query')")
    @GetMapping(value = "/{albumId}")
    public AjaxResult getInfo(@PathVariable("albumId") Long albumId)
    {
        return success(bizAlbumPhotoService.selectBizAlbumPhotoByAlbumId(albumId));
    }

    /**
     * 新增相册图片关联
     */
    @PreAuthorize("@ss.hasPermi('gallery:albumPhoto:add')")
    @Log(title = "相册图片关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizAlbumPhoto bizAlbumPhoto)
    {
        return toAjax(bizAlbumPhotoService.insertBizAlbumPhoto(bizAlbumPhoto));
    }

    /**
     * 修改相册图片关联
     */
    @PreAuthorize("@ss.hasPermi('gallery:albumPhoto:edit')")
    @Log(title = "相册图片关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizAlbumPhoto bizAlbumPhoto)
    {
        return toAjax(bizAlbumPhotoService.updateBizAlbumPhoto(bizAlbumPhoto));
    }

    /**
     * 删除相册图片关联
     */
    @PreAuthorize("@ss.hasPermi('gallery:albumPhoto:remove')")
    @Log(title = "相册图片关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{albumIds}")
    public AjaxResult remove(@PathVariable Long[] albumIds)
    {
        return toAjax(bizAlbumPhotoService.deleteBizAlbumPhotoByAlbumIds(albumIds));
    }
}
