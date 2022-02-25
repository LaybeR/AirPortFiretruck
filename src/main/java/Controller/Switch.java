package Controller;

import AirportFireTruck.ControlPanel;
import Enums.SwitchType;

public class Switch {
    public final SwitchType type;
    private final ControlPanel controlPanel;
    private boolean isOn;

    public Switch(SwitchType type, ControlPanel controlPanel) {
        this.type = type;
        this.controlPanel = controlPanel;
        this.isOn = false;
    }

    public void press() {
        isOn = !isOn;
        System.out.println("Schalter ist nun" + (isOn ? " an." : " aus."));
        controlPanel.update(this);
    }

    public boolean isPressed() {return isOn;}
}
