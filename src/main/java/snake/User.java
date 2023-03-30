package snake;

public class User {
    //FELTER
    private String name;
    private int score;
    
    //KONSTRUKTØR
    public User(String name, int score){
        this.name = name;
        if(isValidScore(score)){
            this.score = score;
        }
        else{
            throw new IllegalArgumentException("Score kan ikke være negativ!");
        }
    }

    //VALIDERINGSMETODER
    public boolean isValidScore(int score){
        if(score >= 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //STANDARDMETODER
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        isValidScore(score);
        this.score = score;
    }
    
    //ANDRE METODER


    
}
