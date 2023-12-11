package com.hdu.train.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: 订单返回类
 * @date 2023/12/11 15:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {
    private String orderId;
    private String passengerReaName;
    private String trainNumber;
    private String startStationName;
    private String endStationName;
    private String carriageNo;
    private String seatType;
    private String seatNo;
    private String startDate;
    private String startTime;
    private String orderStatus;
    private String passengerPhoneNumber;
    private String passengerIdNumber;
    private String orderMoney;
}
