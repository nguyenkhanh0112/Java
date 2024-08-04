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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentationlayer.panel.JPNSinhVien_DangKyHocPhan;
import presentationlayer.panel.JPNAdmin_NguoiDung;
import presentationlayer.panel.JPNSinhVien_ChuongTrinhHoc;
import presentationlayer.panel.JPNSinhVien_HocPhi;
import presentationlayer.panel.JPNSinhVien_ThongTinCaNhan;
import util.Constants;

public class JFSinhVien extends JFrame{
    private JPanel pnCenter;

    private JLabel lblTitle;
    private JButton btThongTinCaNhan;
    private JButton btChuongTrinhHoc;
    private JButton btDangKy;
    private JButton btHocPhi;
    private JButton btDangXuat;
    private JButton btLogo;
    
    public JFSinhVien() {
        super("Sinh viên");
        addControl();
        addEvent();
    }

    public void doShow() {
        setSize(1154, 630);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addControl() {
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
        btLogo.setBorderPainted(false);
        btLogo.setContentAreaFilled(false);

        lblTitle = new JLabel("Xin chào");
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

        btThongTinCaNhan = createNewJButton("Thông tin cá nhân");
        pnButtons.add(btThongTinCaNhan, gbcButtons);

        btChuongTrinhHoc = createNewJButton("Chương trình học");
        pnButtons.add(btChuongTrinhHoc, gbcButtons);

        btDangKy = createNewJButton("Đăng ký học phần");
        pnButtons.add(btDangKy, gbcButtons);

        btHocPhi = createNewJButton("Học phí");
        pnButtons.add(btHocPhi, gbcButtons);

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
        btThongTinCaNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                JPNSinhVien_ThongTinCaNhan jpnSinhVien_ThongTinCaNhan = new JPNSinhVien_ThongTinCaNhan();
                pnCenter.add(jpnSinhVien_ThongTinCaNhan);
                pnCenter.revalidate();
                pnCenter.repaint();
                lblTitle.setText(btThongTinCaNhan.getText());
            }
        });

        btChuongTrinhHoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                JPNSinhVien_ChuongTrinhHoc jpnSinhVien_ChuongTrinhHoc = new JPNSinhVien_ChuongTrinhHoc();
                pnCenter.add(jpnSinhVien_ChuongTrinhHoc);
                pnCenter.revalidate();
                pnCenter.repaint();
                lblTitle.setText(btChuongTrinhHoc.getText());
            }
        });

        btDangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                JPNSinhVien_DangKyHocPhan jpnSinhVien_DangKy = new JPNSinhVien_DangKyHocPhan();
                pnCenter.add(jpnSinhVien_DangKy);
                pnCenter.revalidate();
                pnCenter.repaint();
                lblTitle.setText(btDangKy.getText());
            }
        });

        btHocPhi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                JPNSinhVien_HocPhi jpnSinhVien_HocPhi = new JPNSinhVien_HocPhi();
                pnCenter.add(jpnSinhVien_HocPhi);
                pnCenter.revalidate();
                pnCenter.repaint();
                lblTitle.setText(btHocPhi.getText());
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
                lblTitle.setText("Xin chào");
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
