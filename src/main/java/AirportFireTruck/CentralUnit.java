package AirportFireTruck;

import Cabin.Display;
import Cannon.FloorCannon;
import Cannon.FrontCannon;
import Cannon.Mixer;
import Cannon.RoofCannon;
import Controller.BrakePedal;
import Controller.GasPedal;
import Controller.Knob;
import Controller.SteeringWheel;
import Driving.BatteryManagement;
import Driving.Chassis;
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

    public CentralUnit() {
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

    public void changeVehicleDirection(int change) {

    }

    public void iterate() {
        chassis.iterate();
        if(roofCannon.isActivated())  mixer.getMix(waterTank,powderTank,1-roofCannon.getRatio(), 99999999);
        if(frontCannon.isActivated()) mixer.getMix(waterTank,powderTank,1-frontCannon.getRatio(), 99999999);
        if(floorCannon.isActivated()) waterTank.takeOut(100);
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

    public BatteryManagement getBatteryManagement() {
        return batteryManagement;
    }
}
