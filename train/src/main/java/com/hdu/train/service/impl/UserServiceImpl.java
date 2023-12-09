package com.hdu.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.dto.UserRegisterDTO;
import com.hdu.train.entity.User;
import com.hdu.train.mapper.UserMapper;
import com.hdu.train.service.IUserService;
import com.hdu.train.util.Result;
import com.hdu.train.vo.UserRegisterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        // TODO: 加密密码
        BeanUtils.copyProperties(userRegisterDTO,user);
        userMapper.insert(user);
        UserRegisterVO userRegisterVO = new UserRegisterVO();
        BeanUtils.copyProperties(userRegisterDTO,userRegisterVO);
        return Result.ok().data("user",userRegisterVO);
    }
}
