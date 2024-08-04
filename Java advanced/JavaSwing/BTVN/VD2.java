package JavaSwing.BTVN;

import javax.swing.*;
import java.awt.*;

public class VD2 extends JFrame {
    public VD2(){
        super("Demo FlowLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thay đổi 3 thành JFrame.EXIT_ON_CLOSE
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Thêm dòng này để set layout của frame thành FlowLayout
        setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton button1 = new JButton("Flowlayout");
        JButton button2 = new JButton("Add các control");
        JButton button3 = new JButton("Trên 1 dòng");
        JButton button4 = new JButton("Hết chỗ chứa");
        JButton button5 = new JButton("Thì xuống dòng");
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        // Thay vì thêm panel vào frame, thêm các button trực tiếp vào frame

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);

        setVisible(true);
    }

    public static void main(String[] args) {
        new VD2();
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(3);
//        frame.setSize(400,300);
//        frame.setLocationRelativeTo(null);
//        frame.setLayout(new FlowLayout());
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout());
//        JButton button1 = new JButton("Flowlayout");
//        JButton button2 = new JButton("Add các control");
//        JButton button3 = new JButton("Trên 1 dòng");
//        JButton button4 = new JButton("Hết chỗ chứa");
//        JButton button5 = new JButton("Thì xuống dòng");
//
//        panel.add(button1);
//        panel.add(button2);
//        panel.add(button3);
//        panel.add(button4);
//        panel.add(button5);
//
//        frame.add(panel);
//        frame.setVisible(true);
    }
}
