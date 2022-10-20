
package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Place extends PlayObject {
    //constants
    private static final int DISTANCE_BETWEEN_MEMBERS = 50;
    private static final int DISTANCE_BELOW_PLACE = 30;
    //field
    ArrayList<PlayObject> mMembers = new ArrayList<PlayObject>();
    public ArrayList<PlayObject> getmembers() {
        return this.mMembers;
    }  
    
    //constructor
    protected Place(String name) {
        super(name);
    }
    
    //method
    public void add(PlayObject po) {
        this.mMembers.add(po);
        this.rearrangeMembers();
    }
    
    private void rearrangeMembers() {
        for (int i = 0; i < this.mMembers.size(); i++) {
            PlayObject po = this.mMembers.get(i);
            po.setPosition(new Point(
                this.getPosition().x +
                (this.mMembers.size() / 2 + i) * DISTANCE_BETWEEN_MEMBERS,
                this.getPosition().y + DISTANCE_BELOW_PLACE));
        }
    }
    
    public void remove(PlayObject po) {
        this.mMembers.remove(po);
        this.rearrangeMembers();
    }

    @Override
    protected Image callImage() {
        String fileName = null;
        switch (this.getName()) {
            case "closet":
                fileName = "closet";
                break;
            case "bed":
                fileName = "bed";
                break;
            case "tree":
                fileName = "tree";
                break;
        }
        return this.loadImage(fileName);
    }
     
}
