package com.hdu.train.controller;

import com.hdu.train.entity.Passenger;
import com.hdu.train.util.Result;
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
@RequestMapping("/passenger")
public class PassengerController {
    @GetMapping("getPassengerInfo")
    public Result GetPassengerInfo(@RequestParam String token){

        return Result.ok();
    }

}
