package thebigbadwolf;

import java.awt.Image;
import java.io.IOException;

public class Background extends Place {
    //field
    BBWTheater theater = BBWTheater.getInstance();
    private Image mBackgroundImage = null;
    
    //constructor
    protected Background(String name) {
        super(name);
        
        String fileName = "bg/bg_" + name;
        this.mBackgroundImage = this.loadImage(fileName);
    }
    
    //method
    public void changeBackgroundTo(Background changedBg) {
        theater.changeBgTo(changedBg);
    }
}
