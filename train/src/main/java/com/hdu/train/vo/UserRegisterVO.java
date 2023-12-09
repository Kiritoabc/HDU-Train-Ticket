package com.hdu.train.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: TODO
 * @date 2023/12/9 16:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterVO {
    private String userPhoneNumber;

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
