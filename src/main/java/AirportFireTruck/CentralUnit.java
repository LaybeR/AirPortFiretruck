package AirportFireTruck;

import Cabin.Display;
import Cannon.*;
import Controller.*;
import Driving.*;
import Enums.*;
import Events.*;
import Lights.*;
import Tanks.PowderTank;
import Tanks.WaterTank;
import User.IUser;
import org.greenrobot.eventbus.EventBus;

public class CentralUnit implements ICentralUnit {
    private final GasPedal gasPedal;
    private final BrakePedal brakePedal;
    private final SteeringWheel steeringWheel;
    private final Display display;
    private final BatteryManagement batteryManagement;
    private final Chassis chassis;
    private final RoofCannon roofCannon;
    private final FrontCannon frontCannon;
    private final FloorCannon[] floorCannons;
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
    private final BatteryManagementAdapter batteryManagementAdapter;
    private final ChargingStation chargingStation;


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
        SideLight sideLight = new SideLight(FrontRearSide.FRONT,LeftRightSide.LEFT);
        this.chassis = new Chassis();
        this.roofCannon = new RoofCannon();
        this.frontCannon = new FrontCannon();
        this.floorCannons = new FloorCannon[7];
        for (int i = 0; i < floorCannons.length; i++) floorCannons[i] = new FloorCannon();
        this.mixer = new Mixer();
        this.waterTank = new WaterTank();
        this.powderTank = new PowderTank();
        this.batteryManagementAdapter = new BatteryManagementAdapter(batteryManagement);
        this.chargingStation = new ChargingStation();
        for (EmergencyLight emergencyLight : emergencyLights) EventBus.getDefault().register(emergencyLight);
        for (ElectricEngine electricEngine : getChassis().getEngines()) EventBus.getDefault().register(electricEngine);
        for (HeadLights headLight : headLights) EventBus.getDefault().register(headLight);
        for (RoofLight roofLight : roofLights) EventBus.getDefault().register(roofLight);
        for (FloorCannon floorCannon : floorCannons) EventBus.getDefault().register(floorCannon);
        for (WarningLight warningLight : warningLights ) EventBus.getDefault().register(warningLight);
        EventBus.getDefault().register(sideLight);


    }

    public void setListener(FillGaugeLED waterTankL, FillGaugeLED powderTankL) {
        waterTank.addListener(waterTankL);
        powderTank.addListener(powderTankL);
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
        if(roofCannon.isActivated() && roofCannon.isFiring())  mixer.getMix(waterTank,powderTank,1-roofCannon.getRatio(), roofCannonAmount);
        if(frontCannon.isActivated() && frontCannon.isFiring()) mixer.getMix(waterTank,powderTank,1-frontCannon.getRatio(), frontCannonAmount);
        for (FloorCannon f : floorCannons) if (f.isActivated()) waterTank.takeOut(100);
        display.setRemainingEnergy(batteryManagement.getCurrentCharge()/Double.parseDouble("" + batteryManagement.getMaxCharge()));
    }

    public void postDisplay() {
        display.getSpeed();
        display.getRemainingEnergy();
    }

    @Override
    public void increaseSpeed() {
        chassis.increaseSpeed();
        display.setSpeed(chassis.getSpeed());
    }

    @Override
    public void decreaseSpeed() {
        chassis.decreaseSpeed();
        display.setSpeed(chassis.getSpeed());
    }

    public GasPedal getGasPedal() {
        return gasPedal;
    }

    public Display getDisplay() {
        return display;
    }

    public BrakePedal getBrakePedal() {
        return brakePedal;
    }

    public FrontCannon getFrontCannon() {
        return frontCannon;
    }

    public RoofCannon getRoofCannon() {
        return roofCannon;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public FloorCannon[] getFloorCannons() {
        return floorCannons;
    }

    public PowderTank getPowderTank() {
        return powderTank;
    }

    public WaterTank getWaterTank() {
        return waterTank;
    }

    public IMixer getMixer() {
        return mixer;
    }

    public void turnSwitchOn(SwitchType s, IUser user) {
        switch (s) {
            case HEAD_LIGHT -> {
                for (HeadLights light : headLights) {
                    EventBus.getDefault().post(new HeadLightEventOn());
                }
            }
            case WARNING_LIGHT -> {
                for (WarningLight light : warningLights) {
                    EventBus.getDefault().post(new WarningLightEventOn());
                }
            }
            case ROOF_LIGHT -> {
                for (RoofLight light : roofLights) {
                    EventBus.getDefault().post(new RoofLightEventOn());
                }
            }
            case SIDE_LIGHT -> {}
            case EMERGENCY_LIGHT -> {
                for (EmergencyLight light : emergencyLights) {
                    EventBus.getDefault().post(new EmergencyLightEventOn());                }
            }
            case FIRE_SELF_PROTECTION -> {
                for (FloorCannon f : floorCannons) {
                    EventBus.getDefault().post(new SelfProtectionEventOn());                }
            }
            case ELECTRIC_ENGINE -> {
                CannonVisitor visitor = new CannonVisitor();
                if (!roofCannon.accept(visitor)) {
                    System.out.println("Fehler in der Dachl??schanlage");
                    return;
                }
                if (!frontCannon.accept(visitor)) {
                    System.out.println("Fehler in der Frontl??schanlage");
                    return;
                }
                for (FloorCannon f : floorCannons) {
                    if (!f.accept(visitor)) {
                        System.out.println("Fehler in der Bodenl??schanlage");
                        return;
                    }
                }
                chassis.changeEngineStatus(true);
                EventBus.getDefault().post(new ElectricEngineEventOn());
            }
        }
    }

    public void turnSwitchOff(SwitchType s, IUser user) {
        switch (s) {
            case HEAD_LIGHT -> {
                for (HeadLights light : headLights) {
                    EventBus.getDefault().post(new HeadLightEventOff());
                }
            }
            case WARNING_LIGHT -> {
                for (WarningLight light : warningLights) {
                    EventBus.getDefault().post(new WarningLightEventOff());
                }
            }
            case ROOF_LIGHT -> {
                for (RoofLight light : roofLights) {
                    EventBus.getDefault().post(new RoofLightEventOff());
                }
            }
            case SIDE_LIGHT -> {}
            case EMERGENCY_LIGHT -> {
                for (EmergencyLight light : emergencyLights) {
                    EventBus.getDefault().post(new EmergencyLightEventOff());                }
            }
            case FIRE_SELF_PROTECTION -> {
                for (FloorCannon f : floorCannons) {
                    EventBus.getDefault().post(new SelfProtectionEventOff());                }
            }
            case ELECTRIC_ENGINE -> {
                EventBus.getDefault().post(new ElectricEngineEventOff());            }
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

    public void plugInCharger(){
        chargingStation.plugIn(batteryManagementAdapter);
    }

    public void plugOutCharger(){
        chargingStation.plugOut();
    }

    public ChargingStation getChargingStation() {
        return chargingStation;
    }
}
