package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class EngineOff implements ICommand{
    private ICentralUnit c;

    public EngineOff(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOff(SwitchType.ELECTRIC_ENGINE, user);
    }
}
