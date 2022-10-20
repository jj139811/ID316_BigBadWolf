package thebigbadwolf;

import java.awt.Image;

public class Popcorn extends PlayObject {
    //constructor
    public Popcorn(String name) {
        super(name);
    }
    
    //method
    public void explode() {
        String s = this.getName() + " explodes.";
        System.out.println(s);
        Image imageToChange = null;
        this.setImage(imageToChange);
    }
}
