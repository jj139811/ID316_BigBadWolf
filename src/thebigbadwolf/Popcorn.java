package thebigbadwolf;

public class Popcorn extends PlayObject {
    //constructor
    public Popcorn(String name) {
        super(name);
    }
    
    //method
    public void explode() {
        String s = this.getName() + " explodes.";
        System.out.println(s);
    }
}
