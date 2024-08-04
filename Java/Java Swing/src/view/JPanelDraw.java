package view;

import javax.swing.*;
import java.awt.*;


public class JPanelDraw extends JPanel {
    public JPanelDraw(){
        this.setBackground(Color.WHITE);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(15,15,50,150);

        g.setColor(Color.GREEN);
        g.drawOval(255,255,50,50);

        g.setColor(Color.CYAN);
        g.drawRect(45,150,30,90);

        g.setColor(Color.DARK_GRAY);
        g.drawOval(400,300,50,50);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(100,100,150,150);
    }
}
