package com.hwsafe.risk.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 安全风险分析对象
 * @Author: jeecg-boot
 * @Date:   2022-08-30
 * @Version: V1.0
 */
@Data
@TableName("risk_analyze_object")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="risk_analyze_object对象", description="安全风险分析对象")
public class RiskAnalyzeObject implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**风险分析对象类型*/
	@Excel(name = "风险分析对象类型", width = 15, dicCode = "risk_object_type")
	@Dict(dicCode = "risk_object_type")
    @ApiModelProperty(value = "风险分析对象类型")
    private java.lang.String riskAnalyzeType;
	/**风险分析对象名称*/
	@Excel(name = "风险分析对象名称", width = 15)
    @ApiModelProperty(value = "风险分析对象名称")
    private java.lang.String riskAnalyzeName;
	/**危险源名称*/
	@Excel(name = "危险源名称", width = 15)
    @ApiModelProperty(value = "危险源名称")
    private java.lang.String hazardName;
	/**危险源编码*/
	@Excel(name = "危险源编码", width = 15)
    @ApiModelProperty(value = "危险源编码")
    private java.lang.String hazardCode;
	/**责任部门*/
	@Excel(name = "责任部门", width = 15, dictTable = "sys_depart", dicText = "depart_name", dicCode = "id")
	@Dict(dictTable = "sys_depart", dicText = "depart_name", dicCode = "id")
    @ApiModelProperty(value = "责任部门")
    private java.lang.String dutyOrg;
	/**责任人*/
	@Excel(name = "责任人", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "username")
	@Dict(dictTable = "sys_user", dicText = "realname", dicCode = "username")
    @ApiModelProperty(value = "责任人")
    private java.lang.String dutyUser;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
	/**状态*/
	@Excel(name = "状态", width = 15)
    @ApiModelProperty(value = "状态")
    private java.lang.String deleFlag;
	/**租户id*/
	@Excel(name = "租户id", width = 15)
    @ApiModelProperty(value = "租户id")
    private java.lang.String tenantId;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
	/**分析状态*/
	@Excel(name = "分析状态", width = 15)
    @ApiModelProperty(value = "分析状态")
    private java.lang.String status;
	/**风险等级*/
	@Excel(name = "风险等级", width = 15, dicCode = "risk_level")
	@Dict(dicCode = "risk_level")
    @ApiModelProperty(value = "风险等级")
    private java.lang.String riskLevel;
}
