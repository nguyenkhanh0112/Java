package JavaSwing.BTVN.Bai12;

import JavaSwing.BTVN.Bai11.Class;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Bai12 extends JFrame {
    private DefaultTreeModel defaultTreeModel;
    private JTree tree;
    private JButton btnRoomAdd,btnRoomRemove,btnRoomUpdate;
    private DefaultListModel<Staff> defaultListModel;
    private JList<Staff> listStaff;
    private JTextField txtMa,txtHoten,txtTuoi,txtPhai;
    private JButton btnStaffAdd,btnStaffRemove,btnStaffUpdate,btnStaffClear;

    private Office office;
    private DefaultMutableTreeNode listRoom;

    public DefaultMutableTreeNode getListRoom() {
        return listRoom;
    }
    public DefaultTreeModel getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public JTree getTree() {
        return tree;
    }

    public DefaultListModel<Staff> getDefaultListModel() {
        return defaultListModel;
    }

    public JList<Staff> getListStaff() {
        return listStaff;
    }

    public JTextField getTxtMa() {
        return txtMa;
    }

    public JTextField getTxtHoten() {
        return txtHoten;
    }

    public JTextField getTxtTuoi() {
        return txtTuoi;
    }

    public JTextField getTxtPhai() {
        return txtPhai;
    }

    public void setTxtMa(String txtMa) {
        this.txtMa.setText(txtMa);
    }

    public void setTxtHoten(String txtHoten) {
        this.txtHoten.setText(txtHoten);
    }

    public void setTxtTuoi(String txtTuoi) {
        this.txtTuoi.setText(txtTuoi);
    }

    public void setTxtPhai(String txtPhai) {
        this.txtPhai.setText(txtPhai);
    }

    public Bai12(){

        init();
        control();
        setVisible(true);
    }


    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setSize(650,400);
        setTitle("Quản lý nhân viên");

        Font font = new Font("Aria",Font.BOLD,14);
        Font font1 = new Font("Aria",Font.BOLD,20);

        JLabel jLabel = new JLabel("CÔNG TY TNHH THÀNH AN",JLabel.CENTER);
        jLabel.setFont(font1);
        add(jLabel,BorderLayout.NORTH);
        jLabel.setForeground(Color.magenta);

        Staff staff1 = new Staff("01","Trần Văn Lành","Nam",21);
        Staff staff2 = new Staff("02","Trần Văn Hùng","Nam",21);
        Staff staff3 = new Staff("03","Nguyễn Thị Cẩm Nhung","Nữ",21);
        Staff staff4 = new Staff("04","Nguyễn Văn Khánh","Nam",21);
        ArrayList<Staff> staffs = new ArrayList<>();
        staffs.add(staff1);
        staffs.add(staff2);
        staffs.add(staff3);
        staffs.add(staff4);
        Office office1 = new Office("Kế Toán",staffs);
        Office office2 = new Office("Kỹ Thuật");
        Office office3 = new Office("Vật Tư");
        Office office4 = new Office("Kế hoạch hành chính");
        Office office5 = new Office("Tư Vấn Khách hàng");
        Office office6 = new Office("Tạp Vụ");
        DefaultMutableTreeNode defaultMutableTreeNode1 = new DefaultMutableTreeNode(office1);
        DefaultMutableTreeNode defaultMutableTreeNode2 = new DefaultMutableTreeNode(office2);
        DefaultMutableTreeNode defaultMutableTreeNode3 = new DefaultMutableTreeNode(office3);
        DefaultMutableTreeNode defaultMutableTreeNode4 = new DefaultMutableTreeNode(office4);
        DefaultMutableTreeNode defaultMutableTreeNode5 = new DefaultMutableTreeNode(office5);
        DefaultMutableTreeNode defaultMutableTreeNode6 = new DefaultMutableTreeNode(office6);
        listRoom = new DefaultMutableTreeNode("Danh sách phòng ban");
        listRoom.add(defaultMutableTreeNode1);
        listRoom.add(defaultMutableTreeNode2);
        listRoom.add(defaultMutableTreeNode3);
        listRoom.add(defaultMutableTreeNode4);
        listRoom.add(defaultMutableTreeNode5);
        listRoom.add(defaultMutableTreeNode6);

        defaultTreeModel = new DefaultTreeModel(listRoom);
        tree = new JTree(defaultTreeModel);

        btnRoomAdd = new JButton("Add");
        btnRoomRemove = new JButton("Remove");
        btnRoomUpdate = new JButton("Update");

        JPanel jPanelbtnroom =new JPanel();
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Phòng ban");
        jPanelbtnroom.setBorder(titledBorder1);
        jPanelbtnroom.add(btnRoomAdd);
        jPanelbtnroom.add(btnRoomRemove);
        jPanelbtnroom.add(btnRoomUpdate);
        JPanel jPanelWeast = new JPanel(new BorderLayout());
        jPanelWeast.add(tree,BorderLayout.CENTER);
        jPanelWeast.add(jPanelbtnroom,BorderLayout.SOUTH);
        add(jPanelWeast,BorderLayout.WEST);

        defaultListModel = new DefaultListModel<>();
        listStaff = new JList<>(defaultListModel);

        TitledBorder titledBorder2 = new TitledBorder("Danh sách nhân viên");
        listStaff.setBorder(titledBorder2);

        JLabel jLabel1 = new JLabel("Mã nhân viên:");
        JLabel jLabel2 = new JLabel("Họ và tên nhân viên:");
        JLabel jLabel3 = new JLabel("Phái:");
        JLabel jLabel4 = new JLabel("Tuổi:");

        txtMa = new JTextField(20);
        txtHoten = new JTextField(20);
        txtPhai = new JTextField(20);
        txtTuoi = new JTextField(20);

        JPanel jPaneltxt = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,10,0);
        gbc.gridx=0;
        gbc.gridy=0;
        jPaneltxt.add(jLabel1,gbc);
        gbc.gridx++;
        jPaneltxt.add(txtMa,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPaneltxt.add(jLabel2,gbc);
        gbc.gridx++;
        jPaneltxt.add(txtHoten,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPaneltxt.add(jLabel3,gbc);
        gbc.gridx++;
        jPaneltxt.add(txtPhai,gbc);

        gbc.gridx=0;
        gbc.gridy++;
        jPaneltxt.add(jLabel4,gbc);
        gbc.gridx++;
        jPaneltxt.add(txtTuoi,gbc);

        JPanel jPanellist = new JPanel(new BorderLayout());
        jPanellist.add(listStaff,BorderLayout.CENTER);
        jPanellist.add(jPaneltxt,BorderLayout.SOUTH);

        btnStaffAdd = new JButton("Add");
        btnStaffRemove = new JButton("Remove");
        btnStaffUpdate = new JButton("Update");
        btnStaffClear = new JButton("Clear");

        JPanel jPanelBtnStaff = new JPanel();
        TitledBorder titledBorder3 = new TitledBorder("Nhân viên");
        jPanelBtnStaff.setBorder(titledBorder3);
        jPanelBtnStaff.add(btnStaffAdd);
        jPanelBtnStaff.add(btnStaffRemove);
        jPanelBtnStaff.add(btnStaffUpdate);
        jPanelBtnStaff.add(btnStaffClear);

        JPanel jPanelCenter = new JPanel(new BorderLayout());
        jPanelCenter.add(jPanellist,BorderLayout.CENTER);
        jPanelCenter.add(jPanelBtnStaff,BorderLayout.SOUTH);
        add(jPanelCenter,BorderLayout.CENTER);
    }
    public void control(){
        ActionListener actionListener = new ControllerOffice(this);
        ActionListener actionListener1 = new ControllerStaff(this);
        tree.addTreeSelectionListener((TreeSelectionListener) actionListener);
        btnRoomAdd.addActionListener(actionListener);
        btnRoomRemove.addActionListener(actionListener);
        btnRoomUpdate.addActionListener(actionListener);
        listStaff.addListSelectionListener((ListSelectionListener) actionListener);
        btnStaffAdd.addActionListener(actionListener1);
        btnStaffUpdate.addActionListener(actionListener1);
        btnStaffRemove.addActionListener(actionListener1);
        btnStaffClear.addActionListener(actionListener1);
    }
}
