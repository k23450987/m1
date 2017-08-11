package project.mapper;

import java.util.List;
import java.util.Map;

import project.domain.Cols;
import project.domain.Table;

public interface TableMapper {

	/**
	 * 建表
	 * 
	 * @param map
	 */
	void createTable(Map<String, Object> map);

	/**
	 * 查询
	 * 
	 * @param tablename
	 * @return
	 */
	List<Map<String, Object>> select(String tablename);

	/**
	 * 分页查询
	 * 
	 * @param tablename
	 * @return
	 */
	List<Map<String, Object>> selectByPages(Map<String, Object> map);

	
	/**
	 * 模糊查询
	 */
	List<Map<String, Object>> selectLike(Map<String, Object> map);
	
	/**
	 * 查询条数
	 * @param map
	 * @return
	 */
	Integer selectLikeCount(Map<String, Object> map);
	/**
	 * 新建自由库
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
	 * 查找自由库列
	 * 
	 * @return
	 */
	List<Table> findTables();

	/**
	 * 查找自由库的列
	 * 
	 * @param tableId
	 * @return
	 */
	List<Cols> findColsByTableId(Integer tableId);

	/**
	 * 删除库
	 * 
	 * @param tablename
	 */
	void dropTable(String tablename);

	/**
	 * 删除库的记录
	 * 
	 * @param tablename
	 */
	void delTable(Integer tableId);

	/**
	 * 删除行的记录
	 * 
	 * @param tablename
	 */
	void delCols(Integer tableId);

	/**
	 * 根据列id查询列名
	 * 
	 * @param colid
	 * @return
	 */
	String findColNameByColid(Integer colid);

	/**
	 * 在自由库的表中修改列
	 * 
	 * @param map
	 */
	void changeCol(Map<String, String> map);

	/**
	 * 在列信息中修改
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
}
