package thebigbadwolf;

public class Grandma extends Human {
    //constructor
    protected Grandma(String name) {
        super(name);
    }
    
    //method
    public void hide(PlayObject po, Place where) {
        String hidingSubject = new String();
        if (po.getName().equals(this.getName())) {
            hidingSubject = "herself";
        } else {
            hidingSubject = po.getName();
        }
        String s = this.getName() + " hides " + hidingSubject + " to " + where;
        System.out.println(s);
        //change po position to place position.
    }

    @Override
    public void ceremony() {
        String s = this.getName() + " knits.";
        System.out.println(s);
        //change image with knitting grandma.
    }
    
    
    
}
