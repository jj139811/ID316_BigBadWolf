package thebigbadwolf;

import java.awt.Image;

public class GrandmaHouse extends House {
    //constructor
    public GrandmaHouse(String name) {
        super(name);
    }
    @Override
    protected Image loadBackgroundImage() {
        return this.loadImage("bg/bg_grandma_house");
    }
}
