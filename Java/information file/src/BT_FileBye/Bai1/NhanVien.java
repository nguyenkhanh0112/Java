package BT_FileBye.Bai1;

import java.util.Scanner;

public class NhanVien extends Person {
    private String phongBan;
    private double heSoluong;
    private double luongCoBan;
    private int thamNiem;
    public NhanVien(){}

    public double luongThucLinh(){
        return (this.luongCoBan*this.heSoluong*(1+(double)this.thamNiem/100));
    }

    public NhanVien(String hoTen, String ngaySinh, String diaChi, String gioiTinh, String phongBan, double heSoluong, double luongCoBan, int thamNiem) {
        super(hoTen, ngaySinh, diaChi, gioiTinh);
        this.phongBan = phongBan;
        this.heSoluong = heSoluong;
        this.luongCoBan = luongCoBan;
        this.thamNiem = thamNiem;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public double getHeSoluong() {
        return heSoluong;
    }

    public void setHeSoluong(double heSoluong) {
        this.heSoluong = heSoluong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public int getThamNiem() {
        return thamNiem;
    }

    public void setThamNiem(int thamNiem) {
        this.thamNiem = thamNiem;
    }

    @Override
    public String toString() {
        return "NhanVien{" + super.toString() +
                "phongBan='" + phongBan + '\'' +
                ", heSoluong=" + heSoluong +
                ", luongCoBan=" + luongCoBan +
                ", thamNiem=" + thamNiem +
                '}';
    }
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        super.nhapThongTin();
        System.out.println("Nhập phòng ban: ");
        this.phongBan = sc.nextLine();
        System.out.println("Nhập hệ số lương: ");
        this.heSoluong = sc.nextDouble();
        System.out.println("Nhập lương cơ bản: ");
        this.luongCoBan =sc.nextDouble();
        System.out.println("Nhập thâm niêm: ");
        this.thamNiem = sc.nextInt();

    }

}
