package presentationlayer.dialog;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JDLSinhVien_CTHocPhi extends JDialog{
    private JTable tbHocPhi;
    public JDLSinhVien_CTHocPhi() {
        super((JDialog) null, "", true);
        addControl();
        addEvent();
    }

    public void doShow() {
        setSize(816, 489);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addControl() {
        // Panel MAIN
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        Object[][] data = {
                {"User1", "Password1", "Admin"},
                {"User2", "Password2", "User"},
                {"User3", "Password3", "User"}
        };
        String[] columnNames = {"Tài khoản", "Mật khẩu", "Quyền"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tbHocPhi = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tbHocPhi);

        pnMain.add(scrollPane);
        
        getContentPane().add(pnMain);
    }

    private void addEvent() {
        // Add event handling here
    }
}
