create table order_list
(
    order_id           int auto_increment
        primary key,
    user_phone         varchar(20) not null,
    passenger_phone    varchar(20) not null,
    passenger_id       varchar(20) not null,
    train_no           varchar(20) not null,
    start_station_no   varchar(20) not null,
    start_station_name varchar(20) not null,
    end_station_no     varchar(20) not null,
    end_station_name   varchar(20) not null,
    carriage_no        varchar(20) not null,
    seat_no            varchar(20) not null,
    order_money        varchar(20) not null,
    order_create_time  datetime    null,
    order_status       varchar(20) not null,
    train_start_date   datetime    null
)
    row_format = DYNAMIC;

create table passenger
(
    user_phone_number      varchar(20) not null,
    passenger_phone_number varchar(20) not null
        primary key,
    passenger_real_name    varchar(20) not null,
    passenger_id_number    varchar(20) not null,
    passenger_type         int         not null,
    passenger_adress       varchar(50) not null
)
    row_format = DYNAMIC;

create table seat
(
    train_no    varchar(20) not null,
    carriage_no varchar(20) not null,
    seat_type   varchar(20) not null,
    seat_count  int         not null,
    primary key (train_no, carriage_no)
)
    row_format = DYNAMIC;

create table train_info
(
    train_no            varchar(20) not null
        primary key,
    tarin_number        varchar(20) not null,
    tarin_type          varchar(10) not null,
    tarin_carriages     int         not null,
    tarin_end_station   varchar(20) not null,
    tarin_start_station varchar(20) not null,
    tarin_start_time    varchar(20) not null,
    tarin_end_time      varchar(20) not null,
    tarin_arrive_day    varchar(20) not null,
    tarin_running_time  varchar(20) not null,
    tarin_running_type  varchar(20) null
)
    row_format = DYNAMIC;

create table train_parking_station
(
    train_no       varchar(20) not null,
    train_number   varchar(20) not null,
    arrive_day_str varchar(20) not null,
    arriver_time   varchar(20) not null,
    start_time     varchar(20) not null,
    running_time   varchar(20) not null,
    station_no     varchar(20) not null,
    station_name   varchar(20) not null,
    primary key (train_no, station_no)
)
    row_format = DYNAMIC;

create table user
(
    user_phone_number varchar(15) not null
        primary key,
    `user-password`   varchar(20) not null,
    `user-email`      varchar(20) not null,
    `user-real_name`  varchar(10) not null,
    `user-type`       int         not null comment '成人0学生1',
    user_id_number    varchar(20) not null,
    user_gender       int         not null comment '男1女0',
    user_address      varchar(50) not null
)
    row_format = DYNAMIC;

