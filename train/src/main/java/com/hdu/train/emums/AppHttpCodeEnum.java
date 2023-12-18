package com.hdu.train.emums;

public enum AppHttpCodeEnum {
    // 操作成功信息
    SUCCESS(200, "操作成功"),
    // 需要登录后操作
    NEED_LOGIN(401, "需要登陆后操作"),
    // 上传成功
    UPLOAD_OK(201, "文献上传成功"),
    // 作者保存成功
    AUTHOR_SAVE_OK(202,"作者保存成功"),
    // 作者保存失败
    AuTHOR_SAVE_ERROR(402,"作者保存失败"),
    // zincSearch搜索成功
    ZINC_SEARCH_OK(203,"zincSearch搜索成功"),
    // 查询的文献也不存在或该页不存在
    DETAILS_SEARCH_OK(204,"文献详情查询成功"),
    // 查询文献不存在
    DETAILS_SEARCH_RESULT_NULL(403,"该文献不存在或该页不存在"),
    // 查询文献名称给不能为空
    DETAILS_SEARC_NAME_IS_NULL(405,"查询出错，查询文献名称给不能为空"),
    // 文献更新成功
    DOCUMENT_UPDATE_OK(205,"文献更新成功"),
    // 日志查询成功
    LOG_SEARCH_OK(206,"日志查询成功"),
    // 查询记录的用户名或文献名不能为空
    LOG_SEARCH_ERROR(406,"查询记录的用户名或文献名不能为空"),
    // 用户注册成功
    USER_REGISTER_OK(207,"用户注册成功"),
    // 用户注册失败
    USER_REGISTER_ERROR(407,"用户注册失败"),
    // 用户登录密码错误
    USER_NAME_IS_NULL(408,"用户名不能为空"),
    // 登陆成功
    USER_LOGIN_OK(208,"用户登录成功"),
    // 登陆密码错误
    USER_LOGIN_PASSWORD_ERROR(409,"用户登录密码错误"),
    // 两次密码不一致
    USER_UPDATE_PASSWORD_ERROR(410,"两次密码不一致"),
    // 用户更新成功
    USER_UPDATE_OK(209,"用户更新成功"),
    // 操作失败
    ERROR(400,"操作失败");
    ;

    final Integer code;
    final String msg;

    AppHttpCodeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg(){
        return msg;
    }
}