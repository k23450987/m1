package project.domain;

import java.io.Serializable;

public class Dept implements Serializable {
	private static final long serialVersionUID = 6521026330957400338L;
	/**
	 * 部门id
	 */
	private Integer dept_id;
	/**
	 * 部门名称
	 */
	private String dept_name;
	/**
	 * 父部门名称
	 */
	private String fdept_name;
	/**
	 * 父部门id
	 */
	private Integer fdept_id;

	/* 属性 get,set 方法 */
	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Integer getFdept_id() {
		return fdept_id;
	}

	public void setFdept_id(Integer fdept_id) {
		this.fdept_id = fdept_id;
	}

	public String getFdept_name() {
		return fdept_name;
	}

	public void setFdept_name(String fdept_name) {
		this.fdept_name = fdept_name;
	}

	@Override
	public String toString() {
		return "Dept [dept_id=" + dept_id + ", dept_name=" + dept_name
				+ ", fdept_name=" + fdept_name + ", fdept_id=" + fdept_id + "]";
	}

}
