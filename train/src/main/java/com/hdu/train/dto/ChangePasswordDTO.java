package com.hdu.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 菠萝
 * @version 1.0
 * @description: TODO
 * @date 2023/12/10 14:09
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDTO {

    private String token;


    private String userOldPassword;

    private String userNewPassword;
}
