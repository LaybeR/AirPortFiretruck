package AirportFireTruck;

import Controller.Knob;
import Controller.SteeringWheel;
import Controller.Switch;
import Enums.KnobDirectionType;
import Enums.SteeringDirection;
import User.User;
import User.Driver;
import User.Operator;

public class AirportFireTruck {
    private final ICentralUnit centralUnit;

    private AirportFireTruck(int count) {
        this.centralUnit = new CentralUnit();
    }

    public static class Builder {
        int headlights = 6;

        public Builder headlights(int count) {
            headlights = count;
            return this;
        }

        public AirportFireTruck build() {
            return new AirportFireTruck(headlights);
        }
    }

    public void pressSwitch(Switch selectedSwitch, User user) {
        if (user instanceof Operator) {
            selectedSwitch.press();
        }
    }

    public void turnKnob(Knob selectedKnob, User user, KnobDirectionType direction) {
        if (user instanceof Operator) {
            switch (direction) {
                case CLOCKWISE -> selectedKnob.turnClockwise();
                case COUNTER_CLOCKWISE -> selectedKnob.turnCounterClockwise();
            }
        }
    }

    public void pressGas(User user) {
        if (user instanceof Driver) {
            centralUnit.getGasPedal().press();
        }
    }

    public void pressBrake(User user) {
        if (user instanceof Driver) {
            centralUnit.getBrakePedal().press();
        }
    }

    public void turnSteeringWheel(User user, SteeringDirection steeringDirection) {
        if (user instanceof Driver) {
            SteeringWheel steeringWheel = centralUnit.getSteeringWheel();
            switch (steeringDirection) {
                case LEFT -> steeringWheel.turnLeft();
                case RIGHT -> steeringWheel.turnRight();
                case CENTER -> steeringWheel.returnToCenter();
            }
        }
    }
}
