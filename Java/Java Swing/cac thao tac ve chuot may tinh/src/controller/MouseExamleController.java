package controller;

import view.MouseExamleView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseExamleController implements MouseListener, MouseMotionListener {
    private MouseExamleView mouseExamleView;

    public MouseExamleController(MouseExamleView mouseExamleView) {
        this.mouseExamleView = mouseExamleView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.mouseExamleView.Click();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.mouseExamleView.enter();
        int x = e.getX();
        int y = e.getY();
        this.mouseExamleView.update(x,y);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.mouseExamleView.exit();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.mouseExamleView.update(x,y);
    }
}
