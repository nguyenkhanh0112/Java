package BT_FileChar.Bai2;

import java.util.Scanner;

public class SinhVien {
    private String masv;
    private String hoten;
    private String ngaysinh;
    private double diemTB;

    public SinhVien() {
    }

    public SinhVien(String masv, String hoten, String ngaysinh, double diemTB) {
        this.masv = masv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diemTB = diemTB;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return  masv + hoten  + ngaysinh  + diemTB;
    }
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap masv: ");
        this.masv=sc.nextLine();
        System.out.println("nhap hoten: ");
        this.hoten =sc.nextLine();
        System.out.println("nhap ngay sinh: ");
        this.ngaysinh =sc.nextLine();
        System.out.println("nhap diem TB: ");
        this.diemTB = sc.nextDouble();

    }
}
