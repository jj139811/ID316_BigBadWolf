package thebigbadwolf;

import java.awt.Point;


public abstract class Animal extends PlayObject {
    //constant
    public static final int SNEAK_DISTANCE = 100;
    public static final int RUN_DISTANCE = 500;
    public static final int OPEN_DISTANCE = -20;
    
    //constructor
    protected Animal(String name) {
        super(name);
    }
    
    //method
    public void walkTo(PlayObject po) {
        Point sneakPosition = new Point();
        sneakPosition.x = po.getPosition().x;
        sneakPosition.y = po.getPosition().y;
        super.setPosition(sneakPosition);
        
        String s = this.getName() + " walks to " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void say(String something) {
        BBWTheater.getInstance().say(this, something);
        String s = this.getName() + " says: \"" + something + "\"";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void sneak(PlayObject po) {
        Point sneakPosition = new Point();
        sneakPosition.x = po.getPosition().x - SNEAK_DISTANCE;
        sneakPosition.y = po.getPosition().y;
        super.setPosition(sneakPosition);
        
        String s = this.getName() + " sneaks to " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void runaway() {
        String s = this.getName() + " runs away.";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void run(PlayObject po) {
        Point runPosition = new Point();
        runPosition.x = po.getPosition().x - RUN_DISTANCE;
        runPosition.y = po.getPosition().y;
        super.setPosition(runPosition);
        
        String s = this.getName() + " run to " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void open(PlayObject po) {
        Point openPosition = new Point();
        openPosition.x = po.getPosition().x - OPEN_DISTANCE;
        openPosition.y = po.getPosition().y;
        super.setPosition(openPosition);
        
        String s = this.getName() + " opens " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    
}
