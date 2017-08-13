package project.domain;

import java.io.Serializable;

public class Cols implements Serializable {

    private static final long serialVersionUID = -7693596931133332178L;
    /**
     * 列id
     */
    private Integer id;
    /**
     * 列名
     */
    private String params;
    /**
     * 列类型
     */
    private String type;
    /**
     * 是否唯一
     */
    private String unique;
    /**
     * 所属的自由库
     */
    private Integer tableId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "Cols [id=" + id + ", params=" + params + ", type=" + type
                + ", unique=" + unique + ", tableId=" + tableId + "]";
    }

}
