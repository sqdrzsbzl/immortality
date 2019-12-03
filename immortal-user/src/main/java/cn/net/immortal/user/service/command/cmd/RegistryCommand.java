package cn.net.immortal.user.service.command.cmd;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class RegistryCommand {

    @Size(min = 6, max = 64)
    private String account;

    @Size(min = 8, max = 16)
    private String password;

    @Size(max = 64)
    private String name;

    @Size(max=15)
    private String phone;
}
