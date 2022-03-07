package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class WarningLightOff implements ICommand {
    private ICentralUnit c;

    public WarningLightOff(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOff(SwitchType.WARNING_LIGHT, user);
    }
}
