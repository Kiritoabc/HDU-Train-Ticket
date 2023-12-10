package com.hdu.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: 管理员登录req
 * @date 2023/12/10 15:06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginDTO {

    private String userName;


    private String password;
}
