package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class WarningLightOn implements ICommand {
    private ICentralUnit c;

    public WarningLightOn(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOn(SwitchType.WARNING_LIGHT, user);
    }
}
