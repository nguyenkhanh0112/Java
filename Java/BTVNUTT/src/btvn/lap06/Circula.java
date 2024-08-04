package btvn.lap06;

public class Circula extends Shape{

    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn!");
    }

    @Override
    public void rotate(int angle) {
        System.out.println("Quay hình tròn một góc "+angle+" độ!");
    }

    @Override
    public void moveLeft(int point) {
        System.out.println("Di chuyển hình tròn tới điểm "+point);
    }

    @Override
    public void setColor(int color) {
        System.out.println("Tô màu hình tròn với mã màu "+color);
    }
    public int  getArea(){
        return 200;
    }
}
