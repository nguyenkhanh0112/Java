package controller;

import view.SreachView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SreachListener implements ActionListener {
    private SreachView sreachView;

    public SreachListener(SreachView sreachView) {
        this.sreachView = sreachView;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.sreachView.sreach();
    }
}
