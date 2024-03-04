import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // the primary gameplay loop involves performing activities each day, one of which must be studying
        TimeEnergy time = new TimeEnergy();
        // rather than use the predefined constants, new values can be used, since they are not modified at runtime
        Event event1 = new Event( 1, 2, 10,-5,Event.type.RECREATIONAL);
        Event event2 = new Event( 1, 2,20,-10, Event.type.RECREATIONAL);
        Event event3 = new Event(2, 2,50,10, Event.type.RECREATIONAL);
        Event eatingA = new Event(1, -10, Event.type.EAT);
        Event eatingB = new Event(0.5, -5, Event.type.EAT);
        Event studying = new Event( 2.5 , 100, 10, 10, Event.type.STUDY);
        Event studyCatchUp = new Event( 5 , 200, 20, 20, Event.type.STUDY);
        Event sleep = new Event(0, 0, Event.type.SLEEP);
        List<Event> playedEvents = new ArrayList<>();

        //played events are added to the list then the score is calculated at the end of the game


        while (!time.isComplete()){
            Scanner myObj = new Scanner(System.in);

            System.out.println("You have " + time.getDays() + " day(s),  you have " + time.getHours() + " hours remaining and " + time.getEnergy() + " amount of energy" );
            System.out.println("enter an activity");
            int isComplete = 0;
            Event currentEvent = new Event();
            while(isComplete == 0){
                String event = myObj.nextLine();


                switch (event.toLowerCase()){
                    case "a":
                        currentEvent = event1;
                        isComplete = 1;
                        break;
                    case "b":
                        currentEvent = event2;
                        isComplete = 1;
                        break;
                    case "c":
                        currentEvent = event3;
                        isComplete = 1;
                        break;
                    case "d":
                        currentEvent = eatingA;
                        isComplete = 1;
                        break;
                    case "e":
                        currentEvent = eatingB;
                        isComplete = 1;
                        break;
                    case "f":
                        currentEvent = studying;
                        isComplete = 1;
                        break;
                    case "g":
                        currentEvent = studyCatchUp;
                        isComplete = 1;
                        break;
                    case "h":
                        currentEvent = sleep;
                        currentEvent.setEnergyCost(- time.getEnergy());
                        currentEvent.setTimeCost(time.getHours());
                        isComplete = 1;
                        break;
                    default:
                        System.out.println("invalid input");

                }

            }


            if(currentEvent != null){

                if(time.checkEvent(currentEvent.getTimeCost(), currentEvent.getEnergyCost())) {
                    time.event(currentEvent.getTimeCost(), currentEvent.getEnergyCost());
                    playedEvents.add(currentEvent);
                }
            }

        }
        System.out.println(playedEvents);
        int score = Score(playedEvents);
        System.out.println("Your score is " + score);

    }

    public static int Score(List<Event> playedEvents){
        int score = 0;
        int cumulativeEat = 1;
        int cumulativeSleep = 1;
        int studyCount = 0;
        int studyTotal = 0;
        double studyDebuff = 1;
        for(Event event : playedEvents ){
            switch (event.getEventType()){
                case EAT:
                    score += cumulativeEat;
                    cumulativeEat += cumulativeEat;
                    break;
                case SLEEP:
                    score += cumulativeSleep;
                    cumulativeSleep += cumulativeSleep;
                    break;
                case RECREATIONAL:
                    score += event.getEnjoymentStudyLevel();
                    break;
                case STUDY:
                    studyTotal += event.getEnjoymentStudyLevel();
                    studyCount += 1;
                    break;
                default:
                    score += 1;
                    break;

            }
            studyDebuff = - (studyCount * studyCount) + (28 * studyCount) - 150;



        }

        score += Math.round(studyDebuff * studyTotal);
        // score is calculated by the sum os study and events, subtracting fatigue and
        return score;
    }
}