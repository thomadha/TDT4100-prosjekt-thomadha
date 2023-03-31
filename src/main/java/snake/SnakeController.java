package snake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
    private User user;

    @FXML
    private Highscore scoreboard = new Highscore();

    @FXML
    private Timeline klokke;

    @FXML
    private void initializeGame() { // må bytte ut med egen et ellet annet

        Game new_game = new Game();
        String navn = this.navn.getText();
        this.user = new User(this.navn.getText(),new_game.getScore());
        this.snake = new_game.getSnake();

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
                
                //Update scoreboard
                new_game.addRoundToLeaderBoard(navn, Integer.parseInt(poengScore.getText()), scoreboard);
                updateGameLeaderBoard(leaderBoard, "Scores.txt");



                //Rectangle popup = new Rectangle(600, 500, Color.LIGHTSKYBLUE);
                //background.getChildren().add(popup);

                //Text gameover = new Text("GAME OVER" + "\n Score: " + new_game.getScore());
                //background.getChildren().add(gameover); 



                
            }

        }));

        klokke.setCycleCount(Animation.INDEFINITE);
        klokke.playFromStart();
    }
    @FXML
    public void updateGameLeaderBoard(TextArea leaderboard, String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] lineInfo = line.split(",");

                String name = lineInfo[0];
                String score = lineInfo[1];

                //leaderboard.setText(name + "                                            " + score + "points" + "\n");
                leaderboard.appendText(name + "                                            " + score + "points" + "\n");
            }
            scanner.close();


        } catch (FileNotFoundException e) {
           System.out.println("Noe gikk galt");
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

    /*
     * Hva vi mangler:
     * 
     * Lage tester
     * Lese fra fil
     * fikse brukernavn
     * føre inn poengscore og leaderboard
     
     * Gjøre noe med brukergrensesnittet når spillet er over???

     * 
     */

}
