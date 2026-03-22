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
import com.simo.gallery.domain.BizAlbum;
import com.simo.gallery.service.IBizAlbumService;
import com.simo.common.utils.poi.ExcelUtil;
import com.simo.common.core.page.TableDataInfo;

/**
 * 相册管理Controller
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@RestController
@RequestMapping("/gallery/album")
public class BizAlbumController extends BaseController
{
    @Autowired
    private IBizAlbumService bizAlbumService;

    /**
     * 查询相册管理列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:album:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizAlbum bizAlbum)
    {
        startPage();
        List<BizAlbum> list = bizAlbumService.selectBizAlbumList(bizAlbum);
        return getDataTable(list);
    }

    /**
     * 导出相册管理列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:album:export')")
    @Log(title = "相册管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizAlbum bizAlbum)
    {
        List<BizAlbum> list = bizAlbumService.selectBizAlbumList(bizAlbum);
        ExcelUtil<BizAlbum> util = new ExcelUtil<BizAlbum>(BizAlbum.class);
        util.exportExcel(response, list, "相册管理数据");
    }

    /**
     * 获取相册管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:album:query')")
    @GetMapping(value = "/{albumId}")
    public AjaxResult getInfo(@PathVariable("albumId") Long albumId)
    {
        return success(bizAlbumService.selectBizAlbumByAlbumId(albumId));
    }

    /**
     * 新增相册管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:album:add')")
    @Log(title = "相册管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizAlbum bizAlbum)
    {
        return toAjax(bizAlbumService.insertBizAlbum(bizAlbum));
    }

    /**
     * 修改相册管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:album:edit')")
    @Log(title = "相册管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizAlbum bizAlbum)
    {
        return toAjax(bizAlbumService.updateBizAlbum(bizAlbum));
    }

    /**
     * 删除相册管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:album:remove')")
    @Log(title = "相册管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{albumIds}")
    public AjaxResult remove(@PathVariable Long[] albumIds)
    {
        return toAjax(bizAlbumService.deleteBizAlbumByAlbumIds(albumIds));
    }
}
