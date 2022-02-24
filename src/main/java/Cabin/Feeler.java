package Cabin;

public class Feeler {
    private final Joystick stick;


    public Feeler(Joystick stick) {
        this.stick = stick;
    }

    public void hold() {
        stick.holdFeeler();
    }

    public void release() {
        stick.releaseFeeler();
    }
}
