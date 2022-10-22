package thebigbadwolf;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpeachBubble extends BBWUI{
    // static fields
    private static Image mLeftBubbleImage = null;
    private static Image mMidBubbleImage = null;
    private static Image mRightBubbleImage = null;
    private static Image mBubblePointer = null;
    
    // fields
    private String mScript = null;
    
    // constructor
    public SpeachBubble(String script) {
        super(0, 0);
        initialize(script);
    }
    public SpeachBubble(String script, int x, int y) {
        super(x, y);
        initialize(script);
    }
    private void initialize(String script) {
        this.mScript = script;
        try {
            if (mLeftBubbleImage == null) {
                mLeftBubbleImage = ImageIO.read(
                new File("src/thebigbadwolf/resources/ui/bubble_left.png"));
            }
            if (mMidBubbleImage == null) {
                mMidBubbleImage = ImageIO.read(
                new File("src/thebigbadwolf/resources/ui/bubble_mid.png"));
            }
            if (mRightBubbleImage == null) {
                mRightBubbleImage = ImageIO.read(
                new File("src/thebigbadwolf/resources/ui/bubble_right.png"));
            }
            if (mBubblePointer == null) {
                mBubblePointer = ImageIO.read(
                new File("src/thebigbadwolf/resources/ui/bubble_pointer.png"));
            }
        } catch (IOException e) {
            System.out.println("cannot read image file: " + e.getMessage());
        }
    }
    
    private int getAnchorX() {
        int width = mMidBubbleImage.getWidth(null);
        int offsetX = -width * this.mScript.length() / 2;
        int bubbleOffsetX = 0;
        if (this.mPosition.x - mLeftBubbleImage.getWidth(null) + offsetX < 0) {
            bubbleOffsetX = -this.mPosition.x +
                mLeftBubbleImage.getWidth(null) - offsetX;
        }
        if (this.mPosition.x + width * this.mScript.length() + offsetX  + 
            mRightBubbleImage.getWidth(null) > BBWTheater.SCREEN_WIDTH) {
            bubbleOffsetX = -this.mPosition.x -
                width * this.mScript.length() - offsetX -
                mRightBubbleImage.getWidth(null) + BBWTheater.SCREEN_WIDTH;
        }
        return this.mPosition.x - mLeftBubbleImage.getWidth(null) + offsetX + 
            bubbleOffsetX;
    }
    private int getAnchorY() {
        int height = mMidBubbleImage.getHeight(null) / 2;
        return this.mPosition.y - height;
    }
    //methods
    @Override
    public void draw(Graphics2D g2) {
        int width = mMidBubbleImage.getWidth(null);
        int height = mMidBubbleImage.getHeight(null) / 2;
        g2.drawImage(mLeftBubbleImage,
            this.getAnchorX(), this.getAnchorY(), null);
        
        int i = 0;
        for (; i < this.mScript.length() + 1; i++) {
            g2.drawImage(mMidBubbleImage,
                this.getAnchorX() + width * i + mLeftBubbleImage.getWidth(null),
                this.getAnchorY(), null);
        }
        g2.drawImage(mRightBubbleImage,
            this.getAnchorX() + width * i + mLeftBubbleImage.getWidth(null),
            this.getAnchorY(), null);
        
        g2.drawImage(mBubblePointer,
            this.mPosition.x, this.mPosition.y + height, null);
        
        g2.setColor(BBWCanvas.COLOR_DESCRIPTION);
        g2.setFont(BBWCanvas.FONT_DESCRIPTION);
        g2.drawString(this.mScript,
            this.getAnchorX() + mLeftBubbleImage.getWidth(null),
            this.mPosition.y + BBWCanvas.FONT_DESCRIPTION.getSize() / 2);
    }
    
    public Rectangle getRectangle() {
        int x = this.getAnchorX();
        int y = this.getAnchorY();
        int rectWidth = mMidBubbleImage.getWidth(null) * this.mScript.length();
        int rectHeight = mMidBubbleImage.getHeight(null);
        return new Rectangle(x, y, rectWidth, rectHeight);
    }
}
