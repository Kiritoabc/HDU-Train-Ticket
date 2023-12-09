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
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userPhoneNumber;

    private String passengerPhoneNumber;

    private String passengerRealName;

    private String passengerIdNumber;

    private Integer passengerType;

    private String passengerAdress;

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
    public String getPassengerPhoneNumber() {
        return passengerPhoneNumber;
    }

    public void setPassengerPhoneNumber(String passengerPhoneNumber) {
        this.passengerPhoneNumber = passengerPhoneNumber;
    }
    public String getPassengerRealName() {
        return passengerRealName;
    }

    public void setPassengerRealName(String passengerRealName) {
        this.passengerRealName = passengerRealName;
    }
    public String getPassengerIdNumber() {
        return passengerIdNumber;
    }

    public void setPassengerIdNumber(String passengerIdNumber) {
        this.passengerIdNumber = passengerIdNumber;
    }
    public Integer getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(Integer passengerType) {
        this.passengerType = passengerType;
    }
    public String getPassengerAdress() {
        return passengerAdress;
    }

    public void setPassengerAdress(String passengerAdress) {
        this.passengerAdress = passengerAdress;
    }

    @Override
    public String toString() {
        return "Passenger{" +
            "userPhoneNumber=" + userPhoneNumber +
            ", passengerPhoneNumber=" + passengerPhoneNumber +
            ", passengerRealName=" + passengerRealName +
            ", passengerIdNumber=" + passengerIdNumber +
            ", passengerType=" + passengerType +
            ", passengerAdress=" + passengerAdress +
        "}";
    }
}
