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

import businesslogiclayer.CHUYENNGANHBUS;
import businesslogiclayer.KHOABUS;
import dtos.ChuyenNganh;
import presentationlayer.dialog.JDLQuanLy_ChuongTrinhHoc;
import util.Constants;

public class JPNQuanLy_ChuyenNganh extends JPanel{
    private ChuyenNganh obj = new ChuyenNganh();
    private CHUYENNGANHBUS bus = new CHUYENNGANHBUS();

    JTextField txfMaChuyenNganh;
    JTextField txfTenChuyenNganh;
    JComboBox cbMaKhoa;
    JButton btThem;
    JButton btSua;
    JButton btXoa;
    JButton btReset;
    JButton btXuatExcel;
    JButton btNhapExcel;
    JButton btChuongTrinhHoc;
    JTable tbChuyenNganh;
    DefaultTableModel dtmChuyennganh;

    public JPNQuanLy_ChuyenNganh() {
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

        txfMaChuyenNganh = new JTextField();
        pnCenter.add(createSubPanel("Mã chuyên ngành:", txfMaChuyenNganh));

        cbMaKhoa = new JComboBox<>();
        addDataMaKhoa();
        pnCenter.add(createSubPanel("Mã khoa:", cbMaKhoa));
        
        txfTenChuyenNganh = new JTextField();
        pnCenter.add(createSubPanel("Tên chuyên ngành:", txfTenChuyenNganh));

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
            dtmChuyennganh = resultSetToTableModel(bus.GetData());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        tbChuyenNganh = new JTable(dtmChuyennganh);
        tbChuyenNganh.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tbChuyenNganh);

        btChuongTrinhHoc = new JButton("Xem chương trình học");
        btChuongTrinhHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        btChuongTrinhHoc.setBackground(Color.WHITE);

        pnSouth.add(scrollPane, BorderLayout.CENTER);
        pnSouth.add(btChuongTrinhHoc, BorderLayout.SOUTH);

        // Add components to the main panel
        add(pnCenter, BorderLayout.CENTER);
        add(pnEast, BorderLayout.EAST);
        add(pnSouth, BorderLayout.SOUTH);
    }

    private void addEvent() {
        tbChuyenNganh.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tbChuyenNganh.getSelectedRow();
                if (selectedRow != -1) {
                    txfMaChuyenNganh.setText(dtmChuyennganh.getValueAt(selectedRow, 0).toString());
                    txfTenChuyenNganh.setText(dtmChuyennganh.getValueAt(selectedRow, 1).toString());
                    cbMaKhoa.setSelectedItem(dtmChuyennganh.getValueAt(selectedRow, 2).toString());
                }
            }
        });

        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setMaCN(txfMaChuyenNganh.getText());
                obj.setTenCN(txfTenChuyenNganh.getText());
                obj.setMaKhoa(cbMaKhoa.getSelectedItem().toString());
                try {
                    ResultSet resultSet = bus.GetData(txfMaChuyenNganh.getText());
                    if (!resultSet.next()) {
                        bus.Insert(obj);
                        Object[] newRowData = {obj.getMaCN(), obj.getTenCN(), obj.getMaKhoa()};
                        dtmChuyennganh.addRow(newRowData);
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã chuyên ngành đã tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaChuyenNganh.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setMaCN(txfMaChuyenNganh.getText());
                obj.setTenCN(txfTenChuyenNganh.getText());
                obj.setMaKhoa(cbMaKhoa.getSelectedItem().toString());

                try {
                    ResultSet resultSet = bus.GetData(txfMaChuyenNganh.getText());
                    if (resultSet.next()) {
                        bus.Update(obj);
                        Object[] rowData = {obj.getMaCN(), obj.getTenCN(), obj.getMaKhoa()};
                        for (int i = 0; i < dtmChuyennganh.getRowCount(); i++) {
                            if (dtmChuyennganh.getValueAt(i, 0).equals(obj.getMaCN())) {
                                dtmChuyennganh.insertRow(i, rowData);
                                dtmChuyennganh.removeRow(i + 1);
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã chuyên ngành không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaChuyenNganh.requestFocus();
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
                    ResultSet resultSet = bus.GetData(txfMaChuyenNganh.getText());
                    if (resultSet.next()) {
                        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa chuyên ngành này không", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            bus.Delete(txfMaChuyenNganh.getText());
                            for (int i = 0; i < dtmChuyennganh.getRowCount(); i++) {
                                if (dtmChuyennganh.getValueAt(i, 0).equals(txfMaChuyenNganh.getText())) {
                                    dtmChuyennganh.removeRow(i);
                                    break;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            btReset.doClick();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Chuyên ngành không tồn tại, vui lòng nhập mã chuyên ngành khác", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaChuyenNganh.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }        
            }
        });

        btReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txfMaChuyenNganh.setText("");
                txfTenChuyenNganh.setText("");
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

        btChuongTrinhHoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbChuyenNganh.getSelectedRow();
                if (selectedRow != -1) {
                    JDLQuanLy_ChuongTrinhHoc jdlQuanLy_ChuongTrinhHoc = new JDLQuanLy_ChuongTrinhHoc(dtmChuyennganh.getValueAt(selectedRow, 0).toString());
                    jdlQuanLy_ChuongTrinhHoc.doShow();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn chuyên ngành muốn xem chương trình học", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
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

    public void addDataMaKhoa() {
        KHOABUS temp = new KHOABUS();
        ResultSet rs = temp.GetData();
        try {
            while (rs.next()) {
                cbMaKhoa.addItem(rs.getString(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
