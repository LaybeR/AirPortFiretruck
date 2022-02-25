package AirportFireTruck;

import Cabin.Display;
import Cannon.FloorCannon;
import Cannon.FrontCannon;
import Cannon.Mixer;
import Cannon.RoofCannon;
import Controller.*;
import Driving.BatteryManagement;
import Driving.Chassis;
import Enums.*;
import Lights.*;
import Tanks.PowderTank;
import Tanks.WaterTank;

public class CentralUnit implements ICentralUnit {
    private final GasPedal gasPedal;
    private final BrakePedal brakePedal;
    private final SteeringWheel steeringWheel;
    private final Display display;
    private final BatteryManagement batteryManagement;
    private final Chassis chassis;
    private final RoofCannon roofCannon;
    private final FrontCannon frontCannon;
    private final FloorCannon floorCannon;
    private final Mixer mixer;
    private final WaterTank waterTank;
    private final PowderTank powderTank;
    private final ControlPanel controlPanel;
    private final HeadLights[] headLights;
    private final DirectionIndicator[] turnLeft;
    private final DirectionIndicator[] turnRight;
    private final BrakeLight[] brakeLights;
    private final RoofLight[] roofLights;
    private final WarningLight[] warningLights;
    private final EmergencyLight[] emergencyLights;

    public CentralUnit(ControlPanel controlPanel, int count) {
        this.headLights = new HeadLights[count*2];
        for (int i = 0; i < headLights.length; i += 2){
            headLights[i] = new HeadLights(LeftRightSide.LEFT);
            headLights[i+1] = new HeadLights(LeftRightSide.RIGHT);
        }

        roofLights = new RoofLight[4];
        for (int i = 0; i < roofLights.length; i += 2){
            roofLights[i] = new RoofLight(LeftRightSide.LEFT);
            roofLights[i+1] = new RoofLight(LeftRightSide.RIGHT);
        }

        turnLeft = new DirectionIndicator[2];
        turnLeft[0] = new DirectionIndicator(FrontRearSide.FRONT,LeftRightSide.LEFT);
        turnLeft[1] = new DirectionIndicator(FrontRearSide.REAR,LeftRightSide.LEFT);
        turnRight = new DirectionIndicator[2];
        turnRight[0] = new DirectionIndicator(FrontRearSide.FRONT,LeftRightSide.RIGHT);
        turnRight[1] = new DirectionIndicator(FrontRearSide.REAR,LeftRightSide.RIGHT);

        brakeLights = new BrakeLight[2];
        brakeLights[0] = new BrakeLight(LeftRightSide.LEFT);
        brakeLights[1] = new BrakeLight(LeftRightSide.RIGHT);

        warningLights = new WarningLight[2];
        warningLights[0] = new WarningLight(FrontRearSide.FRONT,LeftRightSide.LEFT);
        warningLights[1] = new WarningLight(FrontRearSide.REAR,LeftRightSide.RIGHT);

        emergencyLights = new EmergencyLight[6];
        emergencyLights[0] = new EmergencyLight(LateralPosition.BOTTOM,FrontRearSide.FRONT,LeftRightSide.LEFT,LightSize.SMALL);
        emergencyLights[1] = new EmergencyLight(LateralPosition.BOTTOM,FrontRearSide.FRONT,LeftRightSide.RIGHT,LightSize.SMALL);
        emergencyLights[2] = new EmergencyLight(LateralPosition.TOP,FrontRearSide.FRONT,LeftRightSide.LEFT,LightSize.LARGE);
        emergencyLights[3] = new EmergencyLight(LateralPosition.TOP,FrontRearSide.FRONT,LeftRightSide.RIGHT,LightSize.LARGE);
        emergencyLights[4] = new EmergencyLight(LateralPosition.BOTTOM,FrontRearSide.REAR,LeftRightSide.LEFT,LightSize.MEDIUM);
        emergencyLights[5] = new EmergencyLight(LateralPosition.BOTTOM,FrontRearSide.REAR,LeftRightSide.RIGHT,LightSize.MEDIUM);

        this.controlPanel = controlPanel;
        this.gasPedal = new GasPedal(this);
        this.brakePedal = new BrakePedal(this);
        this.steeringWheel = new SteeringWheel(this);
        this.display = new Display(this);
        this.batteryManagement = BatteryManagement.INSTANCE;
        batteryManagement.setCU(this);
        this.chassis = new Chassis();
        this.roofCannon = new RoofCannon();
        this.frontCannon = new FrontCannon();
        this.floorCannon = new FloorCannon();
        this.mixer = new Mixer();
        this.waterTank = new WaterTank();
        this.powderTank = new PowderTank();
    }

    public void changeVehicleDirection(int change, SteeringDirection direction) {
        chassis.changeRotation(change);
        if (direction == SteeringDirection.CENTER) {
            for (DirectionIndicator indicator : turnLeft) indicator.turnOff();
            for (DirectionIndicator directionIndicator : turnRight) directionIndicator.turnOff();
        } else if (direction == SteeringDirection.LEFT) {
            for (DirectionIndicator indicator : turnLeft) indicator.turnOn();
            for (DirectionIndicator directionIndicator : turnRight) directionIndicator.turnOff();
        } else if (direction == SteeringDirection.RIGHT) {
            for (DirectionIndicator indicator : turnLeft) indicator.turnOff();
            for (DirectionIndicator directionIndicator : turnRight) directionIndicator.turnOn();
        }
    }



    public void iterate() {
        chassis.iterate();
        int roofCannonAmount = 0;
        switch (controlPanel.getKnob(KnobType.ROOF_CANNON).getKnobPosition()) {
            case 1 -> roofCannonAmount = 500;
            case 2 -> roofCannonAmount = 1500;
            case 3 -> roofCannonAmount = 2500;
        }
        int frontCannonAmount = 0;
        switch (controlPanel.getKnob(KnobType.FRONT_CANNON).getKnobPosition()) {
            case 1 -> frontCannonAmount = 500;
            case 2 -> frontCannonAmount = 1000;
            case 3 -> frontCannonAmount = 1500;
            case 4 -> frontCannonAmount = 2000;
            case 5 -> frontCannonAmount = 2500;
            case 6 -> frontCannonAmount = 3000;
            case 7 -> frontCannonAmount = 3500;
        }
        if(roofCannon.isActivated())  mixer.getMix(waterTank,powderTank,1-roofCannon.getRatio(), roofCannonAmount);
        if(frontCannon.isActivated()) mixer.getMix(waterTank,powderTank,1-frontCannon.getRatio(), frontCannonAmount);
        if(floorCannon.isActivated()) waterTank.takeOut(100);
        display.setRemainingEnergy(batteryManagement.getCurrentCharge()/Double.parseDouble("" + batteryManagement.getMaxCharge()));
    }

    public void postDisplay() {
        display.getSpeed();
        display.getRemainingEnergy();
    }

    @Override
    public void increaseSpeed() {
        if (!controlPanel.getSwitch(SwitchType.ELECTRIC_ENGINE).isPressed()) return;
        chassis.increaseSpeed();
        display.setSpeed(chassis.getSpeed());
    }

    @Override
    public void decreaseSpeed() {
        chassis.decreaseSpeed();
        display.setSpeed(chassis.getSpeed());
    }

    public Display getDisplay() {
        return display;
    }

    public GasPedal getGasPedal() {
        return gasPedal;
    }

    public BrakePedal getBrakePedal() {
        return brakePedal;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public RoofCannon getRoofCannon() {
        return roofCannon;
    }

    public FloorCannon getFloorCannon() {
        return floorCannon;
    }

    public FrontCannon getFrontCannon() {
        return frontCannon;
    }

    public PowderTank getPowderTank() {
        return powderTank;
    }

    public WaterTank getWaterTank() {
        return waterTank;
    }

    public Mixer getMixer() {
        return mixer;
    }

    public void updateLights(Switch s) {
        switch (s.type) {
            case HEAD_LIGHT -> {
                for (HeadLights light : headLights) {
                    if (s.isPressed()) light.turnOn();
                    else light.turnOff();
                }
            }
            case WARNING_LIGHT -> {
                for (WarningLight light : warningLights) {
                    if (s.isPressed()) light.turnOn();
                    else light.turnOff();
                }
            }
            case ROOF_LIGHT -> {
                for (RoofLight light : roofLights) {
                    if (s.isPressed()) light.turnOn();
                    else light.turnOff();
                }
            }
            case SIDE_LIGHT -> {}
            case EMERGENCY_LIGHT -> {
                for (EmergencyLight light : emergencyLights) {
                    if (s.isPressed()) light.turnOn();
                    else light.turnOff();
                }
            }
        }
    }

    public BatteryManagement getBatteryManagement() {
        return batteryManagement;
    }

    public BrakeLight[] getBrakeLights() {
        return brakeLights;
    }

    public EmergencyLight[] getEmergencyLights() {
        return emergencyLights;
    }

    public DirectionIndicator[] getTurnRight() {
        return turnRight;
    }

    public HeadLights[] getHeadLights() {
        return headLights;
    }

    public RoofLight[] getRoofLights() {
        return roofLights;
    }

    public WarningLight[] getWarningLights() {
        return warningLights;
    }

    public DirectionIndicator[] getTurnLeft() {
        return turnLeft;
    }

    public Chassis getChassis() {
        return chassis;
    }
}
