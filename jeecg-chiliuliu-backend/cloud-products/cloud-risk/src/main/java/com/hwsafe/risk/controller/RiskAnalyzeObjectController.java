package com.hwsafe.risk.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import com.hwsafe.risk.entity.RiskAnalyzeObject;
import com.hwsafe.risk.service.IRiskAnalyzeObjectService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 安全风险分析对象
 * @Author: jeecg-boot
 * @Date:   2022-08-30
 * @Version: V1.0
 */
@Api(tags="安全风险分析对象")
@RestController
@RequestMapping("/risk/riskAnalyzeObject")
@Slf4j
public class RiskAnalyzeObjectController extends JeecgController<RiskAnalyzeObject, IRiskAnalyzeObjectService> {
	@Autowired
	private IRiskAnalyzeObjectService riskAnalyzeObjectService;
	
	/**
	 * 分页列表查询
	 *
	 * @param riskAnalyzeObject
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "安全风险分析对象-分页列表查询")
	@ApiOperation(value="安全风险分析对象-分页列表查询", notes="安全风险分析对象-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<RiskAnalyzeObject>> queryPageList(RiskAnalyzeObject riskAnalyzeObject,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<RiskAnalyzeObject> queryWrapper = QueryGenerator.initQueryWrapper(riskAnalyzeObject, req.getParameterMap());
		Page<RiskAnalyzeObject> page = new Page<RiskAnalyzeObject>(pageNo, pageSize);
		IPage<RiskAnalyzeObject> pageList = riskAnalyzeObjectService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param riskAnalyzeObject
	 * @return
	 */
	@AutoLog(value = "安全风险分析对象-添加")
	@ApiOperation(value="安全风险分析对象-添加", notes="安全风险分析对象-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody RiskAnalyzeObject riskAnalyzeObject) {
		riskAnalyzeObjectService.save(riskAnalyzeObject);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param riskAnalyzeObject
	 * @return
	 */
	@AutoLog(value = "安全风险分析对象-编辑")
	@ApiOperation(value="安全风险分析对象-编辑", notes="安全风险分析对象-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody RiskAnalyzeObject riskAnalyzeObject) {
		riskAnalyzeObjectService.updateById(riskAnalyzeObject);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "安全风险分析对象-通过id删除")
	@ApiOperation(value="安全风险分析对象-通过id删除", notes="安全风险分析对象-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		riskAnalyzeObjectService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "安全风险分析对象-批量删除")
	@ApiOperation(value="安全风险分析对象-批量删除", notes="安全风险分析对象-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.riskAnalyzeObjectService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "安全风险分析对象-通过id查询")
	@ApiOperation(value="安全风险分析对象-通过id查询", notes="安全风险分析对象-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<RiskAnalyzeObject> queryById(@RequestParam(name="id",required=true) String id) {
		RiskAnalyzeObject riskAnalyzeObject = riskAnalyzeObjectService.getById(id);
		if(riskAnalyzeObject==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(riskAnalyzeObject);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param riskAnalyzeObject
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, RiskAnalyzeObject riskAnalyzeObject) {
        return super.exportXls(request, riskAnalyzeObject, RiskAnalyzeObject.class, "安全风险分析对象");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, RiskAnalyzeObject.class);
    }

}
