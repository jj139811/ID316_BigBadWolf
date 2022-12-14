package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;

public class Wolf extends Animal {
    // constants
    public static final int CLIMB_DISTANCE = 200;
    public static final int SNUGGLE_DISTANCE = 100;
    public static final int JUMPOUT_DISTANCE = 300;
    public static final int CHASE_DISTANCE = 70;
    public static final int ATTACK_DISTANCE = 50;
    
    public static Image WOLF_FAIRY = null;
    public static Image WOLF_GRANDMA = null;
    
    // constructor
    public Wolf(String name) {
        super(name);
        WOLF_FAIRY = this.loadImage("wolf_fairy");
        WOLF_GRANDMA = this.loadImage("wolf_grandma");
    }
    
    // methods
    public void climb(PlayObject po) {
        Point climbPosition = new Point();
        climbPosition.x = po.getPosition().x;
        climbPosition.y = po.getPosition().y - CLIMB_DISTANCE;
        super.setPosition(climbPosition);
        
        String s = this.getName() + " climbs the " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void reveal() {
        this.setImage(this.mDefaultImage);
        
        String s = this.getName() + "'s disguise reveals.";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void snuggle(PlayObject po) {
        Point snugglePosition = new Point();
        snugglePosition.setLocation(super.getPosition());
        snugglePosition.x = po.getPosition().x;
        snugglePosition.y = po.getPosition().y - SNUGGLE_DISTANCE;
        super.setPosition(snugglePosition);
        
        String s = this.getName() + " snuggles among the " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void jumpOut() {
        Point jumpOutPosition = new Point(this.getPosition().x, 
            this.getPosition().y);
        jumpOutPosition.x -= 0;
        jumpOutPosition.y -= JUMPOUT_DISTANCE;
        super.setPosition(jumpOutPosition);
        
        String s = this.getName() + " jumps out.";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void wear(Cloth c) {
        String clothName = c.getName();
        switch (clothName) {
            case "fairy": 
                this.setImage(WOLF_FAIRY);
                break;
            case "grandma": 
                this.setImage(WOLF_GRANDMA);
                break;
        }
        
        String s = this.getName() + " wears " + c.getName() + "'s clothes.";
        BBWTheater.getInstance().showDescription(s); 
    }
    
    public void chase(PlayObject po) {
        Point chasePosition = new Point();
        chasePosition.x = po.getPosition().x + CHASE_DISTANCE;
        chasePosition.y = po.getPosition().y;
        super.setPosition(chasePosition);
        
        String s = this.getName() + " chases " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void attack(PlayObject po) {
        Point attackPosition = new Point();
        attackPosition.x = po.getPosition().x - ATTACK_DISTANCE;
        attackPosition.y = po.getPosition().y;
        super.setPosition(attackPosition);
        
        String s = this.getName() + " attacks " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    public void dive(PlayObject po) {
        Point divePosition = new Point();
        divePosition.x = po.getPosition().x;
        divePosition.y = po.getPosition().y;
        super.setPosition(divePosition);
        
        String s = this.getName() + " dives into " + po.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    // overridden method from Animal
    @Override
    protected Image callImage() {
        String fileName = "wolf_default";
        return this.loadImage(fileName);
    }
}
