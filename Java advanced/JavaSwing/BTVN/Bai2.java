package JavaSwing.BTVN;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Bai2 extends JFrame {
    private JTextField jTextFieldDoF, jTextFieldDoC;
    private JButton btnTinh, btnTieptuc, btnThoat;

    public Bai2() {
        init();
    }

    public void init() {
        setDefaultCloseOperation(3);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setTitle("Convert from F to C");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "");

        // Kích thước cửa sổ sẽ được quyết định tự động dựa trên kích thước của các thành phần
         setSize(300, 200);

        JPanel panel1 = new JPanel();
        JLabel label = new JLabel("Nhập vào Độ F: ", JLabel.RIGHT);
        jTextFieldDoF = new JTextField(10);
        label.setForeground(Color.red);
        panel1.add(label);
        panel1.add(jTextFieldDoF);

        JPanel panel2 = new JPanel();
        JLabel label1 = new JLabel("Độ C tương ứng: ", JLabel.RIGHT);
        jTextFieldDoC = new JTextField(10);
        label1.setForeground(Color.red);
        panel2.add(label1);
        panel2.add(jTextFieldDoC);

        JPanel panel3 = new JPanel(new FlowLayout());
        btnTinh = new JButton("Tính");
        btnTinh.setForeground(Color.BLUE);

        btnTieptuc = new JButton("Tiếp tục");
        btnTieptuc.setForeground(Color.BLUE);

        btnThoat = new JButton("Thoát");
        btnThoat.setForeground(Color.BLUE);
        panel3.setBorder(titledBorder);
        panel3.add(btnTinh);
        panel3.add(btnTieptuc);
        panel3.add(btnThoat);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(panel1);
        panel.add(panel2);
        panel.setBorder(titledBorder);

        // Thêm các thành phần vào cửa sổ
        add(panel);
        add(panel3);

        // Tự động điều chỉnh kích thước cửa sổ dựa trên kích thước các thành phần
        pack();

        setVisible(true);
    }

    public boolean containsLetters(String s) {
        return s.matches(".*[a-zA-Z].*");
    }

    public void addControl() {
        btnTinh.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextFieldDoF.getText().isEmpty() && jTextFieldDoC.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị vào ít nhất một ô.");
                } else if (!jTextFieldDoF.getText().isEmpty()) {
                    if (containsLetters(jTextFieldDoF.getText())) {
                        JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
                        jTextFieldDoF.requestFocus();
                    } else {
                        double F = Double.parseDouble(jTextFieldDoF.getText());
                        double C = (1.0 * (F - 32)) / 1.8;
                        jTextFieldDoC.setText(String.format("%.2f", C));
                    }
                } else if (!jTextFieldDoC.getText().isEmpty()) {
                    if (containsLetters(jTextFieldDoC.getText())) {
                        JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
                        jTextFieldDoC.requestFocus();
                    } else {
                        double C = Double.parseDouble(jTextFieldDoC.getText());
                        double F = C * 1.8 + 32;
                        jTextFieldDoF.setText(String.format("%.2f", F));
                    }
                }
            }
        });

        btnThoat.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnTieptuc.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldDoC.setText("");
                jTextFieldDoF.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Bai2 bai2 = new Bai2();
        bai2.addControl();
    }
}
