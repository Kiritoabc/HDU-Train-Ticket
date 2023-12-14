package com.hdu.train.controller;

import com.hdu.train.entity.Seat;
import com.hdu.train.entity.Station;
import com.hdu.train.entity.Train;
import com.hdu.train.service.ISeatService;
import com.hdu.train.service.IStationService;
import com.hdu.train.service.ITrainService;
import com.hdu.train.util.Result;
import com.hdu.train.vo.TrainInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zq
 * @since 2023-12-09
 */
@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private ITrainService iTrainService;

    @Autowired
    private IStationService iStationService;

    @Autowired
    private ISeatService iSeatService;

    /**
     * @description:
     * @param:  offset
                limit
     * @return: com.hdu.train.util.Result
     * @author 菠萝
     * @date: 2023/12/14 11:39
     */
    @GetMapping("/trainInfo")
    public Result TrainInfo(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return iTrainService.TrainInfo(offset, limit);
    }
    @GetMapping("/searchtraininfo")
    public Result SearchTrainInfo(String train_number){
        TrainInfoVO trainInfo = iTrainService.selectTrainInfo(train_number);
        if(trainInfo!=null){
            return Result.ok().data("data",trainInfo);
        }
        return Result.error().message("train_number 错误");
    }
    @GetMapping("/searchtrainparkingInfo")
    public Result SearchTrainInfoList(String train_number){
        List<Station> stations = iStationService.searchTrainParkingStation(train_number);
        if(stations!=null){
            return Result.ok().data("list",stations);
        }
        return Result.error().message("train_number 错误");
    }
    @GetMapping("/updateTrainTypeStart")
    public Result updateTrainTypeStart(String train_no){
        try
        {
            iTrainService.updateTrainTypeStart(train_no);
            return Result.ok().message("修改成功");
        }
        catch (Exception e)
        {
            return Result.error().message("修改失败");
        }
    }
    @GetMapping("/updateTrainTypeStop")
    public Result updateTrainTypeStop(String train_no){
        try
        {
            iTrainService.updateTrainTypeStop(train_no);
            return Result.ok().message("修改成功");
        }
        catch (Exception e)
        {
            return Result.error().message("修改失败");
        }
    }
    @GetMapping("/selectSeatInfoByTrainNumber")
    public Result selectSeatInfoByTrainNumber(String train_number){
        List<Seat> seats = iSeatService.selectSeatInfoByTrainNumber(train_number);
        if (seats!=null){
            return Result.ok().data("list",seats);
        }
        return Result.error().message("查询失败,train_number 错误");
    }
    @GetMapping("/deleteTrainSeat")
    public Result deleteTrainSeat(String train_no,String carriage_no){
        try
        {
            iTrainService.deleteTrainSeat(train_no,carriage_no);
            return Result.ok().message("删除成功");
        }
        catch (Exception e)
        {
            return Result.error().message("删除失败");
        }
    }
    @GetMapping("/addTrainSeat")
    public Result addTrainSeat(String train_no,String carriage_no,String seat_type,String seat_count){
        Seat seat = new Seat(train_no,carriage_no,seat_type,Integer.parseInt(seat_count));
        try
        {
            iSeatService.addTrainSeat(seat);
            return Result.ok().message("增加成功");
        }
        catch (Exception e)
        {
            return Result.error().message("增加失败");
        }
    }
    @GetMapping("/getAllTrainNumber")
    public Result getAllTrainNumber(){

        try
        {
            List<String> trainNumbers= iTrainService.getAllTrainNumber();
            return Result.ok().data("list",trainNumbers);
        }
        catch (Exception e)
        {
            return Result.error().message("查询失败");
        }
    }
    @GetMapping("/getAllStationName")
    public Result getAllStationName(){
        try
        {
            List<String> stationNames= iStationService.getAllstationName();
            return Result.ok().data("list",stationNames);
        }
        catch (Exception e)
        {
            return Result.error().message("查询失败");
        }
    }

    @PostMapping("addTrainInfo")
    public Result addTrainInfo(@RequestBody Train train, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        try
        {
            iTrainService.addTrainInfo(train);
            return Result.ok().message("插入成功");
        }
        catch (Exception e)
        {
            return Result.error().message("插入失败");
        }

    }
    @PostMapping("/addTrainStation")
    public Result addTrainStation(@RequestBody Station station,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        try
        {
            iStationService.addTrainStation(station);
            return Result.ok().message("插入成功");
        }
        catch (Exception e)
        {
            return Result.error().message("插入失败");
        }
    }


}
