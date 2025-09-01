package com.ruoyi.contestTeam.controller;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.contestTeam.domain.ContestTeam;
import com.ruoyi.contestTeam.service.IContestTeamService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 组队信息Controller
 * 
 * @author ruoyi
 * @date 2025-08-11
 */
@RestController
@RequestMapping("/contestTeam/team")
public class ContestTeamController extends BaseController
{
    @Autowired
    private IContestTeamService contestTeamService;

    /**
     * 查询组队信息列表
     */
    @PreAuthorize("@ss.hasPermi('contestTeam:team:list')")
    @GetMapping("/list")
    public TableDataInfo list(ContestTeam contestTeam)
    {
        startPage();
        List<ContestTeam> list = contestTeamService.selectContestTeamList(contestTeam);
        return getDataTable(list);
    }

    /**
     * 导出组队信息列表
     */
    @PreAuthorize("@ss.hasPermi('contestTeam:team:export')")
    @Log(title = "组队信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ContestTeam contestTeam)
    {
        List<ContestTeam> list = contestTeamService.selectContestTeamList(contestTeam);
        ExcelUtil<ContestTeam> util = new ExcelUtil<ContestTeam>(ContestTeam.class);
        util.exportExcel(response, list, "组队信息数据");
    }

    /**
     * 获取组队信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('contestTeam:team:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(contestTeamService.selectContestTeamById(id));
    }

    /**
     * 新增组队信息
     */
    @PreAuthorize("@ss.hasPermi('contestTeam:team:add')")
    @Log(title = "组队信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ContestTeam contestTeam)
    {
        return toAjax(contestTeamService.insertContestTeam(contestTeam));
    }

    /**
     * 修改组队信息
     */
    @PreAuthorize("@ss.hasPermi('contestTeam:team:edit')")
    @Log(title = "组队信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ContestTeam contestTeam)
    {
        return toAjax(contestTeamService.updateContestTeam(contestTeam));
    }

    /**
     * 删除组队信息
     */
    @PreAuthorize("@ss.hasPermi('contestTeam:team:remove')")
    @Log(title = "组队信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(contestTeamService.deleteContestTeamByIds(ids));
    }
}
