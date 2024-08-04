package btvn.Thongtincanhan;

import java.util.Scanner;

public class ThongTinSinhVien {
    private String hoten;
    private String msv;
    private String lop;
    private String diaChiEmail;

    public ThongTinSinhVien(){};

    public ThongTinSinhVien(String hoten, String msv, String lop, String diachiemail){
        this.hoten=hoten;
        this.msv=msv;
        this.lop=lop;
        this.diaChiEmail=diachiemail;
    }

    public String getDiachiemail() {
        return diaChiEmail;
    }

    public void setDiachiemail(String diachiemail) {
        this.diaChiEmail = diachiemail;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        this.hoten=sc.nextLine();
        System.out.println("Nhap msv: ");
        this.msv=sc.nextLine();
        System.out.println("Nhap lop: ");
        this.lop=sc.nextLine();
        System.out.println("Nhap Gmail: ");
        this.diaChiEmail=sc.nextLine();
    }

    @Override
    public String toString() {
        return "ThongTinSinhVien{" +
                "hoten='" + hoten + '\'' +
                ", msv='" + msv + '\'' +
                ", lop='" + lop + '\'' +
                ", diaChiEmail='" + diaChiEmail + '\'' +
                '}';
    }
}
