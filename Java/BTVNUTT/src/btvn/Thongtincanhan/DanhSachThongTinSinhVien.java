package btvn.Thongtincanhan;

import btvn.Qunalisv.DanhSachSinhVien;
import btvn.Qunalisv.SinhVien;

import java.util.ArrayList;

public class DanhSachThongTinSinhVien {
    private ArrayList<ThongTinSinhVien>danhSach;
    public DanhSachThongTinSinhVien(){
        this.danhSach = new ArrayList<ThongTinSinhVien>();
    }

    public DanhSachThongTinSinhVien(ArrayList<ThongTinSinhVien> danhSach) {
        this.danhSach = danhSach;
    }
    public void addSinhVien(ThongTinSinhVien sv){
        this.danhSach.add(sv);
    }
    public void inDanhSachSv(){
        System.out.println("Danh Sach Thong Tin cua Sinh Vien ");
        System.out.println("----------------------------------");
        for (ThongTinSinhVien sinhVien:danhSach) {
            System.out.println(sinhVien);
            System.out.println("9 bottles of beer on the wall, 9 bottles of beer. \n" +
                    "Take one down, pass it around, \n" +
                    "8 bottles of beer on the wall, 8 bottles of beer. \n" +
                    "Take one down, pass it around, \n" +
                    "... \n" +
                    "1 bottle of beer on the wall, 1 bottle of beer. \n" +
                    "Take one down, pass it around, \n" +
                    "No more bottles of beer on the wall.");

        }
    }
}
