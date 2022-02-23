package Cannon;

import Cannon.IMixer;
import Tanks.Tank;

public class Mixer implements IMixer {
    @Override
    public int getMix(Tank waterTank, Tank powderTank, double ratioWtP, int amount) {
        double powderShare = 1.0 - ratioWtP;
        int takeOutWater = waterTank.takeOut((int) Math.round(ratioWtP*amount));
        int takeOutPowder = powderTank.takeOut((int) Math.round(powderShare*amount));
        return takeOutPowder+takeOutWater;
    }
}
