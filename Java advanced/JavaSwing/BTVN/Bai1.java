package JavaSwing.BTVN;

import javax.swing.*;

public class Bai1 extends JFrame {
    public Bai1(){
        init();
    }
    public void init(){
    }
    public void addControl(){
        String input1 = JOptionPane.showInputDialog("Nhập số nguyên thứ nhất: ");
        int sothunhat = Integer.parseInt(input1);
        String input2 = JOptionPane.showInputDialog("Nhập số nguyên thứ hai: ");
        int sothuhai = Integer.parseInt(input2);

        if(sothunhat<sothuhai){
            int ramdomnumber = (int) ((Math.random()*((sothuhai-sothunhat)+1))+sothunhat);
            JOptionPane.showMessageDialog(null,"số ngẫu nhiên trong miền giá trị là: "+ramdomnumber);
        }else if(sothuhai<=sothunhat){
            JOptionPane.showMessageDialog(null,"Lỗi: Số thứ hai nhỏ hơn số thứ nhất.");
            input1=JOptionPane.showInputDialog("Nhập lại số nguyên thứ nhất: ");
            int sothunhat1 = Integer.parseInt(input1);
            int ramdomnumber = (int) ((Math.random()*((sothuhai-sothunhat1)+1))+sothunhat1);
            JOptionPane.showMessageDialog(null,"số ngẫu nhiên trong miền giá trị là: "+ramdomnumber);
        }

    }

    public static void main(String[] args) {
        Bai1 bai1= new Bai1();
        bai1.addControl();
    }
}
