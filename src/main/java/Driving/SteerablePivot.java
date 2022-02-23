package Driving;

public class SteerablePivot extends Pivot {
  int direction;

  public void changeDirection(int change){
 direction = change;
  }
  SteerablePivot(){
      this.direction = 0;
  }
}
