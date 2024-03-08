public class TimeEnergy {
    private int days;
    private float days_Hours;
    private int energy;

    public TimeEnergy(){
        days = 7;
        days_Hours = 16;
        energy = 1000;

    }

    public int getDays(){

        return days;
    }

    public float getHours() {

        return days_Hours;
    }

    public void decreaseDays(){

        days -= 1;
    }

    /*a boolean function is used to return if the function was successful or not
    once the time has reached 0 the day count decreases*/
    private boolean decreaseHours(double time){
        if (days_Hours - time < 0){
            return false;
        }
        else if (days_Hours - time == 0) {
            days_Hours = 16;
            decreaseDays();
            return true;
        }
        days_Hours -= time;
        return true;

    }

    public int getEnergy(){
        return energy;
    }

    private boolean decreaseEnergy(int nrg){
        if (energy - nrg < 0){
            return false;
        }
        else if (energy - nrg == 0) {
            energy = 12;
            decreaseDays();
            return true;
        }
        energy -= nrg;
        return true;
    }

    public boolean checkTime(double time){
        if (energy - time < 0){
            return false;
        }
        else if (energy - time == 0) {
            return true;
        }
        return true;
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

    public boolean event(double time, int nrg){
        return (decreaseHours(time) && decreaseEnergy(nrg));
    }

    public boolean checkEvent(double time, int nrg){
        return (checkTime(time) && checkEnergy(nrg));
    }


    public boolean isComplete(){
        return (days == 0);
    }
}
