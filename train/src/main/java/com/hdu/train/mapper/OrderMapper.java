package com.hdu.train.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.train.entity.Order;
import com.hdu.train.vo.GetOrderListVO;
import com.hdu.train.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select A.order_id as orderId , D.passengerRealName as passengerRealName,C.train_number as trainNumber ," +
            "A.start_station_name as startStationName ,A.end_station_name as endStationName," +
            "A.carriage_no as carriageNo, B.seat_type as seatType," +
            "A.seat_no as seatNo,  A.train_start_date as startDate," +
            "C.start_time as startTime , A.order_status as orderStatus," +
            "A.passenger_phone_number as passengerPhoneNumber," +
            "A.passenger_id_number as passengerIdNumber ," +
            "A.order_money as orderMoney  " +
            "from `order` as A ,seat as B , `station` as C , passenger as D " +
            "where A.user_phone_number = #{userPhoneNumber} " +
            "and A.train_no = B.train_no " +
            "and A.carriage_no = B.carriage_no " +
            "and A.train_no = C.train_no " +
            "and A.passenger_phone_number = D.passenger_phone_number " +
            "and C.station_name  = A.start_station_name " +
            " order by A.order_create_time")
    List<OrderVO> getAllOrderLists(@Param("userPhoneNumber") String userPhoneNumber);
    @Select("select A.order_id as orderId , D.passengerRealName as passengerRealName,C.train_number as trainNumber ," +
            "A.start_station_name as startStationName ,A.end_station_name as endStationName," +
            "A.carriage_no as carriageNo, B.seat_type as seatType," +
            "A.seat_no as seatNo,  A.train_start_date as startDate," +
            "C.start_time as startTime , A.order_status as orderStatus," +
            "A.passenger_phone_number as passengerPhoneNumber," +
            "A.passenger_id_number as passengerIdNumber ," +
            "A.order_money as orderMoney  " +
            "from `order` as A ,seat as B , `station` as C , passenger as D " +
            "where A.user_phone_number = #{userPhoneNumber} " +
            "and A.train_no = B.train_no " +
            "and A.carriage_no = B.carriage_no " +
            "and A.train_no = C.train_no " +
            "and A.passenger_phone_number = D.passenger_phone_number " +
            "and C.station_name  = A.start_station_name and A.order_status = '为出行' " +
            " order by A.order_create_time")
    List<OrderVO> getNotripOrderLists(@Param("userPhoneNumber")String userPhoneNumber);

    @Select("select A.order_id as orderId , D.passengerRealName as passengerRealName,C.train_number as trainNumber ," +
            "A.start_station_name as startStationName ,A.end_station_name as endStationName," +
            "A.carriage_no as carriageNo, B.seat_type as seatType," +
            "A.seat_no as seatNo,  A.train_start_date as startDate," +
            "C.start_time as startTime , A.order_status as orderStatus," +
            "A.passenger_phone_number as passengerPhoneNumber," +
            "A.passenger_id_number as passengerIdNumber ," +
            "A.order_money as orderMoney  " +
            "from `order` as A ,seat as B , `station` as C , passenger as D " +
            "where A.user_phone_number = #{userPhoneNumber} " +
            "and A.train_no = B.train_no " +
            "and A.carriage_no = B.carriage_no " +
            "and A.train_no = C.train_no " +
            "and A.passenger_phone_number = D.passenger_phone_number " +
            "and C.station_name  = A.start_station_name and A.order_status = '未支付' " +
            " order by A.order_create_time")
    List<OrderVO> getNopayOrderLists(@Param("userPhoneNumber")String userPhoneNumber);


    @Update("update `order` set order_status = '已退票' where order_id = #{orderId} and user_phone_number = #{userPhoneNumber}")
    void refundTicket(@Param("userPhoneNumber") String userPhoneNumber,@Param("orderId") String orderId);


    @Select("select A.order_id as orderId,B.passenger_real_name as passengerRealName ," +
            "A.passenger_phone_number as passengerPhoneNumber,A.passenger_id_number as passengerIdNumber," +
            "A.carriage_no  as carriageNo, C.seat_type as seatType,A.seat_no as seatNo" +
            " from `order` as A , `passenger` as B ,`seat` as C " +
            " where A.train_no = C.train_no and A.carriage_no = C.carriage_no and A.passenger_phone_number = B.passenger_phone_number and A.order_id = #{orderId}")
    List<GetOrderListVO> GetOrderInfo(@Param("orderId") String orderId);


    @Select("select order_money from `order` where order_id = #{orderId}")
    String GetOrderMoney(@Param("orderId") String orderId);

    @Select("select A.order_id as orderId , D.passengerRealName as passengerRealName,C.train_number as trainNumber ," +
            "A.start_station_name as startStationName ,A.end_station_name as endStationName," +
            "A.carriage_no as carriageNo, B.seat_type as seatType," +
            "A.seat_no as seatNo,  A.train_start_date as startDate," +
            "C.start_time as startTime , A.order_status as orderStatus," +
            "A.passenger_phone_number as passengerPhoneNumber," +
            "A.passenger_id_number as passengerIdNumber ," +
            "A.order_money as orderMoney  " +
            "from `order` as A ,seat as B , `station` as C , passenger as D " +
            "where A.train_no = B.train_no " +
            "and A.carriage_no = B.carriage_no " +
            "and A.train_no = C.train_no " +
            "and A.passenger_phone_number = D.passenger_phone_number " +
            "and C.station_name  = A.start_station_name " +
            " order by A.order_create_time")
    List<OrderVO> GetAllOrder();
}
