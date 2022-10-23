package thebigbadwolf;

import java.awt.Image;

public class Grandma extends Human {
    // constructor
    protected Grandma(String name) {
        super(name);
    }
    
    // method
    public void hide(PlayObject po, Place where) {
        String hidingSubject;
        if (po.getName().equals(this.getName())) {
            hidingSubject = "herself";
        } else {
            hidingSubject = po.getName();
        }
        //change po position to place position.
        where.add(po);
        String s = this.getName() + " hides " + hidingSubject + " to " + 
            where.getName() + ".";
        BBWTheater.getInstance().showDescription(s);
    }
    
    // overridden methods from Human
    @Override
    public void ceremony() {
        String s = this.getName() + " knits.";
        BBWTheater.getInstance().showDescription(s);
        this.setImage(this.mCeremonyImage);
    }

    @Override
    protected Image callImage() {
        return this.loadImage("grandma_default");
    }
    @Override
    protected Image loadCeremonyImage() {
        return this.loadImage("grandma_knitting");
        
    }
}
