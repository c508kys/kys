package com.ruoyi.contestTeam.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.contestTeam.mapper.ContestTeamMapper;
import com.ruoyi.contestTeam.domain.ContestTeam;
import com.ruoyi.contestTeam.service.IContestTeamService;

/**
 * 组队信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-08-11
 */
@Service
public class ContestTeamServiceImpl implements IContestTeamService 
{
    @Autowired
    private ContestTeamMapper contestTeamMapper;

    /**
     * 查询组队信息
     * 
     * @param id 组队信息主键
     * @return 组队信息
     */
    @Override
    public ContestTeam selectContestTeamById(Long id)
    {
        return contestTeamMapper.selectContestTeamById(id);
    }

    /**
     * 查询组队信息列表
     * 
     * @param contestTeam 组队信息
     * @return 组队信息
     */
    @Override
    public List<ContestTeam> selectContestTeamList(ContestTeam contestTeam)
    {
        return contestTeamMapper.selectContestTeamList(contestTeam);
    }

    /**
     * 新增组队信息
     * 
     * @param contestTeam 组队信息
     * @return 结果
     */
    @Override
    public int insertContestTeam(ContestTeam contestTeam)
    {
        contestTeam.setCreateTime(DateUtils.getNowDate());
        return contestTeamMapper.insertContestTeam(contestTeam);
    }

    /**
     * 修改组队信息
     * 
     * @param contestTeam 组队信息
     * @return 结果
     */
    @Override
    public int updateContestTeam(ContestTeam contestTeam)
    {
        contestTeam.setUpdateTime(DateUtils.getNowDate());
        return contestTeamMapper.updateContestTeam(contestTeam);
    }

    /**
     * 批量删除组队信息
     * 
     * @param ids 需要删除的组队信息主键
     * @return 结果
     */
    @Override
    public int deleteContestTeamByIds(Long[] ids)
    {
        return contestTeamMapper.deleteContestTeamByIds(ids);
    }

    /**
     * 删除组队信息信息
     * 
     * @param id 组队信息主键
     * @return 结果
     */
    @Override
    public int deleteContestTeamById(Long id)
    {
        return contestTeamMapper.deleteContestTeamById(id);
    }
}
