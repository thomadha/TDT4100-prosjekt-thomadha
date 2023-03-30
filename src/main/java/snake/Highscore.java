package snake;

import java.util.HashMap;

public class Highscore {
    //FELTER
    private HashMap<String, Integer> highscore;
    private final int max_size;

    //KONSTRUKTØR
    public Highscore(){
        this.highscore = new HashMap<String, Integer>();
        this.max_size = 10;
    }

    //VALIDERINGSMETODER
    

    //STANDARDMETODER
    public HashMap<String, Integer> getHighscore(){
        return this.highscore;
    }

    //METODER
    public void addScore(String name, Integer new_score){
        

    }
    
    
}
