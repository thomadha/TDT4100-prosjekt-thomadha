package snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
    private Label result;

    @FXML
    private Snake snake;

    @FXML
    private Timeline klokke;

    @FXML
    private void initializeGame() { // må bytte ut med egen et ellet annet

        Game new_game = new Game();
        this.snake = new_game.getSnake();
        String navn = this.navn.getText();

        // Kaller på metode som tegner inn slangen
        new_game.drawBoard(spillbrett);

        new_game.placeApple(spillbrett, new Apple());

        this.klokke = new Timeline(new KeyFrame(javafx.util.Duration.seconds(0.5), e -> {
            try{
                snake.move();
                System.out.println(snake);
                System.out.println(new_game.getApple());
    
                // Genererer nytt eple og sjekker om
                new_game.updateBoard(spillbrett, snake, new_game.getApple());
    
                // Endrer poengscore
                poengScore.setText(Integer.toString(new_game.getScore()));
    
            //HVIS GAME OVER:
            } catch(Exception k){
                klokke.stop();
                System.out.println("Game over");
                Rectangle popup = new Rectangle(50, 50, Color.LIGHTSKYBLUE);
                TextField gameover = new TextField("GAME OVER" + "\n Score: " + new_game.getScore());
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

    /*
     * Hva vi mangler:
     * 
     * Lage tester
     * Lese fra fil
     * fikse brukernavn
     * føre inn poengscore og leaderboard
     * fikse evig loop, spillet må kunne avslutte.
     * Gjøre noe med brukergrensesnittet når spillet er over???
     * Fikse så slangen ikke kan kjøre gjennom seg selv??
     * 
     */

}
