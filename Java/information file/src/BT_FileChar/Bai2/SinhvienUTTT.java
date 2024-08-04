package BT_FileChar.Bai2;

import java.util.Scanner;

public class SinhvienUTTT extends SinhVien{
    private String donvi;
    private Double luong;

    public SinhvienUTTT() {
    }


    public SinhvienUTTT(String masv, String hoten, String ngaysinh, double diemTB, String donvi, Double luong) {
        super(masv, hoten, ngaysinh, diemTB);
        this.donvi = donvi;
        this.luong = luong;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public Double getLuong() {
        return luong;
    }
    public void nhapThongTin(){
        super.nhapThongTin();
        System.out.println("nhap don vi: ");
        this.donvi =new Scanner(System.in).nextLine();
        System.out.println("nhap luong: ");
        this.luong= new Scanner(System.in).nextDouble();
    }
    public void setLuong(Double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return  super.toString()+ donvi + luong;
    }
}
