package project.service;

import java.util.List;
import java.util.Map;

import project.domain.Cols;
import project.domain.Table;

public interface TableService {

	/**
	 * 新建自由库
	 * 
	 * @param map
	 */
	void createTable(Map<String, Object> map);

	/**
	 * 查询自由库数据
	 * 
	 * @param tableId
	 * @return
	 */
	List<Map<String, Object>> select(Integer tableId);

	/**
	 * 添加表信息
	 * 
	 * @param tablename
	 */
	void addTable(String tablename);

	/**
	 * 查找自由库id
	 * 
	 * @param tablename
	 * @return
	 */
	Integer findTableIdByName(String tablename);

	/**
	 * 添加行信息
	 * 
	 * @param cols
	 */
	void addCol(Cols cols);

	/**
	 * 查找库信息
	 * 
	 * @return
	 */
	List<Table> findTables();

	/**
	 * 查找库中的行
	 * 
	 * @param tableId
	 * @return
	 */
	List<Cols> findColsByTableId(Integer tableId);

	/**
	 * 通过自由库id查找自由库名称
	 * 
	 * @param tableId
	 * @return
	 */
	String findTableNameById(Integer tableId);

	/**
	 * 删除自由库
	 * 
	 * @param tableId
	 */
	void delete(Integer tableId);

	/**
	 * 编辑列
	 * 
	 * @param cols
	 * @param tableName
	 */
	void edit(Cols cols, String tableName);

	/**
	 * 插入列
	 * 
	 * @param cols
	 * @param tableName
	 */
	void insertCol(Cols cols, String tableName);

	/**
	 * 删除列，在列信息中
	 * 
	 * @param map
	 */
	void dropCol(Map<String, String> map);

	/**
	 * 删除列，在自由库中
	 * 
	 * @param colid
	 */
	void delCol(Integer colid);

	/**
	 * 查询总条数
	 * 
	 * @param tablename
	 * @return
	 */
	Integer selectCounts(String tablename);

	/**
	 * 分页查询
	 * 
	 * @param tableId
	 * @param pageNum
	 * @return
	 */
	List<Map<String, Object>> selectPage(Integer tableId, Integer pageNum);
	
	/**
	 * 模糊查询
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectLike(Map<String, Object> map);
	
	String findColNameByColid(Integer colid);
	
	Integer selectLikeCount(Map<String, Object> map);
}