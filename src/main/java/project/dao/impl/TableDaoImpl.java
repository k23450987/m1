package project.dao.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import project.dao.TableDao;
import project.domain.Cols;
import project.domain.Table;
import project.mapper.TableMapper;

/**
 * @see TableDao
 */
@Repository
public class TableDaoImpl extends SqlSessionDaoSupport implements TableDao {

	/**
	 * 获取 SqlSessionFactory
	 */
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public void createTable(Map<String, Object> map) {

		getSqlSession().getMapper(TableMapper.class).createTable(map);

	}

	public List<Map<String, Object>> select(String tablename) {
		return getSqlSession().getMapper(TableMapper.class).select(tablename);
	}

	public List<Map<String, Object>> selectPage(Map<String, Object> map) {
		return getSqlSession().getMapper(TableMapper.class).selectByPages(map);
	}

	public List<Map<String, Object>> selectLike(Map<String, Object> map) {
		return getSqlSession().getMapper(TableMapper.class).selectLike(map);
	}

	public void addTable(String tablename) {
		getSqlSession().getMapper(TableMapper.class).addTable(tablename);

	}

	public Integer findTableIdByName(String tablename) {
		return getSqlSession().getMapper(TableMapper.class).findTableIdByName(tablename);
	}

	public String findTableNameById(Integer tableId) {
		return getSqlSession().getMapper(TableMapper.class).findTableNameById(tableId);
	}

	public void addCol(Cols cols) {
		getSqlSession().getMapper(TableMapper.class).addCol(cols);
	}

	public List<Table> findTables() {
		return getSqlSession().getMapper(TableMapper.class).findTables();
	}

	public List<Cols> findColsByTableId(Integer tableId) {
		return getSqlSession().getMapper(TableMapper.class).findColsByTableId(tableId);
	}

	public void dropTable(String tablename) {
		getSqlSession().getMapper(TableMapper.class).dropTable(tablename);
	}

	public void delTable(Integer tableId) {
		getSqlSession().getMapper(TableMapper.class).delTable(tableId);
	}

	public void delCols(Integer tableId) {
		getSqlSession().getMapper(TableMapper.class).delCols(tableId);
	}

	public String findColNameByColid(Integer colid) {
		return getSqlSession().getMapper(TableMapper.class).findColNameByColid(colid);
	}

	public void changeCol(Map<String, String> map) {
		getSqlSession().getMapper(TableMapper.class).changeCol(map);
	}

	public void updateColInfo(Cols cols) {
		getSqlSession().getMapper(TableMapper.class).updateColInfo(cols);
	}

	public void insertCol(Map<String, String> map) {
		getSqlSession().getMapper(TableMapper.class).insertCol(map);
	}

	public void dropCol(Map<String, String> map) {
		getSqlSession().getMapper(TableMapper.class).dropCol(map);
	}

	public void delCol(Integer colid) {
		getSqlSession().getMapper(TableMapper.class).delCol(colid);
	}

	public Integer selectCounts(String tablename) {
		return getSqlSession().getMapper(TableMapper.class).selectCounts(tablename);
	}

	public Integer selectLikeCount(Map<String, Object> map) {
		return getSqlSession().getMapper(TableMapper.class).selectLikeCount(map);
	}
}