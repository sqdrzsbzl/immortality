package cn.net.immortal.user.service.cmd;

import cn.net.immortal.user.entity.cmd.SignInCmd;
import cn.net.immortal.user.entity.cmd.SignUpCmd;

public interface AccountCmdService {

    void signUp(SignUpCmd signUpCmd);

    void signIn(SignInCmd signInCmd);

    void signOut(String token);
}
