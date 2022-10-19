package thebigbadwolf;

public class Pig extends Protagonist {
    //constructor
    protected Pig(String name) {
        super(name);
    }
    
    //method
    @Override
    public void ceremony() {
        
    }
    public void buildHouse() {
       String s = this.getName() + " builds brickhouse.";
       System.out.println(s);
    }
    
    public void sing() {
       String s = this.getName() + " sings.";
       System.out.println(s);
    }
    
    
    public void put(PlayObject what, PlayObject where) {
       String s = this.getName() + " puts " + what.getName() + "into" + where.getName() + " .";
       System.out.println(s);
    }
    
}
