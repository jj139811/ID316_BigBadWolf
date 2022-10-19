
package thebigbadwolf;

public abstract class Animal extends PlayObject {
    //fields
    BBWTheater theater = new BBWTheater();
    
    //constructor
    protected Animal(String name) {
        super(name);
    }
    
    public void walkTo(PlayObject po) {
        String s = this.getName() + " walk to " + po.getName() + ".";
        System.out.println(s);
        
        
    }
    
    public void say(String something) {
        
        theater.say(this, something);
    }
    
    public void sneak(PlayObject po) {
        String s = this.getName() + " sneaks to " + po.getName() + ".";
        theater.showDescription(s);
        super.setPosition(po.getPosition());
    }
    
    public void runaway() {

    }
    
    public void run(PlayObject po) {

    }
    
    public void open(PlayObject po) {

    }
    
    
}
