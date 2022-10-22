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

public class BBWTheater extends Thread implements MouseListener {
    // Singleton
    private static BBWTheater instance = null;
    public static BBWTheater getInstance() {
        if (instance == null) {
            instance = new BBWTheater();
        }
        return instance;
    }
    
    //constants
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    
    //fields
    private JFrame mFrame = null;
    private BBWCanvas mBBWCanvas = null;
    //skip to Nth page 
    private int mSkipCount = 0;
    private ArrayList<PlayObject> mPlayObjectsInCurScene = null;
    public ArrayList<PlayObject> getPlayObjectsInCurScene() {
        return this.mPlayObjectsInCurScene;
    }
    
    public BBWTheater() {
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
        
    }
    
    private void waitForNextButton() {
        this.mSkipCount += 1;
        this.mBBWCanvas.repaint();
        while (this.mSkipCount > 0) {
            Thread.yield();
        }
        this.mBBWCanvas.clearSpeachBubbles();
        this.clearDescription();
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
        Cloth bag = new Cloth("bag");
        Place closet = new Place("closet");
        Place tree = new Place("tree");
        Place bed = new Place("bed");
        
        frontyard.setPosition(new Point(100, 400));
        forest.setPosition(new Point(100, 400));
        grandmaHouse.setPosition(new Point(100, 400));
        brickHouse.setPosition(new Point(100, 400));
        
        wolf.putSomethingIn(wolfPants);
        
        //scene 1
        System.out.println("====in front of pig3's brickhouse");
        this.addToScene(firstPig);
        this.addToScene(secondPig);
        this.addToScene(thirdPig);
        this.addToScene(redRidingHood);
        this.changeBgTo(frontyard);
        
        redRidingHood.walkTo(thirdPig);
        this.waitForNextButton();
        firstPig.ceremony();
        this.waitForNextButton();
        secondPig.ceremony();
        this.waitForNextButton();
        thirdPig.buildHouse();
        this.waitForNextButton();
        firstPig.say("good morning, little red riding hood.");
        this.waitForNextButton();
        redRidingHood.say("good morning, how do you do?");
        this.waitForNextButton();
        thirdPig.say("good morning, miss riding hood.");
        this.waitForNextButton();
        firstPig.say("where are you going, red riding hood?");
        this.waitForNextButton();
        redRidingHood.say("i'm bringing grandma cakes and wines.");
        this.waitForNextButton();
        firstPig.say("you get there quick, red riding hood, ");
        this.waitForNextButton();
        firstPig.say("if you take the shortcut through the wood.");
        this.waitForNextButton();
        thirdPig.say("beware, the big bad wolf is lurking there.");
        this.waitForNextButton();
        secondPig.say("we’ll go with you and protect you.");
        this.waitForNextButton();
        
        //scene 2
        System.out.println("====in the forest");
        this.clearScene();
        this.addToScene(firstPig);
        this.addToScene(secondPig);
        this.addToScene(redRidingHood);
        this.addToScene(tree);
        this.addToScene(wolf);
        this.changeBgTo(forest);
        firstPig.setToDefaultImage();
        secondPig.setToDefaultImage();
        thirdPig.setToDefaultImage();
        wolf.setPosition(new Point(600, 400));
        tree.setPosition(new Point(500, 350));
        firstPig.setPosition(new Point(300, 400));
        secondPig.setPosition(new Point(400, 400));
        redRidingHood.setPosition(new Point(500, 400));
        this.waitForNextButton();
        
        redRidingHood.walkTo(forest);
        this.waitForNextButton();
        wolf.sneak(redRidingHood);
        this.waitForNextButton();
        wolf.climb(tree);
        tree.add(wolf);
        this.waitForNextButton();
        wolf.wear(new Cloth("fairy"));
        this.waitForNextButton();
        wolf.say("i'm the fairy queen.");
        this.waitForNextButton();
        wolf.reveal();
        this.waitForNextButton();
        firstPig.runaway();
        secondPig.runaway();
        redRidingHood.runaway();
        this.waitForNextButton();
        wolf.chase(redRidingHood);
        this.waitForNextButton();
        wolf.snuggle(tree);
        this.waitForNextButton();
        wolf.say("Curses!");
        this.waitForNextButton();
        firstPig.runaway();
        secondPig.runaway();
        this.waitForNextButton();

        //scene 3
        System.out.println("====grandma's house ");
        this.clearScene();
        this.addToScene(closet);
        this.addToScene(grandma);
        this.addToScene(bed);
        this.addToScene(wolf);
        this.changeBgTo(grandmaHouse);
        closet.setPosition(new Point(200, 400));
        bed.setPosition(new Point(600, 500));
        
        wolf.sneak(grandmaHouse);
        this.waitForNextButton();
        grandma.say("come in.");
        this.waitForNextButton();
        wolf.attack(grandma);
        this.waitForNextButton();
        grandma.runaway();
        closet.add(grandma);
        this.waitForNextButton();
        wolf.open(closet);
        this.waitForNextButton();
        this.addToScene(redRidingHood);
        redRidingHood.walkTo(grandmaHouse);
        this.waitForNextButton();
        wolf.wear(new Cloth("grandma"));
        this.waitForNextButton();
        wolf.dive(bed);
        this.waitForNextButton();
        redRidingHood.say("good morning grandma, how do you feel today?");
        this.waitForNextButton();
        redRidingHood.walkTo(wolf);
        this.waitForNextButton();
        wolf.say("terrible!");
        this.waitForNextButton();
        wolf.chase(redRidingHood);
        this.waitForNextButton();
        redRidingHood.runaway();
        this.waitForNextButton();
        
        //scene 4
        System.out.println("====brickhouse ");
        this.clearScene();
        this.addToScene(firstPig);
        this.addToScene(secondPig);
        this.addToScene(thirdPig);
        this.addToScene(bag);
        this.addToScene(popcorn);
        this.changeBgTo(brickHouse);
        thirdPig.setPosition(new Point(600, 400));
        this.waitForNextButton();
        brickHouse.remove(thirdPig);
        
        firstPig.run(brickHouse);
        brickHouse.add(firstPig);
        secondPig.run(brickHouse);
        brickHouse.add(secondPig);
        this.waitForNextButton();
        firstPig.say("the wolf! he's got her!");
        this.waitForNextButton();
        thirdPig.put(popcorn, bag);
        thirdPig.putSomethingIn(bag);
        this.waitForNextButton();
        thirdPig.run(grandmaHouse);
        this.waitForNextButton();
        
        System.out.println("====grandma's house");
        this.clearScene();
        this.addToScene(closet);
        this.addToScene(bed);
        this.addToScene(wolf);
        this.addToScene(redRidingHood);
        this.addToScene(grandma);
        this.changeBgTo(grandmaHouse);
        closet.setPosition(new Point(100, 400));
        closet.add(grandma);
        bed.setPosition(new Point(600, 500));
        redRidingHood.setPosition(new Point(300, 500));
        
        wolf.chase(redRidingHood);
        this.waitForNextButton();
        redRidingHood.runaway();
        this.waitForNextButton();
        grandma.hide(redRidingHood, closet);
        this.waitForNextButton();
        wolf.open(closet);
        this.waitForNextButton();
        wolf.say("open the door and let me in!");
        this.waitForNextButton();
        this.addToScene(thirdPig);
        this.addToScene(bag);
        this.addToScene(popcorn);
        thirdPig.sneak(grandmaHouse);
        this.waitForNextButton();
        thirdPig.put(popcorn, wolfPants);
        this.waitForNextButton();
        wolf.jumpOut();
        this.waitForNextButton();
        popcorn.explode();
        wolf.runaway();
        this.waitForNextButton();
        
        //scene 5
        System.out.println("====brick house");
        brickHouse.setPosition(new Point(100, 400));
        this.clearScene();
        this.addToScene(redRidingHood);
        this.addToScene(grandma);
        this.addToScene(firstPig);
        this.addToScene(secondPig);
        this.addToScene(thirdPig);
        this.changeBgTo(brickHouse);
        redRidingHood.setPosition(new Point(100, 450));
        thirdPig.setPosition(new Point(200, 450));
        secondPig.setPosition(new Point(400, 450));
        firstPig.setPosition(new Point(500, 450));
        grandma.setPosition(new Point(600, 400));
        
        redRidingHood.ceremony();
        this.waitForNextButton();
        thirdPig.ceremony();
        this.waitForNextButton();
        firstPig.ceremony();
        this.waitForNextButton();
        secondPig.ceremony();
        this.waitForNextButton();
        grandma.ceremony();
        this.waitForNextButton();
        firstPig.say("who's afraid of that big bad wolf? ");
        secondPig.say("who's afraid of that big bad wolf? ");
        this.waitForNextButton();

        System.out.println("====the end");
    }
    
    public void say(PlayObject speaker, String script) {
        this.mBBWCanvas.addSpeachBubble(script,
            speaker.getPosition().x,
            speaker.getPosition().y - 100);
    }
    
    public void showDescription(String script) {
        this.mBBWCanvas.setDescription(script);
        System.out.println(script);
    }
    public void clearDescription() {
        this.mBBWCanvas.clearDescription();
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
    
    public void clearSpeechBubble() {
        this.mBBWCanvas.clearSpeachBubbles();
    }
    
    public void addToScene(PlayObject po) {
        this.mPlayObjectsInCurScene.add(po);
    }
    public void removeFromScene(PlayObject po) {
        this.mPlayObjectsInCurScene.remove(po);
    }
    public void clearScene() {
        this.mPlayObjectsInCurScene.clear();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        this.mSkipCount -= 1;
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
