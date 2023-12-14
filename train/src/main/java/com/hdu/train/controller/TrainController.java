package com.hdu.train.controller;

import com.hdu.train.service.IStationService;
import com.hdu.train.service.ITrainService;
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
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private ITrainService iTrainService;

    @Autowired
    private IStationService iStationService;

    /**
     * @description:
     * @param:  offset
                limit
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/14 11:39
     */
    @GetMapping("/trainInfo")
    public Result TrainInfo(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return iTrainService.TrainInfo(offset, limit);
    }



}
