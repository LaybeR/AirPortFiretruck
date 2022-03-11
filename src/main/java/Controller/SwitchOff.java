package Controller;

import Events.*;
import User.IUser;
import org.greenrobot.eventbus.EventBus;

public class SwitchOff implements ISwitchState {
    public void press(Switch s, IUser user) {
        s.changeState(new SwitchOn());
        switch (s.type){
            case HEAD_LIGHT -> EventBus.getDefault().post(new HeadLightEvent());
            case ROOF_LIGHT -> EventBus.getDefault().post(new RoofLightEvent());
            case SIDE_LIGHT -> EventBus.getDefault().post(new SideLightEvent());
            case WARNING_LIGHT -> EventBus.getDefault().post(new WarningLightEvent());
            case ELECTRIC_ENGINE -> EventBus.getDefault().post(new ElectricEngineEvent());
            case EMERGENCY_LIGHT -> EventBus.getDefault().post(new EmergencyLightEvent());
            case FIRE_SELF_PROTECTION -> EventBus.getDefault().post(new SelfProtectionEvent());
        }
        s.getOn().execute(user);
    }
}
