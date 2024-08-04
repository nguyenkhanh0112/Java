package presentationlayer.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.Constants;

public class JPNQuanLy_PhieuThu extends JPanel{

    JTextField txfMaPhieuThu;
    JTextField txfMaSinhVien;
    JTextField txfNienKhoa;
    JTextField txfTongHocPhi;
    JTextField txfTongDaDong;
    JTextField txfTongChuaDong;
    JComboBox cbHocKy;
    
    JButton btThem;
    JButton btSua;
    JButton btXoa;
    JButton btReset;
    JButton btKiemTra;
    JButton btChiTiet;
    JTable tbPhieuThu;

    public JPNQuanLy_PhieuThu() {
        super();
        addControl();
        addEvent();
    }

    private void addControl() {
        // Panel MAIN
        setLayout(new BorderLayout());

        // Panel Center
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));

        txfMaPhieuThu = new JTextField();
        pnCenter.add(createSubPanel("Mã phiếu thu:", txfMaPhieuThu));

        JLabel lblHocPhi = new JLabel("THÔNG TIN HỌC PHÍ");
        lblHocPhi.setBorder(new EmptyBorder(0, 70, 0, 70));
        lblHocPhi.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 24));
        pnCenter.add(lblHocPhi);

        txfMaSinhVien = new JTextField();
        pnCenter.add(createSubPanel("Mã sinh viên:",  txfMaSinhVien));

        txfTongHocPhi = new JTextField();
        pnCenter.add(createSubPanel("Tổng học phí:", txfTongHocPhi));

        txfNienKhoa = new JTextField();
        pnCenter.add(createSubPanel("Niên khóa:", txfNienKhoa));

        txfTongDaDong = new JTextField();
        pnCenter.add(createSubPanel("Tổng đã đóng:", txfTongDaDong));

        cbHocKy = new JComboBox<>();
        pnCenter.add(createSubPanel("Học kỳ", cbHocKy));

        txfTongChuaDong = new JTextField();
        pnCenter.add(createSubPanel("Tổng chưa đóng:", txfTongChuaDong));

        // Panel EAST
        JPanel pnEast = new JPanel();
        pnEast.setLayout(new BorderLayout());

        JPanel pnButtons = new JPanel();
        pnButtons.setLayout(new GridBagLayout());
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.insets = new Insets(1, 0, 1, 0);
        gbcButtons.anchor = GridBagConstraints.NORTH;
        gbcButtons.gridwidth = GridBagConstraints.REMAINDER;

        btThem = createNewJButton("Thêm");
        btSua = createNewJButton("Sửa");
        btXoa = createNewJButton("Xóa");
        btReset = createNewJButton("Reset");
        btKiemTra = createNewJButton("Kiểm tra");

        pnButtons.add(btThem, gbcButtons);
        pnButtons.add(btSua, gbcButtons);
        pnButtons.add(btXoa, gbcButtons);
        pnButtons.add(btReset, gbcButtons);
        pnButtons.add(btKiemTra, gbcButtons);

        pnEast.add(pnButtons, BorderLayout.NORTH);

        // Panel South
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BorderLayout());
        pnSouth.setPreferredSize(new Dimension(1081, 443));

        Object[][] data = {
                {"User1", "Password1", "Admin"},
                {"User2", "Password2", "User"},
                {"User3", "Password3", "User"}
        };
        String[] columnNames = {"Mã khoa", "Tên khoa", "Đơn giá tín chỉ"};
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tbPhieuThu = new JTable(model);
        tbPhieuThu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tbPhieuThu);

        btChiTiet = new JButton("Xem thông tin chi tiết");
        btChiTiet.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        btChiTiet.setBackground(Color.WHITE);

        pnSouth.add(scrollPane, BorderLayout.CENTER);
        pnSouth.add(btChiTiet, BorderLayout.SOUTH);

        // Add components to the main panel
        add(pnCenter, BorderLayout.CENTER);
        add(pnEast, BorderLayout.EAST);
        add(pnSouth, BorderLayout.SOUTH);
    }

    private void addEvent() {
        // Add event handling here
    }

    private JButton createNewJButton(String btName) {
        JButton temp = new JButton(btName);
        temp.setBackground(Color.WHITE);
        temp.setPreferredSize(new Dimension(109, 45));
        temp.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 14));

        return temp;
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

    public JPanel createSubPanel(String lblName, JComboBox control) {
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
