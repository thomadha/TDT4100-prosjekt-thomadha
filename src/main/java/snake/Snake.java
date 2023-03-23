package snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    
    private List <XYvalue> snakeBody = new ArrayList<>();
    private String direction = "right"; 
    

    //lager kroppen til slangen. 
    private void generateBody(){
        XYvalue kroppEn = new  XYvalue();
        kroppEn.setxValue(1);
        kroppEn.setyValue(1);
        XYvalue kroppTo = new  XYvalue();
        kroppTo.setxValue(2);
        kroppTo.setyValue(1);
        XYvalue kroppTre = new  XYvalue();
        kroppTre.setxValue(3);
        kroppTre.setyValue(1);

        snakeBody.add(kroppEn);
        snakeBody.add(kroppTo);
        snakeBody.add(kroppTre);

    }



    //flytter slangen i den rettningen den peker
    public void move(){
        int xVerdi = snakeBody.get(2).getxValue();
        int yVerdi = snakeBody.get(2).getyValue();
        XYvalue kropp = new XYvalue();

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
        Snake slange = new Snake();
        slange.generateBody();
        System.out.println(slange);
        slange.move();
        System.out.println(slange);
        slange.move();
        slange.move();
        System.out.println(slange);
        slange.changeDirection("down");
        slange.move();
        System.out.println(slange);
        slange.move();
        System.out.println(slange);
        slange.move();
        System.out.println(slange);

    }
}
