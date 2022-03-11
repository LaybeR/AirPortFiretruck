package Controller;

import User.IUser;
import org.greenrobot.eventbus.EventBus;

interface ISwitchState {
    void press(Switch s, IUser user);
}
