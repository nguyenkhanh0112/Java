package mmmvc.color.controller;

import mmmvc.color.view1.MyColorView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyColorListener implements ActionListener {
    private MyColorView myColorView;
    public MyColorListener(MyColorView myColorView){
        this.myColorView=myColorView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Red Text")){
            this.myColorView.changerTextColor(Color.RED);
        }else if(src.equals("Yellow Text")){
            this.myColorView.changerTextColor(Color.YELLOW);
        }else if(src.equals("Green Text")){
            this.myColorView.changerTextColor(Color.GREEN);
        }else if(src.equals("Red Background")){
            this.myColorView.changeBackgroundColor(Color.RED);
        }else if(src.equals("Yellow Background")){
            this.myColorView.changeBackgroundColor(Color.YELLOW);
        }else if(src.equals("Green Background")){
            this.myColorView.changeBackgroundColor(Color.GREEN);
        }
    }
}
