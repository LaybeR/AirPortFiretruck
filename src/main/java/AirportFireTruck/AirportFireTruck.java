package AirportFireTruck;

import Cabin.Cabin;
import Controller.Knob;
import Controller.SteeringWheel;
import Controller.Switch;
import Enums.KnobDirectionType;
import Enums.LeftRightPosition;
import Enums.SteeringDirection;
import User.User;
import User.Driver;
import User.Operator;
import User.Person;
import User.Passenger;
import Cabin.Joystick;

public class AirportFireTruck {
    private final ICentralUnit centralUnit;
    private final Cabin cabin;

    private AirportFireTruck(int count) {
        this.centralUnit = new CentralUnit();
        this.cabin = new Cabin(centralUnit);
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

    public Joystick getJoystick(LeftRightPosition side) {
        Joystick result = null;
        switch (side) {
            case LEFT -> result = cabin.LJ;
            case RIGHT -> result = cabin.RJ;
        }
        return result;
    }

    public void holdFeeler(User user, Joystick joystick) {
        if (user instanceof Driver && joystick.getLeftRightPosition() == LeftRightPosition.LEFT) {
            joystick.feeler.hold();
        } else if (user instanceof Operator && joystick.getLeftRightPosition() == LeftRightPosition.RIGHT) {
            joystick.feeler.hold();
        }
    }

    public void releaseFeeler(User user, Joystick joystick) {
        if (user instanceof Driver && joystick.getLeftRightPosition() == LeftRightPosition.LEFT) {
            joystick.feeler.release();
        } else if (user instanceof Operator && joystick.getLeftRightPosition() == LeftRightPosition.RIGHT) {
            joystick.feeler.release();
        }
    }

    public void pressJoystickButton(User user, Joystick joystick, LeftRightPosition side) {
        if (user instanceof Driver && joystick.getLeftRightPosition() == LeftRightPosition.LEFT) {
            switch (side) {
                case LEFT -> joystick.LB.press();
                case RIGHT -> joystick.RB.press();
            }
        } else if (user instanceof Operator && joystick.getLeftRightPosition() == LeftRightPosition.RIGHT) {
            switch (side) {
                case LEFT -> joystick.LB.press();
                case RIGHT -> joystick.RB.press();
            }
        }
    }

    public void pressDoorButtonLeft(User user) {
        if (user instanceof Person) {
            cabin.LD.DBOUT.press();
        } else if (user instanceof Passenger) {
            Passenger temp = (Passenger) user;
            if (temp.seatedIn().getSide() == LeftRightPosition.LEFT) {
                cabin.LD.DBIN.press();
            }
        }
    }

    public void pressDoorButtonRight(User user) {
        if (user instanceof Person) {
            cabin.RD.DBOUT.press();
        } else if (user instanceof Passenger) {
            Passenger temp = (Passenger) user;
            if (temp.seatedIn().getSide() == LeftRightPosition.RIGHT) {
                cabin.RD.DBIN.press();
            }
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

    public void iterate() {
        centralUnit.iterate();
    }
}
