package Cannon;

import Tanks.Tank;

public interface IMixer {
    int getMix(Tank waterTank,Tank powderTank, double ratioWtP, int amount);
}
