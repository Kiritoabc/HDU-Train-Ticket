package com.hdu.train.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: TODO
 * @date 2023/12/11 16:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderListVO {

    private String orderId;

    private String passengerRealName;

    private String passengerPhoneNumber;

    private String passengerIdNumber;

    private String carriageNo;

    private String seatType;

    private String seatNo;
}
