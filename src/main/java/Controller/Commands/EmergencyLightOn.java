package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class EmergencyLightOn implements ICommand {
    private ICentralUnit c;

    public EmergencyLightOn(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOn(SwitchType.FIRE_SELF_PROTECTION, user);
    }
}
