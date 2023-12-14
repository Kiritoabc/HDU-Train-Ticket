package com.hdu.train.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.train.entity.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@Mapper
public interface SeatMapper extends BaseMapper<Seat> {

    @Select("select train.train_no as train_no ,train_number ,carriage_no ,seat_type,seat_count from train_info ,seat where train.train_no = seat.train_no and train.train_number=#{train_number}")
    List<Seat> selectSeatInfoByTrainNumber(@Param("train_number") String train_number);

}
