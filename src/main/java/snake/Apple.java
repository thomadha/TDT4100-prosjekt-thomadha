package snake;

import javafx.scene.Node;

public class Apple implements SnakeInterface {
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


    @Override
    public String toString() {
        return "Apple [coordinate=" + coordinate + "]";
    }


    @Override
    public int getxValue() {
        return coordinate.getxValue();
    }


    @Override
    public int getyValue() {
        return coordinate.getyValue();
    }

    
    
    
    
}
