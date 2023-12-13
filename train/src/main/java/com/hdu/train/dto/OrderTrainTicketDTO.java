package com.hdu.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: TODO
 * @date 2023/12/13 13:30
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTrainTicketDTO {
    private String token;

    private String datetime;

    private String trainNo;

    private String startNo;

    private String endNo;

    private String trainNumber;

    private String carriageNo;

    private String seatType;

    private  String seatNumber;

    private String passengerPhoneNumber;

    private String passengerIdNumber;

    private String highSeatPrice;

    private String mediumSeatPrice;

    private String lowSeatPrice;
}
