package com.hdu.train.controller;

import com.hdu.train.entity.User;
import com.hdu.train.service.IUserService;
import com.hdu.train.util.JwtToken;
import com.hdu.train.util.RedisObjUtil;
import com.hdu.train.util.RedisUtils;
import com.hdu.train.util.Result;
import com.hdu.train.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

import com.hdu.train.dto.UserRegisterDTO;

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

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisObjUtil redisObjUtil;

    @PostMapping("login")
    public Result login(@RequestBody User user){
        if(iUserService.login(user)!=null){
            String username = iUserService.login(user);
            String token = JwtToken.generateToken(username);
            // 将username 存入redis
//            redisUtils.set(token,username);
            // 将user信息存入redis,并设置过期时间 --> 对应jwt的有效时间为7天
            redisObjUtil.setEntity(token,user,60*24*7);
            return Result.ok().data("token",token);
        }
        return Result.error().message("登陆失败，账号或密码错误");
    }
    @GetMapping("/info")
    public Result info(@RequestParam String token){
        String username = redisUtils.get(token);
        if (iUserService.info(username)!=null){
            Result.ok().data("data",iUserService.info(username));
        }
        return Result.error();
    }
    @GetMapping("/hello")
    public Result hello(){
        return Result.ok().data("hello","world");
    }


    /**
     * @description:  注册接口
     * @param: userRegisterDTO
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/9 16:46
     */
    @PostMapping("/register")
    public Result UserRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        return iUserService.register(userRegisterDTO);
    }

    /**
     * @description: 退出等铁路
     * @param: token
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/9 22:21
     */
    @GetMapping("/signout")
    public Result Logout(@RequestParam String token){
        if (redisObjUtil.deleteEntity(token)) {
            return Result.ok().message("成功退出");
        }
        return Result.error().message("redis缓存删除失败");
    }

    /**
     * @description: 查询用户信息接口
     * @param: token
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/10 13:02
     */
    @GetMapping("/userinfo")
    public Result getUserInfo(@RequestParam String token){
        User user = redisObjUtil.getEntity(token);
        if(Objects.isNull(user)) {
            return Result.error().message("用户登录过期，请重新登录");
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user,userInfoVO);
        return Result.ok().data("userInfo",userInfoVO);
    }
}
