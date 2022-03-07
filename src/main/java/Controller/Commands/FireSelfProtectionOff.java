package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class FireSelfProtectionOff implements ICommand {

    private ICentralUnit c;

    public FireSelfProtectionOff(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOff(SwitchType.FIRE_SELF_PROTECTION, user);
    }
}
