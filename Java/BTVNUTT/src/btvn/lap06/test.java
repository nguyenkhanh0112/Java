package btvn.lap06;

import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Shape> figure = new ArrayList<>();
        Line line = new Line();
        Circula circula1 = new Circula();
        Circula circula2 = new Circula();
        Composite composite =new Composite();
        Line line1 = new Line();
        Line line2 = new Line();
        Line line3 = new Line();
        Circula circula3 = new Circula();
        composite.add(line1);
        composite.add(line2);
        composite.add(line3);
        composite.add(circula3);
        figure.add(line);
        figure.add(circula1);
        figure.add(circula2);
        figure.add(composite);
        System.out.println("Đổi màu đồng bộ các hình line, circula,composite");
        for (Shape shape:figure) {
            shape.setColor(102);
        }
        System.out.println("Quay một góc 90 độ các hình line, circula, composite");
        for (Shape shape:figure) {
            shape.rotate(90);
        }
        for (int i = 0; i < figure.size(); i++) {
            Shape shape = figure.get(i);
            shape.setColor(102);
            shape.rotate(90);
        }

    }
}
