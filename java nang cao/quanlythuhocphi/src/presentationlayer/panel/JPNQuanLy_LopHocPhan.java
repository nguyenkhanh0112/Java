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

import businesslogiclayer.CHUYENNGANHBUS;
import businesslogiclayer.GIANGVIENBUS;
import businesslogiclayer.KHOABUS;
import businesslogiclayer.LOPHOCPHANBUS;
import businesslogiclayer.MONHOCBUS;
import dtos.LopHocPhan;
import util.Constants;

public class JPNQuanLy_LopHocPhan extends JPanel{
    private LopHocPhan obj = new LopHocPhan();
    private LOPHOCPHANBUS bus = new LOPHOCPHANBUS();

    JTextField txfMaLopHocPhan;
    JTextField txfNienKhoa;
    JTextField txfHocKy;
    JComboBox cbMaChuyenNganh;
    JComboBox cbMaMonHoc;
    JComboBox cbMaGiangVien;
    JRadioButton rdbTrue;
    JRadioButton rdbFlase;

    JButton btThem;
    JButton btSua;
    JButton btXoa;
    JButton btReset;
    JButton btXuatExcel;
    JButton btNhapExcel;
    JTable tbLopHocPhan;
    DefaultTableModel dtmLopHocPhan;

    public JPNQuanLy_LopHocPhan() {
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

        txfMaLopHocPhan = new JTextField();
        pnCenter.add(createSubPanel("Mã lớp học phần:", txfMaLopHocPhan));
        settingTxfMaLopHocPhan();

        cbMaChuyenNganh = new JComboBox<>();
        pnCenter.add(createSubPanel("Mã chuyên ngành:", cbMaChuyenNganh));

        txfNienKhoa = new JTextField();
        pnCenter.add(createSubPanel("Niên khóa:", txfNienKhoa));

        txfHocKy = new JTextField();
        pnCenter.add(createSubPanel("Học kỳ:", txfHocKy));

        cbMaMonHoc = new JComboBox<>();
        pnCenter.add(createSubPanel("Mã môn học:", cbMaMonHoc));
        
        cbMaGiangVien = new JComboBox<>();
        pnCenter.add(createSubPanel("Mã giảng viên:", cbMaGiangVien));

        rdbTrue = new JRadioButton("True");
        rdbFlase = new JRadioButton("Flase");
        pnCenter.add(createSubRadioButtonPanel("Hủy lớp:", rdbTrue, rdbFlase));

        addDataJComboBox();

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
            dtmLopHocPhan = resultSetToTableModel(bus.GetData());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        tbLopHocPhan = new JTable(dtmLopHocPhan);
        tbLopHocPhan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tbLopHocPhan);

        pnSouth.add(scrollPane, BorderLayout.CENTER);

        // Add components to the main panel
        add(pnCenter, BorderLayout.CENTER);
        add(pnEast, BorderLayout.EAST);
        add(pnSouth, BorderLayout.SOUTH);
    }

    private void addEvent() {
        tbLopHocPhan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tbLopHocPhan.getSelectedRow();
                if (selectedRow != -1) {
                    txfMaLopHocPhan.setText(dtmLopHocPhan.getValueAt(selectedRow, 0).toString());
                    txfNienKhoa.setText(dtmLopHocPhan.getValueAt(selectedRow, 1).toString());
                    txfHocKy.setText(dtmLopHocPhan.getValueAt(selectedRow, 2).toString());
                    cbMaMonHoc.setSelectedItem(dtmLopHocPhan.getValueAt(selectedRow, 3).toString());
                    cbMaGiangVien.setSelectedItem(dtmLopHocPhan.getValueAt(selectedRow, 4).toString());
                    cbMaChuyenNganh.setSelectedItem(dtmLopHocPhan.getValueAt(selectedRow, 5).toString());

                    if ((Boolean) dtmLopHocPhan.getValueAt(selectedRow, 6)){
                        rdbTrue.setSelected(true);
                    } else {
                        rdbFlase.setSelected(true);
                    }
                }
            }
        });

        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setNienKhoa(txfNienKhoa.getText());
                obj.setHocKy(Integer.parseInt(txfHocKy.getText()));
                obj.setMaMH(cbMaMonHoc.getSelectedItem().toString());
                obj.setMaGV(cbMaGiangVien.getSelectedItem().toString());
                obj.setMaCN(cbMaChuyenNganh.getSelectedItem().toString());
                if (rdbTrue.isSelected()) {
                    obj.setHuyLop(true);
                } else {
                    obj.setHuyLop(false);
                }

                try {
                    ResultSet resultSet = bus.GetData(Integer.parseInt(txfMaLopHocPhan.getText()));
                    if (!resultSet.next()) {
                        bus.Insert(obj);
                        Object[] newRowData = { txfMaLopHocPhan.getText(), obj.getNienKhoa(), obj.getHocKy(), obj.getMaMH(), obj.getMaGV(), obj.getMaCN(), obj.isHuyLop()};
                        dtmLopHocPhan.addRow(newRowData);
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã lớp học phần đã tồn tại, vui lòng nhập mã lớp học phần khác", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaLopHocPhan.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setMaLHP(Integer.parseInt(txfMaLopHocPhan.getText()));
                obj.setNienKhoa(txfNienKhoa.getText());
                obj.setHocKy(Integer.parseInt(txfHocKy.getText()));
                obj.setMaMH(cbMaMonHoc.getSelectedItem().toString());
                obj.setMaGV(cbMaGiangVien.getSelectedItem().toString());
                obj.setMaCN(cbMaChuyenNganh.getSelectedItem().toString());
                if (rdbTrue.isSelected()) {
                    obj.setHuyLop(true);
                } else {
                    obj.setHuyLop(false);
                }
                
                try {
                    ResultSet resultSet = bus.GetData(Integer.parseInt(txfMaLopHocPhan.getText()));
                    if (resultSet.next()) {
                        bus.Update(obj);
                        for (int i = 0; i < dtmLopHocPhan.getRowCount(); i++) {
                            if (dtmLopHocPhan.getValueAt(i, 0).equals(obj.getMaLHP())) {
                                dtmLopHocPhan.setValueAt(obj.getMaLHP(), i, 0);
                                dtmLopHocPhan.setValueAt(obj.getNienKhoa(), i, 1);
                                dtmLopHocPhan.setValueAt(obj.getHocKy(), i, 2);
                                dtmLopHocPhan.setValueAt(obj.getMaMH(), i, 3);
                                dtmLopHocPhan.setValueAt(obj.getMaGV(), i, 4);
                                dtmLopHocPhan.setValueAt(obj.getMaCN(), i, 5);
                                dtmLopHocPhan.setValueAt(obj.isHuyLop(), i, 6);
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã lớp học phần không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaLopHocPhan.requestFocus();
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
                    ResultSet resultSet = bus.GetData(Integer.parseInt(txfMaLopHocPhan.getText()));
                    if (resultSet.next()) {
                        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa lớp học phần này không", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            bus.Delete(Integer.parseInt(txfMaLopHocPhan.getText()));
                            for (int i = 0; i < dtmLopHocPhan.getRowCount(); i++) {
                                if (Integer.parseInt(dtmLopHocPhan.getValueAt(i, 0).toString()) == Integer.parseInt(txfMaLopHocPhan.getText())) {
                                    dtmLopHocPhan.removeRow(i);
                                    break;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            btReset.doClick();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã lớp học phần không tồn tại, vui lòng nhập mã khác", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaLopHocPhan.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingTxfMaLopHocPhan();
                txfNienKhoa.setText("");
                txfHocKy.setText("");
                rdbFlase.setSelected(false);
                rdbTrue.setSelected(false);
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

    public void addDataJComboBox() {
        try {
            // MaMonHoc
            MONHOCBUS monhocbus = new MONHOCBUS();
            ResultSet rsMonHoc = monhocbus.GetData();
            while (rsMonHoc.next()) {
                cbMaMonHoc.addItem(rsMonHoc.getString(1));
            }

            // MaGiaoVien
            GIANGVIENBUS giangvienbus = new GIANGVIENBUS();
            ResultSet rsGiangVien = giangvienbus.GetData();
            while (rsGiangVien.next()) {
                cbMaGiangVien.addItem(rsGiangVien.getString(1));
            }

            // MaChuyenNganh
            CHUYENNGANHBUS chuyennganhbus = new CHUYENNGANHBUS();
            ResultSet rsChuyenNganh = chuyennganhbus.GetData();
            while (rsChuyenNganh.next()) {
                cbMaChuyenNganh.addItem(rsChuyenNganh.getString(1));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void settingTxfMaLopHocPhan() {
        txfMaLopHocPhan.setEditable(false);
        try {
            ResultSet rs = bus.GetDataMaLHP();
            rs.next();
            txfMaLopHocPhan.setText(rs.getString(1));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
