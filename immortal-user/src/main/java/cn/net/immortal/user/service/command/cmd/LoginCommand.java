package cn.net.immortal.user.service.command.cmd;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class LoginCommand {
    @Size(min = 6, max = 64)
    private String account;
    @Size(min = 8, max = 16)
    private String password;
}
