package com.ruoyi.competition.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.competition.mapper.ContestInfoMapper;
import com.ruoyi.competition.domain.ContestInfo;
import com.ruoyi.competition.service.IContestInfoService;

/**
 * 比赛信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-11
 */
@Service
public class ContestInfoServiceImpl implements IContestInfoService 
{
    @Autowired
    private ContestInfoMapper contestInfoMapper;

    /**
     * 查询比赛信息
     * 
     * @param id 比赛信息主键
     * @return 比赛信息
     */
    @Override
    public ContestInfo selectContestInfoById(Long id)
    {
        return contestInfoMapper.selectContestInfoById(id);
    }

    /**
     * 查询比赛信息列表
     * 
     * @param contestInfo 比赛信息
     * @return 比赛信息
     */
    @Override
    public List<ContestInfo> selectContestInfoList(ContestInfo contestInfo)
    {
        return contestInfoMapper.selectContestInfoList(contestInfo);
    }

    /**
     * 新增比赛信息
     * 
     * @param contestInfo 比赛信息
     * @return 结果
     */
    @Override
    public int insertContestInfo(ContestInfo contestInfo)
    {
        contestInfo.setCreateTime(DateUtils.getNowDate());
        return contestInfoMapper.insertContestInfo(contestInfo);
    }

    /**
     * 修改比赛信息
     * 
     * @param contestInfo 比赛信息
     * @return 结果
     */
    @Override
    public int updateContestInfo(ContestInfo contestInfo)
    {
        contestInfo.setUpdateTime(DateUtils.getNowDate());
        return contestInfoMapper.updateContestInfo(contestInfo);
    }

    /**
     * 批量删除比赛信息
     * 
     * @param ids 需要删除的比赛信息主键
     * @return 结果
     */
    @Override
    public int deleteContestInfoByIds(Long[] ids)
    {
        return contestInfoMapper.deleteContestInfoByIds(ids);
    }

    /**
     * 删除比赛信息信息
     * 
     * @param id 比赛信息主键
     * @return 结果
     */
    @Override
    public int deleteContestInfoById(Long id)
    {
        return contestInfoMapper.deleteContestInfoById(id);
    }
}
