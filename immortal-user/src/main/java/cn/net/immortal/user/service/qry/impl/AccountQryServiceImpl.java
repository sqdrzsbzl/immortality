package cn.net.immortal.user.service.qry.impl;

import cn.net.immortal.user.mapper.AccountMapperExt;
import cn.net.immortal.user.service.qry.AccountQryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class AccountQryServiceImpl implements AccountQryService {

    @Resource
    private AccountMapperExt accountMapperExt;

    @Override
    public Boolean existAccount(String account) {
        return Objects.nonNull(accountMapperExt.selectByAccount(account));
    }
}
