package controller;

import view.MiniCalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniCalculatiorListenner implements ActionListener {
    private MiniCalculatorView miniCalculatorView;

    public MiniCalculatiorListenner(MiniCalculatorView miniCalculatorView) {
        this.miniCalculatorView = miniCalculatorView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if(button.equals("+"))
            this.miniCalculatorView.plus();
        else if(button.equals("-"))
            this.miniCalculatorView.minus();
        else if(button.equals("*"))
            this.miniCalculatorView.multiply();
        else if(button.equals("/"))
            this.miniCalculatorView.divide();
        else if(button.equals("^"))
            this.miniCalculatorView.pow();
        else if(button.equals("%"))
            this.miniCalculatorView.mod();
    }
}
