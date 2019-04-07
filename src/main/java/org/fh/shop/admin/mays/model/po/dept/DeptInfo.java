package org.fh.shop.admin.mays.model.po.dept;

import javax.persistence.*;
import java.util.Objects;

/**
 * 类名: DeptInfo
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 15:09
 */

@Entity
@Table(name = "t_dept", schema = "test")
public class DeptInfo {
    private int id;
    private String industryTitle;
    private Integer pid;
    private String remark;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "industryTitle", nullable = true, length = 50)
    public String getIndustryTitle() {
        return industryTitle;
    }

    public void setIndustryTitle(String industryTitle) {
        this.industryTitle = industryTitle;
    }

    @Basic
    @Column(name = "pid", nullable = true)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptInfo deptInfo = (DeptInfo) o;
        return id == deptInfo.id &&
                Objects.equals(industryTitle, deptInfo.industryTitle) &&
                Objects.equals(pid, deptInfo.pid) &&
                Objects.equals(remark, deptInfo.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, industryTitle, pid, remark);
    }

    @Override
    public String toString() {
        return "DeptInfo{" +
                "id=" + id +
                ", industryTitle='" + industryTitle + '\'' +
                ", pid=" + pid +
                ", remark='" + remark + '\'' +
                '}';
    }
}
