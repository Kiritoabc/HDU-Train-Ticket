package com.hdu.train.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.train.entity.Train;
import com.hdu.train.util.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public interface ITrainService extends IService<Train> {

    Result TrainInfo(Integer offset, Integer limit);
}
