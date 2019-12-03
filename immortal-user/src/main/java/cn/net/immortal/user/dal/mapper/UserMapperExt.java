package cn.net.immortal.user.dal.mapper;

import cn.net.immortal.user.dal.entity.User;

public interface UserMapperExt extends UserMapper {

    User selectByUserId(String userId);
}
