package JavaSwing.BTVN.Bai10;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ThongTinSinhVien extends JFrame {
    private JTextField txtMsv;
    private JTextField txtHoten;
    private JTextField txtTuoi;
    private JButton btnAdd,btnRemove,btnUpdate,btnClear;
    private DefaultTreeModel defaultTreeModel;
    private DefaultMutableTreeNode students;
    private JTree tree;

    public ThongTinSinhVien(){
        init();
        control();
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
        jLabel.setForeground(Color.RED);
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border);

        students = new DefaultMutableTreeNode("Danh Sách Sinh viên");
        Student student1 = new Student("455345","Trần Thị Lê Hoa",21);
        Student student2 = new Student("44545","Nguyễn Thủy Tiên",21);
        students.add(new DefaultMutableTreeNode(student1));
        students.add(new DefaultMutableTreeNode(student2));
        defaultTreeModel = new DefaultTreeModel(students);
        tree = new JTree(defaultTreeModel);
        tree.setBorder(border);
        add(tree,BorderLayout.WEST);

        JLabel jLabel1 = new JLabel("Ma sinh vien:");
        txtMsv = new JTextField(20);
        JLabel jLabel2 = new JLabel("Ho va Ten:");
        txtHoten = new JTextField(20);
        JLabel jLabel3 = new JLabel("Tuoi:");
        txtTuoi = new JTextField(20);
        JPanel jPanel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets= new Insets(10,10,10,10);
        gbc.gridx =0;
        gbc.gridy=0;
        jPanel1.add(jLabel1,gbc);
        gbc.gridx++;
        jPanel1.add(txtMsv,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPanel1.add(jLabel2,gbc);
        gbc.gridx++;
        jPanel1.add(txtHoten,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPanel1.add(jLabel3,gbc);
        gbc.gridx++;
        jPanel1.add(txtTuoi,gbc);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(titledBorder);
        jPanel.add(jPanel1,BorderLayout.NORTH);
        add(jPanel,BorderLayout.CENTER);

        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnUpdate = new JButton("Update");
        btnClear = new JButton("Clear");
        JPanel jPanelbtn = new JPanel();
        jPanelbtn.setBorder(border);
        jPanelbtn.add(btnAdd);
        jPanelbtn.add(btnRemove);
        jPanelbtn.add(btnUpdate);
        jPanelbtn.add(btnClear);
        add(jPanelbtn,BorderLayout.SOUTH);
    }
    public void control(){
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath selectedPath = tree.getSelectionPath();
                if(selectedPath!=null){
                    DefaultMutableTreeNode selectedNode =(DefaultMutableTreeNode)selectedPath.getLastPathComponent();
                    if(selectedNode.getUserObject() instanceof Student){
                        Student student =(Student) selectedNode.getUserObject();
                        txtMsv.setText(student.getMsv().toString());
                        txtHoten.setText(student.getHoten().toString());
                        txtTuoi.setText(String.valueOf(student.getTuoi()).toString());
                    }
                }

            }
        });
        btnAdd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtMsv.getText().isEmpty()&&!txtHoten.getText().isEmpty()&&!txtTuoi.getText().isEmpty()){
                    String ma = txtMsv.getText().toString();
                    String hoten =txtHoten.getText().toString();
                    int tuoi = Integer.parseInt(txtTuoi.getText());
                    Student student = new Student(ma,hoten,tuoi);
                    DefaultMutableTreeNode newStudentNode = new DefaultMutableTreeNode(student);
                    students.add(newStudentNode);
                    defaultTreeModel.reload();
                    txtMsv.setText("");
                    txtHoten.setText("");
                    txtTuoi.setText("");
                }else{
                    JOptionPane.showMessageDialog(null,"Nhập đầy đủ thông tin");
                }
            }
        });
        btnRemove.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                TreePath selectedPaths = tree.getSelectionPath();
//                System.out.println(selectedPaths);
//                DefaultMutableTreeNode selectNode =(DefaultMutableTreeNode) selectedPaths.getLastPathComponent();
//                students.remove(selectNode);
//                defaultTreeModel.reload();
                TreePath[] selectedPaths = tree.getSelectionPaths();
                if (selectedPaths != null) {
                    for (TreePath path : selectedPaths) {
                        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                        students.remove(selectedNode);
                    }
                    defaultTreeModel.reload();
                    txtMsv.setText("");
                    txtHoten.setText("");
                    txtTuoi.setText("");
                }
            }
        });
        btnUpdate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreePath selectPath = tree.getSelectionPath();
                if(selectPath!=null){
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectPath.getLastPathComponent();
                    if(selectedNode.getUserObject() instanceof Student){
                        Student selectStudent = (Student) selectedNode.getUserObject();
                        selectStudent.setMsv(txtMsv.getText().toString());
                        selectStudent.setHoten(txtHoten.getText().toString());
                        selectStudent.setTuoi(Integer.parseInt(txtTuoi.getText().toString()));
                        defaultTreeModel.nodeChanged(selectedNode);
                        txtMsv.setText("");
                        txtHoten.setText("");
                        txtTuoi.setText("");
                        JOptionPane.showMessageDialog(null,"Thay đổi thành công!");
                    }
                }
            }
        });
        btnClear.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMsv.setText("");
                txtHoten.setText("");
                txtTuoi.setText("");
            }
        });
    }
    public void showListStudent(){

    }

    public static void main(String[] args) {
        ThongTinSinhVien thongTinSinhVien = new ThongTinSinhVien();
    }

}
