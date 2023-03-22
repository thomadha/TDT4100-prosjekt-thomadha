package snake;

public class XYvalue {
    
    private int xValue;
    private int yValue;


    public void setxValue(int xValue) {
        if(xValue>10 || xValue<0){
            throw new IllegalArgumentException("Du traff veggen!");
        }
        this.xValue = xValue;
    }
    public void setyValue(int yValue) {
        if(yValue>10 || yValue<0){
            throw new IllegalArgumentException("Du traff veggen!");
        }
        this.yValue = yValue;
    }
    public int getxValue() {
        return xValue;
    }
    public int getyValue() {
        return yValue;
    } 

    
}
