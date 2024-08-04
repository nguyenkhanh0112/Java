package presentationlayer.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPNSinhVien_HocPhi extends JPanel{
    private JTable tbHocPhi;
    public JPNSinhVien_HocPhi() {
        super();
        addControl();
        addEvent();
    }

    private void addControl() {
        // Panel MAIN
        setLayout(new BorderLayout());

        Object[][] data = {
                {"User1", "Password1", "Admin"},
                {"User2", "Password2", "User"},
                {"User3", "Password3", "User"}
        };
        String[] columnNames = {"Tài khoản", "Mật khẩu", "Quyền"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tbHocPhi = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbHocPhi);

        // Add components to the main panel
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addEvent() {
        // Add event handling here
    }
}
