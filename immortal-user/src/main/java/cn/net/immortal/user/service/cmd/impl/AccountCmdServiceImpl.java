package cn.net.immortal.user.service.cmd.impl;

import cn.net.immortal.user.entity.cmd.SignInCmd;
import cn.net.immortal.user.entity.cmd.SignUpCmd;
import cn.net.immortal.user.entity.factories.AccountFactory;
import cn.net.immortal.user.mapper.AccountMapperExt;
import cn.net.immortal.user.mapper.entity.Account;
import cn.net.immortal.user.service.cmd.AccountCmdService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

@Service
public class AccountCmdServiceImpl implements AccountCmdService {

    @Resource
    private AccountMapperExt accountMapperExt;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void signUp(SignUpCmd signUpCmd) {
        if(Objects.nonNull(accountMapperExt.selectByAccount(signUpCmd.getEmail()))) {
            //TODO 邮箱重复
        }
        Account account = AccountFactory.getAccount(signUpCmd);
        //注册未验证
        accountMapperExt.insert(account);
        //发布事件
    }

    @Override
    public void signIn(SignInCmd signInCmd) {
        Account account = accountMapperExt.selectByAccount(signInCmd.getEmail());
        if(Objects.equals(account.getPassword(), signInCmd.getPassword())){
            //TODO 查询所属角色 redis存储
        }
        //TODO 邮箱不存在

    }

    @Override
    public void signOut(String token) {
        //TODO 清除redis数据
        stringRedisTemplate.opsForValue().set("token", UUID.randomUUID().toString());
    }
}
