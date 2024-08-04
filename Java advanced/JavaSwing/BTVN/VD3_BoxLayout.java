package JavaSwing.BTVN;

import javax.swing.*;
import java.awt.*;

public class VD3_BoxLayout extends JFrame {
    public VD3_BoxLayout(){

        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setSize(400,300);
        setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));

        JButton button1 = new JButton("BoxLayout");
        JButton button2 = new JButton("X_AXIS");
        JButton button3 = new JButton("Y_AXIS");

        button1.setForeground(Color.red);
        button2.setForeground(Color.blue);
        button3.setForeground(Color.yellow);

        add(button1);
        add(button2);
        add(button3);
        setVisible(true);


    }
    public static void main(String[] args) {
        new VD3_BoxLayout();
    }
}
