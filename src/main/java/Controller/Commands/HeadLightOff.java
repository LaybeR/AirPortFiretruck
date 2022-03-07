package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class HeadLightOff implements ICommand {
    private ICentralUnit c;

    public HeadLightOff(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOff(SwitchType.HEAD_LIGHT, user);
    }
}
