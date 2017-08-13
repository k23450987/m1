package project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeJson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9093374024040649332L;
	private Integer id;
	private Integer pid;
	private String text;
	private String iconCls;
	private String state;
	private String checked;
	private List<TreeJson> children = new ArrayList<TreeJson>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeJson> getChildren() {
		return children;
	}

	public void setChildren(List<TreeJson> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
}
