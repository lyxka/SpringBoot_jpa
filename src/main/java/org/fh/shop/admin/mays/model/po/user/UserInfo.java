package org.fh.shop.admin.mays.model.po.user;

import org.fh.shop.admin.mays.model.po.dept.DeptInfo;

import javax.persistence.*;
import java.util.Date;

/**
 * 类名: UserInfo
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 14:43
 */

@Entity
@Table(name = "t_user", schema = "test")
@NamedEntityGraph(name = "User.Graph", attributeNodes = {@NamedAttributeNode("deptInfo")})
public class UserInfo {
    private int id;
    private String userName;
    private String userPassword;
    private String salt;
    private Date loginDate;
    private Integer loginCount;
    private Date errorLoginDate;
    private Integer errorLoginCount;
    private Integer stauts;
    private String userRealName;
    private Date birthday;
    private Integer deptId;
    private Double salary;
    private Integer sex;
    private String imagePath;

    private DeptInfo deptInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId", referencedColumnName="id", insertable=false, updatable=false)
    public DeptInfo getDeptInfo() {
        return deptInfo;
    }

    public void setDeptInfo(DeptInfo deptInfo) {
        this.deptInfo = deptInfo;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userPassword", nullable = true, length = 50)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "salt", nullable = true, length = 50)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "loginDate", nullable = true)
    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Basic
    @Column(name = "loginCount", nullable = true)
    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Basic
    @Column(name = "errorLoginDate", nullable = true)
    public Date getErrorLoginDate() {
        return errorLoginDate;
    }

    public void setErrorLoginDate(Date errorLoginDate) {
        this.errorLoginDate = errorLoginDate;
    }

    @Basic
    @Column(name = "errorLoginCount", nullable = true)
    public Integer getErrorLoginCount() {
        return errorLoginCount;
    }

    public void setErrorLoginCount(Integer errorLoginCount) {
        this.errorLoginCount = errorLoginCount;
    }

    @Basic
    @Column(name = "stauts", nullable = true)
    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
    }

    @Basic
    @Column(name = "userRealName", nullable = true, length = 50)
    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "deptId", nullable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "salary", nullable = true, precision = 2)
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "imagePath", nullable = true, length = 255)
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id) return false;
        if (userName != null ? !userName.equals(userInfo.userName) : userInfo.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(userInfo.userPassword) : userInfo.userPassword != null)
            return false;
        if (salt != null ? !salt.equals(userInfo.salt) : userInfo.salt != null) return false;
        if (loginDate != null ? !loginDate.equals(userInfo.loginDate) : userInfo.loginDate != null) return false;
        if (loginCount != null ? !loginCount.equals(userInfo.loginCount) : userInfo.loginCount != null) return false;
        if (errorLoginDate != null ? !errorLoginDate.equals(userInfo.errorLoginDate) : userInfo.errorLoginDate != null)
            return false;
        if (errorLoginCount != null ? !errorLoginCount.equals(userInfo.errorLoginCount) : userInfo.errorLoginCount != null)
            return false;
        if (stauts != null ? !stauts.equals(userInfo.stauts) : userInfo.stauts != null) return false;
        if (userRealName != null ? !userRealName.equals(userInfo.userRealName) : userInfo.userRealName != null)
            return false;
        if (birthday != null ? !birthday.equals(userInfo.birthday) : userInfo.birthday != null) return false;
        if (deptId != null ? !deptId.equals(userInfo.deptId) : userInfo.deptId != null) return false;
        if (salary != null ? !salary.equals(userInfo.salary) : userInfo.salary != null) return false;
        if (sex != null ? !sex.equals(userInfo.sex) : userInfo.sex != null) return false;
        if (imagePath != null ? !imagePath.equals(userInfo.imagePath) : userInfo.imagePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (loginDate != null ? loginDate.hashCode() : 0);
        result = 31 * result + (loginCount != null ? loginCount.hashCode() : 0);
        result = 31 * result + (errorLoginDate != null ? errorLoginDate.hashCode() : 0);
        result = 31 * result + (errorLoginCount != null ? errorLoginCount.hashCode() : 0);
        result = 31 * result + (stauts != null ? stauts.hashCode() : 0);
        result = 31 * result + (userRealName != null ? userRealName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", loginDate=" + loginDate +
                ", loginCount=" + loginCount +
                ", errorLoginDate=" + errorLoginDate +
                ", errorLoginCount=" + errorLoginCount +
                ", stauts=" + stauts +
                ", userRealName='" + userRealName + '\'' +
                ", birthday=" + birthday +
                ", deptId=" + deptId +
                ", salary=" + salary +
                ", sex=" + sex +
                ", imagePath='" + imagePath + '\'' +
                ", deptInfo=" + deptInfo +
                '}';
    }
}
