package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class HeadLightOn implements ICommand {
    private ICentralUnit c;

    public HeadLightOn(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOn(SwitchType.HEAD_LIGHT, user);
    }
}
