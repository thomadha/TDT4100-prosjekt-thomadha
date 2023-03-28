package snake;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Game {
    //FELTER
    private int score;
    private Snake snake;

    //KONSTRUKTØR
    public Game(){
        this.snake = new Snake();
    }

    //METODER

    public Snake getSnake(){
        return this.snake;
    }

    public void drawBoard(GridPane spillbrett){
        for (XYvalue bodypart : snake.getSnakeBody()) {
            Node node = bodypart.getRectangle();
            spillbrett.add(node, bodypart.getxValue(), bodypart.getyValue());
            
        }
    }

    public void placeApple(){
        
        XYvalue coordinateApple = new XYvalue();

        //Hva om eplet plasseres på slangen? 
        if(snake.getSnakeBody().contains(coordinateApple)){
            placeApple();
        } 

    }

    public void moveSnake(){

        
    }
}