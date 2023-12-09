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
public class Train implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trainNo;

    private String tarinNumber;

    private String tarinType;

    private Integer tarinCarriages;

    private String tarinEndStation;

    private String tarinStartStation;

    private String tarinStartTime;

    private String tarinEndTime;

    private String tarinArriveDay;

    private String tarinRunningTime;

    private String tarinRunningType;

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
    public String getTarinNumber() {
        return tarinNumber;
    }

    public void setTarinNumber(String tarinNumber) {
        this.tarinNumber = tarinNumber;
    }
    public String getTarinType() {
        return tarinType;
    }

    public void setTarinType(String tarinType) {
        this.tarinType = tarinType;
    }
    public Integer getTarinCarriages() {
        return tarinCarriages;
    }

    public void setTarinCarriages(Integer tarinCarriages) {
        this.tarinCarriages = tarinCarriages;
    }
    public String getTarinEndStation() {
        return tarinEndStation;
    }

    public void setTarinEndStation(String tarinEndStation) {
        this.tarinEndStation = tarinEndStation;
    }
    public String getTarinStartStation() {
        return tarinStartStation;
    }

    public void setTarinStartStation(String tarinStartStation) {
        this.tarinStartStation = tarinStartStation;
    }
    public String getTarinStartTime() {
        return tarinStartTime;
    }

    public void setTarinStartTime(String tarinStartTime) {
        this.tarinStartTime = tarinStartTime;
    }
    public String getTarinEndTime() {
        return tarinEndTime;
    }

    public void setTarinEndTime(String tarinEndTime) {
        this.tarinEndTime = tarinEndTime;
    }
    public String getTarinArriveDay() {
        return tarinArriveDay;
    }

    public void setTarinArriveDay(String tarinArriveDay) {
        this.tarinArriveDay = tarinArriveDay;
    }
    public String getTarinRunningTime() {
        return tarinRunningTime;
    }

    public void setTarinRunningTime(String tarinRunningTime) {
        this.tarinRunningTime = tarinRunningTime;
    }
    public String getTarinRunningType() {
        return tarinRunningType;
    }

    public void setTarinRunningType(String tarinRunningType) {
        this.tarinRunningType = tarinRunningType;
    }

    @Override
    public String toString() {
        return "Train{" +
            "trainNo=" + trainNo +
            ", tarinNumber=" + tarinNumber +
            ", tarinType=" + tarinType +
            ", tarinCarriages=" + tarinCarriages +
            ", tarinEndStation=" + tarinEndStation +
            ", tarinStartStation=" + tarinStartStation +
            ", tarinStartTime=" + tarinStartTime +
            ", tarinEndTime=" + tarinEndTime +
            ", tarinArriveDay=" + tarinArriveDay +
            ", tarinRunningTime=" + tarinRunningTime +
            ", tarinRunningType=" + tarinRunningType +
        "}";
    }
}
