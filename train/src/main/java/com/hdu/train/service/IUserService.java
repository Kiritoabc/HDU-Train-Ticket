package com.hdu.train.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.train.dto.ChangeUserDTO;
import com.hdu.train.dto.UserRegisterDTO;
import com.hdu.train.entity.User;
import com.hdu.train.util.Result;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public interface IUserService extends IService<User> {

    String login(User user);

    Object info(String username);
    Result register(UserRegisterDTO userRegisterDTO);

    Result changeUserInfo(ChangeUserDTO changeUserDTO);
}
