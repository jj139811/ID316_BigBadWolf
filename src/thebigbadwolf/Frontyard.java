package thebigbadwolf;

import java.awt.Image;

public class Frontyard extends Background {
    //constructor
    public Frontyard(String name) {
        super(name);
    }
    
    //method
    @Override
    protected Image loadBackgroundImage() {
        return this.loadImage("bg/bg_frontyard");
    }
}
