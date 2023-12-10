package com.hdu.train.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdu.train.entity.User;
import com.hdu.train.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
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
public interface UserMapper extends BaseMapper<User> {

    @Update("update `user` " +
            "set `user_real_name`=#{userRealName},`user_eamil`=#{userEmail}," +
            "`user_type`=#{userType},`user_gender`=#{userGender},`user_id_number`=#{userIdNumber}," +
            "`user_address`=#{userAddress} " +
            "where `user_phone_number` = #{userPhoneNumber} ")
    void UpdateUserInfo(String userRealName, String userEmail, Integer userType, Integer userGender, String userIdNumber, String userAddress, String userPhoneNumber);

    @Select("select `user_real_name`,`user_eamil`,`user_type`,`user_gender`,`user_id_number`,`user_address`,`user_phone_number`" +
            "from `user`")
    List<UserInfoVO> selectAllUser();
}
