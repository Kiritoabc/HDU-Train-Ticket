package com.hdu.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: 用户注册请求实体
 * @date 2023/12/9 16:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    private String userPhoneNumber;

    private String userPassword;

    private String userPassword2;
    private String userEmail;

    private String userRealName;

    /**
     * 成人0学生1
     */
    private Integer userType;

    private String userIdNumber;

    /**
     * 男1女0
     */
    private Integer userGender;

    private String userAddress;

}
