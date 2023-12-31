package com.hdu.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.entity.Passenger;
import com.hdu.train.mapper.PassengerMapper;
import com.hdu.train.service.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@Service("iPassengerService")
public class PassengerServiceImpl extends ServiceImpl<PassengerMapper, Passenger> implements IPassengerService {


    @Override
    public boolean addPassenger(Passenger insertPassenger) {
        if(this.baseMapper.insert(insertPassenger)==1){
            return true;
        }
        return false;
    }
}
