
package thebigbadwolf;

public class Animal extends PlayObject {
    //constructor
    protected Animal(String name) {
        super(name);
    }
    
    public void walkTo(PlayObject po) {
    String s = this.mName + " walk to " + po.getName() + ".";
    System.out.println(s);
    }
    
}
