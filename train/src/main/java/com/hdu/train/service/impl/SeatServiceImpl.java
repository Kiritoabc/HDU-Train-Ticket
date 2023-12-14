package com.hdu.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.entity.Seat;
import com.hdu.train.mapper.SeatMapper;
import com.hdu.train.service.ISeatService;
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
@Service("iSeatService")
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat> implements ISeatService {

    @Override
    public List<Seat> selectSeatInfoByTrainNumber(String train_number) {
        return this.baseMapper.selectSeatInfoByTrainNumber(train_number);
    }
}
