package snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SnakeController {
    @FXML
    private TextField navn;

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

        this.drawBoard();



        /* Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
            snake.move();
            System.out.println(snake);
            spillbrett.getChildren().clear();
            XYvalue part = snake.getSnakeBody().get(2);
            Node node = part.getRectangle();
            spillbrett.add(node, part.getxValue(), part.getyValue());
            }
        }, 1000, 500); */

    }

    @FXML
    private void drawBoard(){
        for (XYvalue bodypart : snake.getSnakeBody()) {
            Node node = bodypart.getRectangle();
            spillbrett.add(node, bodypart.getxValue(), bodypart.getyValue());
        }

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
