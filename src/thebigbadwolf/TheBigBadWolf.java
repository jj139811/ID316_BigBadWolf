package thebigbadwolf;

public class TheBigBadWolf {
    //field
    private BBWTheater mTheater = null;
    //constructor
    public TheBigBadWolf() {
        this.mTheater = BBWTheater.getInstance();
        this.mTheater.start();
    }
    public static void main(String[] args) {
        new TheBigBadWolf();
    }
}
