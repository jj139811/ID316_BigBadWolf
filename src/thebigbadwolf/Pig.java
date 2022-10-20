package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

    @Override
    protected Image callImage() {
        String fileName = null;
        switch (this.getName()) {
            case "adam":
                fileName = "pig1_default";
                break;
            case "brian":
                fileName = "pig2_default";
                break;
            case "chris":
                fileName = "pig3_default";
                break;
        } 
        try {
            return ImageIO.read(
                new File("src/thebigbadwolf/resources/" + fileName + ".png"));
        }   catch (IOException e) { 
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    protected Image loadCeremonyImage() {
        String fileName = null;
        switch (this.getName()) {
            case "adam":
                fileName = "pig1_flute";
                break;
            case "brian":
                fileName = "pig2_fiddle";
                break;
            case "chris":
                fileName = "pig3_makePianoWork";
                break;
        } 
        return this.loadImage(fileName);
    }
    
}
