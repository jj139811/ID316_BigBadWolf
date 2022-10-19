package thebigbadwolf;

public class BBWTheater {
    public BBWTheater () {
        
    }
    public void say(PlayObject speaker, String script) {
        System.out.println (speaker.getName() + " says: " + script);
    }
    public void showDescription(String script) {
        System.out.println(script);
    }
    public void changeBgTo(Background background) {
        System.out.println("Background changed to ");
    }
}
