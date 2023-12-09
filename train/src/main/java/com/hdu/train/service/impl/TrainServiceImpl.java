package com.hdu.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.entity.Train;
import com.hdu.train.mapper.TrainMapper;
import com.hdu.train.service.ITrainService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@Service("iTrainService")
public class TrainServiceImpl extends ServiceImpl<TrainMapper, Train> implements ITrainService {

}
