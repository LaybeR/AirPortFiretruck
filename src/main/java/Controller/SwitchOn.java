package Controller;

import User.IUser;

public class SwitchOn implements ISwitchState {
    @Override
    public void press(Switch s, IUser user) {
        s.changeState(new SwitchOff());
        s.getOff().execute(user);
    }
}
