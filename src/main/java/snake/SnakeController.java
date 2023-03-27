package snake;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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
       Snake snake = new Snake();
       this.snake = snake;

       spillbrett.getChildren().get(1)
       
    }

    @FXML
    private void handleButtonClick() { //må bytte ut med egne metoder
        
    }

    // noe som sjekker hver gang slangen flytter seg 
    // swiper hele brettet og fargerlegge det som skal fargelegges på nytt 

}
