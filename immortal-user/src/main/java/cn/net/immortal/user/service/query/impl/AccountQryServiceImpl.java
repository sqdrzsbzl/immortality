package cn.net.immortal.user.service.query.impl;

import cn.net.immortal.user.dal.mapper.AccountMapperExt;
import cn.net.immortal.user.service.query.AccountQryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class AccountQryServiceImpl implements AccountQryService {

    @Resource
    AccountMapperExt accountMapperExt;

    @Transactional(readOnly = true)
    @Override
    public Boolean accountExists(String account) {
        //账号不存在返回true
        return Objects.isNull(accountMapperExt.selectByAccount(account));
    }
}
