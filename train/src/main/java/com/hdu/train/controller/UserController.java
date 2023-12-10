package com.hdu.train.controller;

import com.hdu.train.dto.AdminLoginDTO;
import com.hdu.train.dto.ChangePasswordDTO;
import com.hdu.train.dto.ChangeUserDTO;
import com.hdu.train.entity.Passenger;
import com.hdu.train.entity.User;
import com.hdu.train.service.IPassengerService;
import com.hdu.train.service.IUserService;
import com.hdu.train.util.JwtToken;
import com.hdu.train.util.RedisObjUtil;
import com.hdu.train.util.RedisUtils;
import com.hdu.train.util.Result;
import com.hdu.train.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hdu.train.dto.UserRegisterDTO;

import java.util.List;
import java.util.Objects;

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


    @Autowired
    private IPassengerService iPassengerService;

    @PostMapping("login")
    public Result login(@RequestBody User user){
        if(iUserService.login(user)!=null){
            String username = iUserService.login(user);
            String token = JwtToken.generateToken(username);
            // 将user信息存入redis,并设置过期时间 --> 对应jwt的有效时间为7天
            redisObjUtil.setEntity(token,user,60*24*7);
            return Result.ok().data("token",token);
        }
        return Result.error().message("登陆失败，账号或密码错误");
    }
    @GetMapping("/info")
    public Result info(@RequestParam String token){
//        String username = redisUtils.get(token);
        User user = redisObjUtil.getEntity(token);
        String username = user.getUserRealName();
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
     * @description: 退出登录
     * @param: token
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/9 22:21
     */
    @GetMapping("/signout")
    public Result Logout(@RequestParam String token){
        if (redisUtils.delete(token)) {
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
        return iUserService.getUserInfo(token);
    }

    /**
     * @description: 修改用户信息
     * @param: changeUserDTO
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/10 13:26
     */
    @PostMapping("/changeuserinfo")
    public Result ChangeUserInfo(@RequestBody ChangeUserDTO changeUserDTO){
        return iUserService.changeUserInfo(changeUserDTO);
    }

    /**
     * @description: 更改用户密码
     * @param: changePasswordDTO
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/10 14:45
     */
    @PostMapping("/changepassword")
    public Result ChangePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        return iUserService.updatePassword(changePasswordDTO);
    }

    /**
     * @description: 管理员登录
     * @param: adminLoginDTO
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/10 15:22
     */
    @PostMapping("/adminLogin")
    public Result AdminLogin(@RequestBody AdminLoginDTO adminLoginDTO) {
        return iUserService.adminLogin(adminLoginDTO);
    }

    /**
     * @description: 查询所有用户
     * @param: token
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/10 15:42
     */
    @GetMapping("/getAllUser")
    public Result getAllUser(@RequestParam String token) {
        if (Objects.isNull(redisObjUtil.getEntity(token))) {
            return Result.error().message("登录过期");
        }
        List<UserInfoVO> list = iUserService.getAllUser();
        return Result.ok().data("userList",list);
    }

    /**
     * @description: 查询所有乘客
     * @param: token
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/10 15:47
     */
    @GetMapping("/getAllPassenger")
    public Result getAllPassenger(@RequestParam String token) {
        if (Objects.isNull(redisObjUtil.getEntity(token))) {
            return Result.error().message("登录过期");
        }
        List<Passenger> list = iPassengerService.list();
        return Result.ok().data("passengerList",list);
    }

    /**
     * @description: TODO，暂时没考虑好
     * @author 菠萝
     * @date 2023/12/10 15:53
     * @version 1.0
     */
    @GetMapping("/deleteUser")
    public Result deleteUser(@RequestParam String user_phone_number) {
        return iUserService.deleteUser(user_phone_number);
    }

}
