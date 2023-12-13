package com.hdu.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdu.train.dto.OrderTrainTicketDTO;
import com.hdu.train.entity.Order;
import com.hdu.train.mapper.OrderMapper;
import com.hdu.train.service.IOrderService;
import com.hdu.train.util.Result;
import com.hdu.train.vo.GetOrderListVO;
import com.hdu.train.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service("iOrderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderVO> getAllOrderLists(String userPhoneNumber) {

        return orderMapper.getAllOrderLists(userPhoneNumber);
    }

    @Override
    public List<OrderVO> getNotripOrderLists(String userPhoneNumber) {
        return orderMapper.getNotripOrderLists(userPhoneNumber);
    }

    @Override
    public List<OrderVO> getNopayOrderLists(String userPhoneNumber) {
        return orderMapper.getNopayOrderLists(userPhoneNumber);
    }

    @Override
    public void refundTicket(String userPhoneNumber, String orderId) {
        orderMapper.refundTicket(userPhoneNumber, orderId);
    }

    @Override
    public List<GetOrderListVO> getOrderInfo(String orderId) {
        return orderMapper.GetOrderInfo(orderId);
    }

    @Override
    public String getOrderMoney(String orderId) {
        return orderMapper.GetOrderMoney(orderId);
    }

    @Override
    public List<OrderVO> getAllOrder() {
        return orderMapper.GetAllOrder();
    }

    @Override
    public Result orderTrainTicket(OrderTrainTicketDTO orderTrainTicketDTO) {
        // TODO: 订票
        return null;
    }

    @Override
    public List<GetOrderListVO> getOrderList(String userPhoneNumber, String trainNo, String startNo, String endNo) {
        return orderMapper.getOrderList(userPhoneNumber, trainNo,  startNo, endNo);
    }


}
