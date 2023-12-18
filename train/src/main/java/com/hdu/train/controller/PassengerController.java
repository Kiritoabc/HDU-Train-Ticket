package com.hdu.train.controller;

import com.hdu.train.dto.PassengerDTO;
import com.hdu.train.entity.Passenger;
import com.hdu.train.entity.User;
import com.hdu.train.result.Result;
import com.hdu.train.service.IPassengerService;
import com.hdu.train.util.BeanCopyUtils;
import com.hdu.train.util.RedisObjUtil;
import com.hdu.train.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private IPassengerService iPassengerService;
    @Autowired
    private RedisObjUtil redisObjUtil;
    @GetMapping("getPassengerInfo")
    public Result GetPassengerInfo(@RequestParam String token){
        if(redisObjUtil.getEntity(token)){
            User user = redisObjUtil.getEntity(token);
            return Result.ok().data("data",user);
        }
        return Result.error().message("查询失败");
    }
    @PostMapping("/addPassengerInfo")
    public Result addPassenger(@RequestBody PassengerDTO passenger){
        User user = redisObjUtil.getEntity(passenger.getToken());
        if(user!=null){
            passenger.setPassengerPhoneNumber(user.getUserPhoneNumber());
            Passenger insertPassenger = BeanCopyUtils.copyBean(passenger,Passenger.class);
            if (iPassengerService.addPassenger(insertPassenger)){
                return Result.ok().message("插入成功");
            }
            return Result.error().message("插入失败");
        }
        return Result.error().message("插入失败");
    }

}
