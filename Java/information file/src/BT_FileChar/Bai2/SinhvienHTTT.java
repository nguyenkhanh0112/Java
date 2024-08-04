package BT_FileChar.Bai2;

import java.util.Scanner;

public class SinhvienHTTT extends SinhVien {
    private Double hocphi;

    public SinhvienHTTT(String masv, String hoten, String ngaysinh, double diemTB, Double hocphi) {
        super(masv, hoten, ngaysinh, diemTB);
        this.hocphi = hocphi;
    }
    public SinhvienHTTT(){


    }
    public void nhapThongTin(){
        super.nhapThongTin();
        System.out.println("nhap hoc phi: ");
        this.hocphi = new Scanner(System.in).nextDouble();
    }
    @Override
    public String toString() {
        return super.toString() + hocphi;
    }
}
