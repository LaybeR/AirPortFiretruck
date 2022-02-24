package Controller;

import Enums.SwitchType;

public class Switch {
    private SwitchType type;
    private boolean isOn;

    public void press() {
        isOn = !isOn;
        System.out.println("Schalter ist nun" + (isOn ? " an." : " aus."));
    }

    public boolean isPressed() {return isOn;}
}
