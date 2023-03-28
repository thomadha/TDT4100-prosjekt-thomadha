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
        Apple new_apple = new Apple();
        new_game.placeApple(spillbrett, new_apple);

        Timeline klokke = new Timeline(new KeyFrame(javafx.util.Duration.seconds(0.5), e ->{
            try{
                snake.move();
                System.out.println(snake);

                List <Node> ting = new ArrayList<>();
                ting.add(spillbrett.getChildren().get(0));
                ting.add(new_apple.getApplenode());

                //Rensker brettet
                spillbrett.getChildren().retainAll(ting);
                
                
                //Tegner den nye oppdaterte slangen
                new_game.drawBoard(spillbrett);
                

            } catch(Exception k) {
                System.out.println("Du er henta!");
                
            }

    
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



    // noe som sjekker hver gang slangen flytter seg
    // swiper hele brettet og fargerlegge det som skal fargelegges på nytt

}
