package org.fh.shop.admin.mays.model.responseUser;

import org.fh.shop.admin.mays.model.po.user.UserInfo;

import java.io.Serializable;

/**
 * 类名: UserResponse
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 19:21
 */

public class UserResponse extends UserInfo implements Serializable {
    private static final long serialVersionUID = 4988936362745863944L;
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    // 部门名称
    private String industryTitle;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String getIndustryTitle() {
        return industryTitle;
    }

    public void setIndustryTitle(String industryTitle) {
        this.industryTitle = industryTitle;
    }
}
