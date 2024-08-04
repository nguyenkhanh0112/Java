package view;

import controller.MiniCalculatiorListenner;
import model.MiniCalculatorModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MiniCalculatorView extends JFrame {
    private MiniCalculatorModel miniCalculatorModel;
    private JTextField jTextField_firstValue;
    private JTextField jTextField_secondValue;
    private JTextField jTextField_answer;

    public MiniCalculatorView(){
        this.miniCalculatorModel= new MiniCalculatorModel();
        this.init();
        this.setVisible(true);
    }

    public void init(){
        this.setTitle("Mini Calculator");
        this.setSize(500,300);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);

        Font font = new Font("Arial",Font.BOLD,40);
        JLabel jLabel_fristValue = new JLabel("1st Value");
        jLabel_fristValue.setFont(font);
        JLabel jLabel_secondValue = new JLabel("2nd Value");
        jLabel_secondValue.setFont(font);
        JLabel jLabel_answer= new JLabel("Answer");
        jLabel_answer.setFont(font);

        jTextField_firstValue=new JTextField(50);
        jTextField_firstValue.setFont(font);
        jTextField_secondValue=new JTextField(50);
        jTextField_secondValue.setFont(font);
        jTextField_answer =new JTextField(50);
        jTextField_answer.setFont(font);
        jLabel_answer.setFont(font);

        JPanel jPanel_IO = new JPanel();
        jPanel_IO.setLayout(new GridLayout(3,2,10,10));
        jPanel_IO.add(jLabel_fristValue);
        jPanel_IO.add(jTextField_firstValue);
        jPanel_IO.add(jLabel_secondValue);
        jPanel_IO.add(jTextField_secondValue);
        jPanel_IO.add(jLabel_answer);
        jPanel_IO.add(jTextField_answer);

        ActionListener mniCalculatorListenner = new MiniCalculatiorListenner(this);
        JButton jButton_plus = new JButton("+");
        jButton_plus.setFont(font);
        jButton_plus.addActionListener(mniCalculatorListenner);

        JButton jButton_minus = new JButton("-");
        jButton_minus.setFont(font);
        jButton_minus.addActionListener(mniCalculatorListenner);
        JButton jButton_multiply = new JButton("*");
        jButton_multiply.setFont(font);
        jButton_multiply.addActionListener(mniCalculatorListenner);
        JButton jButton_divide = new JButton("/");
        jButton_divide.setFont(font);
        jButton_divide.addActionListener(mniCalculatorListenner);
        JButton jButton_pow = new JButton("^");
        jButton_pow.setFont(font);
        jButton_pow.addActionListener(mniCalculatorListenner);
        JButton jButton_mod = new JButton("%");
        jButton_mod.setFont(font);
        jButton_mod.addActionListener(mniCalculatorListenner);

        JPanel jPanel_Buttons =new JPanel();
        jPanel_Buttons.setLayout(new GridLayout(2,3));
        jPanel_Buttons.add(jButton_plus);
        jPanel_Buttons.add(jButton_minus);
        jPanel_Buttons.add(jButton_multiply);
        jPanel_Buttons.add(jButton_divide);
        jPanel_Buttons.add(jButton_pow);
        jPanel_Buttons.add(jButton_mod);


        this.setLayout(new BorderLayout(10,10));
        this.add(jPanel_IO,BorderLayout.CENTER);
        this.add(jPanel_Buttons,BorderLayout.SOUTH);

    }

    public void plus(){
        double firstValue= Double.valueOf(jTextField_firstValue.getText());
        double secondValue= Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFrist_value(firstValue);
        this.miniCalculatorModel.setSecond_value(secondValue);
        this.miniCalculatorModel.plus();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
    }
    public void minus(){
        double firstValue= Double.valueOf(jTextField_firstValue.getText());
        double secondValue= Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFrist_value(firstValue);
        this.miniCalculatorModel.setSecond_value(secondValue);
        this.miniCalculatorModel.minus();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
    }
    public void multiply(){
        double firstValue= Double.valueOf(jTextField_firstValue.getText());
        double secondValue= Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFrist_value(firstValue);
        this.miniCalculatorModel.setSecond_value(secondValue);
        this.miniCalculatorModel.multiply();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
    }
    public void divide(){
        double firstValue= Double.valueOf(jTextField_firstValue.getText());
        double secondValue= Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFrist_value(firstValue);
        this.miniCalculatorModel.setSecond_value(secondValue);
        this.miniCalculatorModel.divide();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
    }
    public void pow(){
        double firstValue= Double.valueOf(jTextField_firstValue.getText());
        double secondValue= Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFrist_value(firstValue);
        this.miniCalculatorModel.setSecond_value(secondValue);
        this.miniCalculatorModel.pow();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
    }
    public void mod(){
        double firstValue= Double.valueOf(jTextField_firstValue.getText());
        double secondValue= Double.valueOf(jTextField_secondValue.getText());
        this.miniCalculatorModel.setFrist_value(firstValue);
        this.miniCalculatorModel.setSecond_value(secondValue);
        this.miniCalculatorModel.mod();
        this.jTextField_answer.setText(this.miniCalculatorModel.getAnswer()+"");
    }
}
