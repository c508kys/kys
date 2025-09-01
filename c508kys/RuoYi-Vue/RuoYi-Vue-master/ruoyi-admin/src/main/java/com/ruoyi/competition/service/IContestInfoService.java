package com.ruoyi.competition.service;

import java.util.List;
import com.ruoyi.competition.domain.ContestInfo;

/**
 * 比赛信息Service接口
 * 
 * @author ruoyi
 * @date 2025-08-11
 */
public interface IContestInfoService 
{
    /**
     * 查询比赛信息
     * 
     * @param id 比赛信息主键
     * @return 比赛信息
     */
    public ContestInfo selectContestInfoById(Long id);

    /**
     * 查询比赛信息列表
     * 
     * @param contestInfo 比赛信息
     * @return 比赛信息集合
     */
    public List<ContestInfo> selectContestInfoList(ContestInfo contestInfo);

    /**
     * 新增比赛信息
     * 
     * @param contestInfo 比赛信息
     * @return 结果
     */
    public int insertContestInfo(ContestInfo contestInfo);

    /**
     * 修改比赛信息
     * 
     * @param contestInfo 比赛信息
     * @return 结果
     */
    public int updateContestInfo(ContestInfo contestInfo);

    /**
     * 批量删除比赛信息
     * 
     * @param ids 需要删除的比赛信息主键集合
     * @return 结果
     */
    public int deleteContestInfoByIds(Long[] ids);

    /**
     * 删除比赛信息信息
     * 
     * @param id 比赛信息主键
     * @return 结果
     */
    public int deleteContestInfoById(Long id);
}
