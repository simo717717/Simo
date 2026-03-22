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
import com.simo.gallery.domain.BizTag;
import com.simo.gallery.service.IBizTagService;
import com.simo.common.utils.poi.ExcelUtil;
import com.simo.common.core.page.TableDataInfo;

/**
 * 标签管理Controller
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@RestController
@RequestMapping("/gallery/tag")
public class BizTagController extends BaseController
{
    @Autowired
    private IBizTagService bizTagService;

    /**
     * 查询标签管理列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizTag bizTag)
    {
        startPage();
        List<BizTag> list = bizTagService.selectBizTagList(bizTag);
        return getDataTable(list);
    }

    /**
     * 导出标签管理列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:tag:export')")
    @Log(title = "标签管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizTag bizTag)
    {
        List<BizTag> list = bizTagService.selectBizTagList(bizTag);
        ExcelUtil<BizTag> util = new ExcelUtil<BizTag>(BizTag.class);
        util.exportExcel(response, list, "标签管理数据");
    }

    /**
     * 获取标签管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:tag:query')")
    @GetMapping(value = "/{tagId}")
    public AjaxResult getInfo(@PathVariable("tagId") Long tagId)
    {
        return success(bizTagService.selectBizTagByTagId(tagId));
    }

    /**
     * 新增标签管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:tag:add')")
    @Log(title = "标签管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizTag bizTag)
    {
        return toAjax(bizTagService.insertBizTag(bizTag));
    }

    /**
     * 修改标签管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:tag:edit')")
    @Log(title = "标签管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizTag bizTag)
    {
        return toAjax(bizTagService.updateBizTag(bizTag));
    }

    /**
     * 删除标签管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:tag:remove')")
    @Log(title = "标签管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tagIds}")
    public AjaxResult remove(@PathVariable Long[] tagIds)
    {
        return toAjax(bizTagService.deleteBizTagByTagIds(tagIds));
    }
}
