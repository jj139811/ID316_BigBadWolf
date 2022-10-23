package thebigbadwolf;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RedRidingHood extends Human {
    // constructor
    public RedRidingHood(String name) {
        super(name);
    }
    
    // overridden methods from Human
    @Override
    public void ceremony() {
        this.setImage(this.mCeremonyImage);
        
        String s = this.getName() + " plays piano.";
        BBWTheater.getInstance().showDescription(s);
    }

    @Override
    protected Image callImage() {
        String fileName = "redridinghood_default";
        return this.loadImage(fileName);
    }
    @Override
    protected Image loadCeremonyImage() {
        String fileName = "redridinghood_piano";
        try {
            return ImageIO.read(
                new File("src/thebigbadwolf/resources/" + fileName + ".png"));
        }   catch (IOException e) { 
            System.out.println(e.getMessage());
            return null;
        }
    }
}
