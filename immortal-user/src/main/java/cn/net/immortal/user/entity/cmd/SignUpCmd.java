package cn.net.immortal.user.entity.cmd;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class SignUpCmd {

    @Size(max=64,min=8)
    String email;

    @Size(max=16,min=8)
    String password;

    @Size(max=15,min=11)
    String phone;


}
