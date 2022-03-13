
import AirportFireTruck.AirportFireTruck;
import Cabin.Joystick;
import Controller.Knob;
import Controller.Switch;
import Enums.*;
import User.IUser;
import User.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class FireTruckTests {
    AirportFireTruck airportFireTruck;

    @BeforeEach
    void setup() {
        AirportFireTruck.Builder builder = new AirportFireTruck.Builder();
        airportFireTruck = builder.build();
    }


    @Test
    @Order(6)
    void stateAndCommandTest() {
        assert(!airportFireTruck.getSwitch(SwitchType.SIDE_LIGHT).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.FIRE_SELF_PROTECTION).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).isPressed());
        IUser operator = new Person();
        airportFireTruck.pressDoorButtonRight(operator);
        operator = airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT);
        airportFireTruck.getSwitch(SwitchType.SIDE_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.FIRE_SELF_PROTECTION).press(operator);
        airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).press(operator);
        assert(airportFireTruck.getSwitch(SwitchType.SIDE_LIGHT).isPressed());
        assert(airportFireTruck.getSwitch(SwitchType.FIRE_SELF_PROTECTION).isPressed());
        assert(airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).isPressed());
        assert(airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).isPressed());
        assert(airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).isPressed());
        assert(airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).isPressed());
        airportFireTruck.getSwitch(SwitchType.SIDE_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.FIRE_SELF_PROTECTION).press(operator);
        airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).press(operator);
        assert(!airportFireTruck.getSwitch(SwitchType.SIDE_LIGHT).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.FIRE_SELF_PROTECTION).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).isPressed());
        assert(!airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).isPressed());
    }

    @Test
    @Order(8)
    void observerTest() {
        IUser operator = new Person();
        IUser driver = new Person();
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        driver = airportFireTruck.sitIn(operator, LeftRightSide.LEFT, FrontBackPosition.FRONT);
        operator = airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT);
        airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        Knob knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i < 6;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        Joystick stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        stick.LB.press(driver);
        for(int i = 0; i < 3;i++) stick.RB.press(driver);
        stick.feeler.hold(driver);
        assert(airportFireTruck.getControlPanel().getInfoOnFill().equals("Wassertank:\nDie LED ist aus.\nPulvertank:\nDie LED ist aus."));
        for(int i = 0; i < 17;i++) airportFireTruck.iterate();
        assert(airportFireTruck.getControlPanel().getInfoOnFill().equals("Wassertank:\nDie LED ist an und leuchtet gelb.\nPulvertank:\nDie LED ist aus."));
        for(int i = 0; i < 8;i++) airportFireTruck.iterate();
        assert(airportFireTruck.getControlPanel().getInfoOnFill().equals("Wassertank:\nDie LED ist an und leuchtet orange.\nPulvertank:\nDie LED ist aus."));
        for(int i = 0; i < 4;i++) airportFireTruck.iterate();
        assert(airportFireTruck.getControlPanel().getInfoOnFill().equals("Wassertank:\nDie LED ist an und leuchtet rot.\nPulvertank:\nDie LED ist aus."));
        for(int i = 0; i < 20;i++) airportFireTruck.iterate();
        assert(airportFireTruck.getControlPanel().getInfoOnFill().equals("Wassertank:\nDie LED ist an und leuchtet rot.\nPulvertank:\nDie LED ist an und leuchtet gelb."));
        for(int i = 0; i < 24;i++) airportFireTruck.iterate();
        assert(airportFireTruck.getControlPanel().getInfoOnFill().equals("Wassertank:\nDie LED ist an und leuchtet rot.\nPulvertank:\nDie LED ist an und leuchtet orange."));
        for(int i = 0; i < 14;i++) airportFireTruck.iterate();
        assert(airportFireTruck.getControlPanel().getInfoOnFill().equals("Wassertank:\nDie LED ist an und leuchtet rot.\nPulvertank:\nDie LED ist an und leuchtet rot."));
    }

    @Test
    @Order(9)
    void visitorTest() {
        IUser operator = new Person();
        airportFireTruck.pressDoorButtonRight(operator);
        operator = airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT);
        airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        assert(airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
    }

    @Test
    @Order(1)
    void handleParking() {
        assert(!airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(!airportFireTruck.getSeats()[0][0].isFilled() && !airportFireTruck.getSeats()[0][1].isFilled() && !airportFireTruck.getSeats()[1][0].isFilled() && !airportFireTruck.getSeats()[1][1].isFilled());
        Person person = new Person();
        airportFireTruck.pressDoorButtonRight(person);
        airportFireTruck.pressDoorButtonLeft(person);
        assert(airportFireTruck.getLeftDoorstatus() == DoorStatus.OPEN && airportFireTruck.getRightDoorstatus() == DoorStatus.OPEN);
        assert(!airportFireTruck.getCentralUnit().getFrontCannon().isActivated() && !airportFireTruck.getCentralUnit().getRoofCannon().isActivated());
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getTurnLeft().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getTurnLeft()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getTurnRight().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getTurnRight()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getBatteryManagement().getCurrentCharge() == airportFireTruck.getCentralUnit().getBatteryManagement().getMaxCharge());
        assert(airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).getKnobPosition() == 1 && airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).getKnobPosition() == 1 );
    }

    @Test
    @Order(2)
    void handleInspectionDrive(){
        IUser driver = new Person();
        IUser operator = new Person();
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        driver = airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT);
        operator = airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT);
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled() && !airportFireTruck.getSeats()[1][0].isFilled() && !airportFireTruck.getSeats()[1][1].isFilled());
        assert(airportFireTruck.getLeftDoorstatus() == DoorStatus.CLOSED && airportFireTruck.getRightDoorstatus() == DoorStatus.CLOSED);
        //Operator and Driver now Sit in FLF Doors closed
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT).press(operator);
        airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT).press(operator);
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getTurnLeft().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getTurnLeft()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getTurnRight().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getTurnRight()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());
        for(int i = 0; i <7;i++) {airportFireTruck.pressGas(driver); airportFireTruck.iterate();};
        assert(airportFireTruck.getCentralUnit().getChassis().getSpeed() == 28);
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.turnWheel(driver, SteeringDirection.LEFT);
        assert(airportFireTruck.getCentralUnit().getChassis().getRotation() == -5);
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        airportFireTruck.turnWheel(driver, SteeringDirection.CENTER);
        assert(airportFireTruck.getCentralUnit().getChassis().getRotation() == 0);
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.turnWheel(driver, SteeringDirection.RIGHT);
        assert(airportFireTruck.getCentralUnit().getChassis().getRotation() == 5);
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.turnWheel(driver, SteeringDirection.CENTER);
        for(int i = 0; i <7;i++) {airportFireTruck.iterate(); airportFireTruck.pressBrake(driver);}
        assert(airportFireTruck.getCentralUnit().getChassis().getSpeed() == 0);
        assert(airportFireTruck.getCentralUnit().getBatteryManagement().getCurrentCharge() + 18200 == airportFireTruck.getCentralUnit().getBatteryManagement().getMaxCharge());
    }

    @Test
    @Order(3)
    void handleEmergencyService (){
        IUser driver = new Person();
        IUser operator = new Person();
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        driver = airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT);
        operator = airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT);
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled() && !airportFireTruck.getSeats()[1][0].isFilled() && !airportFireTruck.getSeats()[1][1].isFilled());
        assert(airportFireTruck.getLeftDoorstatus() == DoorStatus.CLOSED && airportFireTruck.getRightDoorstatus() == DoorStatus.CLOSED);
        airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).getKnobPosition() == 1 && airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).getKnobPosition() == 1 );
        airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).press(operator);
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getTurnLeft().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getTurnLeft()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getTurnRight().length ; j++){
            assert (!airportFireTruck.getCentralUnit().getTurnRight()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());
        assert(airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).getKnobPosition() == 1 && airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).getKnobPosition() == 1 );
        for(int i = 0; i <20;i++) {airportFireTruck.pressGas(driver); airportFireTruck.iterate();}
        for(int i = 0; i <10;i++) airportFireTruck.iterate();
        System.out.println(airportFireTruck.getCentralUnit().getBatteryManagement().getCurrentCharge());
        System.out.println(airportFireTruck.getCentralUnit().getBatteryManagement().getMaxCharge());
        assert(airportFireTruck.getCentralUnit().getBatteryManagement().getCurrentCharge() + 41000 == airportFireTruck.getCentralUnit().getBatteryManagement().getMaxCharge());
    }

    @Test
    @Order(4)
    void handleFuelTruckOnFire(){
        IUser driver = new Person();
        IUser operator = new Person();
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        driver = airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT);
        operator = airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT);
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled() && !airportFireTruck.getSeats()[1][0].isFilled() && !airportFireTruck.getSeats()[1][1].isFilled());
        assert(airportFireTruck.getLeftDoorstatus() == DoorStatus.CLOSED && airportFireTruck.getRightDoorstatus() == DoorStatus.CLOSED);
        airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).getKnobPosition() == 1 && airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).getKnobPosition() == 1 );
        airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).press(operator);
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        airportFireTruck.getSwitch(SwitchType.FIRE_SELF_PROTECTION).press(operator);
        airportFireTruck.iterate();
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 700 == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        airportFireTruck.getSwitch(SwitchType.FIRE_SELF_PROTECTION).press(operator);
        Knob knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i <5;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        Joystick stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        stick.LB.press(driver);
        for(int i = 0; i <2;i++) stick.RB.press(driver);
        stick.feeler.hold(driver);
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        stick.feeler.release(driver);
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 9250 == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + 450 == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON);
        for(int i = 0; i <2;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.RIGHT);
        stick.LB.press(operator);
        stick.RB.press(operator);
        stick.feeler.hold(operator);
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        stick.feeler.release(operator);
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 16525 == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + 675 == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

    }

    @Test
    @Order(5)
    void handlePushbackVehicleOnFire(){
        IUser driver = new Person();
        IUser operator = new Person();
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        driver = airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT);
        operator = airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT);
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled() && !airportFireTruck.getSeats()[1][0].isFilled() && !airportFireTruck.getSeats()[1][1].isFilled());
        assert(airportFireTruck.getLeftDoorstatus() == DoorStatus.CLOSED && airportFireTruck.getRightDoorstatus() == DoorStatus.CLOSED);
        airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).getKnobPosition() == 1 && airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).getKnobPosition() == 1 );
        airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.SIDE_LIGHT).press(operator);
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        Knob knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i < 6;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        Joystick stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        stick.LB.press(driver);
        for(int i = 0; i < 3;i++) stick.RB.press(driver);
        stick.feeler.hold(driver);
        for(int i = 0; i < 3;i++) airportFireTruck.iterate();
        stick.feeler.release(driver);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 9450 == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + 1050 == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON);
        for(int i = 0; i < 2;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.RIGHT);
        stick.LB.press(operator);
        for(int i = 0; i < 2;i++) stick.RB.press(operator);
        stick.feeler.hold(operator);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        stick.feeler.release(operator);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 9450 + (2375*5) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + 1050 + (125*5) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i < 5;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.COUNTER_CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        stick.LB.press(driver);
        for(int i = 0; i < 2;i++) stick.RB.press(driver);
        stick.feeler.hold(driver);
        for(int i = 0; i < 3;i++) airportFireTruck.iterate();
        stick.feeler.release(driver);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 9450 + (2375*5) + (970*3) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + 1050 + (125*5) + (30*3) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

    }

    @Test
    @Order(6)
    void handleAirplaneEngineFire(){
        IUser driver = new Person();
        IUser operator = new Person();
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        driver = airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT);
        operator = airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT);
        airportFireTruck.pressDoorButtonLeft(driver);
        airportFireTruck.pressDoorButtonRight(operator);
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled() && !airportFireTruck.getSeats()[1][0].isFilled() && !airportFireTruck.getSeats()[1][1].isFilled());
        assert(airportFireTruck.getLeftDoorstatus() == DoorStatus.CLOSED && airportFireTruck.getRightDoorstatus() == DoorStatus.CLOSED);
        airportFireTruck.getSwitch(SwitchType.ELECTRIC_ENGINE).press(operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).getKnobPosition() == 1 && airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).getKnobPosition() == 1 );
        airportFireTruck.getSwitch(SwitchType.HEAD_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.WARNING_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.ROOF_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.EMERGENCY_LIGHT).press(operator);
        airportFireTruck.getSwitch(SwitchType.SIDE_LIGHT).press(operator);
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        Knob knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i < 6;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        Joystick stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        stick.LB.press(driver);
        for(int i = 0; i < 3;i++) stick.RB.press(driver);
        stick.feeler.hold(driver);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        stick.feeler.release(driver);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + (3150*5) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + (350*5) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON);
        for(int i = 0; i < 2;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.RIGHT);
        stick.LB.press(operator);
        for(int i = 0; i < 3;i++) stick.RB.press(operator);
        stick.feeler.hold(operator);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        stick.feeler.release(operator);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + (3150*5) + (2250*5) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + (350*5) + (250*5) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        stick.feeler.hold(operator);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        stick.feeler.release(operator);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + (3150*5) + (2250*10) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + (350*5) + (250*10) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i < 5;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.COUNTER_CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        for(int i = 0; i < 2;i++) stick.RB.press(driver);
        stick.feeler.hold(driver);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        stick.feeler.release(driver);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + (3150*5) + (2250*10) + (970*5) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + (350*5) + (250*10) + (30*5) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());
    }
}
