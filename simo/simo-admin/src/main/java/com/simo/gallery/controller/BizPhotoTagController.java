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
import com.simo.gallery.domain.BizPhotoTag;
import com.simo.gallery.service.IBizPhotoTagService;
import com.simo.common.utils.poi.ExcelUtil;
import com.simo.common.core.page.TableDataInfo;

/**
 * 图片标签关联Controller
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@RestController
@RequestMapping("/gallery/photoTag")
public class BizPhotoTagController extends BaseController
{
    @Autowired
    private IBizPhotoTagService bizPhotoTagService;

    /**
     * 查询图片标签关联列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:photoTag:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizPhotoTag bizPhotoTag)
    {
        startPage();
        List<BizPhotoTag> list = bizPhotoTagService.selectBizPhotoTagList(bizPhotoTag);
        return getDataTable(list);
    }

    /**
     * 导出图片标签关联列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:photoTag:export')")
    @Log(title = "图片标签关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizPhotoTag bizPhotoTag)
    {
        List<BizPhotoTag> list = bizPhotoTagService.selectBizPhotoTagList(bizPhotoTag);
        ExcelUtil<BizPhotoTag> util = new ExcelUtil<BizPhotoTag>(BizPhotoTag.class);
        util.exportExcel(response, list, "图片标签关联数据");
    }

    /**
     * 获取图片标签关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:photoTag:query')")
    @GetMapping(value = "/{photoId}")
    public AjaxResult getInfo(@PathVariable("photoId") Long photoId)
    {
        return success(bizPhotoTagService.selectBizPhotoTagByPhotoId(photoId));
    }

    /**
     * 新增图片标签关联
     */
    @PreAuthorize("@ss.hasPermi('gallery:photoTag:add')")
    @Log(title = "图片标签关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizPhotoTag bizPhotoTag)
    {
        return toAjax(bizPhotoTagService.insertBizPhotoTag(bizPhotoTag));
    }

    /**
     * 修改图片标签关联
     */
    @PreAuthorize("@ss.hasPermi('gallery:photoTag:edit')")
    @Log(title = "图片标签关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizPhotoTag bizPhotoTag)
    {
        return toAjax(bizPhotoTagService.updateBizPhotoTag(bizPhotoTag));
    }

    /**
     * 删除图片标签关联
     */
    @PreAuthorize("@ss.hasPermi('gallery:photoTag:remove')")
    @Log(title = "图片标签关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{photoIds}")
    public AjaxResult remove(@PathVariable Long[] photoIds)
    {
        return toAjax(bizPhotoTagService.deleteBizPhotoTagByPhotoIds(photoIds));
    }
}
