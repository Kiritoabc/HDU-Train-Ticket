package com.hdu.train.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.train.entity.Train;
import com.hdu.train.vo.TrainScheduleInfoVO;
import org.apache.ibatis.annotations.*;

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
public interface TrainMapper extends BaseMapper<Train> {
    @Update("update train_info set train_running_type = '正在运行' where train_no = #{train_no}")
    void updateTrainTypeStart(@Param("train_no") String train_no);
    @Update("update train_info set train_running_type = '已停运' where train_no = #{train_no}")
    void updateTrainTypeStop(@Param("train_no") String train_no);
    @Delete("delete from seat where train_no = #{train_no} and carriage_no = #{carriage_no}")
    void deleteTrainSeat(@Param("train_no") String train_no,@Param("carriage_no") String carriage_no);

    @Select("select train_number from train")
    List<String> getAllTrainNumber();

    @Select("select C.train_no as train_no ,C.train_number as train_number ,\n" +
            " C.station_name as start_station ,D.station_name as end_station ,\n" +
            " C.station_no as start_no , D.station_no as  end_no  ,\n" +
            " C.start_time as start_time , D.arrive_time as arrive_time,\n" +
            " C.running_time as start_running_time ,D.running_time as end_running_time \n" +
            " from station as C ,station as D \n" +
            " where C.train_no = D.train_no \n" +
            " and C.station_name = #{trainStartStation} and D.station_name = #{trainEndStation}\n" +
            " and C.train_no in (select A.train_no from \n" +
            "station as A ,station as B \n" +
            "where  A.train_no = B.train_no and \n" +
            "A.station_name = #{trainStartStation} and\n" +
            " B.station_name = #{trainEndStation} \n" +
            " and A.station_no <B.station_no)")
    List<TrainScheduleInfoVO> getTrainScheduleInfo(String trainStartStation, String trainEndStation);

    @Select("select A.train_no as train_no, A.train_number as train_number ,\n" +
            "A.station_name as start_station ,B.station_name as end_station , \n" +
            " A.station_no as start_no , B.station_no as  end_no  ,\n" +
            "  A.start_time as start_time , B.arrive_time as arrive_time,\n" +
            "   A.running_time as start_running_time ,B.running_time as end_running_time \n" +
            "    from `station` as A ,`station` as B \n" +
            "    where A.station_no between #{trainStartStationNo} and #{trainEndStationNo} \n" +
            "    and  B.station_no between #{trainStartStationNo} and #{trainEndStationNo} \n" +
            "    and A.train_no = #{trainNo} \n" +
            "    and A.train_no = B.train_no \n" +
            "    and B.station_no = A.station_no +1 order by A.station_no ,B.station_no ")
    List<TrainScheduleInfoVO> searchTrainScheduleList(String trainNo, String trainStartStationNo, String trainEndStationNo);
}
