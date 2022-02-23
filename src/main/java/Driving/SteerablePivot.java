package Driving;

public class SteerablePivot extends Pivot {
  int direction;

  public SteerablePivot(){
      create();
      this.direction = 0;
  }

  public void changeDirection(int change){
 direction = change;
  }

}
