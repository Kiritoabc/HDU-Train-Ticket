package com.hdu.train.controller;

import com.hdu.train.dto.UserRegisterDTO;
import com.hdu.train.service.IUserService;
import com.hdu.train.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @GetMapping("/hello")
    public Result hello(){
        return Result.ok().data("hello","world");
    }



    @PostMapping("/register")
    public Result UserRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        return iUserService.register(userRegisterDTO);
    }
}
