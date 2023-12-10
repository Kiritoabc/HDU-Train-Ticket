package com.hdu.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: 修改用户信息的req
 * @date 2023/12/10 13:19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeUserDTO {

    private String token;

    private String userPhoneNumber;

    private String userRealName;

    private String userEmail;

    private String userIdNumber;
    /**
     * 男1女0
     */
    private Integer userGender;

    /**
     * 成人0学生1
     */
    private Integer userType;

    private String userAddress;
}
