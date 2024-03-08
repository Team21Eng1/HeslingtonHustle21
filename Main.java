import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // the primary gameplay loop involves performing activities each day, one of which must be studying
        TimeEnergy time = new TimeEnergy();
        // rather than use the predefined constants, new values can be used, since they are not modified at runtime
        Event event1 = new Event( EventConstants.eventATime, EventConstants.eventAEnergy);
        Event event2 = new Event( EventConstants.eventBTime, EventConstants.eventBEnergy);
        Event event3 = new Event(EventConstants.eventCTime, EventConstants.eventCEnergy);
        Event eatingA = new Event(1, -10);
        Event eatingB = new Event(0.5, -5);
        Event studying = new Event( 2.5 , 100, 10, 0, true);
        Event studyCatchUp = new Event( 5 , 200, 20, 20, true);
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

    }

    public int Score(List<Event> playedEvents){
        int score = 0;
        return score;
    }
}