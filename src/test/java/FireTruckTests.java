
import AirportFireTruck.AirportFireTruck;
import Enums.*;
import User.Driver;
import User.IUser;
import User.Operator;
import User.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FireTruckTests {
    AirportFireTruck airportFireTruck;

    @BeforeEach
    void setup() {
        AirportFireTruck.Builder builder = new AirportFireTruck.Builder();
        airportFireTruck = builder.build();
    }

    @Test
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
        assert(airportFireTruck.getCentralUnit().getWaterTank().getCapacity()[74][44][29] == 1 && airportFireTruck.getCentralUnit().getPowderTank().getCapacity()[74][44][9] == 1 );
        assert(airportFireTruck.getCentralUnit().getBatteryManagement().getBatteryBox().getBatteryBox()[1][1].getCapacity()[99][9][99] == 1 );

        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
    }

    @Test
    void handleInspectionDrive(){
        Driver driver = new Driver(airportFireTruck.getSeats()[0][0]);
        Operator operator = new Operator(airportFireTruck.getSeats()[0][1] );
        Person person = new Person();
        airportFireTruck.pressDoorButtonLeft(person);
        airportFireTruck.getSeats()[0][0].sitIn(airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT));
        airportFireTruck.pressDoorButtonRight(person);
        airportFireTruck.getSeats()[0][1].sitIn(airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT));
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled());
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).press();
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT).press();
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT));
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
        assert(airportFireTruck.getCentralUnit().getWaterTank().getCapacity()[74][44][29] == 1 && airportFireTruck.getCentralUnit().getPowderTank().getCapacity()[74][44][9] == 1 );
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
        for(int i = 0; i <7;i++) {airportFireTruck.pressBrake(driver); airportFireTruck.iterate();}
        assert(airportFireTruck.getCentralUnit().getChassis().getSpeed() == 0);
        //erwarteter verbrauch:18200 12600
        //assert(airportFireTruck.getCentralUnit().getBatteryManagement().getBatteryBox().getBatteryBox()[1][1].getPointer() == 100000-18200);
    }
    @Test
    void handleEmergencyService (){
        Driver driver = new Driver(airportFireTruck.getSeats()[0][0]);
        Operator operator = new Operator(airportFireTruck.getSeats()[0][1] );
        Person person = new Person();
        airportFireTruck.pressDoorButtonLeft(person);
        airportFireTruck.getSeats()[0][0].sitIn(airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT));
        airportFireTruck.pressDoorButtonRight(person);
        airportFireTruck.getSeats()[0][1].sitIn(airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT));
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled());
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).press();
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT).press();
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT));
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
        assert(airportFireTruck.getCentralUnit().getWaterTank().getCapacity()[74][44][29] == 1 && airportFireTruck.getCentralUnit().getPowderTank().getCapacity()[74][44][9] == 1 );
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        for(int i = 0; i <20;i++) {airportFireTruck.pressGas(driver); airportFireTruck.iterate();}
        for(int i = 0; i <10;i++) airportFireTruck.iterate();
        ///assert ENERGY?!?!
    }
    @Test
    void handleFuelTruckOnFire(){
        Driver driver = new Driver(airportFireTruck.getSeats()[0][0]);
        Operator operator = new Operator(airportFireTruck.getSeats()[0][1] );
        Person person = new Person();
        airportFireTruck.pressDoorButtonLeft(person);
        airportFireTruck.getSeats()[0][0].sitIn(airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT));
        airportFireTruck.pressDoorButtonRight(person);
        airportFireTruck.getSeats()[0][1].sitIn(airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT));
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled());
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).press();
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.SIDE_LIGHT).press();
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.SIDE_LIGHT));
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getCapacity()[74][44][29] == 1 && airportFireTruck.getCentralUnit().getPowderTank().getCapacity()[74][44][9] == 1 );
        //schwenken!
        airportFireTruck.getControlPanel().getSwitch(SwitchType.FIRE_SELF_PROTECTION).press();
        for(int i = 0; i <5;i++) airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).turnClockwise();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).LB.press();
        for(int i = 0; i <2;i++) airportFireTruck.getJoystick(LeftRightPosition.LEFT).RB.press();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).feeler.hold();
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).feeler.release();
        //assert(Verbrauch??)
        for(int i = 0; i <4;i++) airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).turnClockwise();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).LB.press();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).RB.press();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).feeler.hold();
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).feeler.release();
        //assert(Verbrauch??)
    }

    @Test
    void handlePushbackVehicleOnFire(){
        Driver driver = new Driver(airportFireTruck.getSeats()[0][0]);
        Operator operator = new Operator(airportFireTruck.getSeats()[0][1] );
        Person person = new Person();
        airportFireTruck.pressDoorButtonLeft(person);
        airportFireTruck.getSeats()[0][0].sitIn(airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT));
        airportFireTruck.pressDoorButtonRight(person);
        airportFireTruck.getSeats()[0][1].sitIn(airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT));
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled());
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).press();
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.SIDE_LIGHT).press();
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.SIDE_LIGHT));
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getCapacity()[74][44][29] == 1 && airportFireTruck.getCentralUnit().getPowderTank().getCapacity()[74][44][9] == 1 );
        //Schwenken!
        for(int i = 0; i <6;i++) airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).turnClockwise();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).LB.press();
        for(int i = 0; i <3;i++) airportFireTruck.getJoystick(LeftRightPosition.LEFT).RB.press();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.hold();
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.release();
        //assert(Verbrauch??)
        for(int i = 0; i <4;i++) airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).turnClockwise();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).LB.press();
        for(int i = 0; i <2;i++) airportFireTruck.getJoystick(LeftRightPosition.RIGHT).RB.press();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).feeler.hold();
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).feeler.release();
        //assert(Verbrauch??)
        for(int i = 0; i <5;i++) airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).turnCounterClockwise();
        for(int i = 0; i <2;i++) airportFireTruck.getJoystick(LeftRightPosition.LEFT).RB.press();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.hold();
        for(int i = 0; i <3;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.release();
        //assert(Verbrauch??)

    }

    @Test
    void handleAirplaneEngineFire(){
        Driver driver = new Driver(airportFireTruck.getSeats()[0][0]);
        Operator operator = new Operator(airportFireTruck.getSeats()[0][1] );
        Person person = new Person();
        airportFireTruck.pressDoorButtonLeft(person);
        airportFireTruck.getSeats()[0][0].sitIn(airportFireTruck.sitIn(driver, LeftRightSide.LEFT, FrontBackPosition.FRONT));
        airportFireTruck.pressDoorButtonRight(person);
        airportFireTruck.getSeats()[0][1].sitIn(airportFireTruck.sitIn(operator, LeftRightSide.RIGHT, FrontBackPosition.FRONT));
        assert(airportFireTruck.getSeats()[0][0].isFilled() && airportFireTruck.getSeats()[0][1].isFilled());
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).press();
        assert(airportFireTruck.getControlPanel().getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed());
        assert(airportFireTruck.getControlPanel().knobFrontCannon.getKnobPosition() == 1 && airportFireTruck.getControlPanel().knobRoofCannon.getKnobPosition() == 1 );
        airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT).press();
        airportFireTruck.getControlPanel().getSwitch(SwitchType.SIDE_LIGHT).press();
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.HEAD_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.WARNING_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.ROOF_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.EMERGENCY_LIGHT));
        airportFireTruck.getControlPanel().update(airportFireTruck.getControlPanel().getSwitch(SwitchType.SIDE_LIGHT));
        for(int j = 0 ; j < airportFireTruck.getCentralUnit().getHeadLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getHeadLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getRoofLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getRoofLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getWarningLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getWarningLights()[j].isOn);
        }for(int j = 0 ; j < airportFireTruck.getCentralUnit().getEmergencyLights().length ; j++){
            assert (airportFireTruck.getCentralUnit().getEmergencyLights()[j].isOn);
        }
        assert(airportFireTruck.getCentralUnit().getWaterTank().getCapacity()[74][44][29] == 1 && airportFireTruck.getCentralUnit().getPowderTank().getCapacity()[74][44][9] == 1 );
        //Schwenken!
        for(int i = 0; i <6;i++) airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).turnClockwise();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).LB.press();
        for(int i = 0; i <3;i++) airportFireTruck.getJoystick(LeftRightPosition.LEFT).RB.press();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.hold();
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.release();
        //assert(Verbrauch??)
        for(int i = 0; i <4;i++) airportFireTruck.getControlPanel().getKnob(KnobType.ROOF_CANNON).turnClockwise();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).LB.press();
        for(int i = 0; i <3;i++) airportFireTruck.getJoystick(LeftRightPosition.RIGHT).RB.press();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).feeler.hold();
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.RIGHT).feeler.release();
        //assert(Verbrauch??)
        for(int i = 0; i <2;i++) airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).turnCounterClockwise();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.hold();
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.release();
        //assert(Verbrauch??)
        for(int i = 0; i <3;i++) airportFireTruck.getControlPanel().getKnob(KnobType.FRONT_CANNON).turnCounterClockwise();
        for(int i = 0; i <2;i++) airportFireTruck.getJoystick(LeftRightPosition.LEFT).RB.press();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.hold();
        for(int i = 0; i <5;i++) airportFireTruck.iterate();
        airportFireTruck.getJoystick(LeftRightPosition.LEFT).feeler.release();
        //assert(Verbrauch??)
    }



}
