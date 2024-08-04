package mvc.count.view;

import mvc.count.controller.CounterListener;
import mvc.count.model.CounterModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CounterView extends JFrame {
    private CounterModel counterModel;
    private JButton jButton_up;
    private JButton jButton_down;
    private JLabel jLabel_Value;
    private JButton jButton_reset;
    public CounterView(){
        this.counterModel= new CounterModel();
        this.init();
        this.setVisible(true);
    }
    public void init(){
        this.setTitle("Counter");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener ac = new CounterListener(this);
        jButton_up = new JButton("UP");
        jButton_up.addActionListener(ac);
        jButton_down = new JButton("DOWN");
        jButton_down.addActionListener(ac);
        jButton_reset = new JButton("RESET");
        jButton_reset.addActionListener(ac);
        jLabel_Value = new JLabel(this.counterModel.getValue()+"",JLabel.CENTER);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jButton_up,BorderLayout.WEST);
        jPanel.add(jLabel_Value,BorderLayout.CENTER);
        jPanel.add(jButton_down,BorderLayout.EAST);
        jPanel.add(jButton_reset,BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(jPanel,BorderLayout.CENTER);

    }
    public void increment(){
        this.counterModel.increment();
        this.jLabel_Value.setText(this.counterModel.getValue()+"");
    }
    public void decrement(){
        this.counterModel.decrement();
        this.jLabel_Value.setText(this.counterModel.getValue()+"");
    }
    public void reset(){
        this.counterModel.reset();
        this.jLabel_Value.setText(this.counterModel.getValue()+"");
    }
}
