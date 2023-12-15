package com.hdu.train.controller;

import com.hdu.train.service.ITrainService;
import com.hdu.train.util.Result;
import com.hdu.train.vo.TrainScheduleInfoVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  列车时刻表查询的业务处理逻辑
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@RestController
@RequestMapping("/trainSchedule")
public class TrainScheduleController {

    @Autowired
    private ITrainService iTrainService;

    /**
     * @description: 根据起始站 目的站  查询符合条件的列车信息
     * @param:  train_start_station
                train_end_station
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/14 22:17
     */
    @GetMapping("/searchTrainSchedule")
    public Result GetTrainScheduleInfo(@RequestParam String train_start_station, String train_end_station) {
        List<TrainScheduleInfoVO> list = iTrainService.getTrainScheduleInfo(train_start_station, train_end_station);
        return Result.ok().data("list",list);
    }


    /**
     * @description: 返回列车具体的经停信息
     * @param:  train_start_station_no
                train_end_station_no
                train_no
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/15 13:11
     */
    @GetMapping("/getTrainScheduleList")
    public Result GetTrainScheduleInfoList(@RequestParam String train_start_station_no, String  train_end_station_no, String train_no) {
        List<TrainScheduleInfoVO> list = iTrainService.searchTrainScheduleInfoList(train_no,train_start_station_no,train_end_station_no);
        return Result.ok().data("list",list);
    }

    /**
     * @description: TODO:查询接续换乘路线
     * @param:  train_start_station
                train_end_station
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/15 13:13
     */
    @GetMapping("/searchTransferSchedule")
    public Result GetTrainScheduleInfoList(@RequestParam String train_start_station, String train_end_station) {
        return null;
    }
}
