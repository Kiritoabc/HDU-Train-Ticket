package com.hdu.train.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.train.entity.Station;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public interface IStationService extends IService<Station> {

    List<Station> searchTrainParkingStation(String trainNumber);
}
