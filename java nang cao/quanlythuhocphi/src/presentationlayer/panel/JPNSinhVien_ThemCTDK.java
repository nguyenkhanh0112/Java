package presentationlayer.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.Constants;

public class JPNSinhVien_ThemCTDK extends JPanel{
    private JTextField txfSoPhieuDK;
    private JTextField txfTenMonHoc;
    private JButton btTimKiem;
    private JButton btDangKy;
    private JTable tbChiTietDK;
    
    public JPNSinhVien_ThemCTDK() {
        super();
        addControl();
        addEvent();
    }

    private void addControl() {
        // Panel MAIN
        setLayout(new BorderLayout());

        // Panel North
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 13, 30));

        JLabel lblNorthTitle = new JLabel("Số phiếu đăng ký:");
        lblNorthTitle.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        txfSoPhieuDK = new JTextField(15);
        txfSoPhieuDK.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        JLabel lblTenMonHoc = new JLabel("Tên môn học:");
        lblTenMonHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        lblTenMonHoc.setBorder(new EmptyBorder(0, 130, 0, 0));

        txfTenMonHoc = new JTextField(15);
        txfTenMonHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        btTimKiem = new JButton("Tìm kiếm");
        btTimKiem.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        pnNorth.add(lblNorthTitle);
        pnNorth.add(txfSoPhieuDK);
        pnNorth.add(lblTenMonHoc);
        pnNorth.add(txfTenMonHoc);
        pnNorth.add(btTimKiem);

        // Panel Center
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());

        Object[][] data = {
                {"User1", "Password1", "Admin"},
                {"User2", "Password2", "User"},
                {"User3", "Password3", "User"}
        };
        String[] columnNames = {"Tài khoản", "Mật khẩu", "Quyền"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tbChiTietDK = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbChiTietDK);

        pnCenter.add(scrollPane);

        // Panel South
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BorderLayout());

        btDangKy = new JButton("Đăng ký");
        btDangKy.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 13));

        pnSouth.add(btDangKy);

        // Add components to the main panel
        add(pnNorth, BorderLayout.NORTH);
        add(pnCenter, BorderLayout.CENTER);
        add(pnSouth, BorderLayout.SOUTH);
    }

    private void addEvent() {
        // Add event handling here
    }
}
