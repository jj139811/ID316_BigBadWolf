package thebigbadwolf;

import java.awt.Image;

public class Popcorn extends PlayObject {
    // field
    private Image explodedPopcorn = null;
    
    // constructor
    public Popcorn(String name) {
        super(name);
        explodedPopcorn = this.loadImage("popcorn_exploded");
    }
    
    // method
    public void explode() {
        Image imageToChange = this.explodedPopcorn;
        this.setImage(imageToChange);
        
        String s = this.getName() + " explodes.";
        BBWTheater.getInstance().showDescription(s);
    }
    
    // overridden method from PlayObject
    @Override
    protected Image callImage() {
        return this.loadImage("popcorn_default");
    }
}
