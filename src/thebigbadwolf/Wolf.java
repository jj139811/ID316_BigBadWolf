package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;

public class Wolf extends Animal{
    //constant
    public static final int CLIMB_DISTANCE = 200;
    public static final int SNUGGLE_DISTANCE = 100;
    public static final int JUMPOUT_DISTANCE = 300;
    public static final int CHASE_DISTANCE = 70;
    public static final int ATTACK_DISTANCE = 50;
    
    public static final Image WOLF_DEFAULT = null;
    public static final Image WOLF_FAIRY = null;
    public static final Image WOLF_GRANDMA = null;
    
    //constructor
    protected Wolf(String name) {
        super(name);
    }
    
    //method
    public void climb(PlayObject po) {
        String s = this.getName() + " climbs the " + po.getName() + ".";
        theater.showDescription(s);
        Point climbPosition = new Point();
        climbPosition.x = po.getPosition().x;
        climbPosition.y = po.getPosition().y - CLIMB_DISTANCE;
        super.setPosition(climbPosition);
    }
    
    public void reveal() {
        String s = this.getName() + "'s disguise reveals.";
        theater.showDescription(s);
        this.setImage(WOLF_DEFAULT);
    }
    
    public void snuggle(PlayObject po) {
        String s = this.getName() + " snuggles among the " + po.getName() + ".";
        theater.showDescription(s);
        Point snugglePosition = new Point();
        snugglePosition.setLocation(super.getPosition());
        snugglePosition.x = po.getPosition().x;
        snugglePosition.y = po.getPosition().y - SNUGGLE_DISTANCE;
        super.setPosition(snugglePosition);
    }
    
    public void jumpOut() {
        String s = this.getName() + " jumps out.";
        theater.showDescription(s);
        Point jumpOutPosition = new Point();
        jumpOutPosition.x -= 0;
        jumpOutPosition.y -= JUMPOUT_DISTANCE;
        super.setPosition(jumpOutPosition);
    }
    
    public void wear(Cloth c) {
        String s = this.getName() + " wears " + c.getName() + ".";
        theater.showDescription(s);
        //change image with cloth 
        String clothName = c.getName();
        switch (clothName) {
            case "fairy": 
                this.setImage(WOLF_FAIRY);
                break;
            case "grandma": 
                this.setImage(WOLF_GRANDMA);
                break;
        }    
    }
    
    public void chase(PlayObject po) {
        String s = this.getName() + " chases " + po.getName() + ".";
        theater.showDescription(s);
        Point chasePosition = new Point();
        chasePosition.x = po.getPosition().x + CHASE_DISTANCE;
        chasePosition.y = po.getPosition().y;
        super.setPosition(chasePosition);
    }
    
    public void attack(PlayObject po) {
        String s = this.getName() + " attacks " + po.getName() + ".";
        theater.showDescription(s);
        Point attackPosition = new Point();
        attackPosition.x = po.getPosition().x - ATTACK_DISTANCE;
        attackPosition.y = po.getPosition().y;
        super.setPosition(attackPosition);
    }
    
    public void dive(PlayObject po) {
        String s = this.getName() + " dives into " + po.getName() + ".";
        theater.showDescription(s);
        Point divePosition = new Point();
        divePosition.x = po.getPosition().x;
        divePosition.y = po.getPosition().y;
        super.setPosition(divePosition);
    }
}
