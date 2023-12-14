package com.hdu.train.vo;

/**
 * @author 菠萝
 * @version 1.0
 * @description: TODO
 * @date 2023/12/14 11:14
 */
public class TrainInfoVO {

    private String trainNo;
    private String trainNumber; // 使用 convert 方法将字段名转换为驼峰命名法
    private String trainType;
    private String trainCarriages;
    private String trainStartStation;
    private String trainEndStation;
    private String trainStartTime;
    private String trainEndTime;
    private String trainArriveDay;
    private String trainRunningTime;

    private String trainRunningType;

    public TrainInfoVO() {
    }

    @Override
    public String toString() {
        return "TrainInfoVO{" +
                "trainNo='" + trainNo + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", trainType='" + trainType + '\'' +
                ", trainCarriages='" + trainCarriages + '\'' +
                ", trainStartStation='" + trainStartStation + '\'' +
                ", trainEndStation='" + trainEndStation + '\'' +
                ", trainStartTime='" + trainStartTime + '\'' +
                ", trainEndTime='" + trainEndTime + '\'' +
                ", trainArriveDay='" + trainArriveDay + '\'' +
                ", trainRunningTime='" + trainRunningTime + '\'' +
                ", trainRunningType='" + trainRunningType + '\'' +
                '}';
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

    public String getTrainCarriages() {
        return trainCarriages;
    }

    public void setTrainCarriages(String trainCarriages) {
        this.trainCarriages = trainCarriages;
    }

    public String getTrainStartStation() {
        return trainStartStation;
    }

    public void setTrainStartStation(String trainStartStation) {
        this.trainStartStation = trainStartStation;
    }

    public String getTrainEndStation() {
        return trainEndStation;
    }

    public void setTrainEndStation(String trainEndStation) {
        this.trainEndStation = trainEndStation;
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

    public TrainInfoVO(String trainNo, String trainNumber, String trainType, String trainCarriages, String trainStartStation, String trainEndStation, String trainStartTime, String trainEndTime, String trainArriveDay, String trainRunningTime, String trainRunningType) {
        this.trainNo = trainNo;
        this.trainNumber = trainNumber;
        this.trainType = trainType;
        this.trainCarriages = trainCarriages;
        this.trainStartStation = trainStartStation;
        this.trainEndStation = trainEndStation;
        this.trainStartTime = trainStartTime;
        this.trainEndTime = trainEndTime;
        this.trainArriveDay = trainArriveDay;
        this.trainRunningTime = trainRunningTime;
        this.trainRunningType = trainRunningType;
    }
}
