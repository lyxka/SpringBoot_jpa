package org.fh.shop.admin.mays.model.responseUser;

import java.io.Serializable;

/**
 * 类名: DeptResponse
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 20:26
 */

public class DeptResponse implements Serializable {

    private static final long serialVersionUID = -6749716235608666716L;
    private Integer id;
    private String name;
    private String remark;
    private Integer pid;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
