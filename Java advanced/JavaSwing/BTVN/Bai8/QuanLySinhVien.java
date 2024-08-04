package JavaSwing.BTVN.Bai8;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class QuanLySinhVien extends JFrame {

    private JButton btnAdd,btnRemove,btnUpdate,btnClear;
    private JList<student> jList;
    private JTextField jtxtMSV,jtxtHVT,jtxtTuoi;
    private DefaultListModel<student> listModel = new DefaultListModel<student>();

    public QuanLySinhVien(){
        init();
        Control();
    }
    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setTitle("Quản lý sinh viên");
        Font font = new Font("Aria",Font.BOLD,14);
        Font font1 = new Font("Aria",Font.BOLD,20);
        JLabel jLabel = new JLabel("THÔNG TIN SINH VIÊN",JLabel.CENTER);
        jLabel.setFont(font1);
        jLabel.setForeground(Color.red);
        add(jLabel,BorderLayout.NORTH);

        Border border = BorderFactory.createLineBorder(Color.orange);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"Danh Sách Sinh viên...");
        titledBorder.setTitleFont(font);
        JPanel panelWeast = new JPanel(new BorderLayout());
        panelWeast.setBorder(titledBorder);
        jList = new JList(listModel);
        jList.setFont(font);
        panelWeast.add(new JScrollPane(jList),BorderLayout.CENTER);
        add(panelWeast,BorderLayout.WEST);

        JPanel panelCenter = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các thành phần


        JLabel jLabel1 = new JLabel("Ma sinh vien:");
        jLabel1.setFont(font);
        jLabel1.setForeground(Color.red);
        jtxtMSV = new JTextField(20);

        JLabel jLabel2 = new JLabel("Ho va ten:");
        jtxtHVT = new JTextField(20);
        jLabel2.setFont(font);

        JLabel jLabel3 = new JLabel("Tuoi:");
        jtxtTuoi = new JTextField(20);
        jLabel3.setFont(font);

        panelCenter.add(jLabel1, gbc);
        gbc.gridx++;
        panelCenter.add(jtxtMSV, gbc);

        gbc.gridx = 0; // Reset lại cột khi qua hàng mới
        gbc.gridy++;
        panelCenter.add(jLabel2, gbc);
        gbc.gridx++;
        panelCenter.add(jtxtHVT, gbc);

        gbc.gridx = 0; // Reset lại cột khi qua hàng mới
        gbc.gridy++;
        panelCenter.add(jLabel3, gbc);
        gbc.gridx++;
        panelCenter.add(jtxtTuoi, gbc);
        Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(panelCenter,BorderLayout.NORTH);
        panel.setBorder(border1);
        add(panel, BorderLayout.CENTER);

        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnUpdate = new JButton("Update");
        btnClear = new JButton("Clear");
        JPanel panelSouth = new JPanel(new FlowLayout());
        panelSouth.add(btnAdd);
        panelSouth.add(btnRemove);
        panelSouth.add(btnUpdate);
        panelSouth.add(btnClear);
        add(panelSouth,BorderLayout.SOUTH);


    }
    private int selectedIndex;
    public void Control(){
        jtxtMSV.setEnabled(false);
        jtxtHVT.setEnabled(false);
        jtxtTuoi.setEnabled(false);
        student student1 = new student("72DCHT20020","Nguyễn Văn Khánh",21);
        student student2 = new student("72DCHT20020","Nguyễn Văn Khánh1213",21);
        listModel.addElement(student1);
        listModel.addElement(student2);
        ListSelectionModel selectionModel =  jList.getSelectionModel();

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedIndex = jList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        jtxtTuoi.setEnabled(true);
                        jtxtMSV.setEnabled(true);
                        jtxtHVT.setEnabled(true);
                        int selectJlist = jList.getSelectedIndex();
                        jtxtMSV.setText(listModel.getElementAt(selectJlist).getMasv().toString());
                        jtxtHVT.setText(listModel.getElementAt(selectJlist).getHovaten().toString());
                        jtxtTuoi.setText(String.valueOf(listModel.getElementAt(selectJlist).getTuoi()));
                    }
                }
            }
        });
        btnAdd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtxtTuoi.setEnabled(true);
                jtxtMSV.setEnabled(true);
                jtxtHVT.setEnabled(true);
                if(jtxtMSV.getText().isEmpty()&&jtxtMSV.getText().isEmpty()&&jtxtTuoi.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Bạn chưa Nhập thng tin");
                }else{
                    String masv = jtxtMSV.getText();
                    String hvt = jtxtHVT.getText();
                    int Tuoi =Integer.parseInt(jtxtTuoi.getText());
                    student student = new student(masv,hvt,Tuoi);
                    listModel.addElement(student);
                    jtxtMSV.setText("");
                    jtxtHVT.setText("");
                    jtxtTuoi.setText("");
                    jList.clearSelection();
                }
            }
        });
        btnRemove.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex != -1) {
                    listModel.removeElementAt(selectedIndex);
                    // Reset các JTextField sau khi xóa
                    jtxtMSV.setText("");
                    jtxtHVT.setText("");
                    jtxtTuoi.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một sinh viên để xóa.");
                }
            }
        });
        btnUpdate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex != -1) {
                    String masv = jtxtMSV.getText();
                    String hvt = jtxtHVT.getText();
                    int tuoi = Integer.parseInt(jtxtTuoi.getText());
                    // Cập nhật thông tin của sinh viên đã chọn
                    listModel.setElementAt(new student(masv, hvt, tuoi), selectedIndex);
                    jtxtMSV.setText("");
                    jtxtHVT.setText("");
                    jtxtTuoi.setText("");
                    jList.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một sinh viên để cập nhật.");
                }
            }
        });
        btnClear.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = listModel.getSize()-1;i>=0;i--){
                    listModel.removeElementAt(i);
                }
                jtxtMSV.setText("");
                jtxtHVT.setText("");
                jtxtTuoi.setText("");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        QuanLySinhVien bai8 = new QuanLySinhVien();
    }
}
