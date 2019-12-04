package cn.net.immortal.user.controller;

import cn.net.immortal.common.response.ResponseWrapper;
import cn.net.immortal.user.service.command.cmd.AddUserCommand;
import cn.net.immortal.user.service.command.cmd.UpdateUserCommand;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public ResponseWrapper user(@Validated @RequestBody AddUserCommand addUserCommand){
        return ResponseWrapper.success("");
    }


    @PutMapping
    public ResponseWrapper user(@Validated @RequestBody UpdateUserCommand updateUserCommand){
        return ResponseWrapper.success("");
    }

    @GetMapping("/{id}")
    public ResponseWrapper user(@PathVariable String id){
        return ResponseWrapper.success("");
    }
}
