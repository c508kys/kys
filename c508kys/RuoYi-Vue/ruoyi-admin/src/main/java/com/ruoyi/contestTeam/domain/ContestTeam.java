package com.ruoyi.contestTeam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 组队信息对象 contest_team
 * 
 * @author ruoyi
 * @date 2025-08-11
 */
public class ContestTeam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 比赛ID */
    @Excel(name = "比赛ID")
    private Long contestId;

    /** 队伍名称 */
    @Excel(name = "队伍名称")
    private String teamName;

    /** 队员名单（逗号分隔） */
    @Excel(name = "队员名单", readConverterExp = "逗=号分隔")
    private String members;

    /** 队长姓名 */
    @Excel(name = "队长姓名")
    private String leader;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contact;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setContestId(Long contestId) 
    {
        this.contestId = contestId;
    }

    public Long getContestId() 
    {
        return contestId;
    }

    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }

    public void setMembers(String members) 
    {
        this.members = members;
    }

    public String getMembers() 
    {
        return members;
    }

    public void setLeader(String leader) 
    {
        this.leader = leader;
    }

    public String getLeader() 
    {
        return leader;
    }

    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contestId", getContestId())
            .append("teamName", getTeamName())
            .append("members", getMembers())
            .append("leader", getLeader())
            .append("contact", getContact())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
