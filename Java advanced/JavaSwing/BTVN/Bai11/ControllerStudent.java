package JavaSwing.BTVN.Bai11;

import JavaSwing.BTVN.Bai11.File.MyFile;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControllerStudent implements ActionListener {
    private Bai11 viewStudent;
    private Student student;
    private Class aClass;

    public ControllerStudent(Class aClass) {
        this.aClass = aClass;
    }

    private MyFile myFile;
    public ControllerStudent(Bai11 viewStudent) {
        this.viewStudent = viewStudent;
    }

    public ControllerStudent(Student student) {
        this.student = student;
    }
    private ListSelectionModel listSelectionModel;
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Add":{
                String ma = viewStudent.getTxtMSV().getText().toString();
                String hoten = viewStudent.getTxtHoTen().getText().toString();
                int tuoi = Integer.parseInt(viewStudent.getTxtTuoi().getText());
                this.student = new Student(ma,hoten,tuoi);
                viewStudent.getDefaultListModel().addElement(student);
                TreePath treePath = viewStudent.getJtree().getSelectionPath();
                if(treePath!=null){
                    DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
                    if(defaultMutableTreeNode.getUserObject() instanceof Class){
                        this.aClass = (Class) defaultMutableTreeNode.getUserObject();
                        this.aClass.addStudentArrayList(this.student);
                        viewStudent.getDefaultTreeModel().reload();
                    }
                }
                JOptionPane.showMessageDialog(null,"Thêm thành công!");
                viewStudent.setTxtMSV("");
                viewStudent.setTxtHoTen("");
                viewStudent.setTxtTuoi("");
                break;
            }
            case "Remove":{
                int index = viewStudent.getJlistStudents().getSelectedIndex();
                if(index!=-1){
                    viewStudent.getDefaultListModel().removeElementAt(index);
                    TreePath treePath = viewStudent.getJtree().getSelectionPath();
                    if(treePath!=null){
                        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
                        if(defaultMutableTreeNode.getUserObject() instanceof Class){
                            this.aClass = (Class) defaultMutableTreeNode.getUserObject();
                            this.aClass.removeStudentArrayList(index);
                            viewStudent.getDefaultTreeModel().reload();
                        }
                    }
                    viewStudent.setTxtMSV("");
                    viewStudent.setTxtHoTen("");
                    viewStudent.setTxtTuoi("");
                    JOptionPane.showMessageDialog(null,"Xóa thành công!");
                }
                break;
            }
            case "Update":{
                int index = viewStudent.getJlistStudents().getSelectedIndex();
                if(index!=-1){
                    String ma = viewStudent.getTxtMSV().getText().toString();
                    String hoten = viewStudent.getTxtHoTen().getText().toString();
                    int tuoi = Integer.parseInt(viewStudent.getTxtTuoi().getText().toString());
                    this.student = new Student(ma,hoten,tuoi);
                    viewStudent.getDefaultListModel().setElementAt(this.student,index);
                    TreePath treePath = viewStudent.getJtree().getSelectionPath();
                    if(treePath!=null){
                        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
                        if(defaultMutableTreeNode.getUserObject() instanceof Class){
                            this.aClass = (Class) defaultMutableTreeNode.getUserObject();
                            this.aClass.updateStudentArrayList(index,this.student);
                            viewStudent.getDefaultTreeModel().reload();
                        }
                    }
                    viewStudent.setTxtMSV("");
                    viewStudent.setTxtHoTen("");
                    viewStudent.setTxtTuoi("");
                }
                break;
            }
            case "Search":{
                if(viewStudent.getDefaultListModel().size()!=0){
                    listSelectionModel = viewStudent.getJlistStudents().getSelectionModel();
                    listSelectionModel.clearSelection();
                    viewStudent.setTxtMSV("");
                    viewStudent.setTxtHoTen("");
                    viewStudent.setTxtTuoi("");
                    String name = JOptionPane.showInputDialog("Nhập Sinh viên cần tìm kiếm!");
                    for(int i=0;i<viewStudent.getDefaultListModel().size();i++){
                        String name1 = viewStudent.getDefaultListModel().get(i).getHoten().toString();
                        if(name1.equalsIgnoreCase(name)){
                            Student student1 = viewStudent.getDefaultListModel().get(i);
                            listSelectionModel.addSelectionInterval(i,i);
                            viewStudent.setTxtMSV(student1.getMsv());
                            viewStudent.setTxtHoTen(student1.getHoten());
                            viewStudent.setTxtTuoi(String.valueOf(student1.getTuoi()));
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"không có dữ liệu để tìm hãy nhập thêm dữ liệu");
                }
                break;
            }
            case "Clear":{
                listSelectionModel = viewStudent.getJlistStudents().getSelectionModel();
                listSelectionModel.clearSelection();
                viewStudent.setTxtMSV("");
                viewStudent.setTxtHoTen("");
                viewStudent.setTxtTuoi("");
                break;
            }
            case "Save":{
                myFile = new MyFile();
//                int index = viewStudent.getJlistStudents().getSelectedIndex();
//                if(index!=-1){
//                    String name = JOptionPane.showInputDialog("Hãy nhập tên File");
//                    Student student1 =viewStudent.getDefaultListModel().get(index);
//                    myFile.WriteFile(name,student1);
//                    if(myFile.ReadFile(name) instanceof Student){
//                        System.out.println(((Student) myFile.ReadFile(name)).getMsv());
//                        System.out.println(((Student) myFile.ReadFile(name)).getHoten());
//                        System.out.println(((Student) myFile.ReadFile(name)).getTuoi());
//                    }
//                    JOptionPane.showMessageDialog(null,"Lưu FIle Thành công!");
//                }
                ArrayList<Student> arrayList = new ArrayList<>();
                int[] selectedIndices = viewStudent.getJlistStudents().getSelectedIndices();
                if(selectedIndices.length>=1){
                    String name = JOptionPane.showInputDialog("Hãy nhập tên File");
                    for (int i=0;i<selectedIndices.length;i++){
                        Student student1 = viewStudent.getDefaultListModel().get(i);
                        arrayList.add(student1);
                    }
                    if(!arrayList.isEmpty()) {
                        myFile.WriteFile(name, arrayList);
                        if (myFile.ReadFile(name) instanceof ArrayList<Student>) {
                            ArrayList<Student> loadedStudents = (ArrayList<Student>) myFile.ReadFile(name);
                            for (Student student : loadedStudents) {
                                System.out.println(student.getMsv());
                                System.out.println(student.getHoten());
                                System.out.println(student.getTuoi());
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Lưu File Thành công!");
                    }else {
                        JOptionPane.showMessageDialog(null, "Chọn ít nhất một sinh viên để lưu!");
                    }
                break;
            }
        }
    }
}
