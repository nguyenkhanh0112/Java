package presentationlayer.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Constants;

public class JPNSinhVien_ThongTinCaNhan extends JPanel{
    private JTextField txfMaSinhVien;
    private JTextField txfHoSinhVien;
    private JTextField txfTenSinhVien;
    private JTextField txfDiaChi;
    private JTextField txfNgaySinh;
    private JComboBox cbMaLop;
    private JCheckBox chbTrue;
    private JCheckBox chbFlase;
    private JCheckBox chbNu;
    private JCheckBox chbNam;

    public JPNSinhVien_ThongTinCaNhan() {
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

        txfMaSinhVien = new JTextField();
        pnCenter.add(createSubPanel("Mã sinh viên:", txfMaSinhVien));

        chbNam = new JCheckBox("Nam  ");
        chbNu = new JCheckBox("Nữ  ");
        pnCenter.add(createSubCheckBoxPanel("Giới tính:", chbNu, chbNam));

        txfHoSinhVien = new JTextField();
        pnCenter.add(createSubPanel("Họ sinh viên:", txfHoSinhVien));

        chbFlase = new JCheckBox("Flase");
        chbTrue = new JCheckBox("True");
        pnCenter.add(createSubCheckBoxPanel("Đang nghỉ học:", chbTrue, chbFlase));

        txfTenSinhVien = new JTextField();
        pnCenter.add(createSubPanel("Tên sinh viên:", txfTenSinhVien));

        txfNgaySinh = new JTextField();
        pnCenter.add(createSubPanel("Ngày sinh:", txfNgaySinh));

        txfDiaChi = new JTextField();
        pnCenter.add(createSubPanel("Địa chỉ:", txfDiaChi));

        cbMaLop = new JComboBox<>();
        pnCenter.add(createSubPanel("Mã lớp:", cbMaLop));

        // Add components to the main panel
        add(pnCenter, BorderLayout.CENTER);
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

    public JPanel createSubCheckBoxPanel(String lblName, JCheckBox chbTrue, JCheckBox cbhFlase) {
        JPanel temp = new JPanel();
        temp.setLayout(new BorderLayout());
        temp.setPreferredSize(new Dimension(397, 42));

        JLabel lbltemp = new JLabel(lblName);
        lbltemp.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        temp.add(lbltemp, BorderLayout.CENTER);

        chbTrue.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        cbhFlase.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 7));
        checkBoxPanel.setPreferredSize(new Dimension(252, 26));
        checkBoxPanel.add(chbTrue);
        checkBoxPanel.add(cbhFlase);

        temp.add(checkBoxPanel, BorderLayout.EAST);

        return temp;
    }
}
