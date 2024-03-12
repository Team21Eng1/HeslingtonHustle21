import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // the primary gameplay loop involves performing activities each day, one of which must be studying
        Time time = new Time();
        // this declares all the events a player has, and no event other than sleep is modified at runtime
        Event event1 = new Event( 1, 2, 10,-5,Event.type.RECREATIONAL);
        Event event2 = new Event( 1, 2,20,-10, Event.type.RECREATIONAL, 15);
        Event event3 = new Event(2, 2,50,10, Event.type.RECREATIONAL, 25);
        Event eatingA = new Event(1, -10, Event.type.EAT);
        Event eatingB = new Event(0.5, -5, Event.type.EAT);
        Event studying = new Event( 2.5 , 100, 10, 10, Event.type.STUDY);
        Event studyCatchUp = new Event( 5 , 200, 20, 20, Event.type.STUDY);
        PlayerCharacter plCharacter = new PlayerCharacter();
        List<Event> playedEvents = new ArrayList<>();

        //played events are added to the list then the score is calculated at the end of the game

        System.out.println("enter a name");
        String name = input();


        while (!time.isComplete()){

            // by replacing outputs with functions, it becomes easier to modify code to suit specific engines
            statusOutput( time,  plCharacter);
            int isComplete = 0;
            Event currentEvent = new Event();
            while(isComplete == 0){
                String event = input();
                // the switch statement uses placeholder names, however they can be named anything and it will not affect code operation
                switch (event.toLowerCase()){
                    case "a":
                        currentEvent = event1;
                        isComplete = 1;
                        break;
                    case "b":
                        currentEvent = event2;
                        if(plCharacter.getMoney() - currentEvent.getMoneyCost() > 0){
                            isComplete = 1;
                            plCharacter.addMoney(- currentEvent.getMoneyCost());
                        }
                        break;
                    case "c":
                        currentEvent = event3;
                        if(plCharacter.getMoney() - currentEvent.getMoneyCost() > 0){
                            isComplete = 1;
                            plCharacter.addMoney(- currentEvent.getMoneyCost());
                        }
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
                        currentEvent = new Event(time.getHours(), - plCharacter.getEnergy(), Event.type.SLEEP);
                        isComplete = 1;
                        break;
                    default:
                        System.out.println("invalid input");

                }

            }


            if(currentEvent != null){

                if(time.checkTime(currentEvent.getTimeCost()) && plCharacter.checkEnergy(currentEvent.getEnergyCost())) {
                    time.decreaseHours(currentEvent.getTimeCost());
                    plCharacter.decreaseEnergy(currentEvent.getEnergyCost());
                    if(time.getHours() == 0 ){
                        time.resetHours();
                        time.decreaseDays();
                    } else if (plCharacter.getEnergy() == 0) {
                        plCharacter.resetEnergy();
                        time.decreaseDays();

                    }


                    playedEvents.add(currentEvent);
                }
            }

        }
        System.out.println(playedEvents);
        int score = Score(playedEvents);
        System.out.println("Your score is " + score);

        File file = new File("scores.txt");
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("scores.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            myWriter.write(name + " score: " + score + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static int Score(List<Event> playedEvents) {
        int score = 0;
        int cumulativeEat = 1;
        int cumulativeSleep = 1;
        int studyCount = 0;
        int studyTotal = 0;
        int recCount = 0;
        int recTotal = 0;
        double studyDebuff = 1;
        double recDebuff = 1;
        for (Event event : playedEvents) {
            switch (event.getEventType()) {
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
                    recCount += 1;
                    break;
                case STUDY:
                    studyTotal += event.getEnjoymentStudyLevel();
                    studyCount += 1;
                    break;
                default:
                    score += 1;
                    break;

            }
            studyDebuff = -(studyCount * studyCount) + (28 * studyCount) - 150;
            recDebuff = (double) 140 / (recCount * recCount);
        }

        score += (int) Math.round(studyDebuff * studyTotal);
        score += (int) Math.round(recDebuff * recTotal);
        // score is calculated by the sum os study and events, subtracting fatigue and
        return score;
    }

    public static String input(){
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }

    public static void statusOutput(Time time, PlayerCharacter plCharacter){
        System.out.println("You have " + time.getDays() + " day(s),  you have " + time.getHours() + " hours remaining and " + plCharacter.getEnergy() + " amount of energy" );
        System.out.println("enter an activity");

    }


}