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
import com.simo.gallery.domain.BizForumPost;
import com.simo.gallery.service.IBizForumPostService;
import com.simo.common.utils.poi.ExcelUtil;
import com.simo.common.core.page.TableDataInfo;

/**
 * 论坛帖子管理Controller
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@RestController
@RequestMapping("/gallery/post")
public class BizForumPostController extends BaseController
{
    @Autowired
    private IBizForumPostService bizForumPostService;

    /**
     * 查询论坛帖子管理列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:post:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizForumPost bizForumPost)
    {
        startPage();
        List<BizForumPost> list = bizForumPostService.selectBizForumPostList(bizForumPost);
        return getDataTable(list);
    }

    /**
     * 导出论坛帖子管理列表
     */
    @PreAuthorize("@ss.hasPermi('gallery:post:export')")
    @Log(title = "论坛帖子管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizForumPost bizForumPost)
    {
        List<BizForumPost> list = bizForumPostService.selectBizForumPostList(bizForumPost);
        ExcelUtil<BizForumPost> util = new ExcelUtil<BizForumPost>(BizForumPost.class);
        util.exportExcel(response, list, "论坛帖子管理数据");
    }

    /**
     * 获取论坛帖子管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('gallery:post:query')")
    @GetMapping(value = "/{postId}")
    public AjaxResult getInfo(@PathVariable("postId") Long postId)
    {
        return success(bizForumPostService.selectBizForumPostByPostId(postId));
    }

    /**
     * 新增论坛帖子管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:post:add')")
    @Log(title = "论坛帖子管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizForumPost bizForumPost)
    {
        return toAjax(bizForumPostService.insertBizForumPost(bizForumPost));
    }

    /**
     * 修改论坛帖子管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:post:edit')")
    @Log(title = "论坛帖子管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizForumPost bizForumPost)
    {
        return toAjax(bizForumPostService.updateBizForumPost(bizForumPost));
    }

    /**
     * 删除论坛帖子管理
     */
    @PreAuthorize("@ss.hasPermi('gallery:post:remove')")
    @Log(title = "论坛帖子管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{postIds}")
    public AjaxResult remove(@PathVariable Long[] postIds)
    {
        return toAjax(bizForumPostService.deleteBizForumPostByPostIds(postIds));
    }
}
