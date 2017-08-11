package project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager<T> implements Serializable {

	private static final long serialVersionUID = 1085502176430689125L;

	/**
	 * 总条数
	 */
	private Integer counts;
	/**
	 * 查询结果
	 */
	private List<T> datas = new ArrayList<T>();

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}


	
}
