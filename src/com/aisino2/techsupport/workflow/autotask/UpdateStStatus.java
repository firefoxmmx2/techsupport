package com.aisino2.techsupport.workflow.autotask;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;

import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.service.SupportTicketService;

/**
 * 自动任务，修改支持单状态
 * @author hooxin
 *
 */
public class UpdateStStatus {
	private String st_status;
	
	private SupportTicketService st_service;
	private ApplicationContext context;
	private Integer worksheet_id;
	private ServletContext sc;
	
	
	public ServletContext getSc() {
		return sc;
	}


	public void setSc(ServletContext sc) {
		this.sc = sc;
	}


	public void setSt_service(SupportTicketService st_service) {
		this.st_service = st_service;
	}


	public void setContext(ApplicationContext context) {
		this.context = context;
	}


	public void setWorksheet_id(Integer worksheet_id) {
		this.worksheet_id = worksheet_id;
	}

	
	public void setSt_status(String st_status) {
		this.st_status = st_status;
	}


	/**
	 * 修改状态
	 */
	public void updateStatus() {

		if(st_status == null){
			throw new RuntimeException("需要设置的状态为空，必须填入");
		}
		if(sc == null){
			throw new RuntimeException("应用服务容器为空，必须在支持单开始的时候设置");
		}
		
		SupportTicket st = new SupportTicket();
		st.setId(worksheet_id);
		st.setStStatus(Constants.ST_STATUS_GOING);
		st_service.updateSupportTicket(st);
		
	}
}