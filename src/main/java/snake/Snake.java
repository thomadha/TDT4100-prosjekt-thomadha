package snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    
    private List <XYvalue> snakeBody = new ArrayList<>();
    private String direction = "right"; 

    //KONSTRUKTØR -> LAGER KROPPEN TIL SLANGEN
    public Snake(){
        XYvalue kroppEn = new  XYvalue(1, 1);
        XYvalue kroppTo = new  XYvalue(2 , 1);
        XYvalue kroppTre = new  XYvalue(3 ,1 );
        snakeBody.add(kroppEn);
        snakeBody.add(kroppTo);
        snakeBody.add(kroppTre);

    }


    //flytter slangen i den rettningen den peker
    public void move(){
        int xVerdi = snakeBody.get(2).getxValue();
        int yVerdi = snakeBody.get(2).getyValue();
        XYvalue kropp = new XYvalue(xVerdi, yVerdi);

        switch(direction){
            case("right"):xVerdi += 1; 
                break;
            case("left"): xVerdi -= 1;
                break;
            case("up"): yVerdi -= 1;
                break;
            case("down"): yVerdi += 1;
                break;
        }
        kropp.setxValue(xVerdi);
        kropp.setyValue(yVerdi);
        //sjekker om ny del av slangen allerede er en del av slangen. 
        for (XYvalue part : snakeBody) {
            if(part.equals(kropp)){
                throw new IllegalArgumentException("Du krasjet i deg selv!");
            }
        }
        //Leger til ny del og fjerner halen. 
        snakeBody.add(kropp);
        snakeBody.remove(0);
    }




    public void changeDirection(String direction){
        if(!(direction.matches("right|left|up|down"))){
            throw new IllegalArgumentException("Må være en gyldig rettning");
        }
        this.direction = direction;
    }

    //getter
    public List<XYvalue> getSnakeBody(){
        return this.snakeBody;
    }






    @Override
    public String toString() {
        return "[snakeBody= {X:" + snakeBody.get(0).getxValue() + " Y:" + snakeBody.get(0).getyValue() + "} {X:" + snakeBody.get(1).getxValue() + " Y:" + snakeBody.get(1).getyValue() + "} {X:" + snakeBody.get(2).getxValue() + " Y:" + snakeBody.get(2).getyValue() + "}]";
    }





    public static void main(String[] args) {
        Game game = new Game();
        game.moveSnake();
        System.out.println(game.getSnake());

    }
}
