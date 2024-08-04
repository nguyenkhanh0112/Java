package view;

import javax.swing.*;
import java.awt.*;

public class ViDu_FlowLayout extends JFrame {
    public ViDu_FlowLayout() {
        this.setTitle("Vi Du Flow Layout");
        this.setSize(600,400);

        // can giua cua so chuong trinh
        this.setLocationRelativeTo(null);

        //set layout
        //FlowLayout flowLayout = new FlowLayout();
        //FlowLayout flowLayout_1 = new FlowLayout(FlowLayout.RIGHT);
        //FlowLayout flowLayout_2 = new FlowLayout(1,50,50);
        //FlowLayout flowLayout_3 = new FlowLayout(FlowLayout.LEFT);
        //FlowLayout flowLayout_4 = new FlowLayout(FlowLayout.TRAILING);
        //this.setLayout(flowLayout_2);
        /*
        //Grid Layout
        GridLayout gridLayout= new GridLayout();
        GridLayout gridLayout_1 = new GridLayout(4,4);
        GridLayout gridLayout_2 = new GridLayout(4,4,25,25);
        this.setLayout(gridLayout_2);

        for(int i=0;i<16;i++){
            JButton jButton =new JButton(i+"");
            this.add(jButton);
        }
        */
        JButton JButton_1 = new JButton("1");
        JButton JButton_2 = new JButton("2");
        JButton JButton_3 = new JButton("3");
        JButton JButton_4 = new JButton("4");
        JButton JButton_5 = new JButton("5");



        BorderLayout borderLayLayout = new BorderLayout();
        BorderLayout borderLayLayout_1 = new BorderLayout(15,15);
        this.setLayout(borderLayLayout_1);

        //add thanhf phan
        this.add(JButton_1,BorderLayout.NORTH);//(phia bac);
        this.add(JButton_2,BorderLayout.SOUTH);//phia nam;
        this.add(JButton_3,BorderLayout.WEST);//phia tay
        this.add(JButton_4,BorderLayout.EAST);//phia dong
        this.add(JButton_5,BorderLayout.CENTER);//o giua


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ViDu_FlowLayout();
    }
}
