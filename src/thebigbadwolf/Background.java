package thebigbadwolf;

import java.awt.Image;

public abstract class Background extends Place {
    // field
    private Image mBackgroundImage = null;
    public Image getBackgroundImage() {
        return this.mBackgroundImage;
    }
    
    // constructor
    protected Background(String name) {
        super(name);
        this.mBackgroundImage = this.loadBackgroundImage();
    }
    
    // abstract method
    protected abstract Image loadBackgroundImage();
    
    // method
    public void changeBackgroundTo(Background changedBg) {
        BBWTheater.getInstance().changeBgTo(changedBg);
    }
}
