package mmmvc.color.model;

import java.awt.*;

public class MyColorModel {
    private Color foregroud;
    private Color backgroud;
    private boolean opaque;

    public MyColorModel(){
        this.foregroud=Color.BLACK;
        this.backgroud=Color.WHITE;
        this.opaque = true;
    }

    public boolean isOpaque() {
        return opaque;
    }

    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }

    public Color getForegroud() {
        return foregroud;
    }

    public void setForegroud(Color foregroud) {
        this.foregroud = foregroud;
    }

    public Color getBackgroud() {
        return backgroud;
    }

    public void setBackgroud(Color backgroud) {
        this.backgroud = backgroud;
    }
}
