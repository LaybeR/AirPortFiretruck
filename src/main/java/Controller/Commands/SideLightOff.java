package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class SideLightOff implements ICommand{
    private ICentralUnit c;

    public SideLightOff(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOff(SwitchType.SIDE_LIGHT, user);
    }
}
