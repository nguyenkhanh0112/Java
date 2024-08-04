package view;

import javax.swing.*;

public class MyWinDow extends JFrame {
    public MyWinDow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void show1(){
        this.setVisible(true);
    }
    public void show1(String title){
        this.setTitle(title);
        this.setVisible(true);
    }
    public void show1(String title,int with,int height){
        this.setTitle(title);
        this.setSize(with,height);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyWinDow m1 = new MyWinDow();
        m1.show1();

        MyWinDow m2 = new MyWinDow();
        m2.show1("Adonis Feed");

        MyWinDow m3 = new MyWinDow();
        m2.show1("Adonis Feed",600,400);
    }
}
