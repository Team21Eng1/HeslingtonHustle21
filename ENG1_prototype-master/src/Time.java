public class Time {
    private int days;
    private float days_Hours;


    public Time(){
        days = 7;
        days_Hours = 16;

    }

    public int getDays(){

        return days;
    }

    public float getHours() {
        return days_Hours;
    }

    public void resetHours(){
        this.days_Hours = 16;
    }

    public void decreaseDays(){

        days -= 1;
    }

    /*a boolean function is used to return if the function was successful or not
    once the time has reached 0 the day count decreases*/
    public boolean decreaseHours(double time){
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




    public boolean checkTime(double time){
        if (this.days_Hours - time < 0){
            return false;
        }
        else if (this.days_Hours - time == 0) {
            return true;
        }
        return true;
    }


    public boolean checkEvent(double time, int nrg){
        return (checkTime(time) && checkEnergy(nrg));
    }


    public boolean isComplete(){
        return (days == 0);
    }
}
