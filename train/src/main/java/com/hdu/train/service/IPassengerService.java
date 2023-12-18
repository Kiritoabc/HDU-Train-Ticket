package com.hdu.train.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.train.entity.Passenger;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public interface IPassengerService extends IService<Passenger> {

    boolean addPassenger(Passenger insertPassenger);
}
