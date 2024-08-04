package JavaSwing.BTVN.Bai9;

import JavaSwing.BTVN.Bai9.QuanLySanPham;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerControllerCategory implements ActionListener, ListSelectionListener {
    private QuanLySanPham bai9;

    public ListenerControllerCategory(QuanLySanPham bai9) {
        this.bai9 = bai9;
    }
    private int index;

    @Override
    public void actionPerformed(ActionEvent e) {
        index = bai9.getSelectedIndex();
        switch (e.getActionCommand()){
            case "New":{
                String name = JOptionPane.showInputDialog("Nhập tên Danh mục: ");
                bai9.addCategory(name);
                break;
            }
            case "Update":{
                if(index!=-1){
                    String name = JOptionPane.showInputDialog("Nhâp Tên danh mục cần thay thế: ");
                    bai9.updateCategory(name,index);
                    break;
                }else{
                    JOptionPane.showMessageDialog(null,"Hãy chọn danh mục cần thay thế!");
                    break;
                }
            }
            case "Remove":{
                if(index!=-1){
                    bai9.removeCategory(index);
                }else{
                    JOptionPane.showMessageDialog(null,"Hãy chọn danh mục cần xóa!");
                }
                break;
            }
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        index = bai9.getSelectedIndex();
        if(!e.getValueIsAdjusting()){
            if(index!=-1){
                bai9.listSanPham();
            }
        }
    }

}
