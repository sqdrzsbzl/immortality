package cn.net.immortal.user.controller;

import cn.net.immortal.common.response.ResponseWrapper;
import cn.net.immortal.user.entity.cmd.SignInCmd;
import cn.net.immortal.user.entity.cmd.SignUpCmd;
import cn.net.immortal.user.service.cmd.AccountCmdService;
import cn.net.immortal.user.service.qry.AccountQryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountCmdService accountCmdService;

    @Resource
    private AccountQryService accountQryService;


    @PostMapping("/signup")
    public ResponseWrapper signUp(@RequestBody @Validated SignUpCmd signUpCmd){
        accountCmdService.signUp(signUpCmd);
        return ResponseWrapper.failure("1");
    }

    @PostMapping("/signin")
    public ResponseWrapper signIn(@RequestBody @Validated SignInCmd signInCmd){
        accountCmdService.signIn(signInCmd);
        return ResponseWrapper.failure("1");
    }

    @DeleteMapping("/signout/{token}")
    public ResponseWrapper signOut(@PathVariable String token){
        accountCmdService.signOut(token);
        return ResponseWrapper.failure("1");
    }

    @GetMapping
    public ResponseWrapper existAccount(String account){
        return ResponseWrapper.success(accountQryService.existAccount(account));
    }
}
