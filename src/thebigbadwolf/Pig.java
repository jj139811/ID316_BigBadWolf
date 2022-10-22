package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pig extends Protagonist {
    //field
    public static final Point houseBuildingPoint = new Point(600,300);
    
    //constructor
    protected Pig(String name) {
        super(name);
    }
    
    //method
    @Override
    public void ceremony() {
        String s = this.getName();
        switch (this.getName()) {
            case "adam":
                s = s + " plays his flute.";
                break;
            case "brian":
                s = s + " plays his fiddle.";
                break;
            case "chris":
                s = s + " makes piano work.";
                break;
        }
        BBWTheater.getInstance().showDescription(s);
        this.setImage(this.mCeremonyImage);
    }
    
    public void buildHouse() {
        this.setImage(this.loadImage("pig3_buildhouse"));
        String s = this.getName() + " builds brickhouse.";
        BBWTheater.getInstance().showDescription(s);
        this.setPosition(houseBuildingPoint);
    }
    
    public void sing() {
       String s = this.getName() + " sings.";
       BBWTheater.getInstance().showDescription(s);
    }
    
    public void put(PlayObject what, PlayObject where) {
        where.putSomethingIn(what);
        String s = this.getName() + " puts " + what + " into " + where + ".";
        BBWTheater.getInstance().showDescription(s);
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
