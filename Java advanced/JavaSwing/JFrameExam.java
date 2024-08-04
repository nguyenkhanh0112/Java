package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFrameExam extends JFrame {
    private JLabel label1,label2;
    private  JPanel panel;
    private  JFrame jFrame;

    public JFrameExam(){
        GUI();
    }

    public static void main(String[] args) {
        JFrameExam demo = new JFrameExam();
        demo.showJFramExam();
    }
    public void GUI(){
        jFrame = new JFrame("Example!");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(400,200);
        jFrame.setVisible(true);
        jFrame.setLayout(new GridLayout(3,1));
        label1 = new JLabel("",0);
        label2 = new JLabel("",0);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        jFrame.add(label1);
        jFrame.add(panel);
        jFrame.add(label2);
    }
    public void showJFramExam(){
        label1.setText("Container in action: JFrame");
        JFrame frame1 = new JFrame();
        frame1.setLayout(new FlowLayout());
        frame1.setDefaultCloseOperation(3);
        frame1.setSize(350,200);
        JLabel label = new JLabel("Chao mung ban den voi chung toi!",0);
        frame1.add(label);
        JButton button = new JButton("Open a Frame");
        frame1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame1.dispose();
            }
        });
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(true);
                frame1.setLocationRelativeTo(null);
                label2.setText("Mot Frame duoc hien thi toi nguoi dung.");
            }
        });
        panel.add(button);
        jFrame.setVisible(true);
    }
}
