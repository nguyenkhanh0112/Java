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

import presentationlayer.panel.JPNQuanLy_BaoCao;
import presentationlayer.panel.JPNQuanLy_ChuyenNganh;
import presentationlayer.panel.JPNQuanLy_GiangVien;
import presentationlayer.panel.JPNQuanLy_Khoa;
import presentationlayer.panel.JPNQuanLy_Lop;
import presentationlayer.panel.JPNQuanLy_LopHocPhan;
import presentationlayer.panel.JPNQuanLy_MonHoc;
import presentationlayer.panel.JPNQuanLy_PhieuThu;
import presentationlayer.panel.JPNQuanLy_SinhVien;
import util.Constants;

public class JFQuanLy extends JFrame{
    private JPanel pnCenter;
    
    private JButton btKhoa;
    private JButton btChuyenNganh;
    private JButton btLop;
    private JButton btMonHoc;
    private JButton btGiangVien;
    private JButton btLopHocPhan;
    private JButton btSinhVien;
    private JButton btTaoPhieuThu;
    private JButton btBaoCao;
    private JButton btDangXuat;
    private JButton btLogo;
    private JLabel lblTitle;
    
    public JFQuanLy() {
        super("Quản lý");
        addControl();
        addEvent();
    }

    public void doShow() {
        setSize(1286, 857);
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

        lblTitle = new JLabel("Quản lý");
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

        btKhoa = createNewJButton("Khoa");
        pnButtons.add(btKhoa, gbcButtons);

        btChuyenNganh = createNewJButton("Chuyên ngành");
        pnButtons.add(btChuyenNganh, gbcButtons);

        btLop = createNewJButton("Lớp");
        pnButtons.add(btLop, gbcButtons);

        btMonHoc = createNewJButton("Môn học");
        pnButtons.add(btMonHoc, gbcButtons);

        btGiangVien = createNewJButton("Giảng viên");
        pnButtons.add(btGiangVien, gbcButtons);

        btLopHocPhan = createNewJButton("Lớp học phần");
        pnButtons.add(btLopHocPhan, gbcButtons);

        btSinhVien = createNewJButton("Sinh viên");
        pnButtons.add(btSinhVien, gbcButtons);

        btTaoPhieuThu = createNewJButton("Tạo phiếu thu");
        pnButtons.add(btTaoPhieuThu, gbcButtons);

        btBaoCao = createNewJButton("Báo cáo");
        pnButtons.add(btBaoCao, gbcButtons);

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
        btKhoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý khoa");
                JPNQuanLy_Khoa jfQuanLy_Khoa = new JPNQuanLy_Khoa();
                pnCenter.add(jfQuanLy_Khoa);
                pnCenter.revalidate();
                pnCenter.repaint();
            }
        });

        btChuyenNganh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý chuyên ngành");
                JPNQuanLy_ChuyenNganh jfQuanLy_ChuyenNganh = new JPNQuanLy_ChuyenNganh();
                pnCenter.add(jfQuanLy_ChuyenNganh);
                pnCenter.revalidate();
                pnCenter.repaint();
            }
        });

        btLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý lớp");
                JPNQuanLy_Lop jfQuanLy_Lop = new JPNQuanLy_Lop();
                pnCenter.add(jfQuanLy_Lop);
                pnCenter.revalidate();
                pnCenter.repaint();
            }
        });

        btMonHoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý môn học");
                JPNQuanLy_MonHoc jfQuanLy_MonHoc = new JPNQuanLy_MonHoc();
                pnCenter.add(jfQuanLy_MonHoc);
                pnCenter.revalidate();
                pnCenter.repaint();
            }
        });

        btGiangVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý giảng viên");
                JPNQuanLy_GiangVien jfQuanLy_GiangVien = new JPNQuanLy_GiangVien();
                pnCenter.add(jfQuanLy_GiangVien);
                pnCenter.revalidate();
                pnCenter.repaint();
            }
        });

        btLopHocPhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý lớp học phần");
                JPNQuanLy_LopHocPhan jfQuanLy_LopHocPhan = new JPNQuanLy_LopHocPhan();
                pnCenter.add(jfQuanLy_LopHocPhan);
                pnCenter.revalidate();
                pnCenter.repaint();
            }
        });

        btSinhVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý sinh viên");
                JPNQuanLy_SinhVien jfQuanLy_SinhVien = new JPNQuanLy_SinhVien();
                pnCenter.add(jfQuanLy_SinhVien);
                pnCenter.revalidate();
                pnCenter.repaint();
            }
        });

        btTaoPhieuThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý phiếu thu");
                JPNQuanLy_PhieuThu jfQuanLy_PhieuThu = new JPNQuanLy_PhieuThu();
                pnCenter.add(jfQuanLy_PhieuThu);
                pnCenter.revalidate();
                pnCenter.repaint();
            }
        });

        btBaoCao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenter.removeAll();
                lblTitle.setText("Quản lý báo cáo");
                JPNQuanLy_BaoCao jfQuanLy_BaoCao = new JPNQuanLy_BaoCao();
                pnCenter.add(jfQuanLy_BaoCao);
                pnCenter.revalidate();
                pnCenter.repaint();
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
                lblTitle.setText("Quản lý");
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
