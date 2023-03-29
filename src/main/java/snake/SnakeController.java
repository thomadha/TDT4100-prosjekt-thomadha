package snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
            try{
                snake.move();
                System.out.println(snake);
                System.out.println(new_game.getApple());

                //Genererer nytt eple og sjekker om 
                new_game.updateBoard(spillbrett, snake, new_game.getApple());

                //Endrer poengscore
                poengScore.setText(Integer.toString(new_game.getScore()));

            }catch(Exception k){
                System.out.println("Du er henta!"); //HVORDAN STOPPE KLOKKE?
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
    Hva vi mangler: 

    Lage tester
    Lese fra fil 
    fikse brukernavn 
    føre inn poengscore og leaderboard 
    fikse evig loop, spillet må kunne avslutte. 
    Gjøre noe med brukergrensesnittet når spillet er over??? 
    Fikse så slangen ikke kan kjøre gjennom seg selv??
    
     */

}
