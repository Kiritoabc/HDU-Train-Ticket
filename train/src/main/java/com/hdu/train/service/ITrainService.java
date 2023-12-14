package com.hdu.train.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.train.entity.Train;
import com.hdu.train.util.Result;
import com.hdu.train.vo.TrainInfoVO;

import java.util.List;

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

    TrainInfoVO selectTrainInfo(String trainNumber);

    void updateTrainTypeStart(String trainNo);

    void updateTrainTypeStop(String trainNo);

    void deleteTrainSeat(String trainNo, String carriageNo);

    List<String> getAllTrainNumber();

    void addTrainInfo(Train train);
}
