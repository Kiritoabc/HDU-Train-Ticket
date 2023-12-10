package com.hdu.train.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: getUserInfo的返回类
 * @date 2023/12/10 13:03
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {
    private String userRealName;

    private String userPhoneNumber;

    private String userEmail;
    /**
     * 成人0学生1
     */
    private Integer userType;
    /**
     * 男1女0
     */
    private String userGender;

    private String userIdNumber;

    private String userAddress;
}
