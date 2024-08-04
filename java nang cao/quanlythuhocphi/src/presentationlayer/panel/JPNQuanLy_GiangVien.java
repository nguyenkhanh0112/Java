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

import businesslogiclayer.GIANGVIENBUS;
import businesslogiclayer.KHOABUS;
import dtos.GiangVien;
import util.Constants;

public class JPNQuanLy_GiangVien extends JPanel{
    private GiangVien obj = new GiangVien();
    private GIANGVIENBUS bus = new GIANGVIENBUS();

    JTextField txfMaGiangVien;
    JTextField txfHoGiangVien;
    JTextField txfTenGiangVien;
    JTextField txfHocHam;
    JComboBox cbMaKhoa;
    JButton btThem;
    JButton btSua;
    JButton btXoa;
    JButton btReset;
    JButton btXuatExcel;
    JButton btNhapExcel;
    JTable tbGiangVien;
    DefaultTableModel dtmGiangVien;

    public JPNQuanLy_GiangVien() {
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

        txfMaGiangVien = new JTextField();
        pnCenter.add(createSubPanel("Mã giảng viên", txfMaGiangVien));

        txfHocHam = new JTextField();
        pnCenter.add(createSubPanel("Học hàm:", txfHocHam));

        txfHoGiangVien = new JTextField();
        pnCenter.add(createSubPanel("Họ giảng viên:", txfHoGiangVien));

        txfTenGiangVien = new JTextField();
        pnCenter.add(createSubPanel("Tên giảng viên:", txfTenGiangVien));

        cbMaKhoa = new JComboBox<>();
        addDataMaKhoa();
        pnCenter.add(createSubPanel("Mã khoa:", cbMaKhoa));
        

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
            dtmGiangVien = resultSetToTableModel(bus.GetData());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        tbGiangVien = new JTable(dtmGiangVien);
        tbGiangVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tbGiangVien);

        pnSouth.add(scrollPane, BorderLayout.CENTER);

        // Add components to the main panel
        add(pnCenter, BorderLayout.CENTER);
        add(pnEast, BorderLayout.EAST);
        add(pnSouth, BorderLayout.SOUTH);
    }

    private void addEvent() {
        tbGiangVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tbGiangVien.getSelectedRow();
                if (selectedRow != -1) {
                    txfMaGiangVien.setText(dtmGiangVien.getValueAt(selectedRow, 0).toString());
                    cbMaKhoa.setSelectedItem(dtmGiangVien.getValueAt(selectedRow, 1));
                    txfHoGiangVien.setText(dtmGiangVien.getValueAt(selectedRow, 2).toString());
                    txfTenGiangVien.setText(dtmGiangVien.getValueAt(selectedRow, 3).toString());
                    txfHocHam.setText(dtmGiangVien.getValueAt(selectedRow, 4).toString());
                }
            }
        });

        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setMaGV(txfMaGiangVien.getText());
                obj.setMaKhoa(cbMaKhoa.getSelectedItem().toString());
                obj.setHo(txfHoGiangVien.getText());
                obj.setTen(txfTenGiangVien.getText());
                obj.setHocHam(txfHocHam.getText());
                try {
                    ResultSet resultSet = bus.GetData(txfMaGiangVien.getText());
                    if (!resultSet.next()) {
                        bus.Insert(obj);
                        Object[] newRowData = {obj.getMaGV(), obj.getMaKhoa(), obj.getHo(), obj.getTen(), obj.getHocHam()};
                        dtmGiangVien.addRow(newRowData);
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã giảng viên đã tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaGiangVien.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.setMaGV(txfMaGiangVien.getText());
                obj.setMaKhoa(cbMaKhoa.getSelectedItem().toString());
                obj.setHo(txfHoGiangVien.getText());
                obj.setTen(txfTenGiangVien.getText());
                obj.setHocHam(txfHocHam.getText());

                try {
                    ResultSet resultSet = bus.GetData(txfMaGiangVien.getText());
                    if (resultSet.next()) {
                        bus.Update(obj);
                        Object[] rowData = {obj.getMaGV(), obj.getMaKhoa(), obj.getHo(), obj.getTen(), obj.getHocHam()};
                        for (int i = 0; i < dtmGiangVien.getRowCount(); i++) {
                            if (dtmGiangVien.getValueAt(i, 0).equals(obj.getMaGV())) {
                                for (int j = 0; j < rowData.length; j++) {
                                    dtmGiangVien.setValueAt(rowData[j], i, j);
                                }
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã giảng viên không tồn tại, vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaGiangVien.requestFocus();
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
                    ResultSet resultSet = bus.GetData(txfMaGiangVien.getText());
                    if (resultSet.next()) {
                        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa giảng viên này không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            bus.Delete(txfMaGiangVien.getText());
                            for (int i = 0; i < dtmGiangVien.getRowCount(); i++) {
                                if (dtmGiangVien.getValueAt(i, 0).equals(txfMaGiangVien.getText())) {
                                    dtmGiangVien.removeRow(i);
                                    break;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            btReset.doClick();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã giảng viên không tồn tại, vui lòng nhập mã giảng viên khác", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txfMaGiangVien.requestFocus();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }        
            }
        });

        btReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txfMaGiangVien.setText("");
                txfHoGiangVien.setText("");
                txfTenGiangVien.setText("");
                txfHocHam.setText("");
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
