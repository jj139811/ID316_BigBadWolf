package thebigbadwolf;

import java.awt.Image;

public class Forest extends Background {
    //constructor
    public Forest(String name) {
        super(name);
    }
    
    //method
    @Override
    protected Image loadBackgroundImage() {
        return this.loadImage("bg/bg_forest");
    }
}
