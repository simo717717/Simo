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
import com.simo.gallery.domain.BizPhotoExif;
import com.simo.gallery.service.IBizPhotoExifService;
import com.simo.common.utils.poi.ExcelUtil;
import com.simo.common.core.page.TableDataInfo;

/**
 * 图片EXIF参数Controller
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@RestController
@RequestMapping("/gallery/exif")
public class BizPhotoExifController extends BaseController
{
    @Autowired
    private IBizPhotoExifService bizPhotoExifService;

    /**
     * 查询图片EXIF参数列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:exif:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizPhotoExif bizPhotoExif)
    {
        startPage();
        List<BizPhotoExif> list = bizPhotoExifService.selectBizPhotoExifList(bizPhotoExif);
        return getDataTable(list);
    }

    /**
     * 导出图片EXIF参数列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:exif:export')")
    @Log(title = "图片EXIF参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizPhotoExif bizPhotoExif)
    {
        List<BizPhotoExif> list = bizPhotoExifService.selectBizPhotoExifList(bizPhotoExif);
        ExcelUtil<BizPhotoExif> util = new ExcelUtil<BizPhotoExif>(BizPhotoExif.class);
        util.exportExcel(response, list, "图片EXIF参数数据");
    }

    /**
     * 获取图片EXIF参数详细信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:exif:query')")
    @GetMapping(value = "/{photoId}")
    public AjaxResult getInfo(@PathVariable("photoId") Long photoId)
    {
        return success(bizPhotoExifService.selectBizPhotoExifByPhotoId(photoId));
    }

    /**
     * 新增图片EXIF参数
     */
    @PreAuthorize("@ss.hasPermi('gallery:exif:add')")
    @Log(title = "图片EXIF参数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizPhotoExif bizPhotoExif)
    {
        return toAjax(bizPhotoExifService.insertBizPhotoExif(bizPhotoExif));
    }

    /**
     * 修改图片EXIF参数
     */
    @PreAuthorize("@ss.hasPermi('gallery:exif:edit')")
    @Log(title = "图片EXIF参数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizPhotoExif bizPhotoExif)
    {
        return toAjax(bizPhotoExifService.updateBizPhotoExif(bizPhotoExif));
    }

    /**
     * 删除图片EXIF参数
     */
    @PreAuthorize("@ss.hasPermi('gallery:exif:remove')")
    @Log(title = "图片EXIF参数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{photoIds}")
    public AjaxResult remove(@PathVariable Long[] photoIds)
    {
        return toAjax(bizPhotoExifService.deleteBizPhotoExifByPhotoIds(photoIds));
    }
}
