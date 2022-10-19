package thebigbadwolf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

public class BBWCanvas extends JPanel {
    // constants
    private static final Color COLOR_DESCRIPTION = new Color(0, 0, 0);
    private static final Font FONT_DESCRIPTION =
        new Font("monospaced", Font.PLAIN, 24);
    private static final int DESCRIPTION_ALIGNMENT_X = 400;
    private static final int DESCRIPTION_ALIGNMENT_Y = 300;
    
    
    // fields
    private BBWTheater mTheater = null;
    
    private Image mBackground = null;
    public void setBackground(Image bg) {
        this.mBackground = bg;
    }
    
    private String mDescription = null;
    public void setDescription(String description) {
        this.mDescription = description;
    }
    
    //constructor
    public BBWCanvas (BBWTheater theater) {
        this.mTheater = theater;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        // draw
        this.drawBackground(g2);
        this.drawPlayObjects(g2);
        this.drawDescription(g2);
    }
    
    private void drawBackground(Graphics2D g2) {
        if (this.mBackground != null) {
            g2.drawImage(this.mBackground, 0, 0, null);
        }
    }
    private void drawPlayObjects(Graphics2D g2) {
        for (PlayObject po: this.mTheater.getPlayObjectsInCurScene()) {
            g2.drawImage(po.getImage(),
                po.getPosition().x, po.getPosition().y, null);
        }
    }
    private void drawDescription(Graphics2D g2) {
        if (this.mDescription != null) {
            g2.setColor(BBWCanvas.COLOR_DESCRIPTION);
            g2.setFont(BBWCanvas.FONT_DESCRIPTION);
            g2.drawString(this.mDescription, BBWCanvas.DESCRIPTION_ALIGNMENT_X,
                BBWCanvas.DESCRIPTION_ALIGNMENT_Y);
        }
    }
}
