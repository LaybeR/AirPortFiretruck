package Driving;

public class Chassis {
    private NonSteerablePivot[] backPivot;
    private SteerablePivot[] frontPivot;

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
    }
}
