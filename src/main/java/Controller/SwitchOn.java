package Controller;

import Events.*;
import User.IUser;
import org.greenrobot.eventbus.EventBus;

public class SwitchOn implements ISwitchState {
    @Override
    public void press(Switch s, IUser user) {
        s.changeState(new SwitchOff());

        s.getOff().execute(user);
    }
}
