package com.hdu.train.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.train.entity.Station;
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
public interface StationMapper extends BaseMapper<Station> {

    @Select("select  DISTINCT b.station_no,b.station_name,  b.train_number, b.start_time," +
            " b.arrive_time, b.running_time,b.arrive_day_str from station as a ," +
            "station as b where a.train_number = #{train_number} " +
            "and a.train_no = b.train_no order by b.station_no ")
    List<Station> findTrainParkingInfo(@Param("train_number") String train_number);

    @Select("select station_name from station")
    List<String> getAllstationName();
}
