public class Event {
    private int isStudy;
    private String name;
    private double timeCost;
    private int energyCost;
    private int fatigue;
    private int enjoymentStudyLevel;
    public enum type {
        EAT,
        SLEEP,
        STUDY,
        RECREATIONAL
    };

    private type eventType;


    public Event(){
    }

    public Event(double time,int energy) {
        timeCost = time;
        energyCost = energy;

    }

    public Event(double time,int energy, int enjoymentStudyLevel, int fatigue, type eventType) {
        // since externally there is no difference between using an int for enjoyment and one for studylevel,
        timeCost = time;
        energyCost = energy;
        this.enjoymentStudyLevel = enjoymentStudyLevel;
        this.fatigue = fatigue;
        this.eventType = eventType;
    }



    public int getEnergyCost() {
        return energyCost;
    }

    public double getTimeCost() {
        return timeCost;
    }

    public int getEnjoymentStudyLevel() {
        return enjoymentStudyLevel;
    }

    public int getFatigue() {
        return fatigue;
    }

    public type getEventType() {
        return eventType;
    }

    public String getName() {
        return name;
    }

    /*
    this class allows for the interfacing of the time and energy classes
    it holds the event name a link to the event constants and the values it holds for scoring
    in the primary gameplay loop the number if events and their nature is stored and then
    the results are used to output score after 7 days*/

}
