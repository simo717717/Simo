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
import com.simo.gallery.domain.BizForumReply;
import com.simo.gallery.service.IBizForumReplyService;
import com.simo.common.utils.poi.ExcelUtil;
import com.simo.common.core.page.TableDataInfo;

/**
 * 论坛回复管理Controller
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@RestController
@RequestMapping("/gallery/reply")
public class BizForumReplyController extends BaseController
{
    @Autowired
    private IBizForumReplyService bizForumReplyService;

    /**
     * 查询论坛回复管理列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:reply:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizForumReply bizForumReply)
    {
        startPage();
        List<BizForumReply> list = bizForumReplyService.selectBizForumReplyList(bizForumReply);
        return getDataTable(list);
    }

    /**
     * 导出论坛回复管理列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:reply:export')")
    @Log(title = "论坛回复管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizForumReply bizForumReply)
    {
        List<BizForumReply> list = bizForumReplyService.selectBizForumReplyList(bizForumReply);
        ExcelUtil<BizForumReply> util = new ExcelUtil<BizForumReply>(BizForumReply.class);
        util.exportExcel(response, list, "论坛回复管理数据");
    }

    /**
     * 获取论坛回复管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:reply:query')")
    @GetMapping(value = "/{replyId}")
    public AjaxResult getInfo(@PathVariable("replyId") Long replyId)
    {
        return success(bizForumReplyService.selectBizForumReplyByReplyId(replyId));
    }

    /**
     * 新增论坛回复管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:reply:add')")
    @Log(title = "论坛回复管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizForumReply bizForumReply)
    {
        return toAjax(bizForumReplyService.insertBizForumReply(bizForumReply));
    }

    /**
     * 修改论坛回复管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:reply:edit')")
    @Log(title = "论坛回复管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizForumReply bizForumReply)
    {
        return toAjax(bizForumReplyService.updateBizForumReply(bizForumReply));
    }

    /**
     * 删除论坛回复管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:reply:remove')")
    @Log(title = "论坛回复管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{replyIds}")
    public AjaxResult remove(@PathVariable Long[] replyIds)
    {
        return toAjax(bizForumReplyService.deleteBizForumReplyByReplyIds(replyIds));
    }
}
