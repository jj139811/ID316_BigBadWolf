package thebigbadwolf;

import java.awt.Image;

public class RedRidingHood extends Human {
    
    //constructor
    protected RedRidingHood(String name) {
        super(name);
    }
    
    //method
    @Override
    public void ceremony() {
        String s = this.getName() + "plays piano.";
        System.out.println(s);
        Image imageToChange = null;
        this.setImage(imageToChange);
    }
}
