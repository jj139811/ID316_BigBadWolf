package thebigbadwolf;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DescriptionPanel extends BBWUI{
    // field
    private static Image mImage = null;
    
    // constructor
    public DescriptionPanel(int x, int y) {
        super(x, y);
        if (mImage == null) {
            try {
                mImage = ImageIO.read(new File(
                    "src/thebigbadwolf/resources/ui/panel.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    // overridden method from BBWUI
    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(mImage, this.getPosition().x, this.getPosition().y, null);
    }
}
