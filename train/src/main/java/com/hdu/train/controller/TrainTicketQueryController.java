package com.hdu.train.controller;

import com.hdu.train.util.RedisObjUtil;
import com.hdu.train.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@RestController
@RequestMapping("/query")
public class TrainTicketQueryController {

    @Autowired
    private RedisObjUtil redisObjUtil;

    @GetMapping("/queryTrainTicket")
    public Result GetTrainScheduleInfo(@RequestParam String train_start_station, String train_end_station, String datetime) {
        return null;
    }

}
