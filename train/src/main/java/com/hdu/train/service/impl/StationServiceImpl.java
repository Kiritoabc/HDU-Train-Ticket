package com.hdu.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.entity.Station;
import com.hdu.train.mapper.StationMapper;
import com.hdu.train.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@Service("iStationService")
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements IStationService {

    @Override
    public List<Station> searchTrainParkingStation(String train_number) {
        return this.baseMapper.findTrainParkingInfo(train_number);
    }

    @Override
    public List<String> getAllstationName() {
        return this.baseMapper.getAllstationName();
    }

    @Override
    public void addTrainStation(Station station) {
        this.baseMapper.insert(station);
    }
}
