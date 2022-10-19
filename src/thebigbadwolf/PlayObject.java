package thebigbadwolf;

public abstract class PlayObject {
    //fields
    protected String mName = null;
    String getName() { 
        return this.mName;
    }
    
    //protected constructor 
    protected PlayObject(String name) {
        this.mName = name;
    }  
    
    
    public void runAwayTo(PlayObject po) {
    String s = null;
    if (po == null) {
        s = this.mName + " runaway";
    } else {
        s = this.mName + " runaway to " + po.getName() + ".";
    }
    System.out.println(s);
    }
}
