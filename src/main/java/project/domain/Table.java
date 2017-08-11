package project.domain;

import java.io.Serializable;
import java.util.List;

public class Table implements Serializable {

	private static final long serialVersionUID = -2277539254411250758L;

	private Integer id;
	private String name;
	private List<String> params;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}



	

}
