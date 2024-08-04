package presentationlayer.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.Constants;

public class JDLSinhVien_ChiTietDKHP extends JDialog{
    private JTextField txfMaDangKy;
    private JTextField txfMaSinhVien;
    private JTextField txfHocKy;
    private JTextField txfTenMonHoc;
    private JButton btTimKiem;
    private JButton btDangKyThem;
    private JTable tbMonHoc;

    public JDLSinhVien_ChiTietDKHP() {
        super((JDialog) null, "", true);
        addControl();
        addEvent();
    }

    public void doShow() {
        setSize(953, 578);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addControl() {
        // Panel Main
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        // Panel North
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel pnNorthWrapper = new JPanel();
        pnNorthWrapper.setLayout(new GridBagLayout());
        GridBagConstraints gbcNorth = new GridBagConstraints();
        gbcNorth.anchor = GridBagConstraints.NORTHWEST;

        JLabel lblNorthTitle = new JLabel("Thông tin phiếu đăng ký:");
        lblNorthTitle.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 21));
        lblNorthTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
        gbcNorth.gridwidth = 2;
        gbcNorth.gridx = 0;
        gbcNorth.gridy = 0;
        pnNorthWrapper.add(lblNorthTitle, gbcNorth);

        gbcNorth.insets = new Insets(5, 30, 5, 30);

        txfMaDangKy = new JTextField();
        gbcNorth.gridwidth = 1;
        gbcNorth.gridx = 0;
        gbcNorth.gridy = 1;
        pnNorthWrapper.add(createSubPanel("Mã đăng ký:", txfMaDangKy), gbcNorth);

        txfHocKy = new JTextField();
        gbcNorth.gridx = 1;
        gbcNorth.gridy = 1;
        pnNorthWrapper.add(createSubPanel("Học kỳ:", txfHocKy), gbcNorth);

        txfMaSinhVien = new JTextField();
        gbcNorth.gridx = 0;
        gbcNorth.gridy = 2;
        pnNorthWrapper.add(createSubPanel("Mã sinh viên:", txfMaSinhVien), gbcNorth);

        pnNorth.add(pnNorthWrapper);

        // Panel Center
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());

        JPanel pnCenterWrapper = new JPanel();
        pnCenterWrapper.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblCenterTitle = new JLabel("Danh sách các môn học đã đăng ký:");
        lblCenterTitle.setBorder(new EmptyBorder(0, 10, 0, 100));
        lblCenterTitle.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 21));

        JLabel lblTenMonHoc = new JLabel("Tên môn học:");
        lblTenMonHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        txfTenMonHoc = new JTextField();
        txfTenMonHoc.setPreferredSize(new Dimension(252, 26));
        txfTenMonHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        btTimKiem = new JButton("Tìm kiếm");
        btTimKiem.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 13));

        pnCenterWrapper.add(lblCenterTitle, BorderLayout.NORTH);
        pnCenterWrapper.add(lblTenMonHoc, BorderLayout.NORTH);
        pnCenterWrapper.add(txfTenMonHoc, BorderLayout.NORTH);
        pnCenterWrapper.add(btTimKiem, BorderLayout.NORTH);

        Object[][] data = {
                {"User1", "Password1", "Admin"},
                {"User2", "Password2", "User"},
                {"User3", "Password3", "User"}
        };
        String[] columnNames = {"Tài khoản", "Mật khẩu", "Quyền"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tbMonHoc = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbMonHoc);

        pnCenter.add(pnCenterWrapper, BorderLayout.NORTH);
        pnCenter.add(scrollPane, BorderLayout.CENTER);
        
        // Panel South
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BorderLayout());

        btDangKyThem = new JButton("Đăng ký thêm");
        btDangKyThem.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        pnSouth.add(btDangKyThem);

        // Add components to the main panel
        pnMain.add(pnCenter, BorderLayout.CENTER);
        pnMain.add(pnNorth, BorderLayout.NORTH);
        pnMain.add(pnSouth, BorderLayout.SOUTH);
        
        getContentPane().add(pnMain);
    }

    private void addEvent() {
        // Add event handling here
    }

    public JPanel createSubPanel(String lblName, JTextField control) {
        JPanel temp = new JPanel();
        temp.setLayout(new BorderLayout());
        temp.setPreferredSize(new Dimension(397, 42));

        JLabel lbltemp = new JLabel(lblName);
        lbltemp.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        temp.add(lbltemp, BorderLayout.CENTER);

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));
        control.setPreferredSize(new Dimension(252, 26));
        control.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        wrapperPanel.add(control);
        temp.add(wrapperPanel, BorderLayout.EAST);

        return temp;
    }
}
