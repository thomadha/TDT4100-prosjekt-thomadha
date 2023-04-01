package snake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Game {
    // FELTER
    private Integer score;
    private Snake snake;
    private Apple apple;
    private List<Node> childrenOfSnake = new ArrayList<>();
    private Rectangle gameoverscreen;
    private Text gameovertext;

    // KONSTRUKTØR
    public Game() {
        this.snake = new Snake();
        this.score = 0;

        setGameoverText();
        setGameoverScreen();

    }

    // STANDARDMETODER

    public Snake getSnake() {
        return this.snake;
    }

    public Integer getScore() {
        return this.score;
    }

    public List<Node> getChildrenOfSnake() {
        return this.childrenOfSnake;
    }

    public Apple getApple() {
        return this.apple;
    }

    // ANDRE METODER

    public void drawBoard(GridPane spillbrett) {
        for (XYvalue bodypart : snake.getSnakeBody()) {

            Node node = bodypart.getRectangle();
            spillbrett.add(node, bodypart.getxValue(), bodypart.getyValue());

            if (!(childrenOfSnake.contains(node))) {
                childrenOfSnake.add(node);
            }
        }
    }

    // Plasserer et nytt eple
    public void placeApple(GridPane spillbrett, Apple apple) {
        this.apple = apple;
        spillbrett.add(apple.getApplenode(), apple.getCoordinate().getxValue(), apple.getCoordinate().getyValue());

        // Hva om eplet plasseres på slangen?
        for (XYvalue body : snake.getSnakeBody()) {
            if (body.getxValue() == apple.getCoordinate().getxValue()
                    && body.getyValue() == apple.getCoordinate().getyValue()) {
                placeApple(spillbrett, apple);
            }

        }
    }

    // Sjekker om eplet er spist
    public boolean isAppleEaten(GridPane spillbrett, Snake snake, Apple new_apple) {
        for (XYvalue body : snake.getSnakeBody()) {
            if (body.getxValue() == new_apple.getCoordinate().getxValue()
                    && body.getyValue() == new_apple.getCoordinate().getyValue()) {
                return true;
            }

        }
        return false;

    }

    // Flytter på slangen, generering av nytt eple, øking av poengscore
    public void updateBoard(GridPane spillbrett, Snake snake, Apple new_apple) {

        // Liste med noder vi vil "beholde" etter rensking (grid-linjer og eplet om
        // slangen ikke har spist det)
        List<Node> ting2 = new ArrayList<Node>();
        ting2.add(spillbrett.getChildren().get(0));
        ting2.add(new_apple.getApplenode());

        // Hvis eplet er spist
        if (isAppleEaten(spillbrett, snake, new_apple)) {
            ting2.remove(new_apple.getApplenode());

            // rensker og adder på score
            spillbrett.getChildren().retainAll(ting2);
            this.score++;
            this.snake.grow(new_apple);

            // tegner brettet på nytt med ny slange, vil plassere nytt eple
            this.drawBoard(spillbrett);
            this.placeApple(spillbrett, new Apple());

        }
        // Hvis eplet ikke er spist
        else {
            // HVIS NEI: Behold eplet i listen med noder vi vil beholde, tegne brettet på
            // nytt (oppdaterer kun slangen)
            spillbrett.getChildren().retainAll(ting2);
            this.drawBoard(spillbrett);

        }

    }

    public void addRoundToLeaderBoard(String name, Integer score, Highscore leaderboard) {
        leaderboard.addScore(name, score);
        leaderboard.writeScoresToFile("Scores.txt");
    }

    public void updateGameLeaderBoard(TextArea leaderboard, String filename) {
        try {
            leaderboard.setText(" ");
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineInfo = line.split(",");

                String name = lineInfo[0];
                String score = lineInfo[1];

                // leaderboard.setText(name + " " + score + "points" + "\n");
                leaderboard.appendText(name + "                        " + score + " points" + "\n");
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Noe gikk galt");
        }
    }

    //GAMEOVER-"POPUP", METODER 

    public void addGameoverScreen(AnchorPane background) {
        
        background.getChildren().add(gameoverscreen);
        background.getChildren().add(gameovertext);


    }

    public void removeGameoverScreen(AnchorPane background) {
        background.getChildren().remove(gameovertext);
        background.getChildren().remove(gameoverscreen); 
        
    }
    
    public void setGameoverText(){
        Text text = new Text(410, 380, "DU TAPTE!:)");
        text.setFont(Font.font("Bodoni 72", 40));
        this.gameovertext = text;
        
    }
    public void setGameoverScreen(){
        Rectangle box = new Rectangle(332, 197, 351, 351);
        box.setFill(Color.CORAL);
        this.gameoverscreen = box;
        
    }

    public Text getGameoverText(){
        return this.gameovertext;
    }
    public Rectangle getGameoverScreen(){
        return this.gameoverscreen;
    }



}
