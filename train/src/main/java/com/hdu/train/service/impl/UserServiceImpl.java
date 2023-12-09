package com.hdu.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.entity.User;
import com.hdu.train.mapper.UserMapper;
import com.hdu.train.service.IUserService;
import kotlin.jvm.internal.Lambda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
        wrapper.eq(User::getUserRealName,username);
        User loginUser = userMapper.selectOne(wrapper);
        if (loginUser!=null){
            HashMap data = new HashMap<>();
            data.put("user_real_name",loginUser.getUserRealName());
            data.put("user_email",loginUser.getUserEmail());
            data.put("user_type",loginUser.getUserType());
            data.put("user_gender",loginUser.getUserGender());
            data.put("user_id_number",loginUser.getUserIdNumber());
            data.put("user_address",loginUser.getUserAddress());
            return data;
        }
        return null;
    }
}
