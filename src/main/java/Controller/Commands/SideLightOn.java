package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class SideLightOn implements ICommand{
    private ICentralUnit c;

    public SideLightOn(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOn(SwitchType.SIDE_LIGHT, user);
    }
}
