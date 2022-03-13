package Controller.Commands;

import AirportFireTruck.ICentralUnit;
import Enums.SwitchType;
import User.IUser;

public class EngineOn implements ICommand{
    private ICentralUnit c;

    public EngineOn(ICentralUnit iCentralUnit) {
        c = iCentralUnit;
    }

    public void execute(IUser user) {
        c.turnSwitchOn(SwitchType.ELECTRIC_ENGINE, user);
    }
}
