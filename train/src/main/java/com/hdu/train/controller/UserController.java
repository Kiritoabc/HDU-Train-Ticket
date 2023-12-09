package com.hdu.train.controller;

import com.hdu.train.entity.User;
import com.hdu.train.service.IUserService;
import com.hdu.train.util.Result;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @PostMapping("login")
    public Result login(@RequestBody User user){
        if
    }
    @GetMapping("/hello")
    public Result hello(){
        return Result.ok().data("hello","world");
    }
}
