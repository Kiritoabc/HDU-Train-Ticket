package com.hdu.train.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.dto.AdminLoginDTO;
import com.hdu.train.dto.ChangePasswordDTO;
import com.hdu.train.dto.ChangeUserDTO;
import com.hdu.train.dto.UserRegisterDTO;
import com.hdu.train.entity.User;
import com.hdu.train.mapper.UserMapper;
import com.hdu.train.service.IUserService;
import com.hdu.train.util.JwtToken;
import com.hdu.train.util.RedisObjUtil;
import com.hdu.train.result.Result;
import com.hdu.train.vo.UserInfoVO;
import com.hdu.train.vo.UserRegisterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@Service("iUserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private RedisObjUtil redisObjUtil;

    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserPhoneNumber,user.getUserPhoneNumber());
        wrapper.eq(User::getUserPassword,user.getUserPassword());
        User loginUser = userMapper.selectOne(wrapper);
        if (loginUser!=null){
            return loginUser.getUserRealName();
        }
        return null;
    }

    @Override
    public Object info(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserRealName, username);
        User loginUser = userMapper.selectOne(wrapper);
        if (loginUser != null) {
            HashMap data = new HashMap<>();
            data.put("user_real_name", loginUser.getUserRealName());
            data.put("user_email", loginUser.getUserEmail());
            data.put("user_type", loginUser.getUserType());
            data.put("user_gender", loginUser.getUserGender());
            data.put("user_id_number", loginUser.getUserIdNumber());
            data.put("user_address", loginUser.getUserAddress());
            return data;
        }
        return null;
    }
    @Transactional
    @Override
    public Result register(UserRegisterDTO userRegisterDTO) {
        // 1.参数验证
        if (!userRegisterDTO.getUserPassword().equals(userRegisterDTO.getUserPassword2())) {
            return Result.error().message("两次输入不相同");
        }

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .eq(User::getUserPhoneNumber,userRegisterDTO.getUserPhoneNumber());

        if(!Objects.isNull(userMapper.selectOne(lambdaQueryWrapper))) {
            return Result.error().message("手机号重复");
        }
        // 2.开始注册
        User user = new User();
        // 采用 hutool 包加密
        String pwd_md5 = SecureUtil.md5(userRegisterDTO.getUserPassword());
        BeanUtils.copyProperties(userRegisterDTO,user);
        user.setUserPassword(pwd_md5);
        // 插入数据库
        userMapper.insert(user);
        UserRegisterVO userRegisterVO = new UserRegisterVO();
        BeanUtils.copyProperties(userRegisterDTO,userRegisterVO);
        // 插入缓存
        redisObjUtil.setEntity(user.getUserPhoneNumber(),user);
        return Result.ok().data("user",userRegisterVO);
    }

    @Transactional
    @Override
    public Result changeUserInfo(ChangeUserDTO changeUserDTO) {
        // 采用 先更新数据库，再删缓存
        // 更新数据库
        userMapper.UpdateUserInfo(changeUserDTO.getUserRealName(),
                changeUserDTO.getUserEmail(),
                changeUserDTO.getUserType(),
                changeUserDTO.getUserGender(),
                changeUserDTO.getUserIdNumber(),
                changeUserDTO.getUserAddress(),
                changeUserDTO.getUserPhoneNumber());
        // 删除缓存
        redisObjUtil.deleteEntity(changeUserDTO.getUserPhoneNumber());
        // 返回
        return Result.ok().message("更新成功");
    }

    @Transactional
    @Override
    public Result getUserInfo(String token) {
        // 首先判断token有没有过期
        User user = redisObjUtil.getEntity(token);
        if(Objects.isNull(user)) {
            return Result.error().message("登录过期，请重新登录");
        }
        // 先从缓存中查询数据
        User cacheUser = redisObjUtil.getEntity(user.getUserPhoneNumber());
        UserInfoVO userInfoVO = new UserInfoVO();
        if(!Objects.isNull(cacheUser)){
            BeanUtils.copyProperties(cacheUser,userInfoVO);
            return Result.ok().data("userInfo",userInfoVO);
        }
        // 查询数据库
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserPhoneNumber,user.getUserPhoneNumber());
        User user1 = userMapper.selectOne(lambdaQueryWrapper);
        // 更新缓存,设置过期时间(暂时不确定要不要)
        redisObjUtil.setEntity(user1.getUserPhoneNumber(),user1);
        BeanUtils.copyProperties(user1,userInfoVO);
        return Result.ok().data("userInfo",userInfoVO);
    }

    @Transactional
    @Override
    public Result updatePassword(ChangePasswordDTO changePasswordDTO) {
        // 修改密码暂时不需要动缓存
        String token = changePasswordDTO.getToken();
        User user = redisObjUtil.getEntity(token);
        // 查询数据库对比密码
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserPhoneNumber,user.getUserPhoneNumber());
        User user1 = userMapper.selectOne(lambdaQueryWrapper);
        if (!SecureUtil.md5(changePasswordDTO.getUserOldPassword()).equals(user1.getUserPassword())){
            return Result.error().message("密码错误");
        }
        // 更新密码
        LambdaUpdateWrapper<User> userUpdateWrapper = new LambdaUpdateWrapper<>();
        userUpdateWrapper.set(User::getUserPassword,
                        SecureUtil.md5(changePasswordDTO.getUserNewPassword()));
        userMapper.update(user1,userUpdateWrapper);
        return Result.ok().message("密码修改成功");
    }

    @Override
    public Result adminLogin(AdminLoginDTO adminLoginDTO) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserPhoneNumber,adminLoginDTO.getUserName());
        User user = userMapper.selectOne(lambdaQueryWrapper);
        // 查看用户名 ，对比密码
        if (Objects.isNull(user) || SecureUtil.md5(adminLoginDTO.getPassword()).equals(user.getUserPassword())) {
            return Result.error().message("用户名或密码错误");
        }
        //  token 存入缓存
        String token = JwtToken.generateToken(user.getUserRealName());
        // 将user信息存入redis,并设置过期时间 --> 对应jwt的有效时间为7天
        redisObjUtil.setEntity(token,user,60*24*7);
        return Result.ok().data("token",token);
    }

    @Override
    public List<UserInfoVO> getAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public Result deleteUser(String userPhoneNumber) {
        // todo: 对于删除用户，是否要考虑用户是否存在订单，考虑是否使用删除字段
        return null;
    }
}
