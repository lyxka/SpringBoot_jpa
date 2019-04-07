package org.fh.shop.admin.mays.serviceResponse;

import java.util.List;

/**
 * 类名: UserServiceResponse
 * 描述：
 *
 * @author
 * @create 2019-03-17 7:27
 **/

public class UserServiceResponse {

    /**
     * code : 200
     * message : 成功
     * data : [{"id":1,"userName":"123","password":"453","phone":"12345678911","email":"25255","birthdayStr":"2019-03-21 00:00:00","regTimeStr":"2019-03-16 18:54:23","lastLoginTimeStr":"2019-03-16 18:54:23","shengid":7,"shiid":7,"xianid":7,"shengName":null,"shiName":null,"xianName":null},{"id":2,"userName":"5643","password":"65432","phone":"13264646464","email":"25255","birthdayStr":"2019-03-21 00:00:00","regTimeStr":"2019-03-16 21:26:14","lastLoginTimeStr":"2019-03-16 21:26:14","shengid":150000,"shiid":150500,"xianid":150502,"shengName":"内蒙古自治区","shiName":"通辽市","xianName":"科尔沁区"},{"id":3,"userName":"5643","password":"65432","phone":"13264646464","email":"25255","birthdayStr":"2019-03-21 00:00:00","regTimeStr":"2019-03-16 21:31:21","lastLoginTimeStr":"2019-03-16 21:31:21","shengid":150000,"shiid":150500,"xianid":150502,"shengName":"内蒙古自治区","shiName":"通辽市","xianName":"科尔沁区"},{"id":4,"userName":"zzz","password":"5423","phone":"12345678911","email":"25255","birthdayStr":"2019-03-17 00:00:00","regTimeStr":"2019-03-17 07:04:57","lastLoginTimeStr":"2019-03-17 07:04:57","shengid":120000,"shiid":120100,"xianid":120110,"shengName":"天津","shiName":"天津市","xianName":"东丽区"}]
     */

    private int code;
    private String message;
    private List<UserVo> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UserVo> getData() {
        return data;
    }

    public void setData(List<UserVo> data) {
        this.data = data;
    }

    public static class UserVo {
        /**
         * id : 1
         * userName : 123
         * password : 453
         * phone : 12345678911
         * email : 25255
         * birthdayStr : 2019-03-21 00:00:00
         * regTimeStr : 2019-03-16 18:54:23
         * lastLoginTimeStr : 2019-03-16 18:54:23
         * shengid : 7
         * shiid : 7
         * xianid : 7
         * shengName : null
         * shiName : null
         * xianName : null
         */

        private int id;
        private String userName;
        private String password;
        private String phone;
        private String email;
        private String birthdayStr;
        private String regTimeStr;
        private String lastLoginTimeStr;
        private int shengid;
        private int shiid;
        private int xianid;
        private Object shengName;
        private Object shiName;
        private Object xianName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBirthdayStr() {
            return birthdayStr;
        }

        public void setBirthdayStr(String birthdayStr) {
            this.birthdayStr = birthdayStr;
        }

        public String getRegTimeStr() {
            return regTimeStr;
        }

        public void setRegTimeStr(String regTimeStr) {
            this.regTimeStr = regTimeStr;
        }

        public String getLastLoginTimeStr() {
            return lastLoginTimeStr;
        }

        public void setLastLoginTimeStr(String lastLoginTimeStr) {
            this.lastLoginTimeStr = lastLoginTimeStr;
        }

        public int getShengid() {
            return shengid;
        }

        public void setShengid(int shengid) {
            this.shengid = shengid;
        }

        public int getShiid() {
            return shiid;
        }

        public void setShiid(int shiid) {
            this.shiid = shiid;
        }

        public int getXianid() {
            return xianid;
        }

        public void setXianid(int xianid) {
            this.xianid = xianid;
        }

        public Object getShengName() {
            return shengName;
        }

        public void setShengName(Object shengName) {
            this.shengName = shengName;
        }

        public Object getShiName() {
            return shiName;
        }

        public void setShiName(Object shiName) {
            this.shiName = shiName;
        }

        public Object getXianName() {
            return xianName;
        }

        public void setXianName(Object xianName) {
            this.xianName = xianName;
        }
    }
}
