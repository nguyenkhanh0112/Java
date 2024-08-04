package JavaSwing.BTVN.Bai12;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerOffice implements ActionListener, TreeSelectionListener, ListSelectionListener {
    private Bai12 viewBai12;
    private Office office;

    public ControllerOffice(Office office) {
        this.office = office;
    }

    public ControllerOffice(Bai12 viewBai12) {
        this.viewBai12 = viewBai12;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Add":{
                String name = JOptionPane.showInputDialog("Nhập tên Phòng Ban!");
                this.office = new Office(name);
                DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(office);
                viewBai12.getListRoom().add(defaultMutableTreeNode);
                viewBai12.getDefaultTreeModel().reload();
                JOptionPane.showMessageDialog(null,"Thêm thành công!");
                break;
            }
            case "Remove":{
                TreePath[] selectedTreePaths = viewBai12.getTree().getSelectionPaths();
                if(selectedTreePaths!=null){
                    for (TreePath treePath:selectedTreePaths) {
                        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                        viewBai12.getListRoom().remove(defaultMutableTreeNode);
                    }
                    viewBai12.getDefaultTreeModel().reload();
                    JOptionPane.showMessageDialog(null,"Xóa Thành Công");
                }
                break;
            }
            case "Update":{
                TreePath[] selectedTreePaths = viewBai12.getTree().getSelectionPaths();
                if(selectedTreePaths!=null){
                    String s = JOptionPane.showInputDialog("Nhập tên phòng ban cần sửa!");
                    for (int i=0;i<selectedTreePaths.length;i++){
                        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) selectedTreePaths[i].getLastPathComponent();
                        Office office1 = (Office)defaultMutableTreeNode.getUserObject();
                        office1.setNameOffice(s);
                        viewBai12.getListRoom().setUserObject(defaultMutableTreeNode);
                        viewBai12.getDefaultTreeModel().reload();
                    }
                    JOptionPane.showMessageDialog(null,"Sửa Thành Công!");
                    viewBai12.getTxtMa().setText("");
                    viewBai12.getTxtHoten().setText("");
                    viewBai12.getTxtTuoi().setText("");
                    viewBai12.getTxtPhai().setText("");
                    break;
                }
            }
        }
    }
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath treePath = viewBai12.getTree().getSelectionPath();
        if(treePath!=null){
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            if(treeNode.getUserObject() instanceof Office){
                Office office1 = (Office) treeNode.getUserObject();
                viewBai12.getDefaultListModel().clear();
                for (Staff staff:office1.getStaffArrayList()) {
                    viewBai12.getDefaultListModel().addElement(staff);
                }
                viewBai12.getTxtMa().setText("");
                viewBai12.getTxtHoten().setText("");
                viewBai12.getTxtTuoi().setText("");
                viewBai12.getTxtPhai().setText("");
            }
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            int index = viewBai12.getListStaff().getSelectedIndex();
            if(index!=-1){
                Staff staff = viewBai12.getDefaultListModel().get(index);
                viewBai12.setTxtMa(staff.getManv().toString());
                viewBai12.setTxtHoten(staff.getHoten().toString());
                viewBai12.setTxtPhai(staff.getPhai().toString());
                viewBai12.setTxtTuoi(String.valueOf(staff.getTuoi()));
            }
        }
    }
}
