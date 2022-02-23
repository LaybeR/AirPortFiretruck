package Driving;

public class Chassis {
    NonSteerablePivot[] backPivot;
    SteerablePivot[] frontPivot;
    ElectricEngine[] engines;

    public void increaseSpeed(){

    }
    public void decreaseSpeed(){

    }
    public int getSpeed(){
        return 0;
    }
    public void changeRotation(){

    }
    Chassis(){
    create();
    }

    void create(){
        backPivot[0] = new NonSteerablePivot();
        backPivot[1] = new NonSteerablePivot();

        frontPivot[0] = new SteerablePivot();
        frontPivot[1] = new SteerablePivot();

        engines[0] = new ElectricEngine();
        engines[1] = new ElectricEngine();
    }
}
