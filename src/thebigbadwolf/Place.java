
package thebigbadwolf;

import java.util.ArrayList;

public class Place extends PlayObject {
    
    //field
    ArrayList<PlayObject> mMembers = new ArrayList<PlayObject>();
    public ArrayList<PlayObject> getmembers() {
        return this.mMembers;
    }  
    
    //constructor
    protected Place(String name) {
        super(name);
    }
    
    //method
    public void add(PlayObject po) {
        this.mMembers.add(po);
    }
    
    public void remove(PlayObject po) {
        this.mMembers.remove(po);
    }
     
}