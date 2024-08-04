package btvn.lap08.KhanhSan;

import java.util.ArrayList;
import java.util.Scanner;

public class KhachTro {
    private int soNgayTro;
    private String loaiPhongTro;
    private int GiaPhong;
    private ArrayList<CaNhan> listCaNhan = new ArrayList<CaNhan>();

    public KhachTro(){

    }

    public int getSoNgayTro() {
        return soNgayTro;
    }
    public void setSoNgayTro(int soNgayTro) {
        this.soNgayTro = soNgayTro;
    }
    public String getLoaiPhongTro() {
        return loaiPhongTro;
    }
    public void setLoaiPhongTro(String loaiPhongTro) {
        this.loaiPhongTro = loaiPhongTro;
    }
    public int getGiaPhong() {
        return GiaPhong;
    }
    public void setGiaPhong(int giaPhong) {
        GiaPhong = giaPhong;
    }
    public ArrayList<CaNhan> getListCaNhan() {
        return listCaNhan;
    }
    public void setListCaNhan(ArrayList<CaNhan> listCaNhan) {
        this.listCaNhan = listCaNhan;
    }
    public void NhapThongtin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Số ngày trọ: ");
        this.soNgayTro =sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập loại phòng trọ: ");
        this.loaiPhongTro=sc.nextLine();
        System.out.println("Nhập Giá Phòng: ");
        this.GiaPhong=sc.nextInt();
        System.out.println("Nhập số lượng Cá nhân trọ trong 1 phòng : ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Nhập thông tin của cá nhân thứ "+(i+1));
            CaNhan caNhan = new CaNhan();
            caNhan.NhapThongTin();
            listCaNhan.add(caNhan);
        }
    }

    @Override
    public String toString() {
        return "KhachTro{" +
                "soNgayTro=" + soNgayTro +
                ", loaiPhongTro='" + loaiPhongTro + '\'' +
                ", GiaPhong=" + GiaPhong +
                ", listCaNhan=" + listCaNhan +
                '}';
    }

    public void xuatThongTin(){
        System.out.println("Số ngày trọ: "+soNgayTro);
        System.out.println("Loại phòng trọ: "+loaiPhongTro);
        System.out.println("Giá Phòng: "+GiaPhong);
        System.out.println("Thông tin các cá nhân trong phòng trọ: ");
        for (CaNhan caNhan:listCaNhan) {
            System.out.println(caNhan);
        }

    }
}
