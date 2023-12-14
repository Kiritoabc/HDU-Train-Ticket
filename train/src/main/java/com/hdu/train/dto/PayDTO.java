package com.hdu.train.dto;

import java.util.List;

/**
 * @author 菠萝
 * @version 1.0
 * @description: TODO
 * @date 2023/12/14 10:42
 */
public class PayDTO {
    private String token;

    private List<String> orderIdList;

    @Override
    public String toString() {
        return "PayDTO{" +
                "token='" + token + '\'' +
                ", orderIdList=" + orderIdList +
                '}';
    }

    public PayDTO() {
    }

    public PayDTO(String token, List<String> orderIdList) {
        this.token = token;
        this.orderIdList = orderIdList;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setOrderIdList(List<String> orderIdList) {
        this.orderIdList = orderIdList;
    }

    public String getToken() {
        return token;
    }

    public List<String> getOrderIdList() {
        return orderIdList;
    }
}
