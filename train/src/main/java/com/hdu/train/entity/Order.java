package com.hdu.train.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    private String userPhone;

    private String passengerPhone;

    private String passengerId;

    private String trainNo;

    private String startStationNo;

    private String startStationName;

    private String endStationNo;

    private String endStationName;

    private String carriageNo;

    private String seatNo;

    private String orderMoney;

    private LocalDateTime orderCreateTime;

    private String orderStatus;

    private LocalDateTime trainStartDate;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }
    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }
    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
    public String getStartStationNo() {
        return startStationNo;
    }

    public void setStartStationNo(String startStationNo) {
        this.startStationNo = startStationNo;
    }
    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }
    public String getEndStationNo() {
        return endStationNo;
    }

    public void setEndStationNo(String endStationNo) {
        this.endStationNo = endStationNo;
    }
    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }
    public String getCarriageNo() {
        return carriageNo;
    }

    public void setCarriageNo(String carriageNo) {
        this.carriageNo = carriageNo;
    }
    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }
    public LocalDateTime getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(LocalDateTime orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public LocalDateTime getTrainStartDate() {
        return trainStartDate;
    }

    public void setTrainStartDate(LocalDateTime trainStartDate) {
        this.trainStartDate = trainStartDate;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId=" + orderId +
            ", userPhone=" + userPhone +
            ", passengerPhone=" + passengerPhone +
            ", passengerId=" + passengerId +
            ", trainNo=" + trainNo +
            ", startStationNo=" + startStationNo +
            ", startStationName=" + startStationName +
            ", endStationNo=" + endStationNo +
            ", endStationName=" + endStationName +
            ", carriageNo=" + carriageNo +
            ", seatNo=" + seatNo +
            ", orderMoney=" + orderMoney +
            ", orderCreateTime=" + orderCreateTime +
            ", orderStatus=" + orderStatus +
            ", trainStartDate=" + trainStartDate +
        "}";
    }
}
