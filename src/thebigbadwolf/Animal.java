package thebigbadwolf;

import java.awt.Point;


public abstract class Animal extends PlayObject {
    //constant
    public static final int SNEAK_DISTANCE = 100;
    public static final int RUN_DISTANCE = 500;
    public static final int OPEN_DISTANCE = -20;
    
    //fields
    BBWTheater theater = null;
    
    //constructor
    protected Animal(String name) {
        super(name);
        this.theater = BBWTheater.getInstance();
    }
    
    //method
    public void walkTo(PlayObject po) {
        String s = this.getName() + " walk to " + po.getName() + ".";
        System.out.println(s);
        Point sneakPosition = new Point();
        sneakPosition.x = po.getPosition().x;
        sneakPosition.y = po.getPosition().y;
        super.setPosition(sneakPosition);
    }
    
    public void say(String something) {
        theater.say(this, something);
    }
    
    public void sneak(PlayObject po) {
        String s = this.getName() + " sneaks to " + po.getName() + ".";
        theater.showDescription(s);
        Point sneakPosition = new Point();
        sneakPosition.x = po.getPosition().x - SNEAK_DISTANCE;
        sneakPosition.y = po.getPosition().y;
        super.setPosition(sneakPosition);
    }
    
    public void runaway() {
        String s = this.getName() + " runs away.";
        theater.showDescription(s);
    }
    
    public void run(PlayObject po) {
        String s = this.getName() + " run to " + po.getName() + ".";
        theater.showDescription(s);
        Point runPosition = new Point();
        runPosition.x = po.getPosition().x - RUN_DISTANCE;
        runPosition.y = po.getPosition().y;
        super.setPosition(runPosition);
    }
    
    public void open(PlayObject po) {
        String s = this.getName() + " opens " + po.getName() + ".";
        theater.showDescription(s);
        Point openPosition = new Point();
        openPosition.x = po.getPosition().x - OPEN_DISTANCE;
        openPosition.y = po.getPosition().y;
        super.setPosition(openPosition);
    }
    
    
}
