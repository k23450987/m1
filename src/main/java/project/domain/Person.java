package project.domain;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 8358115794252123332L;
	/**
	 * 用户id
	 */
	private Integer id;
	/**
	 * 用户姓名
	 */
	private String name;
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
	private Integer deptId;
	/**
	 * 岗位id
	 */
	private Integer jobId;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 岗位名称
	 */
	private String jobName;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, String info, Integer deptId, Integer jobId,
            String deptName, String jobName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.info = info;
        this.deptId = deptId;
        this.jobId = jobId;
        this.deptName = deptName;
        this.jobName = jobName;
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", info='" + info + '\'' +
                ", deptId=" + deptId +
                ", jobId=" + jobId +
                ", deptName='" + deptName + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
