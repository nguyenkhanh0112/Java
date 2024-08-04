package JavaSwing.BTVN;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VD6_cong_tru_nhan_chia extends JFrame {
    private JRadioButton btncong,btntru,btnnhan,btnchia;
    private JButton btnGiai,btnXoa,btnThoat;

    private JTextField jTextSoa ;
    private JTextField jTextSob ;
    private JTextField jTextKetqua ;
    public VD6_cong_tru_nhan_chia(){
        init();
    }
    public void init(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setSize(400,300);
        setTitle("Cộng - Trừ - Nhân - Chia");
        setLayout(new BorderLayout());
        Font font = new Font("Arial",Font.BOLD,18);
        JLabel label = new JLabel("Cộng Trừ Nhân Chia");
        label.setFont(font);
        label.setForeground(Color.blue);

        btnGiai = new JButton("Giải   ");
        btnXoa = new JButton("Xóa   ");
        btnThoat = new JButton("Thoát");


        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(getWidth(),30));
        panel2.add(label);
        add(panel2,BorderLayout.NORTH);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        Border weast = BorderFactory.createLineBorder(Color.red);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(weast,"Chọn tác vụ");
        panel1.setBorder(titledBorder);
        panel1.add(btnGiai);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(btnXoa);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(btnThoat);
        panel1.setPreferredSize(new Dimension(90,30));
        panel1.setBackground(Color.LIGHT_GRAY);
        add(panel1,BorderLayout.WEST);

        JPanel jPanel3 = new JPanel();
        TitledBorder titledBorder2 = new TitledBorder(weast,"Nhập 2 số a và b");
        JLabel label1 = new JLabel("Nhập a");
        JLabel label2 = new JLabel("Nhập b");
        JLabel label3 = new JLabel("Kết Quả: ");
        jTextSoa = new JTextField("",10);
        jTextSob = new JTextField("",10);
        jTextKetqua = new JTextField("",10);
        jTextKetqua.setFocusable(false);

        JPanel so1 = new JPanel(new FlowLayout());
        so1.add(label1);
        so1.add(jTextSoa);
        so1.setPreferredSize(new Dimension(getWidth(),10));
        JPanel so2 = new JPanel(new FlowLayout());
        so2.add(label2);
        so2.add(jTextSob);
        so2.setPreferredSize(new Dimension(getWidth(),0));

        JPanel so3 = new JPanel(new FlowLayout());

        so3.add(label3);
        so3.add(jTextKetqua);
        so3.setPreferredSize(new Dimension(getWidth(),10));
        JPanel jPanelRadioButton = new JPanel(new GridLayout(2,2));
         btncong = new JRadioButton("Cộng");
         btntru = new JRadioButton("Trừ");
         btnnhan = new JRadioButton("Nhân");
         btnchia = new JRadioButton("Chia");
        jPanelRadioButton.setPreferredSize(new Dimension(getWidth(),20));
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Chọn phép toán:");
        jPanelRadioButton.setBorder(titledBorder1);
        jPanelRadioButton.add(btncong);
        jPanelRadioButton.add(btntru);
        jPanelRadioButton.add(btnnhan);
        jPanelRadioButton.add(btnchia);

        JPanel panelCenten = new JPanel();
        panelCenten.setBorder(titledBorder2);
        panelCenten.setLayout(new BoxLayout(panelCenten,BoxLayout.Y_AXIS));
        panelCenten.add(so1);
        panelCenten.add(so2);
        panelCenten.add(jPanelRadioButton);
        panelCenten.add(so3);
        add(panelCenten,BorderLayout.CENTER);

        JPanel jPanelSouth = new JPanel();
        jPanelSouth.setPreferredSize(new Dimension(0,30));
        jPanelSouth.setBackground(Color.PINK);

        JPanel pn1 = new JPanel();
        pn1.setBackground(Color.BLUE);
        jPanelSouth.add(pn1);

        JPanel pn2 = new JPanel();
        pn2.setBackground(Color.RED);
        jPanelSouth.add(pn2);

        JPanel pn3 = new JPanel();
        pn3.setBackground(Color.YELLOW);
        jPanelSouth.add(pn3);
        add(jPanelSouth,BorderLayout.SOUTH);



        setVisible(true);


    }
    public void addControl(){
        btnThoat.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnXoa.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextSoa.setText("");
                jTextSob.setText("");
                jTextKetqua.setText("");
            }
        });
        btnGiai.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sa = jTextSoa.getText();
                int a=0,b=0;
                try{
                     a = Integer.parseInt(sa);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Nhập sai định dạng");
                    jTextSoa.selectAll();
                    jTextSoa.requestFocus();
                }
                String sb = jTextSob.getText();
                try{
                    b= Integer.parseInt(sb);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Nhập sai định dạng");
                    jTextSob.selectAll();
                    jTextSob.requestFocus();
                }
                double kq = 0;
                if(btncong.isSelected()){
                    kq = a +b;

                }else if(btntru.isSelected()){
                    kq = a-b;

                }else if(btnnhan.isSelected()){
                    kq = a*b;

                }else if(btnchia.isSelected()){
                    kq = ((1.0)*a)/b;
                }
                jTextKetqua.setText(kq+"");
            }

        });
    }
    public static void main(String[] args) {
        VD6_cong_tru_nhan_chia vd6_cong_tru_nhan_chia = new VD6_cong_tru_nhan_chia();
        vd6_cong_tru_nhan_chia.addControl();
    }

}
