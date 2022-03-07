package AirportFireTruck;

import Controller.Knob;
import Controller.Switch;
import Enums.KnobType;
import Enums.SwitchType;

public class ControlPanel {
    private final Switch[] switches;
    public final Knob knobRoofCannon;
    public final Knob knobFrontCannon;
    private ICentralUnit centralUnit;


    public ControlPanel() {
        this.switches = new Switch[7];
        this.knobFrontCannon = new Knob(KnobType.FRONT_CANNON,7);
        this.knobRoofCannon = new Knob(KnobType.ROOF_CANNON,3);
    }

    public Knob getKnob(KnobType type) {
        Knob result = null;
        switch (type) {
            case ROOF_CANNON -> result = knobRoofCannon;
            case FRONT_CANNON -> result = knobFrontCannon;
        }
        return result;
    }

    public Switch getSwitch(SwitchType type) {
        for (Switch s : switches) {
            if (s.type == type) return s;
        }
        return null;
    }

    public void setCentralUnit(ICentralUnit centralUnit) {
        this.centralUnit = centralUnit;
        switches[0] = new Switch(SwitchType.ELECTRIC_ENGINE, centralUnit);
        switches[1] = new Switch(SwitchType.WARNING_LIGHT, centralUnit);
        switches[2] = new Switch(SwitchType.EMERGENCY_LIGHT, centralUnit);
        switches[3] = new Switch(SwitchType.HEAD_LIGHT, centralUnit);
        switches[4] = new Switch(SwitchType.ROOF_LIGHT, centralUnit);
        switches[5] = new Switch(SwitchType.SIDE_LIGHT, centralUnit);
        switches[6] = new Switch(SwitchType.FIRE_SELF_PROTECTION, centralUnit);
    }
}
