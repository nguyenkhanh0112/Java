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

import businesslogiclayer.MONHOCBUS;
import dtos.MonHoc;
import util.Constants;

public class JPNQuanLy_MonHoc extends JPanel{
    private MonHoc obj = new MonHoc();
    private MONHOCBUS bus = new MONHOCBUS();

    JTextField txfMaMonHoc;
    JTextField txfSoTinChi;
    JTextField txfTenMonHoc;
    JComboBox cbHocKy;
    JButton btThem;
    JButton btSua;
    JButton btXoa;
    JButton btReset;
    JButton btXuatExcel;
    JButton btNhapExcel;
    JTable tbMonHoc;
    DefaultTableModel dtmMonHoc;

    public JPNQuanLy_MonHoc() {
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

        txfMaMonHoc = new JTextField();
        pnCenter.add(createSubPanel("Mã môn học:", txfMaMonHoc));

        txfSoTinChi = new JTextField();
        pnCenter.add(createSubPanel("Số tín chỉ:", txfSoTinChi));

        txfTenMonHoc = new JTextField();
        pnCenter.add(createSubPanel("Tên môn học:", txfTenMonHoc));

        cbHocKy = new JComboBox<>();
        addDataMonHoc();
        pnCenter.add(createSubPanel("Học kỳ:", cbHocKy));

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
            dtmMonHoc = resultSetToTableModel(bus.GetData());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        tbMonHoc = new JTable(dtmMonHoc);
        tbMonHoc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tbMonHoc);

        pnSouth.add(scrollPane, BorderLayout.CENTER);

        // Add components to the main panel
        add(pnCenter, BorderLayout.CENTER);
        add(pnEast, BorderLayout.EAST);
        add(pnSouth, BorderLayout.SOUTH);
    }

    private void addEvent() {
        tbMonHoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tbMonHoc.getSelectedRow();
                if (selectedRow != -1) {
                    txfMaMonHoc.setText(tbMonHoc.getValueAt(selectedRow, 0).toString());
                    txfTenMonHoc.setText(tbMonHoc.getValueAt(selectedRow, 1).toString());
                    cbHocKy.setSelectedItem(tbMonHoc.getValueAt(selectedRow, 2).toString());
                    txfSoTinChi.setText(tbMonHoc.getValueAt(selectedRow, 3).toString());
                }
            }
        });

        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setMaMH(txfMaMonHoc.getText());
                obj.setTenMH(txfTenMonHoc.getText());
                obj.setHocKy(Integer.parseInt(cbHocKy.getSelectedItem().toString())); // Chuyển đổi từ Object sang String rồi Integer
                obj.setSoTinChi(Integer.parseInt(txfSoTinChi.getText()));
                try {
                    ResultSet resultSet = bus.GetData(txfMaMonHoc.getText());
                    if (!resultSet.next()) {
                        bus.Insert(obj);
                        Object[] newRowData = {obj.getMaMH(), obj.getTenMH(), obj.getHocKy(), obj.getSoTinChi()};
                        dtmMonHoc.addRow(newRowData);
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã môn học đã tồn tại, vui lòng nhập mã môn học khác", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaMonHoc.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setMaMH(txfMaMonHoc.getText());
                obj.setTenMH(txfTenMonHoc.getText());
                obj.setHocKy(Integer.parseInt(cbHocKy.getSelectedItem().toString()));
                obj.setSoTinChi(Integer.parseInt(txfSoTinChi.getText()));

                try {
                    ResultSet resultSet = bus.GetData(txfMaMonHoc.getText());
                    if (resultSet.next()) {
                        bus.Update(obj);
                        for (int i = 0; i < dtmMonHoc.getRowCount(); i++) {
                            if (dtmMonHoc.getValueAt(i, 0).equals(obj.getMaMH())) {
                                dtmMonHoc.setValueAt(obj.getMaMH(), i, 0);
                                dtmMonHoc.setValueAt(obj.getTenMH(), i, 1);
                                dtmMonHoc.setValueAt(obj.getHocKy(), i, 2);
                                dtmMonHoc.setValueAt(obj.getSoTinChi(), i, 3);
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã môn học không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaMonHoc.requestFocus();
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
                    ResultSet resultSet = bus.GetData(txfMaMonHoc.getText());
                    if (resultSet.next()) {
                        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa môn học này không", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            bus.Delete(txfMaMonHoc.getText());
                            // Xóa hàng tương ứng trong DefaultTableModel
                            for (int i = 0; i < dtmMonHoc.getRowCount(); i++) {
                                if (dtmMonHoc.getValueAt(i, 0).equals(txfMaMonHoc.getText())) {
                                    dtmMonHoc.removeRow(i);
                                    break;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            btReset.doClick();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã môn học không tồn tại, vui lòng nhập mã môn học khác", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaMonHoc.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }        
            }
        });

        btReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txfMaMonHoc.setText("");
                txfTenMonHoc.setText("");
                txfSoTinChi.setText("");
            }
        });

        btXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });

        btNhapExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
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

    public void addDataMonHoc() {
        cbHocKy.addItem("1");
        cbHocKy.addItem("2");
        cbHocKy.addItem("3");
        cbHocKy.addItem("4");
        cbHocKy.addItem("5");
    }

}
