package snake;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game {
    //FELTER
    private Integer score;
    private Snake snake;
    private Apple apple;
    private List <Node> childrenOfSnake= new ArrayList<>();
    private String name;

    //KONSTRUKTØR
    public Game(){
        this.snake = new Snake();
        this.score = 0;
    }

    //STANDARDMETODER

    public Snake getSnake(){
        return this.snake;
    }

    public Integer getScore(){
        return this.score;
    }

    public List<Node> getChildrenOfSnake(){
        return this.childrenOfSnake;
    }

    public Apple getApple(){
        return this.apple;
    }

    //ANDRE METODER

    public void drawBoard(GridPane spillbrett){
        for (XYvalue bodypart : snake.getSnakeBody()) {

            Node node = bodypart.getRectangle();
            spillbrett.add(node, bodypart.getxValue(), bodypart.getyValue());
            
            if(!(childrenOfSnake.contains(node))){
                childrenOfSnake.add(node);
            }
        }
    }

    //Plasserer et nytt eple
    public void placeApple(GridPane spillbrett, Apple apple){
        this.apple = apple;
        spillbrett.add(apple.getApplenode(), apple.getCoordinate().getxValue(), apple.getCoordinate().getyValue());

        //Hva om eplet plasseres på slangen? 
        if(snake.getSnakeBody().contains(apple.getCoordinate())){
            placeApple(spillbrett, apple);
        } 


    }

    //Sjekker om eplet er spist
    public boolean isAppleEaten(GridPane spillbrett, Snake snake, Apple new_apple){
        for (XYvalue body: snake.getSnakeBody()){
            if(body.getxValue() == new_apple.getCoordinate().getxValue() && body.getyValue() == new_apple.getCoordinate().getyValue()){
                return true;
            }

        }
        return false;
            
        
    }

    //Flytter på slangen, generering av nytt eple, øking av poengscore
    public void updateBoard(GridPane spillbrett, Snake snake, Apple new_apple){

        //Liste med noder vi vil "beholde" etter rensking (grid-linjer og eplet om slangen ikke har spist det)
        List<Node> ting2 = new ArrayList<Node>();
        ting2.add(spillbrett.getChildren().get(0));
        ting2.add(new_apple.getApplenode());

        //Hvis eplet er spist
        if(isAppleEaten(spillbrett, snake, new_apple)){
            ting2.remove(new_apple.getApplenode());

            //rensker og adder på score
            spillbrett.getChildren().retainAll(ting2);
            this.score++;
            this.snake.grow(new_apple);

            //tegner brettet på nytt med ny slange, vil plassere nytt eple
            this.drawBoard(spillbrett);
            this.placeApple(spillbrett, new Apple());



        }
        //Hvis eplet ikke er spist
        else{
            //HVIS NEI: Behold eplet i listen med noder vi vil beholde, tegne brettet på nytt (oppdaterer kun slangen)
            spillbrett.getChildren().retainAll(ting2);
            this.drawBoard(spillbrett);

        }


    }

    

}