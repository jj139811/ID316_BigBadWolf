package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;

public class Pig extends Protagonist {
    //constructor
    protected Pig(String name) {
        super(name);
    }
    
    //method
    @Override
    //???????????????????????????
    public void ceremony() {
        Image imageToChange = null;
        this.setImage(imageToChange);
    }
    
    public void buildHouse() {
       String s = this.getName() + " builds brickhouse.";
       System.out.println(s);
       Image imageToChange = null;
       this.setImage(imageToChange);
    }
    
    public void sing() {
       String s = this.getName() + " sings.";
       System.out.println(s);
    }
    
    public void put(PlayObject what, PlayObject where) {
       String s = this.getName() + " puts " + what.getName() + "into" + where.getName() + " .";
       System.out.println(s);
       Point targetPosition = new Point();
       targetPosition.x = where.getPosition().x;
       targetPosition.y = where.getPosition().y - 10;
       what.setPosition(targetPosition);
    }
    
}
