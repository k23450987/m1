package project.dao;

import java.util.List;
import java.util.Map;

import project.domain.Cols;
import project.domain.Table;

public interface TableDao {

	/**
	 * 新建自由库
	 */
	void createTable(Map<String, Object> map);

	/**
	 * 查询自由库数据
	 * 
	 * @param tablename
	 * @return
	 */
	List<Map<String, Object>> select(String tablename);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectPage(Map<String, Object> map);

	/**
	 * 模糊查询
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectLike(Map<String, Object> map);

	/**
	 * 添加库
	 * 
	 * @param tablename
	 */
	void addTable(String tablename);

	/**
	 * 查找库id
	 * 
	 * @param tablename
	 * @return
	 */
	Integer findTableIdByName(String tablename);

	/**
	 * 查找库名称
	 * 
	 * @param tableId
	 * @return
	 */
	String findTableNameById(Integer tableId);

	/**
	 * 添加行
	 * 
	 * @param cols
	 */
	void addCol(Cols cols);

	/**
	 * 查询库
	 * 
	 * @return
	 */
	List<Table> findTables();

	/**
	 * 返回
	 * 
	 * @param tableId
	 * @return
	 */
	List<Cols> findColsByTableId(Integer tableId);

	/**
	 * 删除表
	 * 
	 * @param tablename
	 */
	void dropTable(String tablename);

	/**
	 * 删除表记录
	 * 
	 * @param tableId
	 */
	void delTable(Integer tableId);

	/**
	 * 删除行记录
	 * 
	 * @param tableId
	 */
	void delCols(Integer tableId);

	/**
	 * 根据列的 id 返回列名
	 * 
	 * @param colid
	 * @return
	 */
	String findColNameByColid(Integer colid);

	/**
	 * 修改列
	 * 
	 * @param map
	 */
	void changeCol(Map<String, String> map);

	/**
	 * 修改列信息
	 * 
	 * @param cols
	 */
	void updateColInfo(Cols cols);

	/**
	 * 插入列
	 * 
	 * @param map
	 */
	void insertCol(Map<String, String> map);

	/**
	 * 删除列
	 * 
	 * @param map
	 */
	void dropCol(Map<String, String> map);

	/**
	 * 删除列信息
	 * 
	 * @param colid
	 */
	void delCol(Integer colid);

	/**
	 * 获取查询条数
	 * 
	 * @param tablename
	 * @return
	 */
	Integer selectCounts(String tablename);
	
	Integer selectLikeCount(Map<String, Object> map);

}