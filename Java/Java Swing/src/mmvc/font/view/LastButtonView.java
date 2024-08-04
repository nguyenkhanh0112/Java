package mmvc.font.view;

import mmvc.font.controller.LastButtonListener;
import mmvc.font.model.LastButtonModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LastButtonView extends JFrame {
    private LastButtonModel lastButtonModel;
    private JButton jButton_1;
    private JButton jButton_2;
    private JButton jButton_3;
    private JButton jButton_4;

    private JLabel jLabel;

    public LastButtonView(){
        this.lastButtonModel = new LastButtonModel();
        this.init();
        this.setVisible(true);
    }

    public void init(){
        this.setTitle("Last Button");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jpanel_Center = new JPanel();
        jpanel_Center.setLayout(new GridLayout(2,2));

        // tao listener
        ActionListener lastListenner = new LastButtonListener(this);


        // tao font chu
        Font font = new Font("Time New Roman",Font.BOLD,30);

        // gan font chu and Actionlistenner
        jButton_1 = new JButton("1");
        jButton_1.addActionListener(lastListenner);
        jButton_1.setFont(font);
        jButton_2 = new JButton("2");
        jButton_2.addActionListener(lastListenner);
        jButton_2.setFont(font);
        jButton_3 = new JButton("3");
        jButton_3.addActionListener(lastListenner);
        jButton_3.setFont(font);
        jButton_4 = new JButton("4");
        jButton_4.addActionListener(lastListenner);
        jButton_4.setFont(font);

        jpanel_Center.add(jButton_1);
        jpanel_Center.add(jButton_2);
        jpanel_Center.add(jButton_3);
        jpanel_Center.add(jButton_4);

        JPanel jpanel_footer = new JPanel();
        jLabel = new JLabel("------------");
        jLabel.setFont(font);
        jpanel_footer.add(jLabel);

        this.setLayout(new BorderLayout());
        this.add(jpanel_Center,BorderLayout.CENTER);
        this.add(jpanel_footer,BorderLayout.SOUTH);
    }

    public void changeTo_1(){
        this.lastButtonModel.setValue_1();
        jLabel.setText("Last Button: "+this.lastButtonModel.getValue());
    }
    public void changeTo_2(){
        this.lastButtonModel.setValue_2();
        jLabel.setText("Last Button: "+this.lastButtonModel.getValue());
    }
    public void changeTo_3(){
        this.lastButtonModel.setValue_3();
        jLabel.setText("Last Button: "+this.lastButtonModel.getValue());
    }
    public void changeTo_4(){
        this.lastButtonModel.setValue_4();
        jLabel.setText("Last Button: "+this.lastButtonModel.getValue());
    }

}
