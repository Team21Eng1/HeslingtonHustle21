public class PlayerCharacter {
    private int money;
    private int energy;

    public PlayerCharacter(){
        this.money = 100;
        this.energy = 20;

    }

    public PlayerCharacter(int money, int energy){
        this.money = money;
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }


    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public boolean checkEnergy(int nrg){
        if (energy - nrg < 0){
            return false;
        }
        else if (energy - nrg == 0) {
            return true;
        }
        return true;
    }

    public void decreaseEnergy(int nrg){

        if (energy - nrg == 0) {
            energy = 12;

        }
        else {
            energy -= nrg;

        }


    }
}
