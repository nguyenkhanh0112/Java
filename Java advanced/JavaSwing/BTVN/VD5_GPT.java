package JavaSwing.BTVN;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VD5_GPT extends JFrame {
    private JFrame jFrame;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JTextField jtxtSoA;
    private JTextField jtxtSoB;
    private JTextField jtxtSoC;
    private JTextField jtxtKetqua;


    public VD5_GPT(){
        init();
    }
    public void init(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setSize(400,300);


        JLabel label = new JLabel("Giải Phương Trình Bặc 2",JLabel.CENTER);
        JLabel label1 = new JLabel("a:",JLabel.RIGHT);
        JLabel label2 = new JLabel("b:",JLabel.RIGHT);
        JLabel label3 = new JLabel("c:",JLabel.RIGHT);
        JLabel label4 = new JLabel("Kết quả",JLabel.CENTER);

        jtxtSoA = new JTextField(10);
        jtxtSoB = new JTextField(10);
        jtxtSoC = new JTextField(10);
        jtxtKetqua = new JTextField(20);
        jtxtKetqua.setFocusable(false);


        JPanel jPanel1 = new JPanel(new FlowLayout());
        JPanel jPanel2 = new JPanel(new FlowLayout());
        JPanel jPanel3 = new JPanel(new FlowLayout());
        JPanel jPanel4 = new JPanel(new FlowLayout());
        JPanel jPanel5 = new JPanel();
        jPanel5.setPreferredSize(new Dimension(getWidth(),30));


        jPanel1.add(label1);
        jPanel1.add(jtxtSoA);
        jPanel2.add(label2);
        jPanel2.add(jtxtSoB);
        jPanel3.add(label3);
        jPanel3.add(jtxtSoC);
        jPanel4.add(label4);
        jPanel4.add(jtxtKetqua);
        jPanel5.add(label);

        JPanel container1 = new JPanel();
        container1.setLayout(new GridLayout(4,1));
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Nhập a,b,c");
        container1.setBorder(titledBorder);
        container1.add(jPanel1);
        container1.add(jPanel2);
        container1.add(jPanel3);
        container1.add(jPanel4);

        JPanel container2 = new JPanel();
        container2.setLayout(new FlowLayout());
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Chọn thao tác");
        container2.setBorder(titledBorder1);

        jButton1 = new JButton("Giải");
        jButton2 = new JButton("Xóa Trắng");
        jButton3 = new JButton("Thoát");

        container2.add(jButton1);
        container2.add(jButton2);
        container2.add(jButton3);
        container1.setPreferredSize(new Dimension(getWidth(),200));
        add(jPanel5,BorderLayout.NORTH);
        add(container1,BorderLayout.CENTER);
        add(container2,BorderLayout.SOUTH);
        setVisible(true);
    }
    public void GPT(){
        jButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(jtxtSoA.getText());
                int b = Integer.parseInt(jtxtSoB.getText());
                int c = Integer.parseInt(jtxtSoC.getText());
                double denta = Math.pow(b,2)-(4*a*c);
                if(denta > 0){
                    double sqrtDenta = Math.sqrt(denta);
                    double x1 = (-b+sqrtDenta)/(2*a);
                    double x2 = (-b-sqrtDenta)/(2*a);
                    jtxtKetqua.setText("PT Có 2 Nghiệm:\nx1 = "+x1+"\n"+"x2 = "+x2);
                }else if(denta ==0){
                    double x = -b/(2*a);
                    jtxtKetqua.setText("PT Có 1 Nghiệm:\nx = "+x);
                } else if (denta<0) {
                    jtxtKetqua.setText("PT vô nghiệm");
                }
            }
        });
        jButton2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtxtSoA.setText("");
                jtxtSoB.setText("");
                jtxtSoC.setText("");
                jtxtKetqua.setText("");
            }
        });
        jButton3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        VD5_GPT vd5_gpt = new VD5_GPT();
        vd5_gpt.GPT();
    }
}
