package snake;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Game {
    //FELTER
    private int score;
    private Snake snake;
    private List <Node> childrenOfSnake= new ArrayList<>();

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
            
            if(!(childrenOfSnake.contains(node))){
                childrenOfSnake.add(node);
            }
        }
    }

    public List<Node> getChildrenOfSnake(){
        return this.childrenOfSnake;
    }



    public void placeApple(GridPane spillbrett, Apple apple){

        spillbrett.add(apple.getApplenode(), apple.getCoordinate().getxValue(), apple.getCoordinate().getyValue());

        //Hva om eplet plasseres på slangen? 
        if(snake.getSnakeBody().contains(apple.getCoordinate())){
            placeApple(spillbrett, apple);
        } 


    }

    public void eatApple(){
        
    }

}