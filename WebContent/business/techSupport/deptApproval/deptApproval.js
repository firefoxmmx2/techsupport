/**
 * ceApproval.js 技术支持单 总工审批
 */

//onload
var processUrl2=BUSNEISS_PATH +"/init_deptApproval.action";
var saveURL=BUSNEISS_PATH+'/save_deptApproval.action';
var trackingInfoURL=BUSNEISS_PATH+"/querylistNoPage_tracking.action";
var ingridWidth=400;

//部門審批類型
var deptApprType;
//附件
var attachment_div_id="attachment_list_div";
var attachment_table_id="attachment_list_table";
var attachment_tables;
//附件查询路径
var attachment_query_url = BUSNEISS_PATH +"/querylistAttachment_tscommon.action";


function load_page_attachment_query(divpageid){
	attachment_tables=$("#"+divpageid).html();
	attachment_query(1,'#');
}

function set_attachment_list(pageno,url){	
	$("#"+attachment_div_id).html(attachment_tables);
	createXML("att_");
	if (url==null || url=="undefined"){
		url=attachment_query_url;
	}
	return url;
}

/**
 * 查询函数
 * */
function attachment_query(pageno,url){
	
	if (true){
		url=set_attachment_list(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid2 = $("#"+attachment_table_id).ingrid({ 
										url: url,	
										height:40,
										ingridPageWidth:900,
										isPlayResultNull: false,
										havaWaiDivGunDong: true,
                                      	ingridPageParams:sXML,
                                      	onRowSelect:null,
										pageNumber: pageno,
										changeHref:function($table){
											render_attachment_filesize($table);
										},
										noSortColIndex:[3],
										hideColIndex:[2],
										colWidths: ["70%","10%","10%","20%"]
									});
		}
}

//进展
//追踪批复查询URL
var	ingridUrl=getContextPath() + "/techsupport/querylist_tracking.action";
function loadPageTrackingQuery(divpageid){
	tables=$("#"+divpageid).html();
	trackingQuery(1,'#');
}	

/**
 * 查询函数
 * */
function trackingQuery(pageno,url){
	
	if (true){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid2 = $("#"+tableid).ingrid({ 
										url: url,	
										height:60,
										ingridPageWidth:ingridWidth,
										isPlayResultNull: false,
										havaWaiDivGunDong: true,
                                      	ingridPageParams:sXML,
                                      	onRowSelect:null,
										pageNumber: pageno,
										colWidths: ["15%","69%","16%"]				
									});				
		}
}
//督办
var supervision_div_id="supervision_list_div";
var supervision_table_id="supervision_list_table";
var supervision_tables;
//督办查询路径
var supervision_query_url = BUSNEISS_PATH +"/querylist_supervision.action";

function load_page_supervision_query(divpageid){
	supervision_tables=$("#"+divpageid).html();
	supervision_query(1,'#');
}

function set_supervision_list(pageno,url){	
	$("#"+supervision_div_id).html(supervision_tables);
	createXML("sv_");
	if (url==null || url=="undefined"){
		url=supervision_query_url;
	}
	return url;
}

/**
 * 查询函数
 * */
function supervision_query(pageno,url){
	
	if (true){
		url=set_supervision_list(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid2 = $("#"+supervision_table_id).ingrid({ 
										url: url,	
										height:60,
										ingridPageWidth:ingridWidth,
										isPlayResultNull: false,
										havaWaiDivGunDong: true,
                                      	ingridPageParams:sXML,
                                      	onRowSelect:null,
										pageNumber: pageno,
										colWidths: ["14%","70%","16%"]				
									});
		}
}


var gxdwmc_ = gxdwmc; //把gxdwmc 局部化
var gxdwbm_ = gxdwbm; //把gxdwbm 局部化
$(function(){
	//
	
	divnid="trackingTableDiv";//查询内容容器ID
	tableid="trackingTable";//查询内容格式表格ID
	loadPageTrackingQuery(divnid);
	
	//初始化该页面值
	$('#p_taskId').val(dataid);
	
	//设置所有日期参数
	$('.datero').each(function(){
		$(this).attr('readonly',true);
		$(this).datepicker();
	});
	
	//设置只读
	$('.ro').attr('readonly',true);
	
	
	//默认隐藏计划时间
	$('#devAppr').hide();
	$('#psgAppr').hide();
	
	//非阶段性隐藏
	relateHide('devstage');
	relateHide('psgstage');
	
	//当阶段按钮取消的时候，需要情况阶段时间
	$('#devstage,#psgstage').click(function(){
		if(!$(this).attr('checked'))
			$('.'+$(this).attr('id')).find('input:text').val('');	
	});
	//设置大区
//	$('#regionName').click(function(){
//		getDict_item('regionName','regionCode',ST_REGION_DICT_CODE);
//	});
	//设置技术负责人
	$('#supportLeaderName').click(function(){
		getUserofDept('supportLeaderName','supportLeaderCode',gxdwbm_,[ST_ROLE_NAME_STLEADER],true);
	});
	
	//按钮动作
	$('#savebtn').click(function(){
		if(!submitVerity())
			return;
		if($("#deptRadioPanel  input").eq(1).attr("checked")){
			if(!confirm("您确认本支持单不通过审批吗？"))
				return;
			$('#devAppr input,#psgAppr input').val('');
		}
		var params={};
		
		params = getSubmitParams('.deptApproval input,textarea',params);
//		设置任务号
		params['taskId']=$('#p_taskId').val();
//		设置部门审批类型
		params['deptApprType'] = deptApprType;
		
		$.post(saveURL,params,function(dataobj){
			if(dataobj.returnNo==0){
				$(detailWindow).empty();
				$(detailWindow).hideAndRemove("show");
				worksheetQuery(1);
			}
			
			jAlert(dataobj.returnMsg,"提示");
		},'json');
		
	});
	
//	部门审批单选
//	<input type="radio" class=" item " name="st.devApprovalCode" id="devApprovalCodeLess">通过
	buildHTMLComponentByDict('<input type="radio" name="st.trackList[0].approvalCode" value="{fact_value}">{display}',$('#deptRadioPanel'),ST_APPR_TYPE_DICT_CODE,'dict_item.fact_value == 0');
//	默认选中通过
	$('#deptRadioPanel input:radio').eq(0).attr('checked',true);
	
	loadData();
	//附件显示框
	load_page_attachment_query(attachment_div_id);
	
});


/**
 * 初始化页面数据
 */
function loadData(){
	var paramsss = {'taskId':$('#p_taskId').val()};
	$.post(processUrl2,paramsss,function(data){
		$('input:text[name^=st.]').each(function(){
			try{ 
				$(this).val(setNull(eval("("+"data."+$(this).attr('name')+")")));
			}catch(e){
				
			}
			
		});
		
		$('input:hidden[name^=st.]').each(function(){
			try{
				$(this).val(setNull(eval("("+"data."+$(this).attr('name')+")")));
			}catch(e){
				
			}
			
		});
		
		$('textarea[name^=st.]').each(function(){
			try{
				$(this).val(setNull(eval("("+"data."+$(this).attr('name')+")")));
			}catch(e){
				
			}
			
		});
		
		$('#region').val(getDictitem({dictcode:ST_REGION_DICT_CODE,value:$('#region').val()})[0].display_name);
		$('#tracklist_stId').val(data['st']['id']);
//		初始化技术负责人
//		if(data.st.supportLeader){
//			$('#supportLeaderName').val(setNull(data.st.supportLeader.username));
//			$('#supportLeaderCode').val(setNull(data.st.supportLeader.userid));
//		}
		
		setParams("p_");
		$.post(trackingInfoURL,params,function(result){
			if(result == null){
				return;
			}
			var trackinglist = result.lTracking;
			for(i in trackinglist){
				var t=trackinglist[i];
				if(t.type==TRACKING_TYPE_CEREPLY){
					$('#ceApprovalDate').val(setNull(t.trackingDate));
					$('#ceReply').val(setNull(t.newProcess));
					$('#ceName').val(setNull(t.processor.username));
					dictitem=getDictitem({dictcode:ST_APPR_TYPE_DICT_CODE , value : t.approvalCode});
					$('#ceApprovalRadioPanel span').text(dictitem[0].display_name);
					
					break; //显示最新的审核信息
				}
			}
			
		},'json');
		//督办
		$('#sv_st_id').val(data.st.id);
		
		supervision_query(1);
		//进展
		trackingQuery(1,ingridUrl);
		//附件
		$('#att_stId').val(data.st.id);
		attachment_query(1);
		
		//问题记录序号-9 父级部门可以处理子部门的部门审批
		//通过计划时间来区别 技术部门或者产品部门
//		if(!$('#psgScheDate').val()){
//			gxdwmc_ = '技术开发部';
//			gxdwbm_ = 'jskfb';
//		}
//		else {
//			gxdwmc_ = '产品方案部';
//			gxdwbm_ = 'cpfab';
//		}
		//驗証包含審批類型角色
//		userroles = getRoleByUserid(userid);
//		if(userroles && userroles.length > 0){
//			for(var i=0;i<userroles.length;i++){
//				if(userroles[i].rolename == ST_ROLE_TECH_DEPT_APPR_TYPE
//					&& !$('#psgScheDate').val()){
//					
//				}
//			}
//		}
		if($('#activityName').val() == ST_PROCESS_TECH_DEPARTMENT_APPROVAL){
			gxdwmc_ = '技术开发部';
			gxdwbm_ = 'jskfb';
			deptApprType = ST_ROLE_TECH_DEPT_APPR_TYPE;
		}
		else {
			gxdwmc_ = '产品方案部';
			gxdwbm_ = 'cpfab';
			deptApprType = ST_ROLE_PRODUCT_DEPT_APPR_TYPE;
		}
		if(gxdwmc_=="技术开发部"){
			$('#devAppr').show();
			$('#devAppr').append('<input type="hidden" name="st.trackList[0].type" value="'+TRACKING_TYPE_HDEVREPLY+'">');
		}
		else if(gxdwmc_=="产品方案部"){
			$('#psgAppr').show();
			$('#devAppr').append('<input type="hidden" name="st.trackList[0].type" value="'+TRACKING_TYPE_PGMREPLY+'">');
		}
	},'json');
}

/**
 * 提交验证
 */
function submitVerity() {
	if (!checkControlValue("deptApprovalDate","Datetime",1,100,null,1,"审批日期"))
		return false;
	if (!checkControlValue("deptName","String",1,50,null,1,"审批人"))
		return false;

	//在部门审批通过的时候验证。
	if ($('#deptRadioPanel > input').eq(0).attr('checked')) {
		
		if (!checkControlValue("supportLeaderName","String",1,100,null,1,"支持单负责人"))
			return false;
		
		if (gxdwmc_ == '产品方案部') {

			if (!checkControlValue("psgScheDate", "Date", 1, 100, null, 1,
					"计划完成时间"))
				return false;
			// 计划完成时间必须大于当前部门审批的时间
			if (Date.parse(setNull($('#psgScheDate').val()).replace(/-/g,"/")) < Date.parse(setNull($('#deptApprovalDate').val()).replace(/-/g,"/"))){
				jAlert('计划完成时间必须大于等于审批日期','提示');
				return false;
			}
			if ($('#psgstage').attr('checked')) {
				if (!checkControlValue("psgDsScheDate", "Date", 1, 100, null,
						1, "计划需求时间"))
					return false;
				
				
				if(Date.parse(setNull($('#psgDsScheDate').val()).replace(/-/g,"/")) - Date.parse(setNull($('#psgScheDate').val()).replace(/-/g,"/")) != 0){
					jAlert('计划需求时间必须等于计划完成时间','提示');
					return false;
				}
			}
		} else if (gxdwmc_ == '技术开发部') {
			if (!checkControlValue("devScheDate", "Date", 1, 100, null, 1,
					"计划完成时间"))
				return false;
				
			// 计划完成时间必须大于当前部门审批的时间
			if (Date.parse(setNull($('#devScheDate').val()).replace(/-/g,"/")) < Date.parse(setNull($('#deptApprovalDate').val()).replace(/-/g,"/"))){
				jAlert('计划完成时间必须大于等于审批日期','提示');
				return false;
			}
			if ($('#devstage').attr('checked')) {
				if (!checkControlValue("devDsScheDate", "Date", 1, 100, null,
						1, "计划设计时间"))
					return false;
				if (!checkControlValue("devDdScheDate", "Date", 1, 100, null,
						1, "计划开发时间"))
					return false;
				if (!checkControlValue("devDtScheDate", "Date", 1, 100, null,
					1, "计划测试时间"))
					return false;
				//移动实施时间到技术部
				if (!checkControlValue("psgIsScheDate", "Date", 1, 100, null,
						1, "计划实施时间"))
					return false;
				if(!(   Date.parse(setNull($('#devDsScheDate').val()).replace(/-/g,"/")) < Date.parse(setNull($('#devDdScheDate').val()).replace(/-/g,"/")) &&
                        Date.parse(setNull($('#devDdScheDate').val()).replace(/-/g,"/")) < Date.parse(setNull($('#devDtScheDate').val()).replace(/-/g,"/")) &&
                        Date.parse(setNull($('#devDtScheDate').val()).replace(/-/g,"/")) < Date.parse(setNull($('#psgIsScheDate').val()).replace(/-/g,"/")) &&
                        Date.parse(setNull($('#devScheDate').val()).replace(/-/g,"/") )- Date.parse(setNull($('#psgIsScheDate').val()).replace(/-/g,"/")) == 0
					)){
					jAlert('计划设计时间必须小于计划开发时间必须小于计划测试时间，测试时间必须小于实施时间，实施时间必须等于计划完成时间','提示');
					return false;
				}
			}
		}
	}
	//部门意见
	if(!checkControlValue("deptReply","String",1,4000,null,1,"审批意见"))
		return false;
		
	
	return true;
}