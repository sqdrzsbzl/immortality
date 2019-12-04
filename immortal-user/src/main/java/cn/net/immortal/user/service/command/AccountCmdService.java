package cn.net.immortal.user.service.command;

import cn.net.immortal.user.service.command.cmd.LoginCommand;
import cn.net.immortal.user.service.command.cmd.RegistryCommand;

public interface AccountCmdService {

    void registry(RegistryCommand registryCommand);

    Boolean login(LoginCommand loginCommand);
}
