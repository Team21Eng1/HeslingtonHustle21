package com.mygdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.HesHustle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

public class EventManager extends GameObject{
    Event event1,event2,event3,eatingA,eatingB,studying,studyCatchUp;
    Event curEvent = null;
    public Float TRaw,Twait;
    public Integer TSec, TMin;
    Integer day;
    List<Building> buildings;

    public EventManager(List<Building> buildings) {
        super(0,0,0,0);
        this.buildings = buildings;
        TRaw = 0.0f;
        TSec = 0;
        TMin = 8;
        Twait = 0f;
        day = 1;
        generateEvents();
    }
    public void generateEvents() {
        event1 = new Event( 1, 2, 10,-5,Event.type.RECREATIONAL, "",new Texture("Activitys/basketballcourt.png"));
        event2 = new Event( 1, 2,20,-10, Event.type.RECREATIONAL, 15, "",new Texture("Activitys/cs.png"));
        event3 = new Event(2, 2,50,10, Event.type.RECREATIONAL, 25, "",new Texture("Activitys/basketballcourt.png"));
        eatingA = new Event(1, -10, Event.type.EAT, "",new Texture("Activitys/basketballcourt.png"));
        eatingB = new Event(0.5, -5, Event.type.EAT, "",new Texture("Activitys/basketballcourt.png"));
        studying = new Event( 2.5 , 100, 10, 10, Event.type.STUDY, "",new Texture("Activitys/cs.png"));
        studyCatchUp = new Event( 5 , 200, 20, 20, Event.type.STUDY, "",new Texture("Activitys/basketballcourt.png"));

    }
    public void interact(String name)
    {
        Gdx.app.log("a","adsa");
        switch (name){
            default:
                curEvent = null;
                break;
            case "Nisa":
                curEvent = eatingA;
                Twait = 8f;
                break;
            case "Computer\nScience\nDepartment":
                curEvent = studying;
                Twait = 8f;
                break;
        }
    }
    @Override
    public void update(float deltaTime) {
        TRaw += deltaTime;
        Twait -= deltaTime;
        if (Twait<0)
        {
            curEvent = null;
        }
        if (TRaw >= 2){
            TSec++;
            TRaw = 0f;
        }
        if (TSec>=60){
            TSec = 0;
            TMin++;
        }

    }

    public String getTime()
    {
        String forTime = "";
        String z1 = "",z2 = "";
        if (TMin < 10) {z1="0";}
        if (TSec < 10) {z2="0";}

        return "Time: " + z1 +TMin + ":" + z2 +TSec;
    }


    public void render(Camera projection, HesHustle game, ShapeRenderer shape)
    {
        if(curEvent!=null){
            curEvent.render(projection, game, shape);
        }

    }


    /*
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
                        currentEvent = new Event(time.getHours(), - plCharacter.getEnergy(), Event.type.SLEEP, "");
                        isComplete = 1;
                        break;
                    default:
                        System.out.println("invalid input");

                }

            }

            // while this appears redundant, it is to catch any errors that may produce a current event = null
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
        */


}
