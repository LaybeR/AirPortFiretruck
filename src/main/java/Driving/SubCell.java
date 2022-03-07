package Driving;

public class SubCell extends Cell{

    public SubCell(){
        for (int i = 0; i < 10 ; i++){
            this.cells.add(new Cell());
        }
    }

    @Override
    public int charge(int amount) {
        for(int i = 0; i < cells.size() && amount > 0;){
            boolean success = this.cells.get(i).charge();
            if(success) amount--;

        }
        return  amount;
    }

    @Override
    public int discharge(int amount) {
        for(int i = 0; i < cells.size() && amount > 0;){
            boolean success = this.cells.get(i).discharge();
            if(success) amount--;

        }
        return  amount;
    }


    public int getCharged() {
        int charge = 0;
        for (Cell cell : this.cells) {
            if (cell.getCharge()) charge++;
        }
        return charge;
    }
}
