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
import com.simo.gallery.domain.BizPhoto;
import com.simo.gallery.service.IBizPhotoService;
import com.simo.common.utils.poi.ExcelUtil;
import com.simo.common.core.page.TableDataInfo;

/**
 * 图片核心信息Controller
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@RestController
@RequestMapping("/gallery/photo")
public class BizPhotoController extends BaseController
{
    @Autowired
    private IBizPhotoService bizPhotoService;

    /**
     * 查询图片核心信息列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:photo:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizPhoto bizPhoto)
    {
        startPage();
        List<BizPhoto> list = bizPhotoService.selectBizPhotoList(bizPhoto);
        return getDataTable(list);
    }

    /**
     * 导出图片核心信息列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:photo:export')")
    @Log(title = "图片核心信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizPhoto bizPhoto)
    {
        List<BizPhoto> list = bizPhotoService.selectBizPhotoList(bizPhoto);
        ExcelUtil<BizPhoto> util = new ExcelUtil<BizPhoto>(BizPhoto.class);
        util.exportExcel(response, list, "图片核心信息数据");
    }

    /**
     * 获取图片核心信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:photo:query')")
    @GetMapping(value = "/{photoId}")
    public AjaxResult getInfo(@PathVariable("photoId") Long photoId)
    {
        return success(bizPhotoService.selectBizPhotoByPhotoId(photoId));
    }

    /**
     * 新增图片核心信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:photo:add')")
    @Log(title = "图片核心信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizPhoto bizPhoto)
    {
        return toAjax(bizPhotoService.insertBizPhoto(bizPhoto));
    }

    /**
     * 修改图片核心信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:photo:edit')")
    @Log(title = "图片核心信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizPhoto bizPhoto)
    {
        return toAjax(bizPhotoService.updateBizPhoto(bizPhoto));
    }

    /**
     * 删除图片核心信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:photo:remove')")
    @Log(title = "图片核心信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{photoIds}")
    public AjaxResult remove(@PathVariable Long[] photoIds)
    {
        return toAjax(bizPhotoService.deleteBizPhotoByPhotoIds(photoIds));
    }
}
