package JavaSwing.BTVN;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Bai4 extends JFrame {
    private JTextField jTextFieldResult,jTextFieldName;
    private JButton btnWelcome,btnClear,btnCancel;
    private JRadioButton jRadioButton1,jRadioButton2;

    public Bai4(){
        init();
        Control();
    }
    public void init(){
        setDefaultCloseOperation(3);
//        setSize(400,300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(),1));
        Font font = new Font("Arial",Font.PLAIN,16);
        JPanel panel1 = new JPanel();
        JLabel jLabelFullName = new JLabel("Full name:",JLabel.RIGHT);
        jLabelFullName.setForeground(Color.red);
        jTextFieldName = new JTextField(10);
        jTextFieldName.setForeground(Color.red);
        panel1.setFont(font);
        panel1.add(jLabelFullName);
        panel1.add(jTextFieldName);

        TitledBorder titledBorder =BorderFactory.createTitledBorder(null,"Gener");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.blue);
        JPanel jPanel2 = new JPanel();
        jPanel2.setBorder(titledBorder);
        jRadioButton1 = new JRadioButton("Mr.");
        jRadioButton1.setForeground(Color.red);
        jRadioButton2 = new JRadioButton("Miss");
        jRadioButton2.setForeground(Color.red);
        jPanel2.setFont(font);
        jPanel2.add(jRadioButton1);
        jPanel2.add(jRadioButton2);


        JPanel panel3 = new JPanel();
        JLabel jLabelFullResult = new JLabel("Result:",JLabel.RIGHT);
        jLabelFullResult.setForeground(Color.red);
        jTextFieldResult = new JTextField(10);
        jTextFieldResult.setForeground(Color.red);
        jTextFieldResult.setEnabled(false);
        panel3.setFont(font);
        panel3.add(jLabelFullResult );
        panel3.add(jTextFieldResult);

        JPanel jPanel4 = new JPanel();
        btnWelcome = new JButton("Welcome");
        btnWelcome.setForeground(Color.blue);
        btnClear = new JButton("Clear");
        btnClear.setForeground(Color.blue);
        btnCancel = new JButton("Cancel");
        btnCancel.setForeground(Color.blue);
        jPanel4.add(btnWelcome);
        jPanel4.add(btnClear);
        jPanel4.add(btnCancel);
        add(panel1);
        add(jPanel2);
        add(panel3);
        add(jPanel4);
        pack();
    }
    public void Control(){
        btnWelcome.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jTextFieldName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Hãy nhập tên của bạn.");
                }else if(jRadioButton1.isSelected()){
                    jTextFieldResult.setText("Welcome Mr."+jTextFieldName.getText());
                } else if (jRadioButton2.isSelected()) {
                    jTextFieldResult.setText("Welcome Miss "+jTextFieldName.getText());
                }else{
                    jTextFieldResult.setText("Welcome "+jTextFieldName.getText());
                }
            }
        });
        btnCancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnClear.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldName.setText("");
                jTextFieldResult.setText("");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        Bai4 bai4 = new Bai4();
    }

}
