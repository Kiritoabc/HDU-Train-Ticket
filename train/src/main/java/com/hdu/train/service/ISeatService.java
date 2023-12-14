package com.hdu.train.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.train.entity.Seat;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public interface ISeatService extends IService<Seat> {

    List<Seat> selectSeatInfoByTrainNumber(String trainNumber);
}
