package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyjbxx_ls;
public interface IQyjbxx_lsDao {
	/** @param 企业基本信息—历史(t_qyjbxx_ls) 增加 */
	Qyjbxx_ls insertQyjbxx_ls(Qyjbxx_ls qyjbxx_ls);

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 删除 */
	int deleteQyjbxx_ls(Qyjbxx_ls qyjbxx_ls);

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 修改 */
	int updateQyjbxx_ls(Qyjbxx_ls qyjbxx_ls);

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 查询单条 */
	Qyjbxx_ls getQyjbxx_ls(Qyjbxx_ls qyjbxx_ls);

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 多条查询 */
	List getListQyjbxx_ls(Qyjbxx_ls qyjbxx_ls);
	
	/** @param 企业基本信息—历史(t_qyjbxx_ls) 查询指定企业的操作类型为变更的最新一条历史记录 */
	Qyjbxx_ls getLatestBgQyjbxx_ls(Qyjbxx_ls qyjbxx_ls);
	
	/** @param 企业基本信息—历史(t_Qyjbxx_ls) 查询指定企业且操作类型为变更的某条历史记录的下一条记录(即qylsid较大的一条) */
	Qyjbxx_ls getNextBgQyjbxx_ls(Qyjbxx_ls qyjbxx_ls);
}
