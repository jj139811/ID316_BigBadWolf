package thebigbadwolf;

public class Background extends Place {
    //field
    BBWTheater theater = new BBWTheater();
    
    //constructor
    protected Background(String name) {
        super(name);
    }
    
    //method
    public void changeBackgroundTo(Background changedBg) {
        theater.changeBgTo(changedBg);
    }
}
