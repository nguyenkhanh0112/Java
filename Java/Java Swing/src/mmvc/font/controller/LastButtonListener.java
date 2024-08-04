package mmvc.font.controller;

import mmvc.font.view.LastButtonView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LastButtonListener implements ActionListener {
    private LastButtonView lastButtonView;

    public LastButtonListener(LastButtonView lastButtonView) {
        this.lastButtonView = lastButtonView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nguonsukien = e.getActionCommand();
        if(nguonsukien.equals("1")){
            this.lastButtonView.changeTo_1();
        }else if(nguonsukien.equals("2")){
            this.lastButtonView.changeTo_2();
        }else if(nguonsukien.equals("3"))
            this.lastButtonView.changeTo_3();
        else if(nguonsukien.equals("4"))
            this.lastButtonView.changeTo_4();
    }
}
