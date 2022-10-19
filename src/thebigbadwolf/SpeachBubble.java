package thebigbadwolf;

import java.awt.Graphics2D;
import java.awt.Image;
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
    
    
    //methods
    @Override
    public void draw(Graphics2D g2) {
        System.out.println("width: " + mLeftBubbleImage.getWidth(null));
        int width = mMidBubbleImage.getWidth(null);
        int height = mMidBubbleImage.getHeight(null) / 2;
        int offsetX = -width * this.mScript.length() / 2;
        g2.drawImage(mLeftBubbleImage,
            this.mPosition.x - mLeftBubbleImage.getWidth(null) + offsetX,
            this.mPosition.y - height, null);
        
        int i = 0;
        for (; i < this.mScript.length() + 1; i++) {
            g2.drawImage(mMidBubbleImage,
                this.mPosition.x + width * i + offsetX,
                this.mPosition.y - height, null);
        }
        g2.drawImage(mRightBubbleImage,
                this.mPosition.x + width * i + offsetX,
                this.mPosition.y - height, null);
        
        g2.drawImage(mBubblePointer,
            this.mPosition.x, this.mPosition.y + height, null);
        
        g2.setColor(BBWCanvas.COLOR_DESCRIPTION);
        g2.setFont(BBWCanvas.FONT_DESCRIPTION);
        g2.drawString(this.mScript, this.mPosition.x + offsetX,
            this.mPosition.y + BBWCanvas.FONT_DESCRIPTION.getSize() / 2);
    }
}
