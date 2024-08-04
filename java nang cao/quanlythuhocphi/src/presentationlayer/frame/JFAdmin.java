package presentationlayer.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentationlayer.panel.JPNAdmin_NguoiDung;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import util.Constants;

public class JFAdmin extends JFrame{
    
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem itQuanLy;

    private JPanel pnCenter;

    private JButton btTaiKhoan;
    private JButton btDangXuat;
    private JButton btLogo;
    private JLabel lblTitle;
    
    public JFAdmin() {
        super("Admin");
        addControl();
        addEvent();
    }

    public void doShow() {
        setSize(1286, 796);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addControl() {
        //JMenuBar
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        itQuanLy = new JMenuItem("Quản lý");

        menu.add(itQuanLy);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        
        // Panel MAIN
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        // Panel North
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnNorth.setBackground(Constants.BASE_BACKGROUND_COLOR);
        ImageIcon icLogo = new ImageIcon(Constants.IMAGE_PATH + "logoutt.png");
        Image imgLogo = icLogo.getImage();
        Image scaledImageLogo = imgLogo.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcLogo = new ImageIcon(scaledImageLogo);
        btLogo = new JButton(scaledIcLogo);
        btLogo.setPreferredSize(new Dimension(200, 100));
        btLogo.setContentAreaFilled(false);
        btLogo.setBorderPainted(false);

        lblTitle = new JLabel("ADMIN");
        lblTitle.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 48));
        lblTitle.setForeground(Constants.BASE_TEXT_COLOR);
        lblTitle.setAlignmentY(CENTER_ALIGNMENT);
        lblTitle.setBorder(new EmptyBorder(0, 5, 0, 0));

        pnNorth.add(btLogo);
        pnNorth.add(lblTitle);

        // Panel West
        JPanel pnWest = new JPanel(new BorderLayout());

        pnWest.setBackground(Constants.BASE_BACKGROUND_COLOR);

        JPanel pnButtons = new JPanel();
        pnButtons.setLayout(new GridBagLayout());
        pnButtons.setBackground(Constants.BASE_BACKGROUND_COLOR);
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.anchor = GridBagConstraints.NORTH;
        gbcButtons.gridwidth = GridBagConstraints.REMAINDER;

        btTaiKhoan = createNewJButton("Tài Khoản");
        pnButtons.add(btTaiKhoan, gbcButtons);

        btDangXuat = createNewJButton("Đăng Xuất");
        pnButtons.add(btDangXuat, gbcButtons);

        pnWest.add(pnButtons, BorderLayout.NORTH);
        
        // Panel Center
        pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());

        // Frame
        pnMain.add(pnNorth, BorderLayout.NORTH);
        pnMain.add(pnWest, BorderLayout.WEST);
        pnMain.add(pnCenter, BorderLayout.CENTER);

        getContentPane().add(pnMain);
    }

    private void addEvent() {
        itQuanLy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFQuanLy jF = new JFQuanLy();
                jF.doShow();
            }
        });

        btTaiKhoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                JPNAdmin_NguoiDung jpnAdmin_NguoiDung = new JPNAdmin_NguoiDung();
                pnCenter.add(jpnAdmin_NguoiDung);
                pnCenter.revalidate();
                pnCenter.repaint();
                lblTitle.setText("Quản lý tài khoản");
            }
        });

        btDangXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFLogin.getInstance().setVisible(true);
                dispose();
            }
        });

        btLogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                pnCenter.revalidate();
                pnCenter.repaint();
                lblTitle.setText("ADMIN");
            }
        });
    }

    private JButton createNewJButton(String btName) {
        JButton temp = new JButton(btName);
        temp.setBorderPainted(false);
        temp.setContentAreaFilled(false);
        temp.setPreferredSize(new Dimension(200, 70));
        temp.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 21));
        temp.setForeground(Constants.BASE_TEXT_COLOR);

        return temp;
    }
}
