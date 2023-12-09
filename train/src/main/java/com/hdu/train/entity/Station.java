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
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trainNo;

    private String trainNumber;

    private String arriveDayStr;

    private String arriverTime;

    private String startTime;

    private String runningTime;

    private String stationNo;

    private String stationName;

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }
    public String getArriveDayStr() {
        return arriveDayStr;
    }

    public void setArriveDayStr(String arriveDayStr) {
        this.arriveDayStr = arriveDayStr;
    }
    public String getArriverTime() {
        return arriverTime;
    }

    public void setArriverTime(String arriverTime) {
        this.arriverTime = arriverTime;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }
    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Station{" +
            "trainNo=" + trainNo +
            ", trainNumber=" + trainNumber +
            ", arriveDayStr=" + arriveDayStr +
            ", arriverTime=" + arriverTime +
            ", startTime=" + startTime +
            ", runningTime=" + runningTime +
            ", stationNo=" + stationNo +
            ", stationName=" + stationName +
        "}";
    }
}
