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

    private String trainNumber;

    private String trainType;

    private Integer trainCarriages;

    private String trainEndStation;

    private String trainStartStation;

    private String trainStartTime;

    private String trainEndTime;

    private String trainArriveDay;

    private String trainRunningTime;

    private String trainRunningType;

    private Double highPrice;

    private Double mediumPrice;

    private Double lowPrice;

    public Train(String trainNo, String trainNumber, String trainType, Integer trainCarriages, String trainEndStation, String trainStartStation, String trainStartTime, String trainEndTime, String trainArriveDay, String trainRunningTime, String trainRunningType, Double highPrice, Double mediumPrice, Double lowPrice) {
        this.trainNo = trainNo;
        this.trainNumber = trainNumber;
        this.trainType = trainType;
        this.trainCarriages = trainCarriages;
        this.trainEndStation = trainEndStation;
        this.trainStartStation = trainStartStation;
        this.trainStartTime = trainStartTime;
        this.trainEndTime = trainEndTime;
        this.trainArriveDay = trainArriveDay;
        this.trainRunningTime = trainRunningTime;
        this.trainRunningType = trainRunningType;
        this.highPrice = highPrice;
        this.mediumPrice = mediumPrice;
        this.lowPrice = lowPrice;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNo='" + trainNo + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", trainType='" + trainType + '\'' +
                ", trainCarriages=" + trainCarriages +
                ", trainEndStation='" + trainEndStation + '\'' +
                ", trainStartStation='" + trainStartStation + '\'' +
                ", trainStartTime='" + trainStartTime + '\'' +
                ", trainEndTime='" + trainEndTime + '\'' +
                ", trainArriveDay='" + trainArriveDay + '\'' +
                ", trainRunningTime='" + trainRunningTime + '\'' +
                ", trainRunningType='" + trainRunningType + '\'' +
                ", highPrice=" + highPrice +
                ", mediumPrice=" + mediumPrice +
                ", lowPrice=" + lowPrice +
                '}';
    }

    public Train() {
    }

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

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public Integer getTrainCarriages() {
        return trainCarriages;
    }

    public void setTrainCarriages(Integer trainCarriages) {
        this.trainCarriages = trainCarriages;
    }

    public String getTrainEndStation() {
        return trainEndStation;
    }

    public void setTrainEndStation(String trainEndStation) {
        this.trainEndStation = trainEndStation;
    }

    public String getTrainStartStation() {
        return trainStartStation;
    }

    public void setTrainStartStation(String trainStartStation) {
        this.trainStartStation = trainStartStation;
    }

    public String getTrainStartTime() {
        return trainStartTime;
    }

    public void setTrainStartTime(String trainStartTime) {
        this.trainStartTime = trainStartTime;
    }

    public String getTrainEndTime() {
        return trainEndTime;
    }

    public void setTrainEndTime(String trainEndTime) {
        this.trainEndTime = trainEndTime;
    }

    public String getTrainArriveDay() {
        return trainArriveDay;
    }

    public void setTrainArriveDay(String trainArriveDay) {
        this.trainArriveDay = trainArriveDay;
    }

    public String getTrainRunningTime() {
        return trainRunningTime;
    }

    public void setTrainRunningTime(String trainRunningTime) {
        this.trainRunningTime = trainRunningTime;
    }

    public String getTrainRunningType() {
        return trainRunningType;
    }

    public void setTrainRunningType(String trainRunningType) {
        this.trainRunningType = trainRunningType;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(Double mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }
}
