package com.hdu.train.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.train.dto.AdminLoginDTO;
import com.hdu.train.dto.ChangePasswordDTO;
import com.hdu.train.dto.ChangeUserDTO;
import com.hdu.train.dto.UserRegisterDTO;
import com.hdu.train.entity.User;
import com.hdu.train.result.Result;
import com.hdu.train.vo.UserInfoVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public interface IUserService extends IService<User> {

    User login(User user);

    Object info(String username);
    Result register(UserRegisterDTO userRegisterDTO);

    Result changeUserInfo(ChangeUserDTO changeUserDTO);

    Result getUserInfo(String token);

    Result updatePassword(ChangePasswordDTO changePasswordDTO);

    Result adminLogin(AdminLoginDTO adminLoginDTO);

    List<UserInfoVO> getAllUser();

    Result deleteUser(String userPhoneNumber);
}
