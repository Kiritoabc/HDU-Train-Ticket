package com.hdu.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.entity.Train;
import com.hdu.train.mapper.TrainMapper;
import com.hdu.train.service.ITrainService;
import com.hdu.train.util.BeanCopyUtils;
import com.hdu.train.util.Result;
import com.hdu.train.vo.PageVO;
import com.hdu.train.vo.TrainInfoVO;
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
@Service("iTrainService")
public class TrainServiceImpl extends ServiceImpl<TrainMapper, Train> implements ITrainService {

    @Override
    public Result TrainInfo(Integer offset, Integer limit) {
        LambdaQueryWrapper<Train> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<Train> page = new Page<>(offset, limit);
        IPage<Train> iPage = this.baseMapper.selectPage(page, lambdaQueryWrapper);
        List<TrainInfoVO> trainInfoVOS = BeanCopyUtils.copyBeanList(iPage.getRecords(), TrainInfoVO.class);
        PageVO pageVO = new PageVO(trainInfoVOS,iPage.getTotal());
        return Result.ok().data("list",pageVO);
    }

    @Override
    public TrainInfoVO selectTrainInfo(String trainNumber) {
        LambdaQueryWrapper<Train> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Train::getTarinNumber,trainNumber);
        Train train = this.baseMapper.selectOne(lambdaQueryWrapper);
        return BeanCopyUtils.copyBean(train, TrainInfoVO.class);
    }

    @Override
    public void updateTrainTypeStart(String trainNo) {
        this.baseMapper.updateTrainTypeStart(trainNo);
    }

    @Override
    public void updateTrainTypeStop(String trainNo) {
        this.baseMapper.updateTrainTypeStop(trainNo);
    }

    @Override
    public void deleteTrainSeat(String trainNo, String carriageNo) {
        this.baseMapper.deleteTrainSeat(trainNo,carriageNo);
    }
}
