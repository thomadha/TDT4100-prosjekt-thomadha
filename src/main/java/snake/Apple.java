package snake;

import javafx.scene.Node;

public class Apple {
    //FELTER
    private XYvalue coordinate;
    private Node applenode;

    //KONSTRUKTØR
    public Apple(){
        this.coordinate = new XYvalue();
        this.applenode = this.coordinate.getRectangle();
    }

    
    //METODER
    public XYvalue getCoordinate() {
        return coordinate;
    }

    public Node getApplenode() {
        return applenode;
    }
    
    
    
}
