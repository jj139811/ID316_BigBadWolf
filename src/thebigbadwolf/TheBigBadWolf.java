package thebigbadwolf;

public class TheBigBadWolf {
    private BBWTheater mTheater = null;
    public TheBigBadWolf() {
        this.mTheater = BBWTheater.getInstance();
        this.mTheater.start();
    }
    public static void main(String[] args) {
        new TheBigBadWolf();
    }
}
