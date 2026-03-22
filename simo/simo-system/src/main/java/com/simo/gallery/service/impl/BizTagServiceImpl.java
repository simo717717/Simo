package com.simo.gallery.service.impl;

import java.util.List;
import com.simo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simo.gallery.mapper.BizTagMapper;
import com.simo.gallery.domain.BizTag;
import com.simo.gallery.service.IBizTagService;

/**
 * 标签管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
@Service
public class BizTagServiceImpl implements IBizTagService 
{
    @Autowired
    private BizTagMapper bizTagMapper;

    /**
     * 查询标签管理
     * 
     * @param tagId 标签管理主键
     * @return 标签管理
     */
    @Override
    public BizTag selectBizTagByTagId(Long tagId)
    {
        return bizTagMapper.selectBizTagByTagId(tagId);
    }

    /**
     * 查询标签管理列表
     * 
     * @param bizTag 标签管理
     * @return 标签管理
     */
    @Override
    public List<BizTag> selectBizTagList(BizTag bizTag)
    {
        return bizTagMapper.selectBizTagList(bizTag);
    }

    /**
     * 新增标签管理
     * 
     * @param bizTag 标签管理
     * @return 结果
     */
    @Override
    public int insertBizTag(BizTag bizTag)
    {
        bizTag.setCreateTime(DateUtils.getNowDate());
        return bizTagMapper.insertBizTag(bizTag);
    }

    /**
     * 修改标签管理
     * 
     * @param bizTag 标签管理
     * @return 结果
     */
    @Override
    public int updateBizTag(BizTag bizTag)
    {
        bizTag.setUpdateTime(DateUtils.getNowDate());
        return bizTagMapper.updateBizTag(bizTag);
    }

    /**
     * 批量删除标签管理
     * 
     * @param tagIds 需要删除的标签管理主键
     * @return 结果
     */
    @Override
    public int deleteBizTagByTagIds(Long[] tagIds)
    {
        return bizTagMapper.deleteBizTagByTagIds(tagIds);
    }

    /**
     * 删除标签管理信息
     * 
     * @param tagId 标签管理主键
     * @return 结果
     */
    @Override
    public int deleteBizTagByTagId(Long tagId)
    {
        return bizTagMapper.deleteBizTagByTagId(tagId);
    }
}
