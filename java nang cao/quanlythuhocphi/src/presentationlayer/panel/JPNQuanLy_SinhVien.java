package presentationlayer.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

import businesslogiclayer.KHOABUS;
import businesslogiclayer.LOPBUS;
import businesslogiclayer.NGUOIDUNGBUS;
import businesslogiclayer.SINHVIENBUS;
import dtos.NguoiDung;
import dtos.SinhVien;
import util.Constants;

public class JPNQuanLy_SinhVien extends JPanel{
    private SinhVien obj_SV = new SinhVien();
    private NguoiDung obj_ND = new NguoiDung();
    private SINHVIENBUS bus_SV = new SINHVIENBUS();
    private NGUOIDUNGBUS bus_ND = new NGUOIDUNGBUS();

    private JTextField txfMaSinhVien;
    private JTextField txfHoSinhVien;
    private JTextField txfTenSinhVien;
    private JTextField txfDiaChi;
    private JTextField txfNgaySinh;
    private JComboBox cbMaLop;
    private JRadioButton rdbTrue;
    private JRadioButton rdbFalse;
    private JRadioButton rdbNu;
    private JRadioButton rdbNam;

    private JButton btThem;
    private JButton btSua;
    private JButton btXoa;
    private JButton btReset;
    private JButton btXuatExcel;
    private JButton btNhapExcel;
    private JTable tbSinhVien;
    private DefaultTableModel dtmSinhVien;

    public JPNQuanLy_SinhVien() {
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

        rdbNam = new JRadioButton("Nam  ");
        rdbNu = new JRadioButton("Nữ  ");
        pnCenter.add(createSubRadioButtonPanel("Giới tính:", rdbNu, rdbNam));

        txfHoSinhVien = new JTextField();
        pnCenter.add(createSubPanel("Họ sinh viên:", txfHoSinhVien));

        rdbFalse = new JRadioButton("False");
        rdbTrue = new JRadioButton("True");
        pnCenter.add(createSubRadioButtonPanel("Đang nghỉ học:", rdbTrue, rdbFalse));

        txfTenSinhVien = new JTextField();
        pnCenter.add(createSubPanel("Tên sinh viên:", txfTenSinhVien));

        txfNgaySinh = new JTextField();
        pnCenter.add(createSubPanel("Ngày sinh:", txfNgaySinh));

        txfDiaChi = new JTextField();
        pnCenter.add(createSubPanel("Địa chỉ:", txfDiaChi));

        cbMaLop = new JComboBox<>();
        addDataMaLop();
        pnCenter.add(createSubPanel("Mã lớp:", cbMaLop));

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
        btXuatExcel = createNewJButton("Xuất Excel");
        btNhapExcel = createNewJButton("Nhập Excel");

        pnButtons.add(btThem, gbcButtons);
        pnButtons.add(btSua, gbcButtons);
        pnButtons.add(btXoa, gbcButtons);
        pnButtons.add(btReset, gbcButtons);
        pnButtons.add(btXuatExcel, gbcButtons);
        pnButtons.add(btNhapExcel, gbcButtons);

        pnEast.add(pnButtons, BorderLayout.NORTH);

        // Panel South
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BorderLayout());
        pnSouth.setPreferredSize(new Dimension(1081, 430));

        try {
            dtmSinhVien = resultSetToTableModel(bus_SV.GetData());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        tbSinhVien = new JTable(dtmSinhVien);
        tbSinhVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tbSinhVien);

        pnSouth.add(scrollPane, BorderLayout.CENTER);

        // Add components to the main panel
        add(pnCenter, BorderLayout.CENTER);
        add(pnEast, BorderLayout.EAST);
        add(pnSouth, BorderLayout.SOUTH);
    }

    private void addEvent() {
        tbSinhVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tbSinhVien.getSelectedRow();
                if (selectedRow != -1) {
                    txfMaSinhVien.setText(dtmSinhVien.getValueAt(selectedRow, 0).toString());
                    txfHoSinhVien.setText(dtmSinhVien.getValueAt(selectedRow, 1).toString());
                    txfTenSinhVien.setText(dtmSinhVien.getValueAt(selectedRow, 2).toString());
                    txfDiaChi.setText(dtmSinhVien.getValueAt(selectedRow, 6).toString());
                    txfMaSinhVien.setText(dtmSinhVien.getValueAt(selectedRow, 8).toString());
    
                    if (Boolean.parseBoolean(dtmSinhVien.getValueAt(selectedRow, 4).toString())) {
                        rdbNu.setSelected(true);
                    } else {
                        rdbNam.setSelected(true);
                    }
    
                    if (Boolean.parseBoolean(dtmSinhVien.getValueAt(selectedRow, 7).toString())) {
                        rdbTrue.setSelected(true);
                    } else {
                        rdbFalse.setSelected(true);
                    }
    
                    txfNgaySinh.setText(dtmSinhVien.getValueAt(selectedRow, 5).toString());
                    cbMaLop.setSelectedItem(dtmSinhVien.getValueAt(selectedRow, 3).toString());
                }
            }
        });

        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_SV.setMaSV(txfMaSinhVien.getText());
                obj_SV.setHo(txfHoSinhVien.getText());
                obj_SV.setTen(txfTenSinhVien.getText());
                obj_SV.setDiaChi(txfDiaChi.getText());
                obj_SV.setTenTaiKhoan(txfMaSinhVien.getText());

                if (rdbNam.isSelected()) {
                    obj_SV.setPhai(false);
                } else if (rdbNu.isSelected()) {
                    obj_SV.setPhai(true);
                }

                obj_SV.setDangNghiHoc(rdbTrue.isSelected());

                obj_SV.setNgaySinh(txfNgaySinh.getText());

                obj_SV.setMaLop(cbMaLop.getSelectedItem().toString());

                // Gán dữ liệu cho obj_ND
                obj_ND.setTenTaiKhoan(txfMaSinhVien.getText());
                obj_ND.setMatKhau("1");
                obj_ND.setQuyen("User");

                try {
                    ResultSet resultSet = bus_SV.GetData(txfMaSinhVien.getText());
                    if (!resultSet.next()) {
                        // Thực hiện thêm vào CSDL và JTable
                        bus_ND.Insert(obj_ND);
                        bus_SV.Insert(obj_SV);
                        Object[] newRowData = { obj_SV.getMaSV(), obj_SV.getHo(), obj_SV.getTen(), obj_SV.getMaLop(), obj_SV.isPhai(), obj_SV.getNgaySinh(), obj_SV.getDiaChi(), obj_SV.isDangNghiHoc(), obj_SV.getTenTaiKhoan() };
                        dtmSinhVien.addRow(newRowData);
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaSinhVien.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj_SV.setMaSV(txfMaSinhVien.getText());
                obj_SV.setHo(txfHoSinhVien.getText());
                obj_SV.setTen(txfTenSinhVien.getText());
                obj_SV.setDiaChi(txfDiaChi.getText());
                obj_SV.setTenTaiKhoan(txfMaSinhVien.getText());

                if (rdbNam.isSelected()) {
                    obj_SV.setPhai(false);
                } else if (rdbNu.isSelected()) {
                    obj_SV.setPhai(true);
                }

                obj_SV.setDangNghiHoc(rdbTrue.isSelected());

                obj_SV.setNgaySinh(txfNgaySinh.getText());

                obj_SV.setMaLop(cbMaLop.getSelectedItem().toString());

                try {
                    ResultSet resultSet = bus_SV.GetData(txfMaSinhVien.getText());
                    if (resultSet.next()) {
                        bus_SV.Update(obj_SV);
                        Object[] rowData = { obj_SV.getMaSV(), obj_SV.getHo(), obj_SV.getTen(), obj_SV.getMaLop(), obj_SV.isPhai(), obj_SV.getNgaySinh(), obj_SV.getDiaChi(), obj_SV.isDangNghiHoc(), obj_SV.getTenTaiKhoan() };
                        for (int i = 0; i < dtmSinhVien.getRowCount(); i++) {
                            if (dtmSinhVien.getValueAt(i, 0).equals(obj_SV.getMaSV())) {
                                for (int j = 0; j < rowData.length; j++) {
                                    dtmSinhVien.setValueAt(rowData[j], i, j);
                                }
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaSinhVien.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet resultSet = bus_SV.GetData(txfMaSinhVien.getText());
                    if (resultSet.next()) {
                        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa sinh viên này không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            bus_SV.Delete(txfMaSinhVien.getText());
                            for (int i = 0; i < dtmSinhVien.getRowCount(); i++) {
                                if (dtmSinhVien.getValueAt(i, 0).equals(txfMaSinhVien.getText())) {
                                    dtmSinhVien.removeRow(i);
                                    break;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            btReset.doClick();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaSinhVien.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }        
            }
        });

        btReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txfMaSinhVien.setText("");
                txfHoSinhVien.setText("");
                txfTenSinhVien.setText("");
                txfDiaChi.setText("");
                rdbNam.setSelected(false);
                rdbNu.setSelected(false);
                rdbTrue.setSelected(false);
                rdbFalse.setSelected(false);
                txfNgaySinh.setText("");
                
            }
        });

        btXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        btNhapExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

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

    public JPanel createSubRadioButtonPanel(String lblName, JRadioButton rbTrue, JRadioButton rbFalse) {
        JPanel temp = new JPanel();
        temp.setLayout(new BorderLayout());
        temp.setPreferredSize(new Dimension(397, 42));

        JLabel lbltemp = new JLabel(lblName);
        lbltemp.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        temp.add(lbltemp, BorderLayout.CENTER);

        rbTrue.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        rbFalse.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbTrue);
        buttonGroup.add(rbFalse);

        JPanel radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 7));
        radioButtonPanel.setPreferredSize(new Dimension(252, 26));
        radioButtonPanel.add(rbTrue);
        radioButtonPanel.add(rbFalse);

        temp.add(radioButtonPanel, BorderLayout.EAST);

        return temp;
    }

    public DefaultTableModel resultSetToTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(rs.getObject(columnIndex));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public void addDataMaLop() {
        LOPBUS temp = new LOPBUS();
        ResultSet rs = temp.GetData();
        try {
            while (rs.next()) {
                cbMaLop.addItem(rs.getString(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
