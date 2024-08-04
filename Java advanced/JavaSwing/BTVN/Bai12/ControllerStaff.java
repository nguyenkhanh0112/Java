package JavaSwing.BTVN.Bai12;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerStaff implements ActionListener{
    private Bai12 viewBai12;
    private Staff staff;
    private Office aOffice;

    public ControllerStaff(Staff staff) {
        this.staff = staff;
    }

    public ControllerStaff(Bai12 viewBai12) {
        this.viewBai12 = viewBai12;
    }
    public int index(){
        return viewBai12.getListStaff().getSelectedIndex();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Add":{
                int index =index();
                if(index!=-1){
                    Staff staff1 = new Staff();
                    String ma = viewBai12.getTxtMa().getText();
                    String hoten =viewBai12.getTxtHoten().getText();
                    String phai = viewBai12.getTxtPhai().getText();
                    int tuoi =Integer.parseInt(viewBai12.getTxtTuoi().getText());
                    staff1 = new Staff(ma,hoten,phai,tuoi);
                    viewBai12.getDefaultListModel().addElement(staff1);
                    TreePath treePath = viewBai12.getTree().getSelectionPath();
                    if(treePath!=null){
                        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                        if(defaultMutableTreeNode.getUserObject() instanceof Office){
                            this.aOffice = (Office) defaultMutableTreeNode.getUserObject();
                            this.aOffice.addOffice(staff1);
                            viewBai12.getDefaultTreeModel().reload();
                        }
                    }
                    JOptionPane.showMessageDialog(null,"Thêm thành công!");
                    viewBai12.getTxtMa().setText("");
                    viewBai12.getTxtHoten().setText("");
                    viewBai12.getTxtTuoi().setText("");
                    viewBai12.getTxtPhai().setText("");
                }
                break;
            }
            case "Remove":{
                int index = index();
                if(index!=-1){
                    viewBai12.getDefaultListModel().removeElementAt(index());
                    TreePath treePath = viewBai12.getTree().getSelectionPath();
                    if(treePath!=null){
                        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                        if(defaultMutableTreeNode.getUserObject() instanceof Office){
                            this.aOffice = (Office) defaultMutableTreeNode.getUserObject();
                            this.aOffice.removeOffice(index);
                            viewBai12.getDefaultTreeModel().reload();
                        }
                    }
                    viewBai12.getTxtMa().setText("");
                    viewBai12.getTxtHoten().setText("");
                    viewBai12.getTxtTuoi().setText("");
                    viewBai12.getTxtPhai().setText("");
                    JOptionPane.showMessageDialog(null,"Xóa thành công");
                }
                break;
            }
            case "Update":{
                int index = index();
                if(index!=-1){
                    this.staff = viewBai12.getDefaultListModel().get(index());
                    this.staff.setManv(viewBai12.getTxtMa().getText());
                    this.staff.setHoten(viewBai12.getTxtHoten().getText());
                    this.staff.setPhai(viewBai12.getTxtPhai().getText());
                    this.staff.setTuoi(Integer.parseInt(viewBai12.getTxtTuoi().getText()));
                    viewBai12.getDefaultListModel().setElementAt(this.staff,index());
                    TreePath treePath = viewBai12.getTree().getSelectionPath();
                    if(treePath!=null){
                        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                        if(defaultMutableTreeNode.getUserObject() instanceof Office){
                            this.aOffice = (Office) defaultMutableTreeNode.getUserObject();
                            this.aOffice.updateOffice(index(),this.staff);
                            viewBai12.getDefaultTreeModel().reload();
                        }
                    }
                    JOptionPane.showMessageDialog(null,"Sửa Thành Công!");
                    viewBai12.getTxtMa().setText("");
                    viewBai12.getTxtHoten().setText("");
                    viewBai12.getTxtTuoi().setText("");
                    viewBai12.getTxtPhai().setText("");
                }
                break;
            }
            case "Clear":{
                ListSelectionModel listSelectionModel = viewBai12.getListStaff().getSelectionModel();
                listSelectionModel.clearSelection();
                viewBai12.getTxtMa().setText("");
                viewBai12.getTxtHoten().setText("");
                viewBai12.getTxtTuoi().setText("");
                viewBai12.getTxtPhai().setText("");
                break;
            }
        }
    }
}
