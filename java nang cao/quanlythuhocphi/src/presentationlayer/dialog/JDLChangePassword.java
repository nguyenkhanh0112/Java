package presentationlayer.dialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogiclayer.NGUOIDUNGBUS;
import dtos.NguoiDung;

public class JDLChangePassword extends JDialog {
    private String tentaikhoan;
    private NguoiDung obj = new NguoiDung();
    private NGUOIDUNGBUS bus = new NGUOIDUNGBUS();

    JButton btLuu;
    JButton btHuy;
    JTextField txfMKHienTai;
    JTextField txfMKMoi;
    JTextField txfNLMK; 

    public JDLChangePassword(String tentaikhoan) {
        super((JDialog) null, "Đổi mật khẩu", true);
        this.tentaikhoan = tentaikhoan;
        addControl();
        addEvent();
    }

    public void doShow() {
        setSize(499, 449);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void addControl() {
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 5, 20, 5);

        JLabel lblDoiMatKhau = new JLabel("ĐỔI MẬT KHẨU");
        lblDoiMatKhau.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 35));
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnMain.add(lblDoiMatKhau, gbc);

        JLabel lblMKHienTai = new JLabel("Mật khẩu hiện tại");
        lblMKHienTai.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        pnMain.add(lblMKHienTai, gbc);

        txfMKHienTai = new JTextField();
        txfMKHienTai.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        txfMKHienTai.setPreferredSize(new Dimension(281, 26));
        gbc.gridx = 1;
        gbc.gridy = 1;
        pnMain.add(txfMKHienTai, gbc);

        JLabel lblMKMoi = new JLabel("Nhập mật khẩu mới");
        lblMKMoi.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        pnMain.add(lblMKMoi, gbc);

        txfMKMoi = new JTextField();
        txfMKMoi.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        txfMKMoi.setPreferredSize(new Dimension(281, 26));
        gbc.gridx = 1;
        gbc.gridy = 2;
        pnMain.add(txfMKMoi, gbc);

        JLabel lblNLMK = new JLabel("Nhập lại mật khẩu");
        lblNLMK.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        pnMain.add(lblNLMK, gbc);

        txfNLMK = new JTextField();
        txfNLMK.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        txfNLMK.setPreferredSize(new Dimension(281, 26));
        gbc.gridx = 1;
        gbc.gridy = 3;
        pnMain.add(txfNLMK, gbc);

        btLuu = new JButton("Lưu");
        btLuu.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        pnMain.add(btLuu, gbc);

        btHuy = new JButton("Hủy");
        btHuy.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 4;
        pnMain.add(btHuy, gbc);

        getContentPane().add(pnMain);
    }

    public void addEvent() {
        btHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = null;
                rs = bus.GetData(tentaikhoan);
                try {
                    rs.next();
                    if (txfMKHienTai.getText().equals(rs.getString("MATKHAU"))) {
                        if (txfMKMoi.getText().equals(txfNLMK.getText())) {
                            obj.setTenTaiKhoan(tentaikhoan);
                            obj.setMatKhau(txfMKMoi.getText());
                            obj.setQuyen(rs.getString("QUYEN"));
                            if (bus.Update(obj) == 1) {
                                JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Mật khẩu mới không khớp, vui lòng nhập lại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không đúng, vui lòng nhập lại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        txfMKHienTai.requestFocus();
                    }
                } catch (SQLException sqlE) {
                    sqlE.printStackTrace();
                }
            }
        });
    }
}
