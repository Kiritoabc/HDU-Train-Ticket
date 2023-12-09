---
title: db_design v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# db_design

> v1.0.0

Base URLs:

# 乘客管理的业务处理层

## GET 根据用户  获取此用户下的乘客信息

GET /passenger/getPassengerInfo

对应前端的getPassengerInfo请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "passengerInfos": [
    {
      "user_phone_number": "",
      "passenger_real_name": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "passenger_type": "",
      "passenger_address": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[PassengerInfoReturnData](#schemapassengerinforeturndata)|

## POST 用户添加乘客

POST /passenger/addPassengerInfo

对应前端的addPassengerInfo请求

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET 删除乘客信息

GET /passenger/deletePassengerInfo

对应前端的deletePassengerInfo请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|
|passenger_phone_number|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET searchPassengerByNumber

GET /passenger/getPassengerInfoByNumber

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|passenger_phone_number|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "passengerInfos": [
    {
      "user_phone_number": "",
      "passenger_real_name": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "passenger_type": "",
      "passenger_address": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[PassengerInfoReturnData](#schemapassengerinforeturndata)|

## GET deletePassenger

GET /passenger/deletePassenger

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|user_phone_number|query|string| 是 |none|
|passenger_phone_number|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

# 车票查询的业务处理层

## GET 根据出发地 目的地查询票价以及出行时间

GET /query/queryTrainTicket

对应前端的queryTrainTicket请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_start_station|query|string| 是 |none|
|train_end_station|query|string| 否 |none|
|datetime|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainTicketPriceInfoList": [
    {
      "train_no": "",
      "train_number": "",
      "start_station": "",
      "end_station": "",
      "start_no": "",
      "end_no": "",
      "start_time": "",
      "arrive_time": "",
      "start_running_time": "",
      "end_running_time": "",
      "high_seat_price": "",
      "medium_seat_price": "",
      "low_seat_price": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainTicketPriceQueryReturnData](#schematrainticketpricequeryreturndata)|

## GET GetTrainTicketPrice

GET /query/queryTrainTicketNum

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|datetime|query|string| 是 |none|
|train_no|query|string| 否 |none|
|start_no|query|string| 否 |none|
|end_no|query|string| 否 |none|
|train_number|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainRemainingSeats": [
    {
      "carriage_no": "",
      "seat_type": "",
      "High_seat_upper": 0,
      "High_seat_lower": 0,
      "Medium_seat_upper": 0,
      "Medium_seat_middle": 0,
      "Medium_seat_lower": 0,
      "Low_seat_A": 0,
      "Low_seat_B": 0,
      "Low_seat_C": 0,
      "Low_seat_D": 0,
      "Low_seat_E": 0,
      "Low_seat_F": 0
    }
  ],
  "trainRemainingSeats_gds": [
    {
      "carriage_no": "",
      "seat_type": "",
      "High_seat_GD_A": 0,
      "High_seat_GD_B": 0,
      "High_seat_GD_C": 0,
      "Medium_seat_GD_A": 0,
      "Medium_seat_GD_B": 0,
      "Medium_seat_GD_C": 0,
      "Medium_seat_GD_D": 0,
      "Low_seat_GD_A": 0,
      "Low_seat_GD_B": 0,
      "Low_seat_GD_C": 0,
      "Low_seat_GD_D": 0,
      "Low_seat_GD_E": 0
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainSeatQueryReturnData](#schematrainseatqueryreturndata)|

## GET GetTrainTransferScheduleInfo

GET /query/queryTrainTransferTicket

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_start_station|query|string| 是 |none|
|train_end_station|query|string| 否 |none|
|datetime|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainTransferTicketPriceInfoList": [
    {
      "train_no_1": "",
      "train_number_1": "",
      "train_no_2": "",
      "train_number_2": "",
      "start_station_no": "",
      "start_station_name": "",
      "transfer_station_no_1": "",
      "transfer_station_name": "",
      "start_time_1": "",
      "arrive_time_1": "",
      "start_time_2": "",
      "arrive_time_2": "",
      "end_station_no": "",
      "end_station_name": "",
      "start_running_time_1": "",
      "end_running_time_1": "",
      "start_running_time_2": "",
      "end_running_time_2": "",
      "transfer_station_no_2": "",
      "high_seat_price_1": "",
      "medium_seat_price_1": "",
      "low_seat_price_1": "",
      "high_seat_price_2": "",
      "medium_seat_price_2": "",
      "low_seat_price_2": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainTransferTicketPriceReturnData](#schematraintransferticketpricereturndata)|

## POST queryTransferTrainTicketNum

POST /query/queryTransferTrainTicketNum

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainTransferSeatCountList": [
    {
      "train_no": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_count": 0,
      "train_number": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainTransferSeatCountReturnData](#schematraintransferseatcountreturndata)|

# TrainTicketOrderController

## POST UserLogin

POST /order/orderTrainTicket

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "carriage_no": "",
  "seat_type": "",
  "result_seat_no": "",
  "passenger_phone_number": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainTicketOrderReturnData](#schematrainticketorderreturndata)|

## GET 获得 本次订单 订单号

GET /order/getOrderList

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|
|datetime|query|string| 否 |none|
|train_no|query|string| 否 |none|
|start_no|query|string| 否 |none|
|end_no|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "getOrderListList": [
    {
      "order_id": "",
      "passenger_real_name": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_no": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetOrderListReturnData](#schemagetorderlistreturndata)|

## POST 支付成功  获取订单信息

POST /order/paySuccess

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

# 列车时刻表查询的业务处理逻辑

## GET 根据起始站 目的站  查询符合条件的列车信息

GET /trainSchedule/searchTrainSchedule

对应前端的searchTrainSchedule请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_start_station|query|string| 是 |none|
|train_end_station|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainScheduleInfoList": [
    {
      "train_no": "",
      "train_number": "",
      "start_station": "",
      "end_station": "",
      "start_no": "",
      "end_no": "",
      "start_time": "",
      "arrive_time": "",
      "start_running_time": "",
      "end_running_time": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainScheduleReturnData](#schematrainschedulereturndata)|

## GET 返回列车具体的经停信息

GET /trainSchedule/getTrainScheduleList

对应前端的getTrainScheduleList请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_start_station_no|query|string| 是 |none|
|train_end_station_no|query|string| 否 |none|
|train_no|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainScheduleInfoList": [
    {
      "train_no": "",
      "train_number": "",
      "start_station": "",
      "end_station": "",
      "start_no": "",
      "end_no": "",
      "start_time": "",
      "arrive_time": "",
      "start_running_time": "",
      "end_running_time": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainScheduleReturnData](#schematrainschedulereturndata)|

## GET 查询接续换乘路线

GET /trainSchedule/searchTransferSchedule

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_start_station|query|string| 是 |none|
|train_end_station|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainTransferScheduleList": [
    {
      "train_no_1": "",
      "train_number_1": "",
      "train_no_2": "",
      "train_number_2": "",
      "start_station_no": "",
      "start_station_name": "",
      "transfer_station_no_1": "",
      "transfer_station_name": "",
      "start_time_1": "",
      "arrive_time_1": "",
      "start_time_2": "",
      "arrive_time_2": "",
      "end_station_no": "",
      "end_station_name": "",
      "start_running_time_1": "",
      "end_running_time_1": "",
      "start_running_time_2": "",
      "end_running_time_2": "",
      "transfer_station_no_2": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainTransferScheduleReturnData](#schematraintransferschedulereturndata)|

# 有关列车信息查询的业务逻辑层

## GET 查询所有列车信息

GET /train/traininfo

对应前端的getTrainInfoData请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|offset|query|integer| 否 |none|
|limit|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainInfos": [
    {
      "train_no": "",
      "train_number": "",
      "train_type": "",
      "train_carriages": "",
      "train_start_station": "",
      "train_end_station": "",
      "train_start_time": "",
      "train_end_time": "",
      "train_arrive_day": "",
      "train_running_time": "",
      "train_running_type": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainInfoReturnData](#schematraininforeturndata)|

## GET 根据车次查询列车信息

GET /train/searchtraininfo

对应前端的SearchTrainInfoData请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_number|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainInfo": {
    "train_no": "",
    "train_number": "",
    "train_type": "",
    "train_carriages": "",
    "train_start_station": "",
    "train_end_station": "",
    "train_start_time": "",
    "train_end_time": "",
    "train_arrive_day": "",
    "train_running_time": "",
    "train_running_type": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[SearchTrainInfoReturnData](#schemasearchtraininforeturndata)|

## GET 根据车次查询列车的经停信息

GET /train/searchtrainparkingInfo

对应前端的 SearchTrainParkingInfo请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_number|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "trainParkingInfo": [
    {
      "train_number": "",
      "arrive_day_str": "",
      "start_time": "",
      "arrive_time": "",
      "running_time": "",
      "station_no": "",
      "station_name": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[TrainParkingInfoReturnData](#schematrainparkinginforeturndata)|

## GET updateTrainTypeStart

GET /train/updateTrainTypeStart

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_no|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET updateTrainTypeStop

GET /train/updateTrainTypeStop

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_no|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET SelectSeatInfoByTrainNumber

GET /train/selectSeatInfoByTrainNumber

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_number|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "seatInfoList": [
    {
      "train_no": "",
      "train_number": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_count": 0
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[SeatInfoReturnData](#schemaseatinforeturndata)|

## GET deleteTrainSeat

GET /train/deleteTrainSeat

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_no|query|string| 否 |none|
|carriage_no|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET addTrainSeat

GET /train/addTrainSeat

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|train_no|query|string| 否 |none|
|carriage_no|query|string| 否 |none|
|seat_type|query|string| 否 |none|
|seat_count|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET getAllTrainNumber

GET /train/getAllTrainNumber

> 返回示例

> 成功

```json
{
  "status": 0,
  "DataLists": [
    {
      "value": "",
      "address": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetAllTrainNumberListReturnData](#schemagetalltrainnumberlistreturndata)|

## GET getAllStationName

GET /train/getAllStationName

> 返回示例

> 成功

```json
{
  "status": 0,
  "DataLists": [
    {
      "value": "",
      "address": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetAllTrainNumberListReturnData](#schemagetalltrainnumberlistreturndata)|

## POST UserLogin

POST /train/addTrainInfo

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## POST addTrainStation

POST /train/addTrainStation

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

# OrderListController

## GET GetAllOrderList

GET /order/getAllOrderList

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "getAllOrderListList": [
    {
      "order_id": "",
      "passenger_real_name": "",
      "train_number": "",
      "start_station_name": "",
      "end_station_name": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_no": "",
      "start_date": "",
      "start_time": "",
      "order_status": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "order_money": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetAllOrderListReturnData](#schemagetallorderlistreturndata)|

## GET GetNoTripOrderList

GET /order/getNotripOrderList

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "getAllOrderListList": [
    {
      "order_id": "",
      "passenger_real_name": "",
      "train_number": "",
      "start_station_name": "",
      "end_station_name": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_no": "",
      "start_date": "",
      "start_time": "",
      "order_status": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "order_money": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetAllOrderListReturnData](#schemagetallorderlistreturndata)|

## GET GetNoPauOrderList

GET /order/getNoPayOrderList

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "getAllOrderListList": [
    {
      "order_id": "",
      "passenger_real_name": "",
      "train_number": "",
      "start_station_name": "",
      "end_station_name": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_no": "",
      "start_date": "",
      "start_time": "",
      "order_status": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "order_money": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetAllOrderListReturnData](#schemagetallorderlistreturndata)|

## GET RefundTicket

GET /order/refundTicket

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|
|order_id|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## POST TicketChange

POST /order/ticketChange

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## POST getOrderInfo

POST /order/getOrder

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "getOrderListList": [
    {
      "order_id": "",
      "passenger_real_name": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_no": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetOrderListReturnData](#schemagetorderlistreturndata)|

## GET getOrderChangeResult

GET /order/getOrderChangeResult

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|
|datetime|query|string| 否 |none|
|train_no|query|string| 否 |none|
|start_no|query|string| 否 |none|
|end_no|query|string| 否 |none|
|passenger_phone_number|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "getOrderListList": [
    {
      "order_id": "",
      "passenger_real_name": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_no": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetOrderListReturnData](#schemagetorderlistreturndata)|

## GET getOrderChangeResult

GET /order/getOrderMoney

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|order_id|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET GetOrderList

GET /order/getAllOrder

> 返回示例

> 成功

```json
{
  "status": 0,
  "getAllOrderListList": [
    {
      "order_id": "",
      "passenger_real_name": "",
      "train_number": "",
      "start_station_name": "",
      "end_station_name": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_no": "",
      "start_date": "",
      "start_time": "",
      "order_status": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "order_money": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetAllOrderListReturnData](#schemagetallorderlistreturndata)|

## GET getOrderByPhoneNumber

GET /order/getOrderByPhoneNumber

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|user_phone_number|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "getAllOrderListList": [
    {
      "order_id": "",
      "passenger_real_name": "",
      "train_number": "",
      "start_station_name": "",
      "end_station_name": "",
      "carriage_no": "",
      "seat_type": "",
      "seat_no": "",
      "start_date": "",
      "start_time": "",
      "order_status": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "order_money": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetAllOrderListReturnData](#schemagetallorderlistreturndata)|

# 有关用户信息的业务处理层

## POST 用户登录

POST /user/login

对应前端的 login请求

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET 登陆成功后，向前端返回cookie中的内容 作为用户登陆的标记

GET /user/info

并且将用户登陆信息存入token中

对应前端的getAdminInfo请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "data": {
    "user_real_name": "",
    "user_phone_number": "",
    "user_email": "",
    "user_type": "",
    "user_gender": "",
    "user_id_number": "",
    "user_address": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[UserInfoReturnData](#schemauserinforeturndata)|

## POST 用户注册

POST /user/register

对应前端的register请求

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET signout

GET /user/signout

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET 查询用户信息的接口

GET /user/userinfo

对应前端的getUserInfo请求

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "data": {
    "user_real_name": "",
    "user_phone_number": "",
    "user_email": "",
    "user_type": "",
    "user_gender": "",
    "user_id_number": "",
    "user_address": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[UserInfoReturnData](#schemauserinforeturndata)|

## POST 修改个人信息的接口

POST /user/changeuserinfo

对应前端的changeUserInfo请求

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## POST 修改密码的接口

POST /user/changepassword

对应前端的 changePassword请求

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## POST 管理员登陆

POST /user/adminLogin

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

## GET 获取所有用户

GET /user/getAllUser

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "userList": [
    {
      "user_phone_number": "",
      "user_password": "",
      "user_email": "",
      "user_real_name": "",
      "user_type": 0,
      "user_id_number": "",
      "user_gender": 0,
      "user_address": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[GetAllUserReturnData](#schemagetalluserreturndata)|

## GET getAllPassenger

GET /user/getAllPassenger

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "passengerInfos": [
    {
      "user_phone_number": "",
      "passenger_real_name": "",
      "passenger_phone_number": "",
      "passenger_id_number": "",
      "passenger_type": "",
      "passenger_address": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[PassengerInfoReturnData](#schemapassengerinforeturndata)|

## GET deleteUser

GET /user/deleteUser

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|user_phone_number|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "status": 0,
  "success": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[RespBean](#schemarespbean)|

# 数据模型

<h2 id="tocS_GetAllUserReturnData">GetAllUserReturnData</h2>

<a id="schemagetalluserreturndata"></a>
<a id="schema_GetAllUserReturnData"></a>
<a id="tocSgetalluserreturndata"></a>
<a id="tocsgetalluserreturndata"></a>

```json
{
  "status": 0,
  "userList": [
    {
      "user_phone_number": "string",
      "user_password": "string",
      "user_email": "string",
      "user_real_name": "string",
      "user_type": 0,
      "user_id_number": "string",
      "user_gender": 0,
      "user_address": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|userList|[[User](#schemauser)]¦null|false|none||none|

<h2 id="tocS_User">User</h2>

<a id="schemauser"></a>
<a id="schema_User"></a>
<a id="tocSuser"></a>
<a id="tocsuser"></a>

```json
{
  "user_phone_number": "string",
  "user_password": "string",
  "user_email": "string",
  "user_real_name": "string",
  "user_type": 0,
  "user_id_number": "string",
  "user_gender": 0,
  "user_address": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|user_phone_number|string¦null|false|none||none|
|user_password|string¦null|false|none||none|
|user_email|string¦null|false|none||none|
|user_real_name|string¦null|false|none||none|
|user_type|integer¦null|false|none||none|
|user_id_number|string¦null|false|none||none|
|user_gender|integer¦null|false|none||none|
|user_address|string¦null|false|none||none|

<h2 id="tocS_UserInfoReturnData">UserInfoReturnData</h2>

<a id="schemauserinforeturndata"></a>
<a id="schema_UserInfoReturnData"></a>
<a id="tocSuserinforeturndata"></a>
<a id="tocsuserinforeturndata"></a>

```json
{
  "status": 0,
  "data": {
    "user_real_name": "string",
    "user_phone_number": "string",
    "user_email": "string",
    "user_type": "string",
    "user_gender": "string",
    "user_id_number": "string",
    "user_address": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|data|[UserInfo](#schemauserinfo)|false|none||none|

<h2 id="tocS_UserInfo">UserInfo</h2>

<a id="schemauserinfo"></a>
<a id="schema_UserInfo"></a>
<a id="tocSuserinfo"></a>
<a id="tocsuserinfo"></a>

```json
{
  "user_real_name": "string",
  "user_phone_number": "string",
  "user_email": "string",
  "user_type": "string",
  "user_gender": "string",
  "user_id_number": "string",
  "user_address": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|user_real_name|string¦null|false|none||none|
|user_phone_number|string¦null|false|none||none|
|user_email|string¦null|false|none||none|
|user_type|string¦null|false|none||none|
|user_gender|string¦null|false|none||none|
|user_id_number|string¦null|false|none||none|
|user_address|string¦null|false|none||none|

<h2 id="tocS_GetAllOrderListReturnData">GetAllOrderListReturnData</h2>

<a id="schemagetallorderlistreturndata"></a>
<a id="schema_GetAllOrderListReturnData"></a>
<a id="tocSgetallorderlistreturndata"></a>
<a id="tocsgetallorderlistreturndata"></a>

```json
{
  "status": 0,
  "getAllOrderListList": [
    {
      "order_id": "string",
      "passenger_real_name": "string",
      "train_number": "string",
      "start_station_name": "string",
      "end_station_name": "string",
      "carriage_no": "string",
      "seat_type": "string",
      "seat_no": "string",
      "start_date": "string",
      "start_time": "string",
      "order_status": "string",
      "passenger_phone_number": "string",
      "passenger_id_number": "string",
      "order_money": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|getAllOrderListList|[[GetAllOrderList](#schemagetallorderlist)]¦null|false|none||none|

<h2 id="tocS_GetAllOrderList">GetAllOrderList</h2>

<a id="schemagetallorderlist"></a>
<a id="schema_GetAllOrderList"></a>
<a id="tocSgetallorderlist"></a>
<a id="tocsgetallorderlist"></a>

```json
{
  "order_id": "string",
  "passenger_real_name": "string",
  "train_number": "string",
  "start_station_name": "string",
  "end_station_name": "string",
  "carriage_no": "string",
  "seat_type": "string",
  "seat_no": "string",
  "start_date": "string",
  "start_time": "string",
  "order_status": "string",
  "passenger_phone_number": "string",
  "passenger_id_number": "string",
  "order_money": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|order_id|string¦null|false|none||none|
|passenger_real_name|string¦null|false|none||none|
|train_number|string¦null|false|none||none|
|start_station_name|string¦null|false|none||none|
|end_station_name|string¦null|false|none||none|
|carriage_no|string¦null|false|none||none|
|seat_type|string¦null|false|none||none|
|seat_no|string¦null|false|none||none|
|start_date|string¦null|false|none||none|
|start_time|string¦null|false|none||none|
|order_status|string¦null|false|none||none|
|passenger_phone_number|string¦null|false|none||none|
|passenger_id_number|string¦null|false|none||none|
|order_money|string¦null|false|none||none|

<h2 id="tocS_GetAllTrainNumberListReturnData">GetAllTrainNumberListReturnData</h2>

<a id="schemagetalltrainnumberlistreturndata"></a>
<a id="schema_GetAllTrainNumberListReturnData"></a>
<a id="tocSgetalltrainnumberlistreturndata"></a>
<a id="tocsgetalltrainnumberlistreturndata"></a>

```json
{
  "status": 0,
  "DataLists": [
    {
      "value": "string",
      "address": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|DataLists|[[TrainNumberData](#schematrainnumberdata)]¦null|false|none||none|

<h2 id="tocS_TrainNumberData">TrainNumberData</h2>

<a id="schematrainnumberdata"></a>
<a id="schema_TrainNumberData"></a>
<a id="tocStrainnumberdata"></a>
<a id="tocstrainnumberdata"></a>

```json
{
  "value": "string",
  "address": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|value|string¦null|false|none||none|
|address|string¦null|false|none||none|

<h2 id="tocS_SeatInfoReturnData">SeatInfoReturnData</h2>

<a id="schemaseatinforeturndata"></a>
<a id="schema_SeatInfoReturnData"></a>
<a id="tocSseatinforeturndata"></a>
<a id="tocsseatinforeturndata"></a>

```json
{
  "status": 0,
  "seatInfoList": [
    {
      "train_no": "string",
      "train_number": "string",
      "carriage_no": "string",
      "seat_type": "string",
      "seat_count": 0
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|seatInfoList|[[SeatInfo](#schemaseatinfo)]¦null|false|none||none|

<h2 id="tocS_SeatInfo">SeatInfo</h2>

<a id="schemaseatinfo"></a>
<a id="schema_SeatInfo"></a>
<a id="tocSseatinfo"></a>
<a id="tocsseatinfo"></a>

```json
{
  "train_no": "string",
  "train_number": "string",
  "carriage_no": "string",
  "seat_type": "string",
  "seat_count": 0
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|train_no|string¦null|false|none||none|
|train_number|string¦null|false|none||none|
|carriage_no|string¦null|false|none||none|
|seat_type|string¦null|false|none||none|
|seat_count|integer¦null|false|none||none|

<h2 id="tocS_TrainParkingInfoReturnData">TrainParkingInfoReturnData</h2>

<a id="schematrainparkinginforeturndata"></a>
<a id="schema_TrainParkingInfoReturnData"></a>
<a id="tocStrainparkinginforeturndata"></a>
<a id="tocstrainparkinginforeturndata"></a>

```json
{
  "status": 0,
  "trainParkingInfo": [
    {
      "train_number": "string",
      "arrive_day_str": "string",
      "start_time": "string",
      "arrive_time": "string",
      "running_time": "string",
      "station_no": "string",
      "station_name": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainParkingInfo|[[TrainParkingInfo](#schematrainparkinginfo)]¦null|false|none||none|

<h2 id="tocS_TrainParkingInfo">TrainParkingInfo</h2>

<a id="schematrainparkinginfo"></a>
<a id="schema_TrainParkingInfo"></a>
<a id="tocStrainparkinginfo"></a>
<a id="tocstrainparkinginfo"></a>

```json
{
  "train_number": "string",
  "arrive_day_str": "string",
  "start_time": "string",
  "arrive_time": "string",
  "running_time": "string",
  "station_no": "string",
  "station_name": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|train_number|string¦null|false|none||none|
|arrive_day_str|string¦null|false|none||none|
|start_time|string¦null|false|none||none|
|arrive_time|string¦null|false|none||none|
|running_time|string¦null|false|none||none|
|station_no|string¦null|false|none||none|
|station_name|string¦null|false|none||none|

<h2 id="tocS_SearchTrainInfoReturnData">SearchTrainInfoReturnData</h2>

<a id="schemasearchtraininforeturndata"></a>
<a id="schema_SearchTrainInfoReturnData"></a>
<a id="tocSsearchtraininforeturndata"></a>
<a id="tocssearchtraininforeturndata"></a>

```json
{
  "status": 0,
  "trainInfo": {
    "train_no": "string",
    "train_number": "string",
    "train_type": "string",
    "train_carriages": "string",
    "train_start_station": "string",
    "train_end_station": "string",
    "train_start_time": "string",
    "train_end_time": "string",
    "train_arrive_day": "string",
    "train_running_time": "string",
    "train_running_type": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainInfo|[TrainInfo](#schematraininfo)|false|none||none|

<h2 id="tocS_TrainInfoReturnData">TrainInfoReturnData</h2>

<a id="schematraininforeturndata"></a>
<a id="schema_TrainInfoReturnData"></a>
<a id="tocStraininforeturndata"></a>
<a id="tocstraininforeturndata"></a>

```json
{
  "status": 0,
  "trainInfos": [
    {
      "train_no": "string",
      "train_number": "string",
      "train_type": "string",
      "train_carriages": "string",
      "train_start_station": "string",
      "train_end_station": "string",
      "train_start_time": "string",
      "train_end_time": "string",
      "train_arrive_day": "string",
      "train_running_time": "string",
      "train_running_type": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainInfos|[[TrainInfo](#schematraininfo)]¦null|false|none||none|

<h2 id="tocS_TrainInfo">TrainInfo</h2>

<a id="schematraininfo"></a>
<a id="schema_TrainInfo"></a>
<a id="tocStraininfo"></a>
<a id="tocstraininfo"></a>

```json
{
  "train_no": "string",
  "train_number": "string",
  "train_type": "string",
  "train_carriages": "string",
  "train_start_station": "string",
  "train_end_station": "string",
  "train_start_time": "string",
  "train_end_time": "string",
  "train_arrive_day": "string",
  "train_running_time": "string",
  "train_running_type": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|train_no|string¦null|false|none||none|
|train_number|string¦null|false|none||none|
|train_type|string¦null|false|none||none|
|train_carriages|string¦null|false|none||none|
|train_start_station|string¦null|false|none||none|
|train_end_station|string¦null|false|none||none|
|train_start_time|string¦null|false|none||none|
|train_end_time|string¦null|false|none||none|
|train_arrive_day|string¦null|false|none||none|
|train_running_time|string¦null|false|none||none|
|train_running_type|string¦null|false|none||none|

<h2 id="tocS_TrainTransferScheduleReturnData">TrainTransferScheduleReturnData</h2>

<a id="schematraintransferschedulereturndata"></a>
<a id="schema_TrainTransferScheduleReturnData"></a>
<a id="tocStraintransferschedulereturndata"></a>
<a id="tocstraintransferschedulereturndata"></a>

```json
{
  "status": 0,
  "trainTransferScheduleList": [
    {
      "train_no_1": "string",
      "train_number_1": "string",
      "train_no_2": "string",
      "train_number_2": "string",
      "start_station_no": "string",
      "start_station_name": "string",
      "transfer_station_no_1": "string",
      "transfer_station_name": "string",
      "start_time_1": "string",
      "arrive_time_1": "string",
      "start_time_2": "string",
      "arrive_time_2": "string",
      "end_station_no": "string",
      "end_station_name": "string",
      "start_running_time_1": "string",
      "end_running_time_1": "string",
      "start_running_time_2": "string",
      "end_running_time_2": "string",
      "transfer_station_no_2": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainTransferScheduleList|[[TrainTransferSchedule](#schematraintransferschedule)]¦null|false|none||none|

<h2 id="tocS_TrainTransferSchedule">TrainTransferSchedule</h2>

<a id="schematraintransferschedule"></a>
<a id="schema_TrainTransferSchedule"></a>
<a id="tocStraintransferschedule"></a>
<a id="tocstraintransferschedule"></a>

```json
{
  "train_no_1": "string",
  "train_number_1": "string",
  "train_no_2": "string",
  "train_number_2": "string",
  "start_station_no": "string",
  "start_station_name": "string",
  "transfer_station_no_1": "string",
  "transfer_station_name": "string",
  "start_time_1": "string",
  "arrive_time_1": "string",
  "start_time_2": "string",
  "arrive_time_2": "string",
  "end_station_no": "string",
  "end_station_name": "string",
  "start_running_time_1": "string",
  "end_running_time_1": "string",
  "start_running_time_2": "string",
  "end_running_time_2": "string",
  "transfer_station_no_2": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|train_no_1|string¦null|false|none||none|
|train_number_1|string¦null|false|none||none|
|train_no_2|string¦null|false|none||none|
|train_number_2|string¦null|false|none||none|
|start_station_no|string¦null|false|none||none|
|start_station_name|string¦null|false|none||none|
|transfer_station_no_1|string¦null|false|none||none|
|transfer_station_name|string¦null|false|none||none|
|start_time_1|string¦null|false|none||none|
|arrive_time_1|string¦null|false|none||none|
|start_time_2|string¦null|false|none||none|
|arrive_time_2|string¦null|false|none||none|
|end_station_no|string¦null|false|none||none|
|end_station_name|string¦null|false|none||none|
|start_running_time_1|string¦null|false|none||none|
|end_running_time_1|string¦null|false|none||none|
|start_running_time_2|string¦null|false|none||none|
|end_running_time_2|string¦null|false|none||none|
|transfer_station_no_2|string¦null|false|none||none|

<h2 id="tocS_TrainScheduleReturnData">TrainScheduleReturnData</h2>

<a id="schematrainschedulereturndata"></a>
<a id="schema_TrainScheduleReturnData"></a>
<a id="tocStrainschedulereturndata"></a>
<a id="tocstrainschedulereturndata"></a>

```json
{
  "status": 0,
  "trainScheduleInfoList": [
    {
      "train_no": "string",
      "train_number": "string",
      "start_station": "string",
      "end_station": "string",
      "start_no": "string",
      "end_no": "string",
      "start_time": "string",
      "arrive_time": "string",
      "start_running_time": "string",
      "end_running_time": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainScheduleInfoList|[[TrainScheduleInfo](#schematrainscheduleinfo)]¦null|false|none||none|

<h2 id="tocS_TrainScheduleInfo">TrainScheduleInfo</h2>

<a id="schematrainscheduleinfo"></a>
<a id="schema_TrainScheduleInfo"></a>
<a id="tocStrainscheduleinfo"></a>
<a id="tocstrainscheduleinfo"></a>

```json
{
  "train_no": "string",
  "train_number": "string",
  "start_station": "string",
  "end_station": "string",
  "start_no": "string",
  "end_no": "string",
  "start_time": "string",
  "arrive_time": "string",
  "start_running_time": "string",
  "end_running_time": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|train_no|string¦null|false|none||none|
|train_number|string¦null|false|none||none|
|start_station|string¦null|false|none||none|
|end_station|string¦null|false|none||none|
|start_no|string¦null|false|none||none|
|end_no|string¦null|false|none||none|
|start_time|string¦null|false|none||none|
|arrive_time|string¦null|false|none||none|
|start_running_time|string¦null|false|none||none|
|end_running_time|string¦null|false|none||none|

<h2 id="tocS_GetOrderListReturnData">GetOrderListReturnData</h2>

<a id="schemagetorderlistreturndata"></a>
<a id="schema_GetOrderListReturnData"></a>
<a id="tocSgetorderlistreturndata"></a>
<a id="tocsgetorderlistreturndata"></a>

```json
{
  "status": 0,
  "getOrderListList": [
    {
      "order_id": "string",
      "passenger_real_name": "string",
      "passenger_phone_number": "string",
      "passenger_id_number": "string",
      "carriage_no": "string",
      "seat_type": "string",
      "seat_no": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|getOrderListList|[[GetOrderList](#schemagetorderlist)]¦null|false|none||none|

<h2 id="tocS_GetOrderList">GetOrderList</h2>

<a id="schemagetorderlist"></a>
<a id="schema_GetOrderList"></a>
<a id="tocSgetorderlist"></a>
<a id="tocsgetorderlist"></a>

```json
{
  "order_id": "string",
  "passenger_real_name": "string",
  "passenger_phone_number": "string",
  "passenger_id_number": "string",
  "carriage_no": "string",
  "seat_type": "string",
  "seat_no": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|order_id|string¦null|false|none||none|
|passenger_real_name|string¦null|false|none||none|
|passenger_phone_number|string¦null|false|none||none|
|passenger_id_number|string¦null|false|none||none|
|carriage_no|string¦null|false|none||none|
|seat_type|string¦null|false|none||none|
|seat_no|string¦null|false|none||none|

<h2 id="tocS_TrainTicketOrderReturnData">TrainTicketOrderReturnData</h2>

<a id="schematrainticketorderreturndata"></a>
<a id="schema_TrainTicketOrderReturnData"></a>
<a id="tocStrainticketorderreturndata"></a>
<a id="tocstrainticketorderreturndata"></a>

```json
{
  "status": 0,
  "carriage_no": "string",
  "seat_type": "string",
  "result_seat_no": "string",
  "passenger_phone_number": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|carriage_no|string¦null|false|none||none|
|seat_type|string¦null|false|none||none|
|result_seat_no|string¦null|false|none||none|
|passenger_phone_number|string¦null|false|none||none|

<h2 id="tocS_TrainTransferSeatCountReturnData">TrainTransferSeatCountReturnData</h2>

<a id="schematraintransferseatcountreturndata"></a>
<a id="schema_TrainTransferSeatCountReturnData"></a>
<a id="tocStraintransferseatcountreturndata"></a>
<a id="tocstraintransferseatcountreturndata"></a>

```json
{
  "status": 0,
  "trainTransferSeatCountList": [
    {
      "train_no": "string",
      "carriage_no": "string",
      "seat_type": "string",
      "seat_count": 0,
      "train_number": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainTransferSeatCountList|[[TrainTransferSeatCount](#schematraintransferseatcount)]¦null|false|none||none|

<h2 id="tocS_TrainTransferSeatCount">TrainTransferSeatCount</h2>

<a id="schematraintransferseatcount"></a>
<a id="schema_TrainTransferSeatCount"></a>
<a id="tocStraintransferseatcount"></a>
<a id="tocstraintransferseatcount"></a>

```json
{
  "train_no": "string",
  "carriage_no": "string",
  "seat_type": "string",
  "seat_count": 0,
  "train_number": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|train_no|string¦null|false|none||none|
|carriage_no|string¦null|false|none||none|
|seat_type|string¦null|false|none||none|
|seat_count|integer¦null|false|none||none|
|train_number|string¦null|false|none||none|

<h2 id="tocS_TrainTransferTicketPriceReturnData">TrainTransferTicketPriceReturnData</h2>

<a id="schematraintransferticketpricereturndata"></a>
<a id="schema_TrainTransferTicketPriceReturnData"></a>
<a id="tocStraintransferticketpricereturndata"></a>
<a id="tocstraintransferticketpricereturndata"></a>

```json
{
  "status": 0,
  "trainTransferTicketPriceInfoList": [
    {
      "train_no_1": "string",
      "train_number_1": "string",
      "train_no_2": "string",
      "train_number_2": "string",
      "start_station_no": "string",
      "start_station_name": "string",
      "transfer_station_no_1": "string",
      "transfer_station_name": "string",
      "start_time_1": "string",
      "arrive_time_1": "string",
      "start_time_2": "string",
      "arrive_time_2": "string",
      "end_station_no": "string",
      "end_station_name": "string",
      "start_running_time_1": "string",
      "end_running_time_1": "string",
      "start_running_time_2": "string",
      "end_running_time_2": "string",
      "transfer_station_no_2": "string",
      "high_seat_price_1": "string",
      "medium_seat_price_1": "string",
      "low_seat_price_1": "string",
      "high_seat_price_2": "string",
      "medium_seat_price_2": "string",
      "low_seat_price_2": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainTransferTicketPriceInfoList|[[TrainTransferTicketPriceInfo](#schematraintransferticketpriceinfo)]¦null|false|none||none|

<h2 id="tocS_TrainTransferTicketPriceInfo">TrainTransferTicketPriceInfo</h2>

<a id="schematraintransferticketpriceinfo"></a>
<a id="schema_TrainTransferTicketPriceInfo"></a>
<a id="tocStraintransferticketpriceinfo"></a>
<a id="tocstraintransferticketpriceinfo"></a>

```json
{
  "train_no_1": "string",
  "train_number_1": "string",
  "train_no_2": "string",
  "train_number_2": "string",
  "start_station_no": "string",
  "start_station_name": "string",
  "transfer_station_no_1": "string",
  "transfer_station_name": "string",
  "start_time_1": "string",
  "arrive_time_1": "string",
  "start_time_2": "string",
  "arrive_time_2": "string",
  "end_station_no": "string",
  "end_station_name": "string",
  "start_running_time_1": "string",
  "end_running_time_1": "string",
  "start_running_time_2": "string",
  "end_running_time_2": "string",
  "transfer_station_no_2": "string",
  "high_seat_price_1": "string",
  "medium_seat_price_1": "string",
  "low_seat_price_1": "string",
  "high_seat_price_2": "string",
  "medium_seat_price_2": "string",
  "low_seat_price_2": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|train_no_1|string¦null|false|none||none|
|train_number_1|string¦null|false|none||none|
|train_no_2|string¦null|false|none||none|
|train_number_2|string¦null|false|none||none|
|start_station_no|string¦null|false|none||none|
|start_station_name|string¦null|false|none||none|
|transfer_station_no_1|string¦null|false|none||none|
|transfer_station_name|string¦null|false|none||none|
|start_time_1|string¦null|false|none||none|
|arrive_time_1|string¦null|false|none||none|
|start_time_2|string¦null|false|none||none|
|arrive_time_2|string¦null|false|none||none|
|end_station_no|string¦null|false|none||none|
|end_station_name|string¦null|false|none||none|
|start_running_time_1|string¦null|false|none||none|
|end_running_time_1|string¦null|false|none||none|
|start_running_time_2|string¦null|false|none||none|
|end_running_time_2|string¦null|false|none||none|
|transfer_station_no_2|string¦null|false|none||none|
|high_seat_price_1|string¦null|false|none||none|
|medium_seat_price_1|string¦null|false|none||none|
|low_seat_price_1|string¦null|false|none||none|
|high_seat_price_2|string¦null|false|none||none|
|medium_seat_price_2|string¦null|false|none||none|
|low_seat_price_2|string¦null|false|none||none|

<h2 id="tocS_TrainSeatQueryReturnData">TrainSeatQueryReturnData</h2>

<a id="schematrainseatqueryreturndata"></a>
<a id="schema_TrainSeatQueryReturnData"></a>
<a id="tocStrainseatqueryreturndata"></a>
<a id="tocstrainseatqueryreturndata"></a>

```json
{
  "status": 0,
  "trainRemainingSeats": [
    {
      "carriage_no": "string",
      "seat_type": "string",
      "High_seat_upper": "18",
      "High_seat_lower": "18",
      "Medium_seat_upper": "22",
      "Medium_seat_middle": "22",
      "Medium_seat_lower": "22",
      "Low_seat_A": "20",
      "Low_seat_B": "20",
      "Low_seat_C": "20",
      "Low_seat_D": "20",
      "Low_seat_E": "20",
      "Low_seat_F": "20"
    }
  ],
  "trainRemainingSeats_gds": [
    {
      "carriage_no": "string",
      "seat_type": "string",
      "High_seat_GD_A": "6",
      "High_seat_GD_B": "6",
      "High_seat_GD_C": "6",
      "Medium_seat_GD_A": "13",
      "Medium_seat_GD_B": "13",
      "Medium_seat_GD_C": "13",
      "Medium_seat_GD_D": "13",
      "Low_seat_GD_A": "17",
      "Low_seat_GD_B": "17",
      "Low_seat_GD_C": "17",
      "Low_seat_GD_D": "17",
      "Low_seat_GD_E": "17"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainRemainingSeats|[[TrainRemainingSeats](#schematrainremainingseats)]¦null|false|none||none|
|trainRemainingSeats_gds|[[TrainRemainingSeats_GD](#schematrainremainingseats_gd)]¦null|false|none||none|

<h2 id="tocS_TrainRemainingSeats_GD">TrainRemainingSeats_GD</h2>

<a id="schematrainremainingseats_gd"></a>
<a id="schema_TrainRemainingSeats_GD"></a>
<a id="tocStrainremainingseats_gd"></a>
<a id="tocstrainremainingseats_gd"></a>

```json
{
  "carriage_no": "string",
  "seat_type": "string",
  "High_seat_GD_A": "6",
  "High_seat_GD_B": "6",
  "High_seat_GD_C": "6",
  "Medium_seat_GD_A": "13",
  "Medium_seat_GD_B": "13",
  "Medium_seat_GD_C": "13",
  "Medium_seat_GD_D": "13",
  "Low_seat_GD_A": "17",
  "Low_seat_GD_B": "17",
  "Low_seat_GD_C": "17",
  "Low_seat_GD_D": "17",
  "Low_seat_GD_E": "17"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|carriage_no|string¦null|false|none||none|
|seat_type|string¦null|false|none||none|
|High_seat_GD_A|integer¦null|false|none||none|
|High_seat_GD_B|integer¦null|false|none||none|
|High_seat_GD_C|integer¦null|false|none||none|
|Medium_seat_GD_A|integer¦null|false|none||none|
|Medium_seat_GD_B|integer¦null|false|none||none|
|Medium_seat_GD_C|integer¦null|false|none||none|
|Medium_seat_GD_D|integer¦null|false|none||none|
|Low_seat_GD_A|integer¦null|false|none||none|
|Low_seat_GD_B|integer¦null|false|none||none|
|Low_seat_GD_C|integer¦null|false|none||none|
|Low_seat_GD_D|integer¦null|false|none||none|
|Low_seat_GD_E|integer¦null|false|none||none|

<h2 id="tocS_TrainRemainingSeats">TrainRemainingSeats</h2>

<a id="schematrainremainingseats"></a>
<a id="schema_TrainRemainingSeats"></a>
<a id="tocStrainremainingseats"></a>
<a id="tocstrainremainingseats"></a>

```json
{
  "carriage_no": "string",
  "seat_type": "string",
  "High_seat_upper": "18",
  "High_seat_lower": "18",
  "Medium_seat_upper": "22",
  "Medium_seat_middle": "22",
  "Medium_seat_lower": "22",
  "Low_seat_A": "20",
  "Low_seat_B": "20",
  "Low_seat_C": "20",
  "Low_seat_D": "20",
  "Low_seat_E": "20",
  "Low_seat_F": "20"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|carriage_no|string¦null|false|none||none|
|seat_type|string¦null|false|none||none|
|High_seat_upper|integer¦null|false|none||none|
|High_seat_lower|integer¦null|false|none||none|
|Medium_seat_upper|integer¦null|false|none||none|
|Medium_seat_middle|integer¦null|false|none||none|
|Medium_seat_lower|integer¦null|false|none||none|
|Low_seat_A|integer¦null|false|none||none|
|Low_seat_B|integer¦null|false|none||none|
|Low_seat_C|integer¦null|false|none||none|
|Low_seat_D|integer¦null|false|none||none|
|Low_seat_E|integer¦null|false|none||none|
|Low_seat_F|integer¦null|false|none||none|

<h2 id="tocS_TrainTicketPriceQueryReturnData">TrainTicketPriceQueryReturnData</h2>

<a id="schematrainticketpricequeryreturndata"></a>
<a id="schema_TrainTicketPriceQueryReturnData"></a>
<a id="tocStrainticketpricequeryreturndata"></a>
<a id="tocstrainticketpricequeryreturndata"></a>

```json
{
  "status": 0,
  "trainTicketPriceInfoList": [
    {
      "train_no": "string",
      "train_number": "string",
      "start_station": "string",
      "end_station": "string",
      "start_no": "string",
      "end_no": "string",
      "start_time": "string",
      "arrive_time": "string",
      "start_running_time": "string",
      "end_running_time": "string",
      "high_seat_price": "string",
      "medium_seat_price": "string",
      "low_seat_price": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|trainTicketPriceInfoList|[[TrainTicketPriceInfo](#schematrainticketpriceinfo)]¦null|false|none||none|

<h2 id="tocS_TrainTicketPriceInfo">TrainTicketPriceInfo</h2>

<a id="schematrainticketpriceinfo"></a>
<a id="schema_TrainTicketPriceInfo"></a>
<a id="tocStrainticketpriceinfo"></a>
<a id="tocstrainticketpriceinfo"></a>

```json
{
  "train_no": "string",
  "train_number": "string",
  "start_station": "string",
  "end_station": "string",
  "start_no": "string",
  "end_no": "string",
  "start_time": "string",
  "arrive_time": "string",
  "start_running_time": "string",
  "end_running_time": "string",
  "high_seat_price": "string",
  "medium_seat_price": "string",
  "low_seat_price": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|train_no|string¦null|false|none||none|
|train_number|string¦null|false|none||none|
|start_station|string¦null|false|none||none|
|end_station|string¦null|false|none||none|
|start_no|string¦null|false|none||none|
|end_no|string¦null|false|none||none|
|start_time|string¦null|false|none||none|
|arrive_time|string¦null|false|none||none|
|start_running_time|string¦null|false|none||none|
|end_running_time|string¦null|false|none||none|
|high_seat_price|string¦null|false|none||none|
|medium_seat_price|string¦null|false|none||none|
|low_seat_price|string¦null|false|none||none|

<h2 id="tocS_Map«Object»">Map«Object»</h2>

<a id="schemamap«object»"></a>
<a id="schema_Map«Object»"></a>
<a id="tocSmap«object»"></a>
<a id="tocsmap«object»"></a>

```json
{
  "key": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|key|object¦null|false|none||none|

<h2 id="tocS_RespBean">RespBean</h2>

<a id="schemarespbean"></a>
<a id="schema_RespBean"></a>
<a id="tocSrespbean"></a>
<a id="tocsrespbean"></a>

```json
{
  "status": 0,
  "success": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|success|string¦null|false|none||none|

<h2 id="tocS_PassengerInfoReturnData">PassengerInfoReturnData</h2>

<a id="schemapassengerinforeturndata"></a>
<a id="schema_PassengerInfoReturnData"></a>
<a id="tocSpassengerinforeturndata"></a>
<a id="tocspassengerinforeturndata"></a>

```json
{
  "status": 0,
  "passengerInfos": [
    {
      "user_phone_number": "string",
      "passenger_real_name": "string",
      "passenger_phone_number": "string",
      "passenger_id_number": "string",
      "passenger_type": "string",
      "passenger_address": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|status|integer¦null|false|none||none|
|passengerInfos|[[PassengerInfo](#schemapassengerinfo)]¦null|false|none||none|

<h2 id="tocS_PassengerInfo">PassengerInfo</h2>

<a id="schemapassengerinfo"></a>
<a id="schema_PassengerInfo"></a>
<a id="tocSpassengerinfo"></a>
<a id="tocspassengerinfo"></a>

```json
{
  "user_phone_number": "string",
  "passenger_real_name": "string",
  "passenger_phone_number": "string",
  "passenger_id_number": "string",
  "passenger_type": "string",
  "passenger_address": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|user_phone_number|string¦null|false|none||none|
|passenger_real_name|string¦null|false|none||none|
|passenger_phone_number|string¦null|false|none||none|
|passenger_id_number|string¦null|false|none||none|
|passenger_type|string¦null|false|none||none|
|passenger_address|string¦null|false|none||none|

