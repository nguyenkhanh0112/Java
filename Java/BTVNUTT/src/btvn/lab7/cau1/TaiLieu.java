package btvn.lab7.cau1;

import java.util.Scanner;

public class TaiLieu {
    Scanner sc = new Scanner(System.in);
    private String maTaiLieu;
    private String tenNhaSX;
    private int soBanPhatHanh;

    public TaiLieu(String maTaiLieu, String tenNhaSX, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.tenNhaSX = tenNhaSX;
        this.soBanPhatHanh = soBanPhatHanh;
    }
    public TaiLieu(){

    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenNhaSX() {
        return tenNhaSX;
    }

    public void setTenNhaSX(String tenNhaSX) {
        this.tenNhaSX = tenNhaSX;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public void nhapThongTin(){
        System.out.print("Nhap Ma Tai Lieu: ");
        this.maTaiLieu=sc.nextLine();
        System.out.print("Nhap Ten Nha SX: ");
        this.tenNhaSX=sc.nextLine();
        System.out.print("Nhap Số Bản Phát Hành: ");
        this.soBanPhatHanh=sc.nextInt();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "maTaiLieu='" + maTaiLieu + '\'' +
                ", tenNhaSX='" + tenNhaSX + '\'' +
                ", soBanPhatHanh=" + soBanPhatHanh +"',";
    }
}
