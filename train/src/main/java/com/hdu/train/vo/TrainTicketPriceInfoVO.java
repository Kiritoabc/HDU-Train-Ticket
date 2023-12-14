package com.hdu.train.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: TODO
 * @date 2023/12/14 21:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainTicketPriceInfoVO {
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
}
