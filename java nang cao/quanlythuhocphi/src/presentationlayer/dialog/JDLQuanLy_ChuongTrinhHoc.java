package presentationlayer.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.constant.Constable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.table.TableCellRenderer;

import businesslogiclayer.CHUONGTRINHHOCBUS;
import businesslogiclayer.CTCHUYENNGANHBUS;
import businesslogiclayer.KHOABUS;
import dtos.CTChuyenNganh;
import util.Constants;

public class JDLQuanLy_ChuongTrinhHoc extends JDialog{
    private String MaCN;
    private CTChuyenNganh obj = new CTChuyenNganh();
    private CHUONGTRINHHOCBUS bus_CTH = new CHUONGTRINHHOCBUS();
    private CTCHUYENNGANHBUS bus_CTCN = new CTCHUYENNGANHBUS();

    private JTextField txfTenMonHoc;
    private JButton btTimKiem;
    private JButton btDangKy;
    private JButton btHuyDangKy;
    private JTable tbMHChuaDK;
    private DefaultTableModel dtmMHChuaDK;
    private JTable tbMHDK;
    private DefaultTableModel dtmMHDK;
    
    public JDLQuanLy_ChuongTrinhHoc(String MACN) {
        super((JDialog) null, "", true);

        this.MaCN = MACN;
        
        addControl();
        addEvent();
    }

    public void doShow() {
        setSize(1097, 673);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addControl() {
        // Panel MAIN
        JPanel pnMain = new JPanel();
        pnMain.setBackground(Constants.BASE_BACKGROUND_COLOR);
        pnMain.setLayout(new BorderLayout());

        // Panel NORTH
        JPanel pnNorth = new JPanel();
        pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnNorth.setBackground(Constants.BASE_BACKGROUND_COLOR);

        JPanel pnNorthWrapper = new JPanel();
        pnNorthWrapper.setBackground(Constants.BASE_BACKGROUND_COLOR);
        pnNorthWrapper.setLayout(new GridBagLayout());
        GridBagConstraints gbcNorth = new GridBagConstraints();
        gbcNorth.insets = new Insets(5, 5, 5, 5);
        gbcNorth.anchor = GridBagConstraints.NORTHWEST;

        JLabel lblTitle = new JLabel("QUẢN LÝ CHƯƠNG TRÌNH HỌC CỦA CHUYÊN NGÀNH");
        lblTitle.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 27));
        lblTitle.setForeground(Constants.BASE_TEXT_COLOR);
        gbcNorth.gridwidth = 3;
        gbcNorth.gridx = 0;
        gbcNorth.gridy = 0;
        pnNorthWrapper.add(lblTitle, gbcNorth);

        JLabel lblTenMonHoc = new JLabel("Tên môn học:");
        lblTenMonHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        lblTenMonHoc.setForeground(Constants.BASE_TEXT_COLOR);
        gbcNorth.gridwidth = 1;
        gbcNorth.gridx = 0;
        gbcNorth.gridy = 1;
        pnNorthWrapper.add(lblTenMonHoc, gbcNorth);

        txfTenMonHoc = new JTextField();
        txfTenMonHoc.setPreferredSize(new Dimension(252, 26));
        txfTenMonHoc.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        gbcNorth.gridx = 1;
        gbcNorth.gridy = 1;
        pnNorthWrapper.add(txfTenMonHoc, gbcNorth);

        btTimKiem = new JButton("Tìm kiếm");
        btTimKiem.setPreferredSize(new Dimension(100, 26));
        btTimKiem.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        gbcNorth.gridx = 2;
        gbcNorth.gridy = 1;
        pnNorthWrapper.add(btTimKiem, gbcNorth);

        pnNorth.add(pnNorthWrapper);

        // Panel West
        Color tomatoColor = new Color(255, 99, 71);

        JPanel pnWest = new JPanel();
        pnWest.setBackground(tomatoColor);
        pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
        pnWest.setPreferredSize(new Dimension(539, 483));

        JLabel lblWestTitle = new JLabel("Danh sách các môn học:");
        lblWestTitle.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        lblWestTitle.setForeground(Constants.BASE_TEXT_COLOR);

        try {
            dtmMHChuaDK = resultSetToTableModel(bus_CTH.GetDataNotInChuyenNganh(MaCN));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        tbMHChuaDK = new JTable(dtmMHChuaDK);
        tbMHChuaDK.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrpMHChuaDK = new JScrollPane(tbMHChuaDK);

        pnWest.add(lblWestTitle);
        pnWest.add(scrpMHChuaDK);

        // Panel East
        JPanel pnEast = new JPanel();
        pnEast.setBackground(tomatoColor);
        pnEast.setLayout(new BoxLayout(pnEast, BoxLayout.Y_AXIS));
        pnEast.setPreferredSize(new Dimension(539, 483));

        JLabel lblEastTitle = new JLabel("Danh sách các môn học đã đăng ký:");
        lblEastTitle.setFont(new Font(Constants.BASE_FONT_NAME, Font.PLAIN, 16));
        lblEastTitle.setForeground(Constants.BASE_TEXT_COLOR);

        try {
            dtmMHDK = resultSetToTableModel(bus_CTH.GetDataByChuyenNganh(MaCN));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        tbMHDK = new JTable(dtmMHDK);
        tbMHDK.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrpMHDK = new JScrollPane(tbMHDK);

        pnEast.add(lblEastTitle);
        pnEast.add(scrpMHDK);

        // Panel South
        JPanel pnSouth = new JPanel();
        pnSouth.setBackground(Constants.BASE_BACKGROUND_COLOR);
        pnSouth.setLayout(new BorderLayout());

        btDangKy = new JButton("Đăng ký môn học");
        btDangKy.setPreferredSize(new Dimension(539, 30));
        btDangKy.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 16));
        btDangKy.setBackground(Color.white);

        btHuyDangKy = new JButton("Hủy đăng ký môn học");
        btHuyDangKy.setPreferredSize(new Dimension(539, 30));
        btHuyDangKy.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 16));
        btHuyDangKy.setBackground(Color.white);

        pnSouth.add(btDangKy, BorderLayout.WEST);
        pnSouth.add(btHuyDangKy, BorderLayout.EAST);

        // Add components to the main panel
        pnMain.add(pnNorth, BorderLayout.NORTH);
        pnMain.add(pnWest, BorderLayout.WEST);
        pnMain.add(pnEast, BorderLayout.EAST);
        pnMain.add(pnSouth, BorderLayout.SOUTH);
        
        getContentPane().add(pnMain);
    }

    private void addEvent() {
        btTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dtmMHChuaDK = resultSetToTableModel(bus_CTH.FindByTenMHNotInChuyenNganh(MaCN, txfTenMonHoc.getText()));
                    tbMHChuaDK.setModel(dtmMHChuaDK);
                    dtmMHDK = resultSetToTableModel(bus_CTH.FindByTenMHandChuyenNganh(MaCN, txfTenMonHoc.getText()));
                    tbMHDK.setModel(dtmMHDK);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        btDangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbMHChuaDK.getSelectedRow();
                if (selectedRow != -1) {
                    obj.setMACN(MaCN);
                    obj.setMAMH(dtmMHChuaDK.getValueAt(selectedRow, 0).toString());
                    try {
                        bus_CTCN.Insert(obj);
                        dtmMHChuaDK = resultSetToTableModel(bus_CTH.GetDataNotInChuyenNganh(MaCN));
                        tbMHChuaDK.setModel(dtmMHChuaDK);
                        dtmMHDK = resultSetToTableModel(bus_CTH.GetDataByChuyenNganh(MaCN));
                        tbMHDK.setModel(dtmMHDK);
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học muốn đăng ký", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btHuyDangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbMHDK.getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        bus_CTCN.DeleteByMaMH(dtmMHDK.getValueAt(selectedRow, 0).toString());
                        dtmMHChuaDK = resultSetToTableModel(bus_CTH.GetDataNotInChuyenNganh(MaCN));
                        tbMHChuaDK.setModel(dtmMHChuaDK);
                        dtmMHDK = resultSetToTableModel(bus_CTH.GetDataByChuyenNganh(MaCN));
                        tbMHDK.setModel(dtmMHDK);
                        JOptionPane.showMessageDialog(null, "Hủy đăng ký thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học muốn hủy đăng ký", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
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
}
