package project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.dao.TableDao;
import project.domain.Cols;
import project.domain.Table;
import project.service.TableService;

/**
 * @author Administrator
 * @see TableService
 */
@Service
public class TableServiceImpl implements TableService {

	@Resource
	private TableDao tableDao;

	public void createTable(Map<String, Object> map) {

		tableDao.createTable(map);
	}

	public List<Map<String, Object>> select(Integer tableId) {
		String tablename = this.findTableNameById(tableId);
		return tableDao.select(tablename);
	}

	public List<Map<String, Object>> selectPage(Integer tableId, Integer pageNum) {
		// 查找自由库名称
		String tablename = this.findTableNameById(tableId);
		// 设置每页显示条数
		Integer pagesize = 10;
		// 设置起始条数
		Integer offset = (pageNum - 1) * pagesize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tablename", tablename);
		map.put("offset", offset);
		map.put("pagesize", pagesize);
		return tableDao.selectPage(map);
	}

	public List<Map<String, Object>> selectLike(Map<String, Object> map) {

		return tableDao.selectLike(map);
	}

	public void addTable(String tablename) {
		tableDao.addTable(tablename);
	}

	public Integer findTableIdByName(String tablename) {
		return tableDao.findTableIdByName(tablename);
	}

	public String findTableNameById(Integer tableId) {
		return tableDao.findTableNameById(tableId);
	}

	public void addCol(Cols cols) {
		tableDao.addCol(cols);
	}

	public List<Table> findTables() {
		return tableDao.findTables();
	}

	public List<Cols> findColsByTableId(Integer tableId) {
		return tableDao.findColsByTableId(tableId);
	}

	public void delete(Integer tableId) {
		tableDao.dropTable(this.findTableNameById(tableId));
		tableDao.delTable(tableId);
		tableDao.delCols(tableId);
	}

	public String findColNameByColid(Integer colid) {
		return tableDao.findColNameByColid(colid);
	}

	public void edit(Cols cols, String tableName) {
		String oldName = tableDao.findColNameByColid(cols.getColid());
		String newName = cols.getParams();
		// String sql =
		// "alter table "+tableName+" change "+oldName+" "+newName+" ";
		String type = cols.getType();
		if (type.equals("varchar")) {
			type = type + "(30)";
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("tableName", tableName);
		map.put("oldName", oldName);
		map.put("newName", newName);
		map.put("type", type);
		// 在自由苦衷修改
		tableDao.changeCol(map);
		// 在列信息的表中修改
		tableDao.updateColInfo(cols);
		// System.out.println("----");
		// System.out.println(sql);
	}

	public void insertCol(Cols cols, String tableName) {
		String columnName = cols.getParams();
		if (!(columnName == null || columnName.length() <= 0)) {

			// String sql =
			// "alter table "+tableName+" add column "+columnName+" ";
			String type = cols.getType();
			// 判断属性是否需要设置长度
			if (type.equals("varchar")) {
				type = type + "(30)";
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("tableName", tableName);
			map.put("columnName", columnName);
			map.put("type", type);
			Integer tableId = this.findTableIdByName(tableName);
			// 设置列所属的自由库
			cols.setTableId(tableId);
			// 在自由苦衷添加
			tableDao.insertCol(map);
			// 在列信息中添加
			tableDao.addCol(cols);
		}
	}

	public void dropCol(Map<String, String> map) {
		tableDao.dropCol(map);
	}

	public void delCol(Integer colid) {
		tableDao.delCol(colid);
	}

	public Integer selectCounts(String tablename) {
		return tableDao.selectCounts(tablename);
	}

	public Integer selectLikeCount(Map<String, Object> map) {

		return tableDao.selectLikeCount(map);
	}
}
