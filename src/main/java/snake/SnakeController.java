package snake;



import javafx.animation.Animation;
import javafx.animation.KeyFrame;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SnakeController {
    @FXML
    private AnchorPane background;

    @FXML
    private TextField navn;

    @FXML
    private Text poengScore;

    @FXML
    private TextArea leaderBoard;

    @FXML
    private GridPane spillbrett;

    @FXML
    private Label result;

    @FXML
    private Snake snake;

    @FXML
    private Highscore scoreboard = new Highscore();

    @FXML
    private Timeline klokke;

    @FXML
    private void initializeGame() { 
    
        Game new_game = new Game();

        String navn = this.navn.getText();
        this.snake = new_game.getSnake();

        // Kaller på metode som tegner inn slangen og et eple
        new_game.drawBoard(spillbrett);
        new_game.placeApple(spillbrett, new Apple());

        this.klokke = new Timeline(new KeyFrame(javafx.util.Duration.seconds(0.5), e -> {
            //HVIS IKKE GAME-OVER, SKJER DETTE VED HVER FRAME
            try{
                snake.move();
                System.out.println(snake);
                System.out.println(new_game.getApple());
    
                // Oppdaterer spillbrettet, genererer nytt eple og endrer score om det forrige er spist
                new_game.updateBoard(spillbrett, snake, new_game.getApple());
    
                // Endrer poengscore
                poengScore.setText(Integer.toString(new_game.getScore()));
    
            //HVIS GAME OVER:
            } catch(Exception k){   
                
                System.out.println("Game over");
                klokke.stop();
                
                
                //LEGGER TIL GAMEOVER-SKJERM --> HJEELP FÅR IKKE FJERNET DENNE THOMAS :( 
                //metoder for denne ligger i Game, og bare kommenter ut denne linjen (82), for at spillet skal kjøre normalt
                new_game.addGameoverScreen(background); 
                

                //Oppdaterer Leaderboard
                new_game.addRoundToLeaderBoard(navn, Integer.parseInt(poengScore.getText()), scoreboard);
                new_game.updateGameLeaderBoard(leaderBoard, "Scores.txt");
                
                
            }
            
        }));
        
        //PRØVER Å FJERNE FORRIGE SPILL SIN GAMEOVER SKJERM, MEN FUNKER IKKE
        new_game.removeGameoverScreen(background);
       
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
     
     * Lage tester
     * Skrive word-dokument
     * Gjøre noe med brukergrensesnittet når spillet er over???

     
     */

}
