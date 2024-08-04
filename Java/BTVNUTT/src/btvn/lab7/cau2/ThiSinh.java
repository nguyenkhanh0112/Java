package btvn.lab7.cau2;

import java.util.Scanner;

/*
Các thí sinh dự thi đại học bao gồm các thí sinh thi khối A, thí sinh thi
khối B, thí sinh thi khối C
+ Các thí sinh cần quản lý các thuộc tính: Số báo danh, họ tên, địa chỉ,
ưu tiên.
+ Thí sinh thi khối A thi các môn: Toán, lý, hoá
+ Thí sinh thi khối B thi các môn: Toán, Hoá, Sinh
+ Thí sinh thi khối C thi các môn: văn, Sử, Địa
1. Xây dựng các lớp để quản lý các thí sinh sao cho sử dụng lại được
nhiều nhất.
2. Xây dựng lớp TuyenSinh cài đặt các phương thức thực hiện các
nhiệm vụ sau:
- Nhập thông tin về các thí sinh dự thi
- Hiển thị thông tin về một thí sinh
- Tìm kiếm theo số báo danh
- Kết thúc chương trình.
 */
public class ThiSinh {
    Scanner sc = new Scanner(System.in);
    private String SBD;
    private String hoTen;
    private String diaChi;
    private String uuTien;
    public ThiSinh(){}
    public ThiSinh(String SBD, String hoTen, String diaChi, String uuTien) {
        this.SBD = SBD;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.uuTien = uuTien;
    }
    public String getSBD() {
        return SBD;
    }
    public void setSBD(String SBD) {
        this.SBD = SBD;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getUuTien() {
        return uuTien;
    }
    public void setUuTien(String uuTien) {
        this.uuTien = uuTien;
    }
    public void nhapThongTin(){
        System.out.println("Nhập số báo danh: ");
        this.SBD = sc.nextLine();
        System.out.println("Nhập họ tên: ");
        this.hoTen=sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.diaChi = sc.nextLine();
        System.out.println("Nhập ưu tiên: ");
        this.uuTien=sc.nextLine();
    }
    @Override
    public String toString() {
        return "SBD='" + SBD + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", uuTien='" + uuTien + '\'' +
                ",";
    }
}
