package Controller;

import User.IUser;

public class SwitchOff implements ISwitchState {
    public void press(Switch s, IUser user) {
        s.changeState(new SwitchOn());
        s.getOn().execute(user);
    }
}
