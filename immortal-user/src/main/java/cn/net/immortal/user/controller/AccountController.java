package cn.net.immortal.user.controller;

import cn.net.immortal.common.response.ResponseWrapper;
import cn.net.immortal.user.service.command.AccountCmdService;
import cn.net.immortal.user.service.command.cmd.LoginCommand;
import cn.net.immortal.user.service.command.cmd.RegistryCommand;
import cn.net.immortal.user.service.query.AccountQryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountCmdService accountCmdService;

    @Resource
    AccountQryService accountQryService;

    @PostMapping("/registry")
    public ResponseWrapper account(@RequestBody @Validated RegistryCommand registryCommand){
        accountCmdService.registry(registryCommand);
        return ResponseWrapper.success(Boolean.TRUE);
    }

    @PostMapping("/login")
    public ResponseWrapper account(@RequestBody @Validated LoginCommand loginCommand){
        return ResponseWrapper.success(accountCmdService.login(loginCommand));
    }

    @GetMapping("/existence/{account}")
    public ResponseWrapper account(@PathVariable String account){
        return ResponseWrapper.success(accountQryService.accountExists(account));
    }

}
