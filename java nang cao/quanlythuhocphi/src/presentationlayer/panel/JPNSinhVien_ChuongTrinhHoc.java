package presentationlayer.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.Constants;

public class JPNSinhVien_ChuongTrinhHoc extends JPanel{
    private JTextField txfTenMonHoc;
    private JButton btTimKiem;
    private JComboBox cbHocKy;
    private JTable tbChuongTrinhHoc;

    public JPNSinhVien_ChuongTrinhHoc() {
        super();
        addControl();
        addEvent();
    }

    private void addControl() {
        // Panel MAIN
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(937, 489));

        // Panel North
        JPanel pnNorth = new JPanel();
        pnNorth.setBackground(Color.WHITE);
        pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        JLabel lblTenMonHoc = new JLabel("Tên môn học:");
        lblTenMonHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        txfTenMonHoc = new JTextField(15);
        txfTenMonHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        btTimKiem = new JButton("Tìm kiếm");
        btTimKiem.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 13));
        
        JLabel lblHocKy = new JLabel("Học kỳ:");
        lblHocKy.setBorder(new EmptyBorder(0, 300, 0, 0));
        lblHocKy.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        cbHocKy = new JComboBox<>();
        cbHocKy.setPreferredSize(new Dimension(100, 26));
        cbHocKy.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        pnNorth.add(lblTenMonHoc);
        pnNorth.add(txfTenMonHoc);
        pnNorth.add(btTimKiem);
        pnNorth.add(lblHocKy);
        pnNorth.add(cbHocKy);

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
        tbChuongTrinhHoc = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbChuongTrinhHoc);

        pnCenter.add(scrollPane);

        // Add components to the main panel
        add(pnNorth, BorderLayout.NORTH);
        add(pnCenter, BorderLayout.CENTER);
    }

    private void addEvent() {
        // Add event handling here
    }
}
