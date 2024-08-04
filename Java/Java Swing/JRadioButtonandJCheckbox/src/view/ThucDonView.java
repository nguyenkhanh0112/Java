package view;

import controller.ThucDonController;
import model.ThucDonModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ThucDonView extends JFrame {
    public ThucDonModel thucDonModel;

    public JLabel jLabel_ThongTin;
    public ArrayList<JCheckBox> list_buttonGroup_monphu;
    public JComboBox<String> jComboBox_MonChinh;
    public JList<String> jList_monPhu;

    public ThucDonView() {
        this.thucDonModel = new ThucDonModel();
        init();
    }
    private void init(){
        this.setTitle("Thực Đơn");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        Font font = new Font("Time New Roman",Font.BOLD,20);

        JLabel jLabel_header = new JLabel("THỰC ĐƠN NHÀ HÀNG NGUYỄN VĂN KHÁNH");

        JPanel jPanel_TieuDe = new JPanel();
        jPanel_TieuDe.add(jLabel_header);
        this.add(jPanel_TieuDe,BorderLayout.NORTH);//NORTH phía bắc


        JPanel jPanel_MonChinh = new JPanel();
        jPanel_MonChinh.setBackground(Color.GREEN);
       // jPanel_MonChinh.setSize(100,100);
        jPanel_MonChinh.setLayout(new FlowLayout());
        String[] CacmonChinh = new String[]{"Cơm","Phở","Bánh Mì"};
        jComboBox_MonChinh = new JComboBox<String>(CacmonChinh);

        jPanel_MonChinh.add(jComboBox_MonChinh);





        JPanel jPanel_MonPhu = new JPanel();
        jPanel_MonChinh.setBackground(Color.YELLOW);
        jPanel_MonPhu.setLayout(new GridLayout(2,4));
         String[] Cacmonphu = new String[]{"Trà sữa","Bánh Ngọt","cocacola","Nem","sữa","Trà hoa quả","Xúc xíc","Kem"};
          jList_monPhu = new JList<String>(Cacmonphu);
        jPanel_MonPhu.add(jList_monPhu);
         list_buttonGroup_monphu = new ArrayList<JCheckBox>();

        JPanel jPanel_luachon= new JPanel();
        jPanel_luachon.setLayout(new BorderLayout());
        jPanel_luachon.add(jPanel_MonChinh,BorderLayout.NORTH);
        jPanel_luachon.add(jPanel_MonPhu,BorderLayout.CENTER);
        this.add(jPanel_luachon,BorderLayout.CENTER);



        JPanel jPanel_ThanhToan = new JPanel();
        jPanel_ThanhToan.setLayout(new GridLayout(1,2));
         jLabel_ThongTin = new JLabel();
        jLabel_ThongTin.setForeground(Color.RED);
        JButton jButton_ThanhToan = new JButton("Thanh Toan");
        ActionListener thucDonController = new ThucDonController(this);
        jButton_ThanhToan.addActionListener(thucDonController);

        jPanel_ThanhToan.add(jLabel_ThongTin);
        jPanel_ThanhToan.add(jButton_ThanhToan);
        this.add(jPanel_ThanhToan,BorderLayout.SOUTH);//SOUTH phía nam


        this.setVisible(true);


    }

    public void hienthiketqua() {
        String Kq ="Món Chính : "+ this.thucDonModel.getLuachon_MonChinh()+
                    " Món Phụ : "+this.thucDonModel.getLuachon_MonPhu()+
                    " Tổng Tiền : "+this.thucDonModel.getTongTien();
        this.jLabel_ThongTin.setText(Kq);
    }
}
