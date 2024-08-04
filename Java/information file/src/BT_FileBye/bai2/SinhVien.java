package BT_FileBye.bai2;

import java.io.Serializable;
import java.util.Scanner;

public class SinhVien implements Serializable {
    private String maSV;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private double DTB;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, String ngaySinh, String gioiTinh, double DTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.DTB = DTB;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDTB() {
        return DTB;
    }

    public void setDTB(double DTB) {
        this.DTB = DTB;
    }
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        this.maSV = sc.nextLine();
        System.out.println("Nhập họ tên: ");
        this.hoTen = sc.nextLine();
        System.out.println("nhập ngày sinh: ");
        this.ngaySinh = sc.nextLine();;
        System.out.println("Nhập giới tính: ");
        this.gioiTinh = sc.nextLine();
        System.out.println("Nhập dtb: ");
        this.DTB =sc.nextDouble();
    }
    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", DTB=" + DTB +
                '}';
    }
}
