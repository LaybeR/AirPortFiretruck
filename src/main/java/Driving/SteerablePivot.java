package Driving;

public class SteerablePivot extends Pivot {
  int direction;

  public SteerablePivot(){
      super();
      this.direction = 0;
  }

  public void changeDirection(int change){
      direction = change;
      System.out.println("Direction: " + direction);
  }

    public int getDirection() {
        return direction;
    }
}
