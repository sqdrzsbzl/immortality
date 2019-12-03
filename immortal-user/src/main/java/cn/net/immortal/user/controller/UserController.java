package cn.net.immortal.user.controller;

import cn.net.immortal.common.response.ResponseWrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping
    public ResponseWrapper user(){
        return ResponseWrapper.failure("1");
    }

}
