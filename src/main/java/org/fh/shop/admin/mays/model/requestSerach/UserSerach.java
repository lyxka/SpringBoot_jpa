package org.fh.shop.admin.mays.model.requestSerach;

import org.fh.shop.admin.mays.model.po.user.UserInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 类名: UserSerach
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 18:11
 */

public class UserSerach extends UserInfo implements Serializable {
    private static final long serialVersionUID = -4400527993416560210L;

    private Integer draw;
    private Integer start = 0;
    private Integer length = 10;
    private Date minBirthday;
    private Date maxBirthday;
    private Double minSalary;
    private Double maxSalary;
    private List<Integer> deptIds;

    public Date getMinBirthday() {
        return minBirthday;
    }

    public void setMinBirthday(Date minBirthday) {
        this.minBirthday = minBirthday;
    }

    public Date getMaxBirthday() {
        return maxBirthday;
    }

    public void setMaxBirthday(Date maxBirthday) {
        this.maxBirthday = maxBirthday;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Integer> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<Integer> deptIds) {
        this.deptIds = deptIds;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
