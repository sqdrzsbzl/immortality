package cn.net.immortal.user.service.command;

import cn.net.immortal.user.service.command.cmd.LoginCommand;
import cn.net.immortal.user.service.command.cmd.RegistryCommand;

public interface UserCmdService {

    void registry(RegistryCommand registryCommand);

    Boolean login(LoginCommand loginCommand);
}
