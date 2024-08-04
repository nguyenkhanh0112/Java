package btvn.Qunalisv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien{
    private ArrayList<SinhVien> danhSach;
    public DanhSachSinhVien(){

        this.danhSach=new ArrayList<SinhVien>();
    }
    public DanhSachSinhVien(ArrayList<SinhVien>danhSach){

        this.danhSach=danhSach;
    }
    public void themSinhVien(SinhVien sv){
        this.danhSach.add(sv);
    }
    public void inDanhSachSinhVien(){
        System.out.println("------------ DANH SACH SINH VIEN -----------");
        for (SinhVien sinhvien: danhSach) {
            System.out.println(sinhvien);
        }
    }

    public boolean kiemTraDanhSachRong(){
        return this.danhSach.isEmpty();
    }
    public int laySoLuongSinhVien(){
        return danhSach.size();
    }
    public void lamRongDanhSach(){
        this.danhSach.removeAll(danhSach);
    }
    public boolean kiemTraTonTai(SinhVien sv){
        return this.danhSach.contains(sv);
    }
    public boolean xoaSinhVien(SinhVien sv){
        return this.danhSach.remove(sv);
    }
    public void timSinhVien(String ten){
        for (SinhVien sinhvien:danhSach) {
            if(sinhvien.getHoVaten().indexOf(ten)>=0){
                System.out.println(sinhvien);
            }
        }
    }
    public void sapXepSinhVienGiamGian(){
        Collections.sort(this.danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                if(sv1.getDiemTB()>sv2.getDiemTB())
                    return -1;
                else if(sv1.getDiemTB()<sv2.getDiemTB())
                    return 1;
                else
                    return 0;
            }
        });
    }

}
