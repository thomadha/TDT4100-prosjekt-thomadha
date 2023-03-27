package snake;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakeController {
    @FXML
    private TextField navn;
    
    @FXML
    private GridPane spillbrett;

    @FXML
    private Label result; //må bytte ut disse

    @FXML
    private Snake snake; //må bytte ut disse 

    @FXML
    private void initializeGame() { //må bytte ut med egen et ellet annet

       // Rectangle coloredTile = new Rectangle(30, 30).setFill(Color.BLUE);

        Snake snake = new Snake();
        this.snake = snake;

        for (XYvalue bodypart: snake.getSnakeBody()){
            Node node = bodypart.getRectangle();
            spillbrett.add(node, bodypart.getxValue(), bodypart.getyValue());
       }

       
    
      
       
    }

    @FXML
    private void handleButtonClick() { //må bytte ut med egne metoder
        
    }

    // noe som sjekker hver gang slangen flytter seg 
    // swiper hele brettet og fargerlegge det som skal fargelegges på nytt 

}
