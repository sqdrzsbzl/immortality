package cn.net.immortal.user.service.command.impl;

import cn.net.immortal.common.filter.SSOFilter;
import cn.net.immortal.user.dal.entity.Account;
import cn.net.immortal.user.dal.mapper.AccountMapperExt;
import cn.net.immortal.user.service.command.AccountCmdService;
import cn.net.immortal.user.service.command.cmd.LoginCommand;
import cn.net.immortal.user.service.command.cmd.RegistryCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class AccountCmdServiceImpl implements AccountCmdService {

    @Resource
    AccountMapperExt accountMapperExt;

    @Resource
    HttpServletRequest httpServletRequest;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void registry(RegistryCommand registryCommand) {
        Account account = new Account();
        BeanUtils.copyProperties(registryCommand,account);
        //留作邮箱验证码校验
        account.setValidate(1);
        //发布验证事件
        accountMapperExt.insert(account);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean login(LoginCommand loginCommand) {
        Account accountData = accountMapperExt.selectByAccount(loginCommand.getAccount());
        //账号为空或密码不匹配
        if(!(Objects.nonNull(accountData)
                && loginCommand.getPassword().equals(accountData.getAccount()))){
            return Boolean.FALSE;
        }
        httpServletRequest.setAttribute(SSOFilter.ACCOUNT_ID,accountData.getId());
        return Boolean.TRUE;
    }
}
