package cn.net.immortal.user.service.command.impl;

import cn.net.immortal.user.dal.entity.Account;
import cn.net.immortal.user.service.command.UserCmdService;
import cn.net.immortal.user.service.command.cmd.LoginCommand;
import cn.net.immortal.user.service.command.cmd.RegistryCommand;
import cn.net.immortal.user.dal.mapper.AccountMapperExt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserCmdServiceImpl implements UserCmdService {

    @Resource
    AccountMapperExt accountMapperExt;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    HttpServletResponse httpServletResponse;

    @Override
    public void registry(RegistryCommand registryCommand) {
        Account account = new Account();
        BeanUtils.copyProperties(registryCommand,account);
        //留作邮箱验证码校验
        account.setValidate(1);
        //发布验证事件
        accountMapperExt.insert(account);
    }

    @Override
    public Boolean login(LoginCommand loginCommand) {
        Account accountData = accountMapperExt.selectByAccount(loginCommand.getAccount());
        //账号为空或密码不匹配
        if(!(Objects.nonNull(accountData)
                && loginCommand.getPassword().equals(accountData.getAccount()))){
            return Boolean.FALSE;
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        httpServletResponse.setHeader("user-token",token);
        redisTemplate.opsForValue().set(token, accountData);
        return Boolean.TRUE;
    }
}
