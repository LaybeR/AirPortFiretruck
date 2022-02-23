package Controller;

import Enums.SwitchType;

public class Switch {
    private SwitchType type;
    private boolean isOn;

    public void press() {
        isOn = !isOn;
    }

    public boolean isPressed() {return isOn;}
}
