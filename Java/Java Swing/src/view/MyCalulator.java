package view;

import javax.swing.*;
import java.awt.*;

public class MyCalulator extends JFrame {
    public MyCalulator(){
        this.setTitle("Calulator");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField jtextfile = new JTextField(50);
        JPanel jpanel_head = new JPanel();
        jpanel_head.setLayout(new BorderLayout());
        jpanel_head.add(jtextfile,BorderLayout.CENTER);


        JPanel jPanel_Buttons = new JPanel();
        jPanel_Buttons.setLayout(new GridLayout(5 ,3));

        JButton jButton1 = new JButton("1");
        JButton jButton2 = new JButton("2");
        JButton jButton3 = new JButton("3");
        JButton jButton4 = new JButton("4");
        JButton jButton5 = new JButton("5");
        JButton jButton6 = new JButton("6");
        JButton jButton7 = new JButton("7");
        JButton jButton8 = new JButton("8");
        JButton jButton9 = new JButton("9");
        JButton jButton10 = new JButton("0");
        JButton jButton11 = new JButton("+");
        JButton jButton12 = new JButton("-");
        JButton jButton13 = new JButton("*");
        JButton jButton14 = new JButton("/");
        JButton jButton15 = new JButton("=");
        jPanel_Buttons.add(jButton10);
        jPanel_Buttons.add(jButton1);
        jPanel_Buttons.add(jButton2);
        jPanel_Buttons.add(jButton3);
        jPanel_Buttons.add(jButton4);
        jPanel_Buttons.add(jButton5);
        jPanel_Buttons.add(jButton6);
        jPanel_Buttons.add(jButton7);
        jPanel_Buttons.add(jButton8);
        jPanel_Buttons.add(jButton9);
        jPanel_Buttons.add(jButton11);
        jPanel_Buttons.add(jButton12);
        jPanel_Buttons.add(jButton13);
        jPanel_Buttons.add(jButton14);
        jPanel_Buttons.add(jButton15);

        this.setLayout(new BorderLayout());
        this.add(jpanel_head,BorderLayout.NORTH);
        this.add(jPanel_Buttons,BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String[] args) {
       try{
           //com.sun.java.swing.plaf.motif.MotifLookAndFeel
           //com.sun.java.swing.plaf.windows.windowsLookAndFeel
           //com.sun.java.swing.plaf.gtk.GTKLookAndFeel
           UIManager.setLookAndFeel((UIManager.getSystemLookAndFeelClassName()));
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            new MyCalulator();
       }catch(Exception e){
           throw  new RuntimeException(e);
       }
    }
}
