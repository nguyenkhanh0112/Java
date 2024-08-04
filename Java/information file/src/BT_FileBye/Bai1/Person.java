package BT_FileBye.Bai1;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private String gioiTinh;

    public Person(String hoTen, String ngaySinh, String diaChi, String gioiTinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }
    public Person(){}


    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }
    public void nhapThongTin(){
        System.out.println("Nhâp họ tên: ");
        this.hoTen= new Scanner(System.in).nextLine();
        System.out.println("Nhập ngày sinh: ");
        this.ngaySinh = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.diaChi = new Scanner(System.in).nextLine();
        System.out.println("Nhập giới tính: ");
        this.gioiTinh=new Scanner(System.in).nextLine();
    }
}
