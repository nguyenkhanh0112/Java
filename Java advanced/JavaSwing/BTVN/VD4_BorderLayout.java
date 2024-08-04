package JavaSwing.BTVN;

import javax.swing.*;
import java.awt.*;

public class VD4_BorderLayout extends JFrame {
    public VD4_BorderLayout(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setSize(300,200);
        setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.red);

        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(Color.red);

        JPanel panelWest = new JPanel();
        panelWest.setBackground(Color.blue);

        JPanel panelEast = new JPanel();
        panelEast.setBackground(Color.blue);

        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(Color.yellow);

        add(panelNorth,BorderLayout.NORTH);
        add(panelSouth,BorderLayout.SOUTH);
        add(panelCenter,BorderLayout.CENTER);
        add(panelWest,BorderLayout.WEST);
        add(panelEast,BorderLayout.EAST);
        setVisible(true);
    }
    public static void main(String[] args) {
        new VD4_BorderLayout();
    }
}
