package cn.net.immortal.user.dal.mapper;

import cn.net.immortal.user.dal.entity.Account;

public interface AccountMapperExt extends AccountMapper {

    Account selectByAccount(String account);
}