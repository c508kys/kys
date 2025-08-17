package com.ruoyi.competition.controller;

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
import com.ruoyi.competition.domain.ContestInfo;
import com.ruoyi.competition.service.IContestInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 比赛信息Controller
 * 
 * @author ruoyi
 * @date 2025-08-11
 */
@RestController
@RequestMapping("/competition/info")
public class ContestInfoController extends BaseController
{
    @Autowired
    private IContestInfoService contestInfoService;

    /**
     * 查询比赛信息列表
     */
    @PreAuthorize("@ss.hasPermi('competition:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(ContestInfo contestInfo)
    {
        startPage();
        List<ContestInfo> list = contestInfoService.selectContestInfoList(contestInfo);
        return getDataTable(list);
    }

    /**
     * 导出比赛信息列表
     */
    @PreAuthorize("@ss.hasPermi('competition:info:export')")
    @Log(title = "比赛信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ContestInfo contestInfo)
    {
        List<ContestInfo> list = contestInfoService.selectContestInfoList(contestInfo);
        ExcelUtil<ContestInfo> util = new ExcelUtil<ContestInfo>(ContestInfo.class);
        util.exportExcel(response, list, "比赛信息数据");
    }

    /**
     * 获取比赛信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('competition:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(contestInfoService.selectContestInfoById(id));
    }

    /**
     * 新增比赛信息
     */
    @PreAuthorize("@ss.hasPermi('competition:info:add')")
    @Log(title = "比赛信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ContestInfo contestInfo)
    {
        return toAjax(contestInfoService.insertContestInfo(contestInfo));
    }

    /**
     * 修改比赛信息
     */
    @PreAuthorize("@ss.hasPermi('competition:info:edit')")
    @Log(title = "比赛信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ContestInfo contestInfo)
    {
        return toAjax(contestInfoService.updateContestInfo(contestInfo));
    }

    /**
     * 删除比赛信息
     */
    @PreAuthorize("@ss.hasPermi('competition:info:remove')")
    @Log(title = "比赛信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(contestInfoService.deleteContestInfoByIds(ids));
    }
}
