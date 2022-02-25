
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

public class FireTruckTests {
    AirportFireTruck airportFireTruck;

    @BeforeEach
    void setup() {
        AirportFireTruck.Builder builder = new AirportFireTruck.Builder();
        airportFireTruck = builder.build();
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
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
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
        Switch engine = airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE);
        airportFireTruck.pressSwitch(engine,operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        Switch headlight = airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT);
        Switch warninglight = airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT);
        airportFireTruck.pressSwitch(headlight,operator);
        airportFireTruck.pressSwitch(warninglight,operator);
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
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        for(int i = 0; i <7;i++) {airportFireTruck.pressGas(driver); airportFireTruck.iterate();};
        assert(airportFireTruck.getCentralUnit().getChassis().getSpeed() == 28);
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.turnSteeringWheel(driver, SteeringDirection.LEFT);
        assert(airportFireTruck.getCentralUnit().getChassis().getRotation() == -5);
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        airportFireTruck.turnSteeringWheel(driver, SteeringDirection.CENTER);
        assert(airportFireTruck.getCentralUnit().getChassis().getRotation() == 0);
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.turnSteeringWheel(driver, SteeringDirection.RIGHT);
        assert(airportFireTruck.getCentralUnit().getChassis().getRotation() == 5);
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.turnSteeringWheel(driver, SteeringDirection.CENTER);
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
        Switch temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE);
        airportFireTruck.pressSwitch(temp,operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
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
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        for(int i = 0; i <20;i++) {airportFireTruck.pressGas(driver); airportFireTruck.iterate();}
        for(int i = 0; i <10;i++) airportFireTruck.iterate();
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
        Switch temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE);
        airportFireTruck.pressSwitch(temp,operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
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
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.FIRE_SELF_PROTECTION);
        airportFireTruck.pressSwitch(temp,operator);
        airportFireTruck.iterate();
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 700 == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        airportFireTruck.pressSwitch(temp,operator);
        Knob knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i <5;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        Joystick stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.LEFT);
        for(int i = 0; i <2;i++) airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.RIGHT);
        airportFireTruck.holdFeeler(driver,stick);
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(driver,stick);
        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 9250 == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + 450 == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON);
        for(int i = 0; i <2;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.RIGHT);
        airportFireTruck.pressJoystickButton(operator,stick, LeftRightPosition.LEFT);
        airportFireTruck.pressJoystickButton(operator,stick, LeftRightPosition.RIGHT);
        airportFireTruck.holdFeeler(operator,stick);
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(operator,stick);
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
        Switch temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE);
        airportFireTruck.pressSwitch(temp,operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.SIDE_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
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
        airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.LEFT);
        for(int i = 0; i < 3;i++) airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.RIGHT);
        airportFireTruck.holdFeeler(driver,stick);
        for(int i = 0; i < 3;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(driver,stick);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 9450 == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + 1050 == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON);
        for(int i = 0; i < 2;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.RIGHT);
        airportFireTruck.pressJoystickButton(operator,stick, LeftRightPosition.LEFT);
        for(int i = 0; i < 2;i++) airportFireTruck.pressJoystickButton(operator,stick, LeftRightPosition.RIGHT);
        airportFireTruck.holdFeeler(operator,stick);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(operator,stick);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + 9450 + (2375*5) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + 1050 + (125*5) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i < 5;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.COUNTER_CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.LEFT);
        for(int i = 0; i < 2;i++) airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.RIGHT);
        airportFireTruck.holdFeeler(driver,stick);
        for(int i = 0; i < 3;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(driver,stick);

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
        Switch temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE);
        airportFireTruck.pressSwitch(temp,operator);
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
        temp = airportFireTruck.getControlPanel().getSwitch(SwitchType.SIDE_LIGHT);
        airportFireTruck.pressSwitch(temp,operator);
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
        airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.LEFT);
        for(int i = 0; i < 3;i++) airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.RIGHT);
        airportFireTruck.holdFeeler(driver,stick);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(driver,stick);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + (3150*5) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + (350*5) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON);
        for(int i = 0; i < 2;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.RIGHT);
        airportFireTruck.pressJoystickButton(operator,stick, LeftRightPosition.LEFT);
        for(int i = 0; i < 3;i++) airportFireTruck.pressJoystickButton(operator,stick, LeftRightPosition.RIGHT);
        airportFireTruck.holdFeeler(operator,stick);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(operator,stick);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + (3150*5) + (2250*5) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + (350*5) + (250*5) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        airportFireTruck.holdFeeler(operator,stick);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(operator,stick);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + (3150*5) + (2250*10) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + (350*5) + (250*10) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());

        knob = airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON);
        for(int i = 0; i < 5;i++) airportFireTruck.turnKnob(knob,operator,KnobDirectionType.COUNTER_CLOCKWISE);
        stick = airportFireTruck.getJoystick(LeftRightPosition.LEFT);
        for(int i = 0; i < 2;i++) airportFireTruck.pressJoystickButton(driver,stick, LeftRightPosition.RIGHT);
        airportFireTruck.holdFeeler(driver,stick);
        for(int i = 0; i < 5;i++) airportFireTruck.iterate();
        airportFireTruck.releaseFeeler(driver,stick);

        assert(airportFireTruck.getCentralUnit().getWaterTank().getFill() + (3150*5) + (2250*10) + (970*5) == airportFireTruck.getCentralUnit().getWaterTank().getMaxAmount());
        assert(airportFireTruck.getCentralUnit().getPowderTank().getFill() + (350*5) + (250*10) + (30*5) == airportFireTruck.getCentralUnit().getPowderTank().getMaxAmount());
    }



}
