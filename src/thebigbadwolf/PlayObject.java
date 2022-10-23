package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class PlayObject {
    // fields
    private String mName = null;
    public String getName() { 
        return this.mName;
    }
    
    private Place mCurPlace = null;
    public Place getCurPlace() {
        return this.mCurPlace;
    }
    public void setCurPlace(Place place) {
        this.mCurPlace = place;
    }
    
    private Point mPosition = null;
    public Point getPosition() {
        return this.mPosition;      
    }
    public void setPosition(Point targetPosition) {
        this.mPosition = targetPosition;
        if (this.mSomehting != null) {
            this.mSomehting.setPosition(targetPosition);
        }
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
    public void setToDefaultImage() {
        this.setImage(this.mDefaultImage);
    }
    
    protected Image mDefaultImage = null;
    public Image getDefaultImage() {
        return this.mDefaultImage;
    }
    
    private PlayObject mSomehting = null;
    public void putSomethingIn(PlayObject something) {
        this.mSomehting = something;
        something.setPosition(this.mPosition);
    }
    
    // protected constructor 
    protected PlayObject(String name) {
        this.mName = name;
        this.mDefaultImage = this.callImage();
        this.setImage(this.mDefaultImage);
        this.mImageWidth = this.mDefaultImage.getWidth(null) / 3;
        this.mImageHeight = this.mDefaultImage.getHeight(null) / 3;
        this.setPosition(new Point(0, 0));
    }
    
    // abstract method
    protected abstract Image callImage();
    
    // method
    protected Image loadImage(String fileName) {
        try {
            return ImageIO.read(
                new File("src/thebigbadwolf/resources/" + fileName + ".png"));
        } catch (IOException e) {
            try {
                return ImageIO.read(
                    new File("src/thebigbadwolf/resources/sample.png"));
            } catch (IOException e2) { 
                System.out.println(e.getMessage());
                return null;
            }
        }
    }
}