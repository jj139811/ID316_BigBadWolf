package thebigbadwolf;

import java.awt.Image;

public abstract class Protagonist extends Animal{
    //field 
    protected Image mCeremonyImage = null;
    
    //constructor
    protected Protagonist(String name) {
        super(name);
        this.mCeremonyImage = this.loadCeremonyImage();
    }
    
    //method
    public abstract void ceremony();
    protected abstract Image loadCeremonyImage();
    
    
}
