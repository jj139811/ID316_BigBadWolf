package thebigbadwolf;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class BBWTheater extends Thread implements MouseListener{
    // Singleton
    private static BBWTheater instance = null;
    public static BBWTheater getInstance () {
        if (instance == null) {
            instance = new BBWTheater();
        }
        return instance;
    }
    
    //constants
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    
    // test static field
    private static Image defaultImage = null;
    
    //fields
    private JFrame mFrame = null;
    private BBWCanvas mBBWCanvas = null;
    
    private boolean mWaitingForNextButton = true;
    
    private ArrayList<PlayObject> mPlayObjectsInCurScene = null;
    public ArrayList<PlayObject> getPlayObjectsInCurScene() {
        return this.mPlayObjectsInCurScene;
    }
    
    public BBWTheater () {
        //initiallize
        this.mFrame = new JFrame("Big Bad Wolf");
        this.mFrame.setSize(BBWTheater.SCREEN_WIDTH, BBWTheater.SCREEN_HEIGHT);
        this.mFrame.setVisible(true);
        this.mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // initialize fields
        this.mPlayObjectsInCurScene = new ArrayList<>();
        
        // initiallize and add canvas to JFrame
        this.mBBWCanvas = new BBWCanvas(this);
        this.mFrame.add(this.mBBWCanvas);
        
        // add listeners
        this.mBBWCanvas.addMouseListener(this);
        
        this.mBBWCanvas.setFocusable(true);
        this.mFrame.setResizable(false);
        
        this.mBBWCanvas.repaint();
        
        // Test code
        try {
            this.defaultImage = ImageIO.read(
                new File("src/thebigbadwolf/resources/sample.png"));
        } catch (IOException e) {
            System.out.println("Image read failed: " + e.getMessage());
        }
    }
    private void waitForNextButton() {
        this.mWaitingForNextButton = true;
        this.mBBWCanvas.repaint();
        while (this.mWaitingForNextButton) {
            Thread.yield();
        }
        this.mBBWCanvas.clearSpeachBubbles();
    }
    @Override
    public void run() {
        // initiallize
        Pig firstPig = new Pig("adam");
        Pig secondPig = new Pig("brian");
        Pig thirdPig = new Pig("chris");
        Grandma grandma = new Grandma("grandma");
        RedRidingHood redRidingHood = new RedRidingHood("red riding hood");
        Wolf wolf = new Wolf("wilson");
        BrickHouse brickHouse = new BrickHouse("brickhouse");
        Popcorn popcorn = new Popcorn("popcorn");
        Forest forest = new Forest("forest");
        Frontyard frontyard = new Frontyard("frontyard");
        GrandmaHouse grandmaHouse = new GrandmaHouse("grandma's house");
        Cloth wolfPants = new Cloth("wolf's pants");
        Place closet = new Place("closet");
        Place tree = new Place("tree");
        Place bed = new Place("bed");
        
        frontyard.setPosition(new Point(100, 400));
        
        this.addToScene(firstPig);
        this.addToScene(secondPig);
        this.addToScene(thirdPig);
        this.addToScene(redRidingHood);
        this.changeBgTo(frontyard);
       
        
        
        // run scripts
        this.say(firstPig, "Hello!");
        this.showDescription("Wilson is a pig");
        this.waitForNextButton();
        
        this.say(firstPig, "I'm Wilson!");
        
        this.showDescription("And this is a test script");
        this.waitForNextButton();
        
        this.say(firstPig, "I'm a test pig!");
        this.showDescription("good!");
        this.waitForNextButton();
    }
    
    public void say(PlayObject speaker, String script) {
        System.out.println (speaker.getName() + " says: " + script);
        this.mBBWCanvas.addSpeachBubble(script,
            speaker.getPosition().x,
            speaker.getPosition().y - 100);
    }
    public void showDescription(String script) {
        this.mBBWCanvas.setDescription(script);
        System.out.println(script);
    }
    public void changeBgTo(Background background) {
        this.mBBWCanvas.setBackground(background.getBackgroundImage());
        for (PlayObject po: this.mPlayObjectsInCurScene) {
            if (po != background) {
                background.add(po);
            }
        }
        System.out.println("Background changed to " + background.getName());
    }
    public void addToScene(PlayObject po) {
        this.mPlayObjectsInCurScene.add(po);
    }
    public void removeFromScene(PlayObject po) {
        this.mPlayObjectsInCurScene.remove(po);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        this.mWaitingForNextButton = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do nothing
    }
}
