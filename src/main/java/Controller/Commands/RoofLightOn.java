package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class RoofLightOn implements ICommand {
    private ICentralUnit c;

    public RoofLightOn(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOn(SwitchType.ROOF_LIGHT, user);
    }
}
