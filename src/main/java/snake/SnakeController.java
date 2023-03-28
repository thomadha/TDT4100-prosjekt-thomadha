package snake;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;

public class SnakeController {
    @FXML
    private TextField navn;

    @FXML
    private Text poengScore; 
    
    @FXML
    private Text leaderBoard; 

    @FXML
    private GridPane spillbrett;

    @FXML
    private Label result; // må bytte ut disse

    @FXML
    private Snake snake; // må bytte ut disse

    @FXML
    private void initializeGame() { // må bytte ut med egen et ellet annet

        Game new_game = new Game();
        this.snake = new_game.getSnake();

        //Kaller på metode som tegner inn slangen
        new_game.drawBoard(spillbrett);
        
        new_game.placeApple(spillbrett, new Apple());

        Timeline klokke = new Timeline(new KeyFrame(javafx.util.Duration.seconds(0.5), e ->{
            
                snake.move();
                System.out.println(snake);
                System.out.println(new_game.getApple());

                new_game.checkIfAppleIsEatenAndMore(spillbrett, snake, new_game.getApple());

                //Endrer poengscore
                poengScore.setText(Integer.toString(new_game.getScore()));
            
                
        }));

        klokke.setCycleCount(Animation.INDEFINITE);
        klokke.playFromStart();
    }


    @FXML
    private void right() {
        snake.changeDirection("right");
    }

    @FXML
    private void left() {
        snake.changeDirection("left");
    }

    @FXML
    private void up() {
        snake.changeDirection("up");
    }

    @FXML
    private void down() {
        snake.changeDirection("down");
    }



}
