package com.hdu.train.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: TODO
 * @date 2023/12/14 22:02
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainScheduleInfoVO {
    private String train_no;
    private String train_number;
    private String start_station;
    private String end_station;
    private String start_no;
    private String end_no;
    private String start_time;
    private String arrive_time;
    private String start_running_time;
    private String end_running_time;
}
