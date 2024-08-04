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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import businesslogiclayer.NGUOIDUNGBUS;
import businesslogiclayer.SINHVIENBUS;
import dtos.NguoiDung;
import util.Constants;

public class JPNAdmin_NguoiDung extends JPanel{
    private NguoiDung obj = new NguoiDung();
    private NGUOIDUNGBUS bus_ND = new NGUOIDUNGBUS();
    private SINHVIENBUS bus_SV = new SINHVIENBUS();

    JTextField txfTenTaiKhoan;
    JTextField txfMatKhau;
    JComboBox<String> cbQuyen;
    JButton btThem;
    JButton btSua;
    JButton btXoa;
    JButton btReset;
    JButton btXuatExcel;
    JButton btNhapExcel;
    JTable tbNguoiDung;
    DefaultTableModel dtmNguoiDung;

    public JPNAdmin_NguoiDung() {
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

        txfTenTaiKhoan = new JTextField();
        pnCenter.add(createSubPanel("Tên tài khoản:", txfTenTaiKhoan));
        
        txfMatKhau = new JTextField();
        pnCenter.add(createSubPanel("Mật khẩu:", txfMatKhau));

        cbQuyen = new JComboBox<>();
        addQuyen();
        pnCenter.add(createSubPanel("Quyền:", cbQuyen));

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
        pnSouth.setPreferredSize(new Dimension(1081, 351));

        try {
            dtmNguoiDung = resultSetToTableModel(bus_ND.GetData());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        tbNguoiDung = new JTable(dtmNguoiDung);
        tbNguoiDung.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tbNguoiDung);

        pnSouth.add(scrollPane, BorderLayout.CENTER);

        // Add components to the main panel
        add(pnCenter, BorderLayout.CENTER);
        add(pnEast, BorderLayout.EAST);
        add(pnSouth, BorderLayout.SOUTH);
    }

    private void addEvent() {
        tbNguoiDung.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tbNguoiDung.getSelectedRow();
                if (selectedRow != -1) {
                    txfTenTaiKhoan.setText(dtmNguoiDung.getValueAt(selectedRow, 0).toString());
                    txfMatKhau.setText(dtmNguoiDung.getValueAt(selectedRow, 1).toString());
                    cbQuyen.setSelectedItem(dtmNguoiDung.getValueAt(selectedRow, 2).toString());
                }
            }
        });

        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setTenTaiKhoan(txfTenTaiKhoan.getText());
                obj.setMatKhau(txfMatKhau.getText());
                obj.setQuyen(cbQuyen.getSelectedItem().toString());
                try {
                    ResultSet temp = bus_ND.GetData(txfTenTaiKhoan.getText());
                    if (!temp.next()) {
                        bus_ND.Insert(obj);
                        Object[] newRowData = {obj.getTenTaiKhoan(), obj.getMatKhau(), obj.getQuyen()};
                        dtmNguoiDung.addRow(newRowData);
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfTenTaiKhoan.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setTenTaiKhoan(txfTenTaiKhoan.getText());
                obj.setMatKhau(txfMatKhau.getText());
                obj.setQuyen(cbQuyen.getSelectedItem().toString());

                try {
                    ResultSet temp = bus_ND.GetData(txfTenTaiKhoan.getText());
                    if (temp.next()) {
                        bus_ND.Update(obj);
                        Object[] rowData = {obj.getTenTaiKhoan(), obj.getMatKhau(), obj.getQuyen()};
                        for (int i = 0; i < dtmNguoiDung.getRowCount(); i++) {
                            if (dtmNguoiDung.getValueAt(i, 0).equals(obj.getTenTaiKhoan())) {
                                dtmNguoiDung.insertRow(i, rowData);
                                dtmNguoiDung.removeRow(i + 1);
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Tên tài khoản không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfTenTaiKhoan.requestFocus();
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
                    ResultSet resultSet = bus_ND.GetData(txfTenTaiKhoan.getText());
                    if (resultSet.next()) {
                        int option = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa tài khoản này không?", "Thống báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            ResultSet resultSetSV = bus_SV.GetData(txfTenTaiKhoan.getText());
                            if (resultSetSV.next()) {
                                bus_SV.Delete(txfTenTaiKhoan.getText());
                            }
                            bus_ND.Delete(txfTenTaiKhoan.getText());
                            for (int i = 0; i < dtmNguoiDung.getRowCount(); i++) {
                                if (dtmNguoiDung.getValueAt(i, 0).equals(txfTenTaiKhoan.getText())) {
                                    dtmNguoiDung.removeRow(i);
                                    break;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            btReset.doClick();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfTenTaiKhoan.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }                
            }
        });

        btReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txfTenTaiKhoan.setText("");
                txfMatKhau.setText("");
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

    public DefaultTableModel resultSetToTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Tạo DefaultTableModel với tên cột từ ResultSet
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // Tạo Vector để chứa dữ liệu từ ResultSet
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(rs.getObject(columnIndex));
            }
            data.add(row);
        }

        // Trả về DefaultTableModel với dữ liệu và tên cột từ ResultSet
        return new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa giá trị
            }
        };
    }

    public void addQuyen() {
        cbQuyen.addItem("Admin");
        cbQuyen.addItem("QuanLy");
        cbQuyen.addItem("User");
    }
}
