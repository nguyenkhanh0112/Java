package JavaSwing.BTVN.Bai11;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Bai11 extends JFrame {
    private JButton btnAdd,btnRemove,btnUpdate;
    private JList<Student> jlistStudents;
    private DefaultListModel<Student> defaultListModel;
    private JTextField txtMSV,txtHoTen,txtTuoi;
    private JButton btnSVAdd,btnSVRemove,btnSVUpdate,btnSVSearch,btnSVClear,btnSVSave;
    private DefaultTreeModel defaultTreeModel;
    private JTree  jtree;
    private Class aClass;
    private DefaultMutableTreeNode listclass;
    private int selectedIndices;

    public DefaultMutableTreeNode getListclass() {
        return listclass;
    }

    public JTree getJtree() {
        return jtree;
    }

    public DefaultTreeModel getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public DefaultListModel<Student> getDefaultListModel() {
        return defaultListModel;
    }

    public JList<Student> getJlistStudents() {
        return jlistStudents;
    }

    public Bai11(){
        aClass = new Class();
        init();
        controll();
        setVisible(true);
    }
    public void init(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setSize(500,400);
        setTitle("Quản lý Sinh Viên");

        Font font = new Font("Aria",Font.BOLD,14);
        Font font1 = new Font("Aria",Font.BOLD,20);

        JLabel jLabel = new JLabel("THÔNG TIN SINH VIÊN",JLabel.CENTER);
        jLabel.setFont(font1);
        add(jLabel,BorderLayout.NORTH);
        jLabel.setForeground(Color.blue);
        Student student1 = new Student("72DCHT21","Nguyễn Thị Thanh Thúy",21);
        Student student2 = new Student("72DCHT22","Phạm Quỳnh Trang",21);
        Student student3 = new Student("72DCHT23","Nguyễn Văn Khánh",21);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Class class1 = new Class("TCTH36D Trung Cấp tin học 36D",students);
        Class class2 = new Class("TCTH35A Trung Cấp tin học 35D");
        Class class3 = new Class("TCTH1 A Cao Đăng nghề tin học");
        DefaultMutableTreeNode defaultMutableTreeNode1 = new DefaultMutableTreeNode(class1);
        DefaultMutableTreeNode defaultMutableTreeNode2 = new DefaultMutableTreeNode(class2);
        DefaultMutableTreeNode defaultMutableTreeNode3 = new DefaultMutableTreeNode(class3);

        listclass = new DefaultMutableTreeNode("Danh sach lop hoc");
        listclass.add(defaultMutableTreeNode1);
        listclass.add(defaultMutableTreeNode2);
        listclass.add(defaultMutableTreeNode3);
        defaultTreeModel = new DefaultTreeModel(listclass);
//        listSelectionModel = jlistStudents.getSelectionModel();
        jtree = new JTree(defaultTreeModel);
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnUpdate = new JButton("Update");
        JPanel jPanel1 = new JPanel();
        jPanel1.add(btnAdd);
        jPanel1.add(btnRemove);
        jPanel1.add(btnUpdate);

        JPanel jPanelWeast = new JPanel(new BorderLayout());
        jPanelWeast.add(new JScrollPane(jtree),BorderLayout.CENTER);
        jPanelWeast.add(jPanel1,BorderLayout.SOUTH);
        add(jPanelWeast,BorderLayout.WEST);


        defaultListModel = new DefaultListModel<>();
        jlistStudents = new JList(defaultListModel);
        Border border = BorderFactory.createLineBorder(Color.orange);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"Danh sach sinh vien...");
        jlistStudents.setBorder(titledBorder);
        JPanel jPanellisstCenter = new JPanel(new BorderLayout());
        jPanellisstCenter.add(jlistStudents,BorderLayout.CENTER);
        JPanel jPanelCenter = new JPanel(new BorderLayout());

        JLabel msv = new JLabel("Ma sinh vien:");
        txtMSV = new JTextField(20);
        JLabel hoten = new JLabel("Ho ten sinh vien:");
        txtHoTen = new JTextField(20);
        JLabel tuoi = new JLabel("Tuoi:");
        txtTuoi = new JTextField(20);

        JPanel jPanelTXT = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,5,5,5);
        gbc.gridx=0;
        gbc.gridy=0;
        jPanelTXT.add(msv,gbc);
        gbc.gridx++;
        jPanelTXT.add(txtMSV,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPanelTXT.add(hoten,gbc);
        gbc.gridx++;
        jPanelTXT.add(txtHoTen,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPanelTXT.add(tuoi,gbc);
        gbc.gridx++;
        jPanelTXT.add(txtTuoi,gbc);
        jPanellisstCenter.add(jPanelTXT,BorderLayout.SOUTH);
        btnSVAdd = new JButton("Add");
        btnSVRemove = new JButton("Remove");
        btnSVUpdate = new JButton("Update");
        btnSVSearch = new JButton("Search");
        btnSVClear = new JButton("Clear");
        btnSVSave = new JButton("Save");
        JPanel jPanelSouth = new JPanel();
        jPanelSouth.add(btnSVAdd);
        jPanelSouth.add(btnSVRemove);
        jPanelSouth.add(btnSVUpdate);
        jPanelSouth.add(btnSVSearch);
        jPanelSouth.add(btnSVClear);
        jPanelSouth.add(btnSVSave);
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(null,"Sinh vien");
        jPanelSouth.setBorder(titledBorder1);
        jPanelCenter.add(jPanellisstCenter,BorderLayout.CENTER);
        jPanelCenter.add(jPanelSouth,BorderLayout.SOUTH);
        add(jPanelCenter,BorderLayout.CENTER);
        pack();
    }
    public void controll(){
        ActionListener actionListener = new ControllerClass(this);
        ActionListener actionListener1 = new ControllerStudent(this);
        btnAdd.addActionListener(actionListener);
        btnRemove.addActionListener(actionListener);
        btnUpdate.addActionListener(actionListener);
        jtree.addTreeSelectionListener((TreeSelectionListener) actionListener);
        jlistStudents.addListSelectionListener((ListSelectionListener) actionListener);
        btnSVAdd.addActionListener(actionListener1);
        btnSVRemove.addActionListener(actionListener1);
        btnSVUpdate.addActionListener(actionListener1);
        btnSVSearch.addActionListener(actionListener1);
        btnSVClear.addActionListener(actionListener1);
        btnSVSave.addActionListener(actionListener1);

    }
    public void ReloadDefaultTreeModel(){
        defaultTreeModel.reload();
    }
    public int getSelectedIndex(){
        TreePath selectedTreepath = jtree.getSelectionPath();
        if(selectedTreepath!=null){
            selectedIndices = jtree.getRowForPath(selectedTreepath);
        }
        return selectedIndices;
    }
    public TreePath treePath(){
        return jtree.getSelectionPath();
    }
    public TreePath[] treePaths(){
        return  jtree.getSelectionPaths();
    }
    public void setTxt(String ma,String hoten,int tuoi){
        txtMSV.setText(ma);
        txtHoTen.setText(hoten);
        txtTuoi.setText(String.valueOf(tuoi));
    }

    public JTextField getTxtMSV() {
        return txtMSV;
    }

    public JTextField getTxtHoTen() {
        return txtHoTen;
    }

    public JTextField getTxtTuoi() {
        return txtTuoi;
    }

    public void setTxtMSV(String s) {
        this.txtMSV.setText(s);
    }

    public void setTxtHoTen(String s) {
        this.txtHoTen.setText(s);
    }

    public void setTxtTuoi(String s) {
        this.txtTuoi.setText(s);
    }
}
