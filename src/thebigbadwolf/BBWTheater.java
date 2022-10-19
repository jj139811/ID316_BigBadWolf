package thebigbadwolf;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class BBWTheater extends Thread implements MouseListener{
    //constants
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
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
    }
    private void waitForNextButton() {
        this.mWaitingForNextButton = true;
        while (this.mWaitingForNextButton) {
            Thread.yield();
        }
    }
    @Override
    public void run() {
        // initiallize
        
        // run scripts
        System.out.println("1");
        this.waitForNextButton();
        
        System.out.println("2");
        this.waitForNextButton();
        
        System.out.println("3");
        this.waitForNextButton();
        
        System.out.println("4");
        this.waitForNextButton();
    }
    
    public void say(PlayObject speaker, String script) {
        System.out.println (speaker.getName() + " says: " + script);
    }
    public void showDescription(String script) {
        System.out.println(script);
    }
    public void changeBgTo(Background background) {
        this.mBBWCanvas.setBackground(background.getImage());
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
