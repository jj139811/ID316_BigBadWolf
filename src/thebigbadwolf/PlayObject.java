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
    
    private int mImageWidth = 0;
    private int mImageHeight = 0;
    public int getWidth() {
        return this.mImageWidth;
    }
    public int getHeight() {
        return this.mImageHeight;
    }
    public void setSize(int width, int height) {
        this.mImageWidth = width;
        this.mImageHeight = height;
    }
    
    protected Image mImage = null;
    public Image getImage() {
        return this.mImage;
    }
    public void setImage(Image imageToChange) {
        this.mImage = imageToChange;
    }
    
    protected Image mDefaultImage = null;
    public Image getDefaultImage() {
        return this.mDefaultImage;
    }
    
    //protected constructor 
    protected PlayObject(String name) {
        this.mName = name;
        this.mDefaultImage = this.callImage();
        this.setImage(this.mDefaultImage);
        this.mImageWidth = this.mDefaultImage.getWidth(null) / 2;
        this.mImageHeight = this.mDefaultImage.getHeight(null) / 2;
        this.setPosition(new Point(0, 0));
    }
    
    protected abstract Image callImage();
    
    protected Image loadImage(String fileName) {
        try {
            return ImageIO.read(
                new File("src/thebigbadwolf/resources/" + fileName + ".png"));
        }   catch (IOException e) {
            try {
                return ImageIO.read(
                    new File("src/thebigbadwolf/resources/sample.png"));
            }   catch (IOException e2) { 
                System.out.println(e.getMessage());
                return null;
            }
        }
    }
}
