package com.hdu.train.controller;

import cn.hutool.core.date.DateUtil;
import com.hdu.train.dto.TransferTrainTicketNumDTO;
import com.hdu.train.service.ITrainService;
import com.hdu.train.util.RedisObjUtil;
import com.hdu.train.util.Result;
import com.hdu.train.vo.TrainTicketPriceInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@RestController
@RequestMapping("/query")
public class TrainTicketQueryController {

    @Autowired
    private RedisObjUtil redisObjUtil;

    @Autowired
    private ITrainService iTrainService;

    /**
     * @description:
     * @param:  train_start_station
                train_end_station
                datetime
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/14 21:44
     */
    @GetMapping("/queryTrainTicket")
    public Result GetTrainScheduleInfo(@RequestParam String train_start_station, String train_end_station, String datetime) {
        // 将当前时间转换为字符串
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
//        Date now = new Date();
//        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
//        String nowToday = sdfs.format(now);
//        SimpleDateFormat sdfs2 = new SimpleDateFormat("HH:mm:ss");
//        String nowTime = sdfs2.format(now);
        String now = DateUtil.now();
        if(datetime.compareTo(now) < 0) {
            return Result.error().message("当前时间不能查询历史车次");
        }
        List<TrainTicketPriceInfoVO> list = iTrainService.searchTrainScheduleInfo(train_start_station, train_end_station, datetime);
        return Result.ok().data("trainTicketPriceInfo", list);
    }

    /**
     * @description:  TODO：暂时没想好
     * @param: datetime
                train_no
                start_no
                end_no
                train_number
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/14 21:44
     */
    @GetMapping("/queryTrainTicketNum")
    public Result GetTrainTicketPrice(@RequestParam String datetime, String train_no, String start_no,String end_no,String train_number) {
        return null;
    }

    /**
     * @description:  TODO: 暂时没想好
     * @param:  train_start_station
                train_end_station
                datetime
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/14 21:45
     */
    @GetMapping(value ="/queryTrainTransferTicket")
    public Result GetTrainTransferScheduleInfo(@RequestParam String train_start_station, String train_end_station, String datetime){
        return null;
    }

    /**
     * @description: TODO: 暂时没想好
     * @param: transferTrainTicketNumDTO
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/14 21:50
     */
    @RequestMapping(value ="/queryTransferTrainTicketNum",method = RequestMethod.POST)
    public  Result queryTransferTrainTicketNum(@RequestBody TransferTrainTicketNumDTO transferTrainTicketNumDTO) {
        return null;
    }
}
