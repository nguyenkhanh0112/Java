package mmmvc.color.view1;

import mmmvc.color.controller.MyColorListener;
import mmmvc.color.model.MyColorModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyColorView extends JFrame {
    private MyColorModel myColorModel;
    private JLabel jLabel;

    public MyColorView(){
        this.myColorModel= new MyColorModel();
        this.init();
        this.setVisible(true);
    }
    public void init(){
        this.setTitle("My Color");
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font_text = new Font("Time New Roman",Font.BOLD,100);
        jLabel = new JLabel("Adonis Feed");
        jLabel.setFont(font_text);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,3));

        ActionListener myColorListener = new MyColorListener(this);
        Font font = new Font("Time New Roman",Font.BOLD,40);
        JButton jButton_text_red = new JButton("Red Text");
        jButton_text_red.setFont(font);
        jButton_text_red.setForeground(Color.RED);
        jButton_text_red.addActionListener(myColorListener);



        JButton jButton_text_yellow = new JButton("Yellow Text");
        jButton_text_yellow.setFont(font);
        jButton_text_yellow.setForeground(Color.YELLOW);
        jButton_text_yellow.addActionListener(myColorListener);

        JButton jButton_text_Green = new JButton("Green Text");
        jButton_text_Green.setFont(font);
        jButton_text_Green.setForeground(Color.GREEN);
        jButton_text_Green.addActionListener(myColorListener);

        JButton jButton_Background_red = new JButton("Red Background");
        jButton_Background_red.setFont(font);
        jButton_Background_red.setBackground(Color.RED);
        jButton_Background_red.setOpaque(true);
        jButton_Background_red.addActionListener(myColorListener);

        JButton jButton_Background_yellow = new JButton("Yellow Background");
        jButton_Background_yellow.setFont(font);
        jButton_Background_yellow.setBackground(Color.YELLOW);
        jButton_Background_yellow.setOpaque(true);
        jButton_Background_yellow.addActionListener(myColorListener);

        JButton jButton_Background_Green = new JButton("Green Background");
        jButton_Background_Green.setFont(font);
        jButton_Background_Green.setBackground(Color.GREEN);
        jButton_Background_Green.setOpaque(true);
        jButton_Background_Green.addActionListener(myColorListener);


        jPanel.add(jButton_text_red);
        jPanel.add(jButton_text_yellow);
        jPanel.add(jButton_text_Green);
        jPanel.add(jButton_Background_red);
        jPanel.add(jButton_Background_yellow);
        jPanel.add(jButton_Background_Green);

        this.setLayout(new BorderLayout());
        this.add(jLabel,BorderLayout.NORTH);
        this.add(jPanel,BorderLayout.CENTER);

    }

    public void changerTextColor(Color color) {
        this.jLabel.setForeground(color);
    }
    public void changeBackgroundColor(Color color){
        this.jLabel.setBackground(color);
         this.jLabel.setOpaque(true);
    }
}
