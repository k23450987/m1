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

	/**
	 * 往树里添加节点
	 * @param nodes
	 * @param id
	 * @return
	 */
	public static List<TreeJson> buildtree(List<TreeJson> nodes, int id) {
		List<TreeJson> treeJsons = new ArrayList<TreeJson>();
		for (TreeJson treeJson : nodes) {
			TreeJson node = new TreeJson();
			node.setId(treeJson.getId());
			node.setText(treeJson.getText());
			if (id == treeJson.getPid()) {
				node.setChildren(buildtree(nodes, node.getId()));
				treeJsons.add(node);
			}
		}
		/*
		 * for (TreeJson treeJson : treeJsons) { if (treeJson.getPid()==0) {
		 * treeJson.setState("closed"); } }
		 */
		return treeJsons;
	}

	/**
	 * 将根节点的 state 设置为 "closed"
	 * @param treeList
	 * @return
	 */
	public static List<TreeJson> formatTree(List<TreeJson> treeList) {
		for (TreeJson treeJson : treeList) {
			if (treeJson.getChildren().size() != 0) {
				TreeJson.formatTree(treeJson.getChildren());
				treeJson.setState("closed");
			}
		}
		return treeList;
	}
}
