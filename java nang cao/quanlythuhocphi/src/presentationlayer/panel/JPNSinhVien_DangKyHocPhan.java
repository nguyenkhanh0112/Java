package presentationlayer.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import util.Constants;

public class JPNSinhVien_DangKyHocPhan extends JPanel{
    private JTextField txfMaDangKy;
    private JTextField txfMaSinhVien;
    private JComboBox cbHocKy;
    private JButton btDangKy;
    private JTable tbDangKyHP;

    public JPNSinhVien_DangKyHocPhan() {
        super();
        addControl();
        addEvent();
    }

    private void addControl() {
        // Panel MAIN
        setLayout(new BorderLayout());

        // Panel North
        JPanel pnNorth = new JPanel();

        pnNorth.setBackground(Color.WHITE);
        pnNorth.setLayout(new GridBagLayout());
        GridBagConstraints gbcNorth = new GridBagConstraints();
        gbcNorth.insets = new Insets(5, 30, 5, 30);
        gbcNorth.anchor = GridBagConstraints.NORTHWEST;

        txfMaDangKy = new JTextField();
        gbcNorth.gridx = 0;
        gbcNorth.gridy = 0;
        pnNorth.add(createSubPanel("Mã đăng ký:", txfMaDangKy), gbcNorth);

        cbHocKy = new JComboBox<>();
        gbcNorth.gridx = 1;
        gbcNorth.gridy = 0;
        pnNorth.add(createSubPanel("Học kỳ:", cbHocKy), gbcNorth);

        txfMaSinhVien = new JTextField();
        gbcNorth.gridx = 0;
        gbcNorth.gridy = 1;
        pnNorth.add(createSubPanel("Mã sinh viên:", txfMaSinhVien), gbcNorth);

        btDangKy = new JButton("Tìm kiếm");
        btDangKy.setBackground(Color.WHITE);
        btDangKy.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 13));
        gbcNorth.gridx = 0;
        gbcNorth.gridy = 2;
        pnNorth.add(btDangKy, gbcNorth);

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
        tbDangKyHP = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbDangKyHP);

        pnCenter.add(scrollPane);

        // Add components to the main panel
        add(pnNorth, BorderLayout.NORTH);
        add(pnCenter, BorderLayout.CENTER);
    }

    private void addEvent() {
        // Add event handling here
    }

    public JPanel createSubPanel(String lblName, JTextField control) {
        JPanel temp = new JPanel();
        temp.setBackground(Color.WHITE);
        temp.setLayout(new BorderLayout());
        temp.setPreferredSize(new Dimension(397, 42));

        JLabel lbltemp = new JLabel(lblName);
        lbltemp.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        temp.add(lbltemp, BorderLayout.CENTER);

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setBackground(Color.WHITE);
        wrapperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));
        control.setPreferredSize(new Dimension(252, 26));
        control.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        wrapperPanel.add(control);
        temp.add(wrapperPanel, BorderLayout.EAST);

        return temp;
    }

    public JPanel createSubPanel(String lblName, JComboBox control) {
        JPanel temp = new JPanel();
        temp.setBackground(Color.WHITE);
        temp.setLayout(new BorderLayout());
        temp.setPreferredSize(new Dimension(397, 42));

        JLabel lbltemp = new JLabel(lblName);
        lbltemp.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        temp.add(lbltemp, BorderLayout.CENTER);

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setBackground(Color.WHITE);
        wrapperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 7));
        control.setPreferredSize(new Dimension(252, 26));
        control.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        wrapperPanel.add(control);
        temp.add(wrapperPanel, BorderLayout.EAST);

        return temp;
    }
}
