package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bkry;
import com.aisino2.core.dao.Page;
public interface IBkryDao {
	/** @param 布控人员(t_bkry) 增加 */
	Bkry insertBkry(Bkry bkry);

	/** @param 布控人员(t_bkry) 删除 */
	int deleteBkry(Bkry bkry);

	/** @param 布控人员(t_bkry) 修改 */
	int updateBkry(Bkry bkry);

	/** @param 布控人员(t_bkry) 查询单条 */
	Bkry getBkry(Bkry bkry);

	/** @param 布控人员(t_bkry) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 境外布控人员(t_bkry) 分页查询 */
	Page getJwListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 布控人员(t_bkry) 多条查询 */
	List getListBkry(Bkry bkry);
	
	int validateZjhm(Bkry bkry);
}
