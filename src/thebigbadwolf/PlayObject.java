package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class PlayObject {
    //field
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
    
    protected Image mImage = null;
    public Image getImage() {
        return this.mImage;
    }
    public void setImage(Image imageToChange) {
        this.mImage = imageToChange;
    }
    
    //protected constructor 
    protected PlayObject(String name) {
        this.mName = name;
        this.mImage = this.callImage();
        
    }  
    
    protected abstract Image callImage();
    
    protected Image loadImage(String fileName) {
        try {
            return ImageIO.read(
                new File("src/thebigbadwolf/resources/" + fileName + ".png"));
        }   catch (IOException e) { 
            System.out.println(e.getMessage());
            return null;
        }
    }
}
