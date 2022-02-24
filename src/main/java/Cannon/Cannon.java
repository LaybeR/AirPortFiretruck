package Cannon;

public abstract class Cannon {
    boolean activated;
    int rotationInDeg;
    int powderToWaterInPercent;

    public void rotateLeft() {
        if(rotationInDeg > -90) rotationInDeg -= 90;
    }

    public void rotateRight() {
        if(rotationInDeg < 90) rotationInDeg += 90;
    }

    public void activate() {
        activated = true;
    }

    public void deactivate() {
        activated = false;
    }

    public void changeRatio() {
        switch (powderToWaterInPercent){
        case 0-> powderToWaterInPercent = 3;
        case 3-> powderToWaterInPercent = 5;
        case 5-> powderToWaterInPercent = 10;
        case 10-> powderToWaterInPercent = 0;
        }
    }
    public double getRatio(){
    return powderToWaterInPercent/100.;
    }

    public boolean isActivated() {
        return activated;
    }
}
