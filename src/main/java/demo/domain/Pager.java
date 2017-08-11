package demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {

	private int count;// 总记录条数
	private List<T> datas = new ArrayList<T>();// 查询的分页结果

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
