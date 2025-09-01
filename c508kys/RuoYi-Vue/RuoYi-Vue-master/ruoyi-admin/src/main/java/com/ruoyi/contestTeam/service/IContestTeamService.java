package com.ruoyi.contestTeam.service;

import java.util.List;
import com.ruoyi.contestTeam.domain.ContestTeam;

/**
 * 组队信息Service接口
 * 
 * @author ruoyi
 * @date 2025-08-11
 */
public interface IContestTeamService 
{
    /**
     * 查询组队信息
     * 
     * @param id 组队信息主键
     * @return 组队信息
     */
    public ContestTeam selectContestTeamById(Long id);

    /**
     * 查询组队信息列表
     * 
     * @param contestTeam 组队信息
     * @return 组队信息集合
     */
    public List<ContestTeam> selectContestTeamList(ContestTeam contestTeam);

    /**
     * 新增组队信息
     * 
     * @param contestTeam 组队信息
     * @return 结果
     */
    public int insertContestTeam(ContestTeam contestTeam);

    /**
     * 修改组队信息
     * 
     * @param contestTeam 组队信息
     * @return 结果
     */
    public int updateContestTeam(ContestTeam contestTeam);

    /**
     * 批量删除组队信息
     * 
     * @param ids 需要删除的组队信息主键集合
     * @return 结果
     */
    public int deleteContestTeamByIds(Long[] ids);

    /**
     * 删除组队信息信息
     * 
     * @param id 组队信息主键
     * @return 结果
     */
    public int deleteContestTeamById(Long id);
}
