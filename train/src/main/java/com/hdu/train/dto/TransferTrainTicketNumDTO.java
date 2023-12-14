package com.hdu.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description:
 * @date 2023/12/14 21:48
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferTrainTicketNumDTO {

    private String datetime;

    private String train_no_1;

    private String start_station_no;

    private String transfer_station_no_1;

    private String train_number_1;

    private String train_no_2;

    private String train_number_2;

    private String transfer_station_no_2;

    private String end_station_no;

}
