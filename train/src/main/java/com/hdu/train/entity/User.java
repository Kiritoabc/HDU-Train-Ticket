package com.hdu.train.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userPhoneNumber;

    private String userPassword;

    private String userEmail;

    private String userRealName;

    /**
     * 成人0学生1
     */
    private Integer userType;

    private String userIdNumber;

    /**
     * 男1女0
     */
    private Integer userGender;

    private String userAddress;

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(String userIdNumber) {
        this.userIdNumber = userIdNumber;
    }
    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
            "userPhoneNumber=" + userPhoneNumber +
            ", userPassword=" + userPassword +
            ", userEmail=" + userEmail +
            ", userRealName=" + userRealName +
            ", userType=" + userType +
            ", userIdNumber=" + userIdNumber +
            ", userGender=" + userGender +
            ", userAddress=" + userAddress +
        "}";
    }
}
