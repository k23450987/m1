package project.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.domain.Cols;
import project.domain.Table;
import project.service.TableService;

@Controller
public class TableController {

	@Resource
	private TableService tableService;

	/*
	 * @RequestMapping("/creatTable") public String test(String[]
	 * params,String[] type,String[] unique) {
	 * 
	 * System.out.println(params); System.out.println(type);
	 * System.out.println(unique); List<String> paramsList =
	 * Arrays.asList(params); List<String> typeList = Arrays.asList(type);
	 * List<String> uniqueList = Arrays.asList(unique); List<Cols> list = new
	 * ArrayList<Cols>(); for (int i = 0; i < paramsList.size(); i++) { Cols col
	 * = new Cols(); col.setParams(paramsList.get(i));
	 * col.setType(typeList.get(i)); //col.setUnique(uniqueList.get(i));
	 * list.add(col); }
	 * 
	 * 
	 * return "/login.jsp"; }
	 */

	/**
	 * 建表
	 */
	@ResponseBody
	@RequestMapping("/addTable.action")
	public String addTable(String tableName, String json) {
		// System.out.println("----------------");
		// System.out.println(json);
		// System.out.println(tableName);
		// 在表信息中添加表名
		tableService.addTable(tableName);
		// 找到该表的id值
		Integer tableId = tableService.findTableIdByName(tableName);
		Map<String, Object> map = new HashMap<>();
		// 建表时的sql语句
		List<String> keys = new ArrayList<>();
		// 用于设置外键的sql语句
		StringBuilder pksb = new StringBuilder("primary key (");

		try {
			List<Cols> cols = JSON.parseArray(json, Cols.class);
			for (Cols col : cols) {
				col.setTableId(tableId);
				tableService.addCol(col);
				if (col.getUnique().equals("true")) {
					pksb.append(col.getParams()).append(",");
				}
				keys.add((col.getParams() + " " + col.getType() + "(30)"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 通过判断设置外键的字符串中有没有外键的字段名，从而判断是否需要设置外键
		pksb.deleteCharAt(pksb.length() - 1);
		pksb.append(")");
		pksb.length();
		char c = pksb.charAt(12);
		if (c != ')') {
			keys.add(pksb.toString());
		}
		map.put("tablename", tableName);
		map.put("keys", keys);
		tableService.createTable(map);
		return "true";
	}

	/**
	 * 查询自由库数据
	 */
	@RequestMapping("/toFindData.action")
	public String toFindData(Integer tableId, Model model) {
		model.addAttribute("tableId", tableId);

		return "/pageTest";
	}

	@RequestMapping("/findData.action")
	public String find(Integer tableId, Model model) {
		// 1、分页查询
		// 2、能查询表的列，设置列的模糊查询关键字查询
		// 3、页面处理（不要用Easyui，用纯粹的html+jQuery）
		// 获取查询结果
		List<Map<String, Object>> maps = tableService.select(tableId);
		Set<String> key = new TreeSet<>();
		for (Map<String, Object> map : maps) {
			// 获取列名
			Set<String> set = map.keySet();
			for (String string : set) {
				// if(map.get(string) == null){
				// map.put(string, "未设定");
				// }
				key.add(string);
			}
		}
		for (Map<String, Object> map : maps) {
			for (String string : key) {
				if (map.get(string) == null) {
					map.put(string, null);
				}
			}

		}
		for (Map<String, Object> map : maps) {
			Set<String> keySet = map.keySet();
			model.addAttribute("set", keySet);
		}
		model.addAttribute("maps", maps);
		return "/manage/tableManage/hello";
	}

	/**
	 * !!!!重要 查询自由库数据
	 */
	@ResponseBody
	@RequestMapping("/findData1.action")
	public Map<String, Object> find1(Integer tableId) {
		// 获取查询结果
		List<Map<String, Object>> datas = tableService.select(tableId);
		List<Cols> cols = tableService.findColsByTableId(tableId);
		// 构造返回
		Map<String, Object> map = new HashMap<>();
		map.put("datas", datas);
		map.put("cols", cols);
		return map;
	}

	/**
	 * 分页查询
	 * @param tableId 自由库id
	 * @param pageNum 当前页数
	 */
	@ResponseBody
	@RequestMapping("/findData2")
	public Map<String, Object> find2(Integer tableId, Integer pageNum) {
		// 获取查询结果
        PageInfo<Map<String, Object>> datas = tableService.selectPage(tableId, pageNum);
        List<Cols> cols = tableService.findColsByTableId(tableId);
		// 构造返回
		Map<String, Object> map = new HashMap<>();
		map.put("datas", datas);
		map.put("cols", cols);
		return map;
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/test.spring") public Integer selectCounts(){
	 * 
	 * return tableService.selectCounts("bbb");
	 * 
	 * 
	 * 
	 * }
	 */
	/*
	 * @RequestMapping("/test2") public String test2(String
	 * tableName,@RequestBody List<Cols> list) { System.out.println(tableName);
	 * List<String> keys = new ArrayList<String>(); for (Cols cols : list) {
	 * System.out.println(cols.toString()); StringBuffer sBuffer = new
	 * StringBuffer();
	 * sBuffer.append(cols.getParams()+" "+cols.getType()+"(30)"); if
	 * (cols.getUnique().equals("true")) {
	 * sBuffer.append(" "+"not null primary key auto_increment"); }
	 * keys.add(sBuffer.toString()); } return "/login"; }
	 */

	/**
	 * 自由库列表
	 */
	@RequestMapping("/tableList.action")
	public String tableList(Model model) {
		List<Table> tables = tableService.findTables();
		model.addAttribute("tables", tables);
		return "/manage/tableManage/list";
	}

	/**
	 * 表格列
	 */
	@RequestMapping("/colsList.action")
	public String colsList(Integer tableId, Model model) {
		List<Cols> cols = tableService.findColsByTableId(tableId);
		model.addAttribute("cols", cols);
		return "/manage/tableManage/colsList";
	}

	/**
	 * 删除自由库
	 */
	@ResponseBody
	@RequestMapping("/tableDel.action")
	public String tableDel(Integer tableId) {
		int size = tableService.select(tableId).size();
		// System.out.println(size);
		// 判断自由库中有无数据
		if (size > 0) {
			// 有数据，不能删除
			return "false";
		}
		tableService.delete(tableId);
		return "true";
	}

	/**
	 * 编辑自由库
	 */
	@RequestMapping("/tabletoEdit.action")
	public String tabletoEdit(Integer tableId, Model model) {
		List<Cols> cols = tableService.findColsByTableId(tableId);
		String tableName = tableService.findTableNameById(tableId);
		model.addAttribute("cols", cols);
		model.addAttribute("tableName", tableName);
		List<Map<String, Object>> maps = tableService.select(tableId);
		if (maps.size() > 0) {
			return "/manage/tableManage/colsList2";
		} else {
			return "/manage/tableManage/colsEdit";
		}
	}

	/**
	 * 提交编辑结果
	 */
	@ResponseBody
	@RequestMapping("/tableEdit.action")
	public String tableEdit(String json, String tableName) {
		try {
			// json转对象
			List<Cols> cols = JSON.parseArray(json, Cols.class);
			for (Cols col : cols) {
				// 判断自由库的这列是已有的还是新增的
				if (col.getId() != null) {
					// 已有的，修改
					tableService.edit(col, tableName);
				} else {
					// 新增的，添加列
					tableService.insertCol(col, tableName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "true";
	}

	/**
	 * 删除某一列
	 */
	@ResponseBody
	@RequestMapping("/dropCol.action")
	public String dropCol(String tableName, String params, Integer colid) {
		if (colid != null) {
			Map<String, String> map = new HashMap<>();
			map.put("tableName", tableName);
			map.put("columnName", params);
			// 在列信息记录中删除
			tableService.delCol(colid);
			// 在自由库中删除
			tableService.dropCol(map);
			return "true";
		}
		return null;
	}

	/**
	 * 前往添加自由库
	 */
	@RequestMapping("/toAddTable.action")
	public String toAddTable() {
		return "/manage/tableManage/addtable";

	}

	/**
	 * 检查自由库名称是否可用
	 */
	@ResponseBody
	@RequestMapping("/checkTableName.action")
	public String checkTableName(String tableName) {
		Integer id = tableService.findTableIdByName(tableName);
		if (id != null) {
			return "false";
		} else {
			return "true";
		}
	}

	/**
	 * 下面为模糊查询方法
	 */
	@ResponseBody
	@RequestMapping("/getCollist.action")
	public List<Cols> getCollist(Integer tableId) {
		// 获取当前自由库的列
        return tableService.findColsByTableId(tableId);
	}

	@ResponseBody
	@RequestMapping("/selectLike.action")
	public Map<String, Object> selectLike(Integer tableId, String text,
			Integer colid, Integer pageNum, Integer pagesize) {
		// 要模糊查询的列
		String params = tableService.findColNameByColId(colid);
		// 自由库名称
		String tablename = tableService.findTableNameById(tableId);
		// 封装查询参数
		Map<String, Object> map = new HashMap<>();
        map.put("tablename", tablename);
		map.put("params", params);
		map.put("text", text);
		// 返回查询结果
        PageInfo<Map<String, Object>> datas = tableService.selectLike(map, pageNum, pagesize);
        // 返回列
		List<Cols> cols = tableService.findColsByTableId(tableId);
		// 封装查询结果
		Map<String, Object> result = new HashMap<>();
		result.put("cols", cols);
		result.put("datas", datas);
		return result;
	}
}
