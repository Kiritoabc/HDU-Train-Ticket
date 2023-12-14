package com.hdu.train.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.train.entity.Train;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
}
