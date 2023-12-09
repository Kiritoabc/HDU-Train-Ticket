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
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trainNo;

    private String carriageNo;

    private String seatType;

    private Integer seatCount;

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
    public String getCarriageNo() {
        return carriageNo;
    }

    public void setCarriageNo(String carriageNo) {
        this.carriageNo = carriageNo;
    }
    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        return "Seat{" +
            "trainNo=" + trainNo +
            ", carriageNo=" + carriageNo +
            ", seatType=" + seatType +
            ", seatCount=" + seatCount +
        "}";
    }
}
