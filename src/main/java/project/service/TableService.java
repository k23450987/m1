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
     */
    List<Map<String, Object>> select(Integer tableId);

    /**
     * 添加表信息
     */
    void addTable(String tablename);

    /**
     * 查找自由库id
     */
    Integer findTableIdByName(String tablename);

    /**
     * 添加行信息
     */
    void addCol(Cols cols);

    /**
     * 查找库信息
     */
    List<Table> findTables();

    /**
     * 查找库中的行
     */
    List<Cols> findColsByTableId(Integer tableId);

    /**
     * 通过自由库id查找自由库名称
     */
    String findTableNameById(Integer tableId);

    /**
     * 删除自由库
     */
    void delete(Integer tableId);

    /**
     * 编辑列
     */
    void edit(Cols cols, String tableName);

    /**
     * 插入列
     */
    void insertCol(Cols cols, String tableName);

    /**
     * 删除列，在列信息中
     */
    void dropCol(Map<String, String> map);

    /**
     * 删除列，在自由库中
     */
    void delCol(Integer colid);

    /**
     * 查询总条数
     */
    Integer selectCounts(String tablename);

    /**
     * 分页查询
     */
    PageInfo<Map<String, Object>> selectPage(Integer tableId, Integer pageNum);

    /**
     * 模糊查询
     */
    PageInfo<Map<String, Object>> selectLike(Map<String, Object> map, Integer pageNum, Integer pageSize);

    String findColNameByColid(Integer colid);

    Integer selectLikeCount(Map<String, Object> map);
}