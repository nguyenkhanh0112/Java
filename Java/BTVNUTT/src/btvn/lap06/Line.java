package btvn.lap06;

public class Line extends Shape{
    @Override
    public void draw() {
        System.out.println("Vẽ đường thẳng!");
    }

    @Override
    public void rotate(int angle) {
        System.out.println("Đường thẳng quay một góc "+angle+" độ!");
    }

    @Override
    public void moveLeft(int point) {
        System.out.println("Di chuyển đường thẳng sang điêm "+ point);
    }

    @Override
    public void setColor(int color) {
        System.out.println("Tô màu đường thẳng với mã màu: "+ color);
    }
}
