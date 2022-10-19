package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;

public abstract class PlayObject {
    //fields
    private String mName = null;
    public String getName() { 
        return this.mName;
    }
    
    private Place mCurPlace = null;
    public Place getCurPlace() {
        return this.mCurPlace;
    }
    
    private Point mPosition = null;
    public Point getPosition() {
        return this.mPosition;      
    }
    public void setPosition(Point targetPosition) {
        this.mPosition = targetPosition;
    }
    
    private Image mImage = null;
    public Image getImage() {
        return this.mImage;
    }
    public void setImage(Image imageToChange) {
        this.mImage = imageToChange;
    }
    
    //protected constructor 
    protected PlayObject(String name) {
        this.mName = name;
    }  
    

}
