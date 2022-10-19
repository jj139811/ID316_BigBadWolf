package thebigbadwolf;

import java.awt.Graphics2D;
import java.awt.Point;

public abstract class BBWUI {
    // fields
    protected Point mPosition = null;
    public void setPosition(int x, int y) {
        this.mPosition = new Point(x, y);
    }
    
    // protected constructors
    protected BBWUI(int x, int y) {
        this.mPosition = new Point(x, y);
    }
    
    // abstract methods
    public abstract void draw(Graphics2D g2);
}