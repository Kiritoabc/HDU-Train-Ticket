package com.hdu.train.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdu.train.dto.OrderInfoDTO;
import com.hdu.train.entity.Order;
import com.hdu.train.vo.GetOrderListVO;
import com.hdu.train.vo.OrderVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
public interface IOrderService extends IService<Order> {

    List<OrderVO> getAllOrderLists(String userPhoneNumber);

    List<OrderVO> getNotripOrderLists(String userPhoneNumber);

    List<OrderVO> getNopayOrderLists(String userPhoneNumber);

    void refundTicket(String userPhoneNumber, String orderId);

    List<GetOrderListVO> getOrderInfo(String orderId);

    String getOrderMoney(String orderId);

    List<OrderVO> getAllOrder();
}
