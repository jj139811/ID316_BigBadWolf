package thebigbadwolf;

import java.awt.Image;

public class BrickHouse extends House {
    //constructor
    public BrickHouse(String name) {
        super(name);
    }
    
    //method
    @Override
    protected Image loadBackgroundImage() {
        return this.loadImage("bg/bg_brick_house");
    }
}
