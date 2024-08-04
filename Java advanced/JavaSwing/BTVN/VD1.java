package JavaSwing.BTVN;

import javax.swing.*;

public class VD1 extends JFrame {
    public VD1(){
        super("Demo Windows");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        VD1 vd = new VD1();
        vd.setSize(400,300);
        vd.setLocationRelativeTo(null);
        vd.setVisible(true);
    }
}
