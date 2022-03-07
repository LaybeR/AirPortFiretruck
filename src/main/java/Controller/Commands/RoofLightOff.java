package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class RoofLightOff implements ICommand {
    private ICentralUnit c;

    public RoofLightOff(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOff(SwitchType.ROOF_LIGHT, user);
    }
}
