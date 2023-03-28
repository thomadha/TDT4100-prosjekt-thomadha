package snake;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Game {
    //FELTER
    private Integer score;
    private Snake snake;
    private Apple apple;
    private List <Node> childrenOfSnake= new ArrayList<>();

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


    public void placeApple(GridPane spillbrett, Apple apple){
        this.apple = apple;
        spillbrett.add(apple.getApplenode(), apple.getCoordinate().getxValue(), apple.getCoordinate().getyValue());

        //Hva om eplet plasseres på slangen? 
        if(snake.getSnakeBody().contains(apple.getCoordinate())){
            placeApple(spillbrett, apple);
        } 


    }

    public void checkIfAppleIsEatenAndMore(GridPane spillbrett, Snake snake, Apple new_apple){

        //Liste med noder vi vil "beholde" etter rensking (grid-linjer og eplet om slangen ikke har spist det)
        List<Node> ting2 = new ArrayList<Node>();
        ting2.add(spillbrett.getChildren().get(0));
        ting2.add(new_apple.getApplenode());

        //Sjekker om slangen har spist eplet (om noen av koordinatene i slangens kropp matcher koordinatet til eplet)
        for (XYvalue body: snake.getSnakeBody()){
            if(body.getxValue() == new_apple.getCoordinate().getxValue() && body.getyValue() == new_apple.getCoordinate().getyValue()){

                //HVIS JA: Fjerne eplet fra listen med noder vi vil beholde (vil renske vekk eplet også)
                ting2.remove(new_apple.getApplenode());

                //rensker og adder på score
                spillbrett.getChildren().retainAll(ting2);
                this.score++;

                //tegner brettet på nytt med ny slange, vil plassere nytt eple
                this.drawBoard(spillbrett);
                this.placeApple(spillbrett, new Apple());

            }
        
                
        }

        //HVIS NEI: Behold eplet i listen med noder vi vil beholde, tegne brettet på nytt (oppdaterer kun slangen)
        spillbrett.getChildren().retainAll(ting2);
        this.drawBoard(spillbrett);
    }


}