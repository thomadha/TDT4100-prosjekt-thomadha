package snake;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Highscore {
    //FELTER
    private LinkedHashMap<String, Integer> highscore;
    private final int max_size;

    //KONSTRUKTØR
    public Highscore(){
        this.highscore = new LinkedHashMap<String, Integer>();
        this.max_size = 10;
    }

    //VALIDERINGSMETODER
    

    //STANDARDMETODER

    //Sorterer listen i synkende rekkefølge før den returneres
    public LinkedHashMap<String, Integer> getHighscore(){
        LinkedHashMap<String, Integer> sorted_highscoreList = highscore.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
            Map.Entry :: getKey,
            Map.Entry :: getValue,
            (oldValue, newValue) -> oldValue, LinkedHashMap :: new
        ));

        return sorted_highscoreList; //synkende rekkefølge!
    }

    //METODER
    public Integer getWorstScore(){
        return Integer.parseInt(String.valueOf(this.getHighscore().entrySet().toArray()[this.getHighscore().size()-1]));    }


    
    public void addScore(String name, Integer new_score){
        //Hvis max_size ikke er nådd på highscoren, så skal alle nye resultat legges til
        if (highscore.size() < max_size){
            highscore.put(name, new_score);
        }
        //Hvis max_size er nådd på highscoren, sjekke om den nye scoren er god nok
        else{
            //Hvis new_score er god nok til å komme inn på lista, legges den til, og den andre fjernes
            if(new_score >= this.getWorstScore()){
                for (Entry<String, Integer> entry : this.getHighscore().entrySet()){
                    if(entry.getValue().equals(this.getWorstScore())){
                        highscore.remove(String.valueOf(entry.getKey()));
                        break;

                    }
                }
                highscore.put(name, new_score);
            }
        }
    }

    
    public void printHighscore() {
        System.out.println("HIGHSCORE:");
        for(String i: this.getHighscore().keySet()){
            System.out.println("\n Navn: " + i +  "            Score: " + this.getHighscore().get(i));
        }
    }

    public static void main(String[] args) {
        Highscore highscore = new Highscore();

        highscore.addScore("Amalie", 10);
        highscore.addScore("Thomas", 2);
        highscore.addScore("Katrine", 7);
        highscore.addScore("Jennina", 3);

        highscore.printHighscore();
    }


    
    
}
