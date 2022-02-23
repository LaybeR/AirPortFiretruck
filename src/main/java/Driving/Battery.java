package Driving;

import java.util.Arrays;

public class Battery {
    int[][][] capacity = new int[100][10][100];
    int pointer;
    Battery(){
        create();
    }
    void create(){
        Arrays.fill(capacity[0][0],0);
        Arrays.fill(capacity[0],capacity[0][0]);
        Arrays.fill(capacity,capacity[0]);
        pointer = 0;
    }
    int charge(int amount){
        while (amount > 0 && pointer < 75*45*10){
            capacity[100-((pointer / 100) % 100)][pointer / 10000][pointer % 10] = 1;
            pointer ++;
            amount--;
        }
        return amount;
    }
    int takeOut(int amount){
        while (amount > 0 && pointer < 75*45*10){
            --pointer;
            capacity[100-((pointer / 100) % 100)][pointer / 10000][pointer % 10] = 0;
            amount--;
        }
        return amount;
    }
}
