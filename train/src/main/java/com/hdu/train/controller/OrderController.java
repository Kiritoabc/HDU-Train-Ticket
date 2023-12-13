package com.hdu.train.controller;


import com.hdu.train.dto.OrderInfoDTO;
import com.hdu.train.dto.OrderTrainTicketDTO;
import com.hdu.train.entity.User;
import com.hdu.train.service.IOrderService;
import com.hdu.train.util.RedisObjUtil;
import com.hdu.train.util.Result;
import com.hdu.train.vo.GetOrderListVO;
import com.hdu.train.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


// order passenger train trainSchedule query user

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RedisObjUtil redisObjUtil;

    @Autowired
    private IOrderService iOrderService;
    /**
     * @description: 获取用户所有的订单
     * @param: token
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/11 15:56
     */
    @GetMapping("/getAllOrderList")
    public Result GetAllOrderList(@RequestParam String token) {
        User user = redisObjUtil.getEntity(token);
        if(Objects.isNull(user)) {
            return Result.error().message("登录过期，请重新登录");
        }
        List<OrderVO> list = iOrderService.getAllOrderLists(user.getUserPhoneNumber());
        list.forEach((orderVO) -> orderVO.setSeatNo(getResultSeatNo(orderVO.getSeatType(), Integer.parseInt(orderVO.getSeatNo()))));
        return Result.ok().data("list",list);
    }
    /**
     * @description: 获取还未出行的所有订单
     * @param: token
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/11 16:02
     */
    @GetMapping("/getNotripOrderList")
    public Result GetNoTripOrderList(@RequestParam String token) {
        User user = redisObjUtil.getEntity(token);
        if(Objects.isNull(user)) {
            return Result.error().message("登录过期，请重新登录");
        }
        List<OrderVO> list = iOrderService.getNotripOrderLists(user.getUserPhoneNumber());
        list.forEach((orderVO) -> orderVO.setSeatNo(getResultSeatNo(orderVO.getSeatType(), Integer.parseInt(orderVO.getSeatNo()))));
        return Result.ok().data("list",list);
    }

    /**
     * @description: 获取用户未支付的订单
     * @param: token
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/11 16:07
     */
    @GetMapping("/getNoPayOrderList")
    public Result GetNoPauOrderList(@RequestParam String token) {
        User user = redisObjUtil.getEntity(token);
        if(Objects.isNull(user)) {
            return Result.error().message("登录过期，请重新登录");
        }
        List<OrderVO> list = iOrderService.getNopayOrderLists(user.getUserPhoneNumber());
        list.forEach((orderVO) -> orderVO.setSeatNo(getResultSeatNo(orderVO.getSeatType(), Integer.parseInt(orderVO.getSeatNo()))));
        return Result.ok().data("list",list);
    }

    /**
     * @description: 退票
     * @param: token,order_id
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/11 16:14
     */
    @GetMapping("/refundTicket")
    public Result RefundTicket(@RequestParam String token, String order_id){
        User user = redisObjUtil.getEntity(token);
        if(Objects.isNull(user)) {
            return Result.error().message("登录过期，请重新登录");
        }
        iOrderService.refundTicket(user.getUserPhoneNumber(),order_id);
        return Result.ok().message("退票成功，购票金额自动退回账户");
    }

    /**
     * @description: TODO: 暂时没想好
     * @param:
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/11 16:20
     */
    @PostMapping("/ticketChange")
    public Result TicketChange() {
        return null;
    }

    /**
     * @description: 更具订单ID获取订单
     * @param: orderInfoDTO
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/11 16:35
     */
    @PostMapping("/getOrder")
    public Result getOrderInfo(@RequestBody OrderInfoDTO orderInfoDTO) {
        List<GetOrderListVO> list =  iOrderService.getOrderInfo(orderInfoDTO.getOrderId());
        list.forEach((order) -> order.setSeatNo(getResultSeatNo(order.getSeatType(), Integer.parseInt(order.getSeatNo()))));
        return Result.ok().data("list",list);
    }


    /**
     * @description: TODO：什么B东西？？
     * @param:   token
                datetime
                train_no
                start_no
                end_no
                passenger_phone_number
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/11 16:38
     */
    @GetMapping("/getOrderChangeResult")
    public Result getOrderChangeResult(@RequestParam String token,String datetime,String train_no,String start_no,String end_no ,String passenger_phone_number) {
        return null;
    }



    /**
     * @description: 获取订单钱数
     * @param: order_id
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/11 16:44
     */
    @GetMapping("/getOrderMoney")
    public Result getOrderMoney(@RequestParam String order_id){
        String order_money = iOrderService.getOrderMoney(order_id);
        return Result.ok().data("order_money",order_money);
    }

    /**
     * @description: 获取所有订单
     * @param:
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/12 11:19
     */
    @GetMapping("/getAllOrder")
    public Result GetOrderList(){
        List<OrderVO> list =iOrderService.getAllOrder();
        list.forEach(orderVo ->orderVo.setSeatNo(getResultSeatNo(orderVo.getSeatType(), Integer.parseInt(orderVo.getSeatNo()))));
        return Result.ok().data("list",list);
    }
    /**
     * @description: 根据电话查询订单
     * @param: user_phone_number
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/12 11:23
     */
    @GetMapping("/getOrderByPhoneNumber")
    public Result getOrderByPhoneNumber(@RequestParam String user_phone_number){
        List<OrderVO> list = iOrderService.getAllOrderLists(user_phone_number);
        list.forEach(orderVO -> orderVO.setSeatNo(getResultSeatNo(orderVO.getSeatType(), Integer.parseInt(orderVO.getSeatNo()))));
        return Result.ok().data("list",list);
    }
    /**
     * @description: 订票
     * @param: orderTrainTicketDTO
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/13 13:44
     */
    @PostMapping("/orderTrainTicket")
    public Result orderTrainTicket(@RequestBody OrderTrainTicketDTO orderTrainTicketDTO) {
        return iOrderService.orderTrainTicket(orderTrainTicketDTO);
    }

    /**
     * @description:  查询订单
     * @param:  token
                datetime
                train_no
                start_no
                end_no
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/13 14:03
     */
    @GetMapping("/getOrderList")
    public Result getOrderList(@RequestParam String token,String datetime,String train_no,String start_no,String end_no) {
        User user = redisObjUtil.getEntity(token);
        String userPhoneNumber = user.getUserPhoneNumber();
        List<GetOrderListVO> list = iOrderService.getOrderList(userPhoneNumber,train_no,start_no,end_no);
        return Result.ok().data("list",list);
    }

    private String getResultSeatNo(String seatType, int seatNo) {
        String resultSeat = null;
        switch (seatType) {
            case "特等座":
                resultSeat = getResultSeat(seatNo, 3);
                break;
            case "一等座":
                resultSeat = getResultSeat(seatNo, 4);
                break;
            case "二等座":
                resultSeat = getResultSeat(seatNo, 5);
                break;
            case "软卧":
                resultSeat = getResultSoftSleep(seatNo);
                break;
            case "硬卧":
                resultSeat = getResultHardSleep(seatNo);
                break;
            case "硬座":
                resultSeat = getResultHardSeat(seatNo);
                break;
            default:
                break;
        }
        return resultSeat;
    }

    private String getResultSeat(int seatNo, int seatGroup) {
        String resultSeat = String.valueOf(seatNo / seatGroup + 1) + "排";
        int remainder = seatNo % seatGroup;
        switch (remainder) {
            case 0:
                resultSeat += "A座";
                break;
            case 1:
                resultSeat += "B座";
                break;
            case 2:
                resultSeat += "C座";
                break;
            case 3:
                resultSeat += "D座";
                break;
            case 4:
                resultSeat += "E座";
                break;
            default:
                break;
        }
        return resultSeat;
    }

    private String getResultSoftSleep(int seatNo) {
        String resultSoftSleep = String.valueOf(seatNo / 2 + 1) + "排";
        int remainder = seatNo % 2;
        switch (remainder) {
            case 0:
                resultSoftSleep += "上铺";
                break;
            case 1:
                resultSoftSleep += "下铺";
                break;
            default:
                break;
        }
        return resultSoftSleep;
    }

    private String getResultHardSleep(int seatNo) {
        String resultHardSleep = String.valueOf(seatNo / 3 + 1) + "排";
        int remainder = seatNo % 3;
        switch (remainder) {
            case 0:
                resultHardSleep += "上铺";
                break;
            case 1:
                resultHardSleep += "中铺";
                break;
            case 2:
                resultHardSleep += "下铺";
                break;
            default:
                break;
        }
        return resultHardSleep;
    }

    private String getResultHardSeat(int seatNo) {
        String resultHardSeat = String.valueOf(seatNo / 6 + 1) + "排";
        int remainder = seatNo % 6;
        switch (remainder) {
            case 0:
                resultHardSeat += "A座";
                break;
            case 1:
                resultHardSeat += "B座";
                break;
            case 2:
                resultHardSeat += "C座";
                break;
            case 3:
                resultHardSeat += "D座";
                break;
            case 4:
                resultHardSeat += "E座";
                break;
            case 5:
                resultHardSeat += " F座";
                break;
            default:
                break;
        }
        return resultHardSeat;
    }

}
