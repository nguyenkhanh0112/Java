package generic;

public class TextBox2 {
    public static void main(String[] args) {
        Box2 box1 = new Box2<Integer>(15);
        System.out.println("Value: "+box1.getValue());

        Box2 box2 = new Box2<String>("Nguyen Van Khanh");
        System.out.println("Value: "+box2.getValue());

        Box2 box3 = new Box2<Double>(15.5);
        System.out.println("Value: "+box3.getValue());
    }
}
