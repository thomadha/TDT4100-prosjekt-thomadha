package snake;

import java.util.Random;

public class Game {
    //FELTER
    private int score;
    private Snake snake;

    //KONSTRUKTØR

    //METODER
    public void placeApple(){
        
        XYvalue coordinateApple = new XYvalue();

        //Hva om eplet plasseres på slangen? 
        if(snake.getSnakeBody().contains(coordinateApple)){
            placeApple();
        } 

    }

    
}
