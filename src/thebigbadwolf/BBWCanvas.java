package thebigbadwolf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JPanel;

public class BBWCanvas extends JPanel {
    // constants
    public static final Color COLOR_DESCRIPTION = new Color(0, 0, 0);
    public static final Font FONT_DESCRIPTION =
        new Font("monospaced", Font.PLAIN, 24);
    public static final int DESCRIPTION_ALIGNMENT_X = 200;
    public static final int DESCRIPTION_ALIGNMENT_Y = 500;
    
    // fields
    private BBWTheater mTheater = null;
    
    private Image mBackground = null;
    public void setBackground(Image bg) {
        this.mBackground = bg;
    }
    
    private ArrayList<String> mDescriptions = null;
    public void setDescription(String description) {
        this.mDescriptions.add(description);
    }
    public void clearDescription() {
        this.mDescriptions.clear();
    }
    
    private ArrayList<SpeachBubble> mSpeachBubbles = null;
    
    //constructor
    public BBWCanvas (BBWTheater theater) {
        this.mTheater = theater;
        this.mSpeachBubbles = new ArrayList<>();
        this.mDescriptions = new ArrayList<>();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("paintComponent called");
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        // draw
        this.drawBackground(g2);
        this.drawPlayObjects(g2);
        this.drawDescription(g2);
        this.drawSpeachBubbles(g2);
    }
    
    private void drawBackground(Graphics2D g2) {
        if (this.mBackground != null) {
            g2.drawImage(this.mBackground, 0, 0, null);
        }
    }
    private void drawPlayObjects(Graphics2D g2) {
        for (PlayObject po: this.mTheater.getPlayObjectsInCurScene()) {
            g2.drawImage(po.getImage(),
                po.getPosition().x - po.getWidth() / 2,
                po.getPosition().y - po.getHeight() / 2,
                po.getWidth(), po.getHeight(), null);
        }
    }
    private void drawDescription(Graphics2D g2) {
        for (int i = 0; i < this.mDescriptions.size(); i++) {
            String description = this.mDescriptions.get(i);
            if (description != null) {
                g2.setColor(BBWCanvas.COLOR_DESCRIPTION);
                g2.setFont(BBWCanvas.FONT_DESCRIPTION);
                g2.drawString(description,
                    BBWCanvas.DESCRIPTION_ALIGNMENT_X,
                    BBWCanvas.DESCRIPTION_ALIGNMENT_Y + 
                        BBWCanvas.FONT_DESCRIPTION.getSize() * i);
            }
        }
    }
    private void drawSpeachBubbles(Graphics2D g2) {
        for (SpeachBubble bubble: this.mSpeachBubbles) {
            bubble.draw(g2);
        }
    }
    
    // public methods
    public void addSpeachBubble(String script, int x, int y) {
        this.mSpeachBubbles.add(
            new SpeachBubble(script, x, y));
    }
    public void clearSpeachBubbles() {
        this.mSpeachBubbles.clear();
    }
}
