package cn.net.immortal.user.controller;

import cn.net.immortal.common.response.ResponseWrapper;
import cn.net.immortal.user.service.command.UserCmdService;
import cn.net.immortal.user.service.command.cmd.LoginCommand;
import cn.net.immortal.user.service.command.cmd.RegistryCommand;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserCmdService userCmdService;

    @PostMapping("/register")
    public ResponseWrapper user(@RequestBody @Validated RegistryCommand registryCommand){
        userCmdService.registry(registryCommand);
        return ResponseWrapper.success(Boolean.TRUE);
    }

    @PostMapping("/login")
    public ResponseWrapper user(@RequestBody @Validated LoginCommand loginCommand){
        return ResponseWrapper.success(userCmdService.login(loginCommand));
    }

}
