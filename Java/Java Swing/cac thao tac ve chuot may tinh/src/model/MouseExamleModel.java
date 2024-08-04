package model;

public class MouseExamleModel {
    private int x,y;
    private int count;
    private String checkIn;

    public MouseExamleModel(){
        this.x=0;
        this.y=0;
        this.count=0;
        this.checkIn="No";
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    public void addClick(){
        this.count++;
    }
    public void enter(){
        this.checkIn="Yes";
    }
    public void exit(){
        this.checkIn="No";
    }
}
