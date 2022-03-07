package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class EmergencyLightOff implements ICommand{
    private ICentralUnit c;

    public EmergencyLightOff(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOff(SwitchType.EMERGENCY_LIGHT, user);
    }
}
