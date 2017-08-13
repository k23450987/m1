package project.domain;

import java.io.Serializable;

public class Job implements Serializable {

	private static final long serialVersionUID = 1798460009079477036L;
	/**
	 * 职位id
	 */
	private Integer id;
	/**
	 * 职位名称
	 */
	private String name;
	/**
	 * 所属部门id
	 */
	private Integer deptId;
	/**
	 * 所属部门名称
	 */
	private String deptName;
	/**
	 * 所属部门父部门id
	 */
	private Integer parentDeptId;
	/**
	 * 所属部门父部门名称
	 */
	private String parentDeptName;

	public Job() {
	}

	public Job(Integer id, String name, Integer deptId, String deptName, Integer parentDeptId,
			String parentDeptName) {
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.deptName = deptName;
		this.parentDeptId = parentDeptId;
		this.parentDeptName = parentDeptName;
	}

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

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getParentDeptId() {
		return parentDeptId;
	}

	public void setParentDeptId(Integer parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	public String getParentDeptName() {
		return parentDeptName;
	}

	public void setParentDeptName(String parentDeptName) {
		this.parentDeptName = parentDeptName;
	}

	@Override
	public String toString() {
		return "Job{" +
				"id=" + id +
				", name='" + name + '\'' +
				", deptId=" + deptId +
				", deptName='" + deptName + '\'' +
				", parentDeptId=" + parentDeptId +
				", parentDeptName='" + parentDeptName + '\'' +
				'}';
	}
}
