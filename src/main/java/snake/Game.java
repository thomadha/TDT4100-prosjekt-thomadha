package snake;

import java.util.Timer;
import java.util.TimerTask;

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