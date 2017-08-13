package project.domain;

import java.io.Serializable;

public class Dept implements Serializable {
	private static final long serialVersionUID = 6521026330957400338L;
	/**
	 * 部门id
	 */
	private Integer id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 父部门名称
	 */
	private String parentName;
	/**
	 * 父部门id
	 */
	private Integer parentId;

    public Dept() {

    }

    public Dept(Integer id, String name, String parentName, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentName = parentName;
        this.parentId = parentId;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
