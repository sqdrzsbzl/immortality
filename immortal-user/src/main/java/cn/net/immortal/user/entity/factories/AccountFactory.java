package cn.net.immortal.user.entity.factories;

import cn.net.immortal.user.entity.cmd.SignInCmd;
import cn.net.immortal.user.entity.cmd.SignUpCmd;
import cn.net.immortal.user.mapper.entity.Account;
import org.springframework.beans.BeanUtils;

public class AccountFactory {

    public static Account getAccount(SignUpCmd signUpCmd){
        Account account = new Account();
        BeanUtils.copyProperties(signUpCmd,account);
        return account;
    }

    public static Account getAccount(SignInCmd signInCmd){
        Account account = new Account();
        BeanUtils.copyProperties(signInCmd,account);
        return account;
    }
}
