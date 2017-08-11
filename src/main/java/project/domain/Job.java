package project.domain;

import java.io.Serializable;

public class Job implements Serializable {

	private static final long serialVersionUID = 1798460009079477036L;
	/**
	 * 职位id
	 */
	private Integer job_id;
	/**
	 * 职位名称
	 */
	private String job_name;
	/**
	 * 所属部门id
	 */
	private Integer dept_id;
	/**
	 * 所属部门名称
	 */
	private String dept_name;
	/**
	 * 所属部门父部门id
	 */
	private Integer fdept_id;
	/**
	 * 所属部门父部门名称
	 */
	private String fdept_name;

	/* 属性 get,set 方法 */
	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

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
		return "Job [job_id=" + job_id + ", job_name=" + job_name
				+ ", dept_id=" + dept_id + ", dept_name=" + dept_name
				+ ", fdept_id=" + fdept_id + ", fdept_name=" + fdept_name + "]";
	}
	

}
