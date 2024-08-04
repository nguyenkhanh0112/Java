package presentationlayer.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;

import businesslogiclayer.NGUOIDUNGBUS;
import presentationlayer.dialog.JDLChangePassword;
import util.Constants;

public class JFLogin extends JFrame {
    private NGUOIDUNGBUS bus = new NGUOIDUNGBUS();
    private static JFLogin instance;

    private JTextField txfTaiKhoan;
    private JPasswordField passfMatKhau;
    private JButton btDoiMK;
    private JButton btLogin;

    public JFLogin() {
        super("Đăng nhập");
        addControl();
        addEvent();
    }

    public static JFLogin getInstance() {
        if (instance == null) {
            instance = new JFLogin();
        }
        return instance;
    }

    public void doShow() {
        setSize(816, 460);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addControl(){
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        JPanel pnWest = new JPanel();
        pnWest.setLayout(new GridBagLayout());
        GridBagConstraints gbcWest = new GridBagConstraints();

        gbcWest.insets = new Insets(0, 40, 0, 40);
        gbcWest.anchor = GridBagConstraints.CENTER;
        gbcWest.gridx = 0;
        gbcWest.weighty = 0;
        ImageIcon icLogo = new ImageIcon(Constants.IMAGE_PATH + "logoutt.png");
        Image image = icLogo.getImage();
        Image scaledImage = image.getScaledInstance(271, 277, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lblLogo = new JLabel(scaledIcon);
        
        pnWest.add(lblLogo, gbcWest);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new GridBagLayout());
        GridBagConstraints gbcCenter = new GridBagConstraints();
        gbcCenter.insets = new Insets(20, 5, 20, 5);  

        JLabel lblTitle = new JLabel("ĐĂNG NHẬP");
        lblTitle.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 35));
        gbcCenter.gridwidth = 2;
        gbcCenter.gridx = 0;
        gbcCenter.gridy = 0;
        pnCenter.add(lblTitle, gbcCenter);

        JLabel lblTaiKhoan = new JLabel("Tài khoản");
        lblTaiKhoan.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        gbcCenter.anchor = GridBagConstraints.CENTER;
        gbcCenter.gridwidth = 1;
        gbcCenter.gridx = 0;
        gbcCenter.gridy = 1;
        pnCenter.add(lblTaiKhoan, gbcCenter);

        txfTaiKhoan = new JTextField();
        txfTaiKhoan.setPreferredSize(new Dimension(281, 26));
        txfTaiKhoan.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        gbcCenter.gridx = 1;
        gbcCenter.gridy = 1;
        pnCenter.add(txfTaiKhoan, gbcCenter);

        JLabel lblMatKhau = new JLabel("Mật khẩu");
        lblMatKhau.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        gbcCenter.anchor = GridBagConstraints.CENTER;
        gbcCenter.gridx = 0;
        gbcCenter.gridy = 2;
        pnCenter.add(lblMatKhau, gbcCenter);

        passfMatKhau = new JPasswordField();
        passfMatKhau.setPreferredSize(new Dimension(281, 26));
        passfMatKhau.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        gbcCenter.gridx = 1;
        gbcCenter.gridy = 2;
        pnCenter.add(passfMatKhau, gbcCenter);

        btLogin = new JButton("Login");
        btLogin.setPreferredSize(new Dimension(394, 52));
        btLogin.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        gbcCenter.gridwidth = 2;
        gbcCenter.gridx = 0;
        gbcCenter.gridy = 3;
        pnCenter.add(btLogin, gbcCenter);

        btDoiMK = new JButton("Đổi mật khẩu?");
        btDoiMK.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        btDoiMK.setBorderPainted(false);
        btDoiMK.setContentAreaFilled(false);
        btDoiMK.setForeground(Color.BLUE);
        gbcCenter.insets = new Insets(0, 5, 20, 5);
        gbcCenter.anchor = GridBagConstraints.NORTHEAST;
        gbcCenter.gridwidth = 2;
        gbcCenter.gridx = 1;
        gbcCenter.gridy = 4;
        pnCenter.add(btDoiMK, gbcCenter);

        pnMain.add(pnWest, BorderLayout.WEST);
        pnMain.add(pnCenter, BorderLayout.CENTER);

        getContentPane().add(pnMain);
    }

    private void addEvent() {
        btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = null;
                rs = bus.GetData(txfTaiKhoan.getText());
                try {
                    if (rs.next()) {
                        if (rs.getString("MATKHAU").equals(new String(passfMatKhau.getPassword())))
                        {
                            setVisible(false);
                            if (rs.getString("QUYEN").equals("Admin"))
                            {
                                JFAdmin jF = new JFAdmin();
                                jF.doShow();
                            }
                            if (rs.getString("QUYEN").equals("User"))
                            {
                                JFSinhVien jF = new JFSinhVien();
                                jF.doShow();
                            }
                            if (rs.getString("QUYEN").equals("QuanLy"))
                            {
                                JFQuanLy jF = new JFQuanLy();
                                jF.doShow();
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(instance, "Mật khẩu sai, vui lòng nhập lại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(instance, "Tài khoản không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        txfTaiKhoan.requestFocus();
                    }                
                } catch (SQLException sqlE) {
                    sqlE.printStackTrace();
                }
            }
        });

        btDoiMK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs =  null;
                rs = bus.GetData(txfTaiKhoan.getText());
                try {
                    if (rs.next()) {
                        JDLChangePassword jfChangePassword = new JDLChangePassword(txfTaiKhoan.getText());
                        jfChangePassword.doShow();
                    } else {
                        JOptionPane.showMessageDialog(instance, "Tài khoản không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        txfTaiKhoan.requestFocus();
                    }
                } catch (SQLException sqlE) {
                    sqlE.printStackTrace();
                }
            }
        });

        txfTaiKhoan.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btLogin.doClick();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        passfMatKhau.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btLogin.doClick();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}
