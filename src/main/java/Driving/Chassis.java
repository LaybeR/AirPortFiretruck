package Driving;

public class Chassis {
    private NonSteerablePivot[] backPivot;
    private SteerablePivot[] frontPivot;
    private ElectricEngine[] engines;

    public void increaseSpeed(){
        for (ElectricEngine e : engines) {
            e.increase();
        }
    }
    public void decreaseSpeed(){
        for (ElectricEngine e : engines) {
            e.decrease();
        }
    }
    public int getSpeed(){
        int speed = 0;
        for (ElectricEngine e : engines) {
            speed += e.getSpeed();
        }
        return speed/engines.length;
    }
    public void changeRotation(int change){
        for (SteerablePivot s : frontPivot) {
            s.changeDirection(change);
        }
    }

    public void iterate() {
        for (ElectricEngine e : engines) {
            e.iterate();
        }
    }

    public Chassis(){
        backPivot[0] = new NonSteerablePivot();
        backPivot[1] = new NonSteerablePivot();

        frontPivot[0] = new SteerablePivot();
        frontPivot[1] = new SteerablePivot();

        engines[0] = new ElectricEngine();
        engines[1] = new ElectricEngine();
    }

}
