package JavaSwing.BTVN.Bai11;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControllerClass implements ActionListener, TreeSelectionListener,ListSelectionListener {
    private Bai11 viewControllerClass;
    private Class aClass;


    public ControllerClass(Bai11 viewControllerClass) {
        this.viewControllerClass = viewControllerClass;
    }

    public ControllerClass(Class aClass) {
        this.aClass = aClass;
    }
    public int index(){
        return viewControllerClass.getJlistStudents().getSelectedIndex();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Add":{
                String s = JOptionPane.showInputDialog("Hãy nhập tên Class");
                this.aClass = new Class(s);
                DefaultMutableTreeNode defaultMutableTreeNode =new DefaultMutableTreeNode(aClass);
                viewControllerClass.getListclass().add(defaultMutableTreeNode);
                viewControllerClass.ReloadDefaultTreeModel();

                break;
            }
            case "Remove":{
                TreePath[] treePaths = viewControllerClass.treePaths();
                if (treePaths != null) {
                    for (TreePath path : treePaths) {
                        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                        viewControllerClass.getListclass().remove(selectedNode);
                    }
                    viewControllerClass.ReloadDefaultTreeModel();
                    viewControllerClass.setTxtTuoi("");
                    viewControllerClass.setTxtMSV("");
                    viewControllerClass.setTxtHoTen("");
                }
                break;
            }
            case "Update":{
                TreePath selectedTrepath = viewControllerClass.treePath();
                if(selectedTrepath!=null){
                    DefaultMutableTreeNode selectedTreenode = (DefaultMutableTreeNode) selectedTrepath.getLastPathComponent();
                    if(selectedTreenode.getUserObject() instanceof Class ){
                        String s =JOptionPane.showInputDialog("Nhập tên class muốn chỉnh sửa!");
                        Class class1 = (Class) selectedTreenode.getUserObject();
                        class1.setNameClass(s);
                        viewControllerClass.getDefaultTreeModel().nodeChanged(selectedTreenode);
                    }
                }
                break;
            }
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath selectedTreePath = viewControllerClass.treePath();
        if(selectedTreePath!=null){
            DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) selectedTreePath.getLastPathComponent();
            if(defaultMutableTreeNode.getUserObject() instanceof Class){
                Class class1 = (Class) defaultMutableTreeNode.getUserObject();
                viewControllerClass.getDefaultListModel().clear();
                for(Student student : class1.getStudentArrayList()){
                    viewControllerClass.getDefaultListModel().addElement(student);
                }
                viewControllerClass.setTxtTuoi("");
                viewControllerClass.setTxtMSV("");
                viewControllerClass.setTxtHoTen("");
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            int index = index();
            if(index!=-1){
                Student student = viewControllerClass.getDefaultListModel().get(index);
                String ma = student.getMsv().toString();
                String hoten = student.getHoten().toString();
                int tuoi =student.getTuoi();
                viewControllerClass.setTxt(ma,hoten,tuoi);
            }
        }
    }
}
