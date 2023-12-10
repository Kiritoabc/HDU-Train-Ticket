package com.hdu.train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userPhoneNumber;

    private String passengerPhoneNumber;

    private String passengerRealName;

    private String passengerIdNumber;

    private Integer passengerType;

    private String passengerAddress;

}
