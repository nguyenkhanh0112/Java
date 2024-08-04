package view;

import javax.swing.*;
import java.awt.*;

public class DrawExampleview extends JFrame {
    public DrawExampleview(){
        this.setTitle("Draw Example");
        this.setSize(300,300);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);

        JPanelDraw jPanelDraw = new JPanelDraw();
        this.setLayout(new BorderLayout());
        this.add(jPanelDraw,BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DrawExampleview();
    }
}
