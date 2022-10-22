package thebigbadwolf;

import java.awt.Image;

public class Cloth extends PlayObject{
    //constructor
    public Cloth(String name) {
        super(name);
    }   

    @Override
    protected Image callImage() {
        String fileName = "";
        switch (this.getName()) {
            case "bag":
                fileName = "bag";
                break;
            case "fairy":
                fileName = "wolf_fairy";
                break;
            case "grandma":
                fileName = "wolf_grandma";
                break;
            case "wolf's pants":
                fileName = "wolf_pants";
                break;
        }
        return this.loadImage(fileName);
    }
}
