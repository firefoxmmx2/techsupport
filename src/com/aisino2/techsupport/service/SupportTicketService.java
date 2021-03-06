package com.aisino2.techsupport.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.domain.SupportTicket;

public interface SupportTicketService {
	List<SupportTicket> getListSupportTicket(SupportTicket st);

	SupportTicket getSupportTicket(SupportTicket st);

	SupportTicket insertSupportTicket(SupportTicket st);

	void updateSupportTicket(SupportTicket st);

	void deleteSupportTicket(SupportTicket st);

	String generateSupportTicketCode();

	Page getListSupportTicketForPage(Map<String, Object> map, int pageNo,
			int pageSize, String sort, String desc);

	/**
	 * @新增 申请人删除
	 * @param st
	 */
	void deleteSupportTicketByApplicant(SupportTicket st);

}
