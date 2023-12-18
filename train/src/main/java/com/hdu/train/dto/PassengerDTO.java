package com.hdu.train.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO implements Serializable {

    private String token;

    private String userPhoneNumber;

    private String passengerPhoneNumber;

    private String passengerRealName;

    private String passengerIdNumber;

    private Integer passengerType;

    private String passengerAddress;

}