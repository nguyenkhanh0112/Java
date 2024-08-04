package controller;

import view.ThucDonView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class ThucDonController implements ActionListener {

    private ThucDonView thucDonView;

    public ThucDonController(ThucDonView thucDonView) {
        this.thucDonView = thucDonView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String monchinh = thucDonView.jComboBox_MonChinh.getSelectedItem().toString();

       String monphu = "";
       Object[] luachonmonphu = thucDonView.jList_monPhu.getSelectedValues();
        for (Object o:luachonmonphu) {
            monphu = monphu+o.toString()+"; ";
        }

        thucDonView.thucDonModel.setLuachon_MonChinh(monchinh);
        thucDonView.thucDonModel.setLuachon_MonPhu(monphu);
        thucDonView.thucDonModel.tinhtongtien();
        thucDonView.hienthiketqua();

        String soTien_chuoi = (String) JOptionPane.showInputDialog(
                thucDonView,
                thucDonView.jLabel_ThongTin.getText()
                +"\nNhập vào s tiền: ","Thông báo ",
                JOptionPane.PLAIN_MESSAGE);
        try{
            double sotien = Double.valueOf(soTien_chuoi);
            JOptionPane.showMessageDialog(thucDonView,
                    "Tiền thừa cần trả cho khách: "+(sotien-thucDonView.thucDonModel.getTongTien()),
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e1){
            JOptionPane.showMessageDialog(thucDonView,
                    "Nhập dữ liệu sai",
                            "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
