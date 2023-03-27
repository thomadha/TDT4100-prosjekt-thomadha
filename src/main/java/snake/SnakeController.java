package snake;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SnakeController {
    @FXML
    private TextField navn;

    @FXML
    private Label result; //må bytte ut disse

    private Calculator calculator; //må bytte ut disse 

    private void initCalculator(String operator) { //må bytte ut med egen et ellet annet
        calculator = new Calculator(operator);
    }

    @FXML
    private void handleButtonClick() { //må bytte ut med egne metoder
        
    }

    // noe som sjekker hver gang slangen flytter seg 
    // swiper hele brettet og fargerlegge det som skal fargelegges på nytt 

}
