package presentationlayer.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import util.Constants;

public class JDLQuanLy_CTPhieuThu extends JDialog{

    JTextField txfMaPhieuThu;
    JTextField txfMaChiTietPT;
    JTextField txfNgayDong;
    JTextField txfTongHocPhi;
    JTextField txfTongDaDong;
    JTextField txfTongChuaDong;
    JTextField txfSoTienDong;
    
    JButton btThem;
    JButton btSua;
    JButton btXoa;
    JButton btReset;
    JButton btKiemTra;
    JTable tbCTPhieuThu;

    public JDLQuanLy_CTPhieuThu() {
        super((JDialog) null, "Chi tiết phiếu thu", true);
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
        pnMain.setLayout(new BorderLayout());

        // Panel Center
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20));

        txfMaPhieuThu = new JTextField();
        pnCenter.add(createSubPanel("Mã phiếu thu:", txfMaPhieuThu));

        JLabel lblHocPhi = new JLabel("THÔNG TIN HỌC PHÍ KỲ");
        lblHocPhi.setBorder(new EmptyBorder(0, 70, 0, 70));
        lblHocPhi.setFont(new Font(Constants.BASE_FONT_NAME, Font.BOLD, 24));
        pnCenter.add(lblHocPhi);

        txfMaChiTietPT = new JTextField();
        pnCenter.add(createSubPanel("Mã chi tiết phiếu thu:",  txfMaChiTietPT));

        txfTongHocPhi = new JTextField();
        pnCenter.add(createSubPanel("Số tiền phải đóng:", txfTongHocPhi));

        txfNgayDong = new JTextField();
        pnCenter.add(createSubPanel("Ngày đóng:", txfNgayDong));

        txfTongDaDong = new JTextField();
        pnCenter.add(createSubPanel("Tổng đã đóng:", txfTongDaDong));

        txfSoTienDong = new JTextField();
        pnCenter.add(createSubPanel("Số tiền đóng:", txfSoTienDong));

        txfTongChuaDong = new JTextField();
        pnCenter.add(createSubPanel("Tổng chưa đóng:", txfTongChuaDong));

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
        btKiemTra = createNewJButton("Kiểm tra");

        pnButtons.add(btThem, gbcButtons);
        pnButtons.add(btSua, gbcButtons);
        pnButtons.add(btXoa, gbcButtons);
        pnButtons.add(btReset, gbcButtons);
        pnButtons.add(btKiemTra, gbcButtons);

        pnEast.add(pnButtons, BorderLayout.NORTH);

        // Panel South
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BorderLayout());
        pnSouth.setPreferredSize(new Dimension(1081, 423));

        Object[][] data = {
                {"User1", "Password1", "Admin"},
                {"User2", "Password2", "User"},
                {"User3", "Password3", "User"}
        };
        String[] columnNames = {"Mã khoa", "Tên khoa", "Đơn giá tín chỉ"};
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable tbNguoiDung = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbNguoiDung);

        pnSouth.add(scrollPane, BorderLayout.CENTER);

        // Add components to the main panel
        pnMain.add(pnCenter, BorderLayout.CENTER);
        pnMain.add(pnEast, BorderLayout.EAST);
        pnMain.add(pnSouth, BorderLayout.SOUTH);
        
        getContentPane().add(pnMain);
    }

    private void addEvent() {
        // Add event handling here
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
}
