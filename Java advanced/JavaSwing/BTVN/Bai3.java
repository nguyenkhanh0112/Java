package JavaSwing.BTVN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Bai3 extends JFrame {
    public Bai3(){
        init();
        setVisible(true);
    }
    public void init(){
        setDefaultCloseOperation(3);
        setSize(400,300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(),1));
        JTextField jTextField = new JTextField(20);
        JCheckBox jCheckBox1 = new JCheckBox("Bold");
        JCheckBox jCheckBox2 = new JCheckBox("italic");
        JPanel panel = new JPanel();
        panel.add(jCheckBox1);
        panel.add(jCheckBox2);
        add(jTextField);
        add(panel);
        pack();
        Font font = new Font("Arial",Font.PLAIN,16);
        jTextField.setFont(font);
        jCheckBox1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = jTextField.getFont();
                int style = currentFont.getStyle();
                if(jCheckBox1.isSelected()&&jCheckBox2.isSelected()){
                    style = Font.BOLD | Font.ITALIC;

                }else if(!jCheckBox1.isSelected()&&jCheckBox2.isSelected()){
                    style =  Font.ITALIC;
                }
                else if(jCheckBox1.isSelected()){
                    style = Font.BOLD;
                }
                else{
                    style =  Font.PLAIN;
                }
                Font updatedFont = new Font(currentFont.getName(), style, currentFont.getSize());
                jTextField.setFont(updatedFont);
            }
        });
        jCheckBox2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = jTextField.getFont();
                int style = currentFont.getStyle();
                if(jCheckBox1.isSelected()&&jCheckBox2.isSelected()){
                    style = Font.BOLD | Font.ITALIC;
                }else if(jCheckBox1.isSelected()&&!jCheckBox2.isSelected()){
                    style = Font.BOLD;
                }else if(jCheckBox2.isSelected()){
                    style = Font.ITALIC;
                }
                else {
                    style = Font.PLAIN;
                }
                Font updatedFont = new Font(currentFont.getName(), style, currentFont.getSize());
                jTextField.setFont(updatedFont);
            }
        });

    }
    public static void main(String[] args) {
        Bai3 bai3 = new Bai3();
    }
}
