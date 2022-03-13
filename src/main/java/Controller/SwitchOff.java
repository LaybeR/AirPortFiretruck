package Controller;

import Events.*;
import User.IUser;
import org.greenrobot.eventbus.EventBus;

public class SwitchOff implements ISwitchState {
    public void press(Switch s, IUser user) {
        s.changeState(new SwitchOn());

        s.getOn().execute(user);
    }
}
