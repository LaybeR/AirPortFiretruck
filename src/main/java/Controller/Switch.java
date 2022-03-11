package Controller;

import AirportFireTruck.ICentralUnit;
import Controller.Commands.*;
import Enums.SwitchType;
import User.IUser;
import org.greenrobot.eventbus.EventBus;

public class Switch {
    public final SwitchType type;
    private ISwitchState state;
    private ICommand off;
    private ICommand on;

    public Switch(SwitchType type, ICentralUnit c) {
        this.type = type;
        this.state = new SwitchOff();

        switch (type) {
            case FIRE_SELF_PROTECTION -> {
                off = new FireSelfProtectionOff(c);
                on = new FireSelfProtectionOn(c);
            }
            case SIDE_LIGHT -> {
                off = new SideLightOff(c);
                on = new SideLightOn(c);
            }
            case ROOF_LIGHT -> {
                off = new RoofLightOff(c);
                on = new RoofLightOn(c);
            }
            case HEAD_LIGHT -> {
                off = new HeadLightOff(c);
                on = new HeadLightOn(c);
            }
            case WARNING_LIGHT -> {
                off = new WarningLightOff(c);
                on = new WarningLightOn(c);
            }
            case ELECTRIC_ENGINE -> {
                off = new EngineOff(c);
                on = new EngineOn(c);
            }
            case EMERGENCY_LIGHT -> {
                off = new EmergencyLightOff(c);
                on = new EmergencyLightOn(c);
            }
        }
    }

    public void press(IUser user) {
        state.press(this, user);
    }


    ICommand getOff() {return off;}

    ICommand getOn() {return on;}

    void changeState(ISwitchState state) {
        this.state = state;
    }

    public boolean isPressed() {return state instanceof SwitchOn;}
}
