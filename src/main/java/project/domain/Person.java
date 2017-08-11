package project.domain;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 8358115794252123332L;
	/**
	 * 用户id
	 */
	private Integer person_id;
	/**
	 * 用户姓名
	 */
	private String p_name;
	/**
	 * 用户年龄
	 */
	private Integer age;
	/**
	 * 用户信息
	 */
	private String info;
	/**
	 * 所属部门id
	 */
	private Integer dept_id;
	/**
	 * 岗位id
	 */
	private Integer job_id;
	/**
	 * 部门名称
	 */
	private String dept_name;
	/**
	 * 岗位名称
	 */
	private String job_name;

	public Integer getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}


}
