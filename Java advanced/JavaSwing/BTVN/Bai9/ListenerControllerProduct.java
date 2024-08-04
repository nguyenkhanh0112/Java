package JavaSwing.BTVN.Bai9;

import JavaSwing.BTVN.Bai9.QuanLySanPham;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerControllerProduct implements ActionListener, ListSelectionListener {
    private QuanLySanPham bai9;

    public ListenerControllerProduct(QuanLySanPham bai9) {
        this.bai9 = bai9;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = bai9.getSelectedRow();
        switch (e.getActionCommand()){
            case "New":{
                bai9.newProduct();
                break;
            }
            case "Save":{
                bai9.saveProduct();
                break;
            }
            case  "Remove":{
                bai9.removeProduct();
                break;
            }
            case "Write Data to disk":{
                bai9.ghifile();
                JOptionPane.showMessageDialog(null,"ghi file thành công");
                break;
            }
            case "Qpen Data from disk":{
                bai9.docfile();
                break;
            }
            case "Exit":{
                bai9.dispose();
                break;
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            bai9.ShowDetail();
        }
    }
}
