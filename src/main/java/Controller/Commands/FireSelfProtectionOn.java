package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class FireSelfProtectionOn implements ICommand {
    private ICentralUnit c;

    public FireSelfProtectionOn(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOn(SwitchType.FIRE_SELF_PROTECTION, user);
    }
}
