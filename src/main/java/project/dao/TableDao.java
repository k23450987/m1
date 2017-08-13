package project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import project.domain.Cols;
import project.domain.Table;

public interface TableDao {

    /**
     * 建表
     *
     * @param map 建表信息
     */
    void createTable(Map<String, Object> map);

    /**
     * 查询
     *
     * @param tableName 表名
     * @return 数据
     */
    List<Map<String, Object>> select(String tableName);

    /**
     * 分页查询
     *
     * @param map 查询参数
     * @return 数据
     */
    List<Map<String, Object>> selectByPages(@Param("tableName") String tableName);


    /**
     * 模糊查询
     *
     * @param map 查询参数
     * @return 数据
     */
    List<Map<String, Object>> selectLike(Map<String, Object> map);

    /**
     * 查询条数
     *
     * @param map 查询参数
     * @return 数据
     */
    Integer selectLikeCount(Map<String, Object> map);

    /**
     * 新建自由库
     *
     * @param tableName 表名
     */
    void addTable(@Param("tableName") String tableName);

    /**
     * 查找库id
     *
     * @param tableName 表名
     * @return ID
     */
    Integer findTableIdByName(@Param("tableName") String tableName);

    /**
     * 查找库名称
     *
     * @param tableId 表 ID
     * @return 表名
     */
    String findTableNameById(@Param("tableId") Integer tableId);

    /**
     * 添加列
     *
     * @param cols 列
     */
    void addCol(Cols cols);

    /**
     * 查找自由库表
     *
     * @return 表
     */
    List<Table> findTables();

    /**
     * 查找自由库的列
     *
     * @param tableId 表 ID
     * @return 所有的列
     */
    List<Cols> findColsByTableId(@Param("tableId") Integer tableId);

    /**
     * 删除库
     *
     * @param tableName 表名
     */
    void dropTable(String tableName);

    /**
     * 删除库的记录
     *
     * @param tableId 表 ID
     */
    void delTable(@Param("tableId") Integer tableId);

    /**
     * 删除列的记录
     *
     * @param tableId 表 ID
     */
    void delCols(@Param("tableId") Integer tableId);

    /**
     * 根据列id查询列名
     *
     * @param colId 列 ID
     * @return 列名
     */
    String findColNameByColid(@Param("colId") Integer colId);

    /**
     * 在自由库的表中修改列
     *
     * @param map 列信息
     */
    void changeCol(Map<String, String> map);

    /**
     * 在列信息中修改
     *
     * @param cols 列信息
     */
    void updateColInfo(Cols cols);

    /**
     * 插入列
     *
     * @param map 列信息
     */
    void insertCol(Map<String, String> map);

    /**
     * 删除列
     *
     * @param map 列信息
     */
    void dropCol(Map<String, String> map);

    /**
     * 删除列信息
     *
     * @param colId 列 ID
     */
    void delCol(@Param("colId") Integer colId);

    /**
     * 获取查询条数
     *
     * @param tableName 表名
     */
    Integer selectCounts(String tableName);
}
