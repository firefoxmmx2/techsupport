package com.aisino2.techsupport.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Constants {
	/**
	 * 应用服务器真实地址
	 */
	public static String APPLICATION_SERVERCONTEXT_REALPATH;
	/**
	 * 服务器上传地址
	 */
	public static String APPLICATION_UPLOAD_DIR = "/upload";
	// 进行中
	public static String ST_STATUS_GOING = "going";
	// 带公司审批
	public static String ST_STATUS_WAIT_COMPANY_APPRAVAL = "wait_company_appraval";
	// 公司审批未通过
	public static String ST_STATUS_COMPANY_APPRAVAL_NOPASS = "company_appraval_nopass";
	// 带部门审批
	public static String ST_STATUS_WAIT_DEPARTMENT_APPRAVAL = "wait_department_appraval";
	// 部门审批未通过
	public static String ST_STATUS_DEPARTMENT_APPRAVAL_NOPASS = "department_appraval_nopass";
	// 例外终止
	public static String ST_STATUS_STOP = "stop";
	// 已完成
	public static String ST_STATUS_COMPLETE = "gone";
	// 待反馈
	public static String ST_STATUS_WAIT_FEEDBACK = "wait_feedback";
	// 已反馈
	public static String ST_STATUS_FEEDBACKED = "feedbacked";
	// 新需求v1.0sp3
	// 暂停
	public static String ST_STATUS_PAUSE = "pause";

	// 支持单状态字典代码
	public static String ST_STATUS_DICT_CODE = "dm_ts_status";

	// 区域字典代码
	public static String ST_REGION_DICT_CODE = "dm_ts_regin";

	// 区总区域映射字典代码
	public static String ST_RGM_RG_MAP_DICT_CODE = "dm_ts_rm_map";

	// 普通进展批复
	public static String TRACKING_TYPE_TRACKING = "0";
	// 总共批复
	public static String TRACKING_TYPE_CEREPLY = "10";
	// 产品方案批复
	public static String TRACKING_TYPE_PGMREPLY = "20";
	// 技术主管批复
	public static String TRACKING_TYPE_HDEVREPLY = "30";

	// 反馈意见
	public static String TRACKING_TYPE_FEEDBACK = "40";
	// 归档意见或者注释
	public static String TRACKING_TYPE_ARCHIVE = "50";
	// 异常处理
	public static String TRACKING_TYPE_EXCEPTION = "60";
	// 重新指派部门原因
	public static String TRACKING_TYPE_REASSIGN_DEPARTMENT = "70";
	// 重新指派支持单负责人原因
	public static String TRACKING_TYPE_REASSIGN_SUPPORT_LEADER = "80";
	// 新需求v1.0sp3
	// 支持单暂停
	public static String TRACKING_TYPE_PAUSE = "90";
	// 支持单恢复
	public static String TRACKING_TYPE_RESTORE = "91";

	// 流程名称
	public static final String workflowName = "techsupport";

	// 公司代码
	public static String HTJD_DEPT_CODE = "htdj";

	// 技术支持单 审批类型字典
	public static String ST_APPR_TYPE_DICT_CODE = "dm_support_appr_type";
	// 未审核
	public static String ST_APPR_TYPE_UNAPPR = "0";
	// 通过
	public static String ST_APPR_TYPE_APPR_PASSED = "10";
	// 未通过
	public static String ST_APPR_TYPE_APPR_NOPASS = "20";

	// 技术支持单短息发送角色对应状态 字典
	public static String ST_SMS_ROLE_STATUS_DICT_CODE = "dm_ts_role_status";
	// 流程环节字典
	public static String ST_WORKFLOW_NAME_DICT_CODE = "dm_ts_proc";
	/**
	 * 部门审批角色类型
	 */
	public static String ST_DEPART_APPR_TYPE_DICT_CODE = "dm_depart_appr_type";
	// 技术支持单角色信息
	// 填报人
	public static String ST_ROLE_NAME_APPLICANT;
	// 总工 公司审批人
	public static String ST_ROLE_NAME_CE = "ts_总工";
	// 部门经理 技术部门审批人
	public static String ST_ROLE_NAME_DEPTMANAGE = "ts_部门经理";
	// 重庆区总
	public static String ST_ROLE_NAME_RGM_CQ = "ts_重庆区总";
	// 四川区总
	public static String st_ROLE_NAME_RGM_SC = "ts_四川区总";
	// 技术负责人
	public static String ST_ROLE_NAME_STLEADER = "ts_技术负责人";
	// 质量管理员
	public static String ST_ROLE_NAME_QC = "ts_技术质量员";
	// 反馈人
	public static String ST_ROLE_NAME_FEEDBACKER;
	// 督办
	public static String ST_ROLE_NAME_SUPERVISION;
	// 进展提醒
	public static String ST_ROLE_NAME_TRACKING_PROMPT;
	// 审批提醒
	public static String ST_ROLE_NAME_APPROVAL_PROMPT;
	// 反馈提醒
	public static String ST_ROLE_NAME_FEEDBACK_PROMPT;
	// 0 数据管理
	public static String ST_ROLE_NAME_DM;
	// 最后更新日期后X天
	public static Integer LAST_UPDATE_DAY = 7;
	/**
	 * 技術部門審批類型
	 */
	public static String ST_ROLE_TECH_DEPT_APPR_TYPE;
	/**
	 * 產品部門審批類型
	 */
	public static String ST_ROLE_PRODUCT_DEPT_APPR_TYPE;

	public static CommonUtil util;
	private static Logger log = Logger.getLogger(Constants.class);

	// 流程环节
	// 填报
	public static final String ST_PROCESS_APPLY = "apply";
	// 总工审批或者公司审批
	public static final String ST_PROCESS_CE_APPROVAL = "ce_appr";
	// 部门审批或者公司二级审批
	public static final String ST_PROCESS_DEPARTMENT_APPROVAL = "department_appr";
	// 技术部门审批
	public static final String ST_PROCESS_TECH_DEPARTMENT_APPROVAL = "tech_department_appr";
	// 产品部门审批
	public static final String ST_PROCESS_PRODUCT_DEPARTMENT_APPROVAL = "product_department_appr";
	// 追踪批复
	public static final String ST_PROCESS_TRACKING = "tracking_appr";
	// 反馈确认
	public static final String ST_PROCESS_FEEDBACK = "feedback";
	// 归档
	public static final String ST_PROCESS_ARCHIVE = "archive";
	// 例外处理
	public static final String ST_PROCESS_EXCEPTION = "exception_process";
	// 重指派部门
	public static final String ST_PROCESS_REASSIGN_DEPART = "reassign_depart";
	// 重指派支持单负责人
	public static final String ST_PROCESS_REASSGIN_STLEADER = "reassgin_stleader";
	// 新需求v.1sp3
	// 暂停
	public static final String ST_PROCESS_PAUSE = "pause";
	// 恢复
	public static final String ST_PROCESS_RESTORE = "restore";
	// 审批更新间隔代码
	public static final String ST_APPRAVAL_UPDATE_INTERVAL_DAY = "st_appraval_update_interval_day";
	// 进展更新间隔代码
	public static final String ST_TRACKING_UPDATE_INTERVAL_DAY = "st_tracking_update_interval_day";
	// 反馈更新间隔代码
	public static final String ST_FEEDBACK_UPDATE_INTERVAL_DAY = "st_feedback_update_interval_day";

	// 默认导入审批用户
	public static String ST_DEFAULT_IMPORT_APPROVAL_USER;
	// 默认导入审批内容
	public static String ST_DEFAULT_IMPORT_APPROVAL_CONTENT;

	/**
	 * 技术部门审批机构代码
	 */
	public static String ST_APPROVAL_DEPARTMENT_CODE_TECH;

	/**
	 * 产品部门审批机构代码
	 */
	public static String ST_APPROVAL_DEPARTMENT_CODE_PRODUCT;

	/**
	 * 用户邮件字典代码
	 */
	public static String ST_USER_EMAIL_MAP_DICT_CODE = "dm_userAndEmail_tech";

	/**
	 * 机构代码部门审批角色映射
	 */
	public static Map<String, String> ST_DEPARTCODE_DEPARTMENT_APPROVAL_ROLE_MAP = new HashMap<String, String>();

	/**
	 * 支持单时间改变轨迹状态, 产品
	 */
	public static final String ST_TIME_CHANGE_TYPE_PRODUCT = "0";
	/**
	 * 支持单时间改变轨迹状态, 开发
	 */
	public static final String ST_TIME_CHANGE_TYPE_DEVELOP = "1";

	/**
	 * 综合查询机构列表字典代码
	 */
	public static final String ST_QUERY_DEPARTMENT_DICTCODE = "dm_ts_depart_list";

	static {
		util = new CommonUtil();
		try {
			ST_ROLE_NAME_APPLICANT = util
					.getTechSupportEnvConfig("techsupport.role.tech_apply_reporter");
			ST_ROLE_NAME_CE = util
					.getTechSupportEnvConfig("techsupport.role.tech_ce_approve");
			ST_ROLE_NAME_DEPTMANAGE = util
					.getTechSupportEnvConfig("techsupport.role.tech_department_approve");
			ST_ROLE_NAME_STLEADER = util
					.getTechSupportEnvConfig("techsupport.role.tech_support_leader_approve");
			ST_ROLE_NAME_FEEDBACKER = util
					.getTechSupportEnvConfig("techsupport.role.tech_feedback");
			ST_ROLE_NAME_SUPERVISION = util
					.getTechSupportEnvConfig("techsupport.role.tech_supervision");
			ST_ROLE_NAME_TRACKING_PROMPT = util
					.getTechSupportEnvConfig("techsupport.role.tech_tracking_prompt");
			ST_ROLE_NAME_APPROVAL_PROMPT = util
					.getTechSupportEnvConfig("techsupport.role.tech_approval_prompt");
			ST_ROLE_NAME_FEEDBACK_PROMPT = util
					.getTechSupportEnvConfig("techsupport.role.tech_feedback_prompt");
			ST_ROLE_NAME_DM = util
					.getTechSupportEnvConfig("techsupport.role.tech_data_manager");
			ST_ROLE_NAME_QC = util
					.getTechSupportEnvConfig("techsupport.role.tech_quality_control");

			ST_ROLE_TECH_DEPT_APPR_TYPE = util
					.getTechSupportEnvConfig("techsupport.role.tech_dept_approval_type");
			ST_ROLE_PRODUCT_DEPT_APPR_TYPE = util
					.getTechSupportEnvConfig("techsupport.role.product_dept_approval_type");

			// 默认导入审批用户
			ST_DEFAULT_IMPORT_APPROVAL_USER = util
					.getTechSupportEnvConfig("techsupport.worksheet.import.default_user");
			ST_DEFAULT_IMPORT_APPROVAL_CONTENT = util
					.getTechSupportEnvConfig("techsupport.worksheet.import.default_approval_content");

			// 部门审批机构代码
			ST_APPROVAL_DEPARTMENT_CODE_TECH = util
					.getTechSupportEnvConfig("techsupport.worksheet.approval_department.tech");
			ST_APPROVAL_DEPARTMENT_CODE_PRODUCT = util
					.getTechSupportEnvConfig("techsupport.worksheet.approval_department.product");

			// 机构代码部门审批角色映射
			ST_DEPARTCODE_DEPARTMENT_APPROVAL_ROLE_MAP.put(
					ST_APPROVAL_DEPARTMENT_CODE_PRODUCT,
					ST_ROLE_PRODUCT_DEPT_APPR_TYPE);
			ST_DEPARTCODE_DEPARTMENT_APPROVAL_ROLE_MAP.put(
					ST_APPROVAL_DEPARTMENT_CODE_TECH,
					ST_ROLE_TECH_DEPT_APPR_TYPE);

		} catch (IOException e) {
			log.error(e);
			log.debug(e, e.fillInStackTrace());
		}

	}
}
