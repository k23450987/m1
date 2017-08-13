package project.service;

import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;

import project.domain.Cols;
import project.domain.Table;

public interface TableService {

    /**
     * 新建自由库
     */
    void createTable(Map<String, Object> map);

    /**
     * 查询自由库数据
     *
     * @param tableId 表 ID
     */
    List<Map<String, Object>> select(Integer tableId);

    /**
     * 添加表信息
     *
     * @param tableName 表名
     */
    void addTable(String tableName);

    /**
     * 根据表名查找自由库 ID
     *
     * @param tableName 表名
     */
    Integer findTableIdByName(String tableName);

    /**
     * 添加列信息
     *
     * @param cols 列对象
     */
    void addCol(Cols cols);

    /**
     * 查找库信息
     */
    List<Table> findTables();

    /**
     * 查找库中的列
     *
     * @param tableId 表 ID
     */
    List<Cols> findColsByTableId(Integer tableId);

    /**
     * 通过自由库id查找自由库名称
     *
     * @param tableId 表 ID
     */
    String findTableNameById(Integer tableId);

    /**
     * 删除自由库
     *
     * @param tableId 表 ID
     */
    void delete(Integer tableId);

    /**
     * 编辑列
     *
     * @param cols 列对象
     * @param tableName 表名
     */
    void edit(Cols cols, String tableName);

    /**
     * 插入列
     *
     * @param cols 列对象
     * @param tableName 表名
     */
    void insertCol(Cols cols, String tableName);

    /**
     * 删除列，在列信息中
     */
    void dropCol(Map<String, String> map);

    /**
     * 删除列，在自由库中
     *
     * @param colId 列 ID
     */
    void delCol(Integer colId);

    /**
     * 查询总条数
     *
     * @param tableName 表名
     */
    Integer selectCounts(String tableName);

    /**
     * 分页查询
     *
     * @param tableId 表 ID
     * @param pageNum 页数
     */
    PageInfo<Map<String, Object>> selectPage(Integer tableId, Integer pageNum);

    /**
     * 模糊查询
     *
     * @param map 查询条件
     * @param pageNum 页数
     * @param pageSize 显示条数
     */
    PageInfo<Map<String, Object>> selectLike(Map<String, Object> map, Integer pageNum, Integer pageSize);

    /**
     * 根据 列 ID 查找列名
     *
     * @param colId 列 ID
     * @return 列名
     */
    String findColNameByColId(Integer colId);

    Integer selectLikeCount(Map<String, Object> map);
}