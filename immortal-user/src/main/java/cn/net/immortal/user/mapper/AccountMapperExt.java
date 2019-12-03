package cn.net.immortal.user.mapper;

import cn.net.immortal.user.mapper.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapperExt extends AccountMapper {

    Account selectByAccount(String account);
}
