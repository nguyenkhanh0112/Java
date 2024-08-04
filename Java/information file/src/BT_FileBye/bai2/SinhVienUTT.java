package BT_FileBye.bai2;

import BT_FileBye.Bai1.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienUTT extends SinhVien{
    private String donVi;
    private double luong;

    public SinhVienUTT() {
    }

    public SinhVienUTT(String maSV, String hoTen, String ngaySinh, String gioiTinh, double DTB, String donVi, double luong) {
        super(maSV, hoTen, ngaySinh, gioiTinh, DTB);
        this.donVi = donVi;
        this.luong = luong;
    }
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        super.nhapThongTin();
        System.out.println("Nhập đơn vị: ");
        this.donVi=sc.nextLine();
        System.out.println("Nhập lương: ");
        this.luong = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "SinhVienUTT{" + super.toString() +
                "donVi='" + donVi + '\'' +
                ", luong=" + luong +
                '}';
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    public void nhapDuLieu(){
        try{
            OutputStream outputStream = new FileOutputStream("svutt.obj");
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            System.out.println("Nhập số lượng sinh viên UTT: ");
            int n  = new Scanner(System.in).nextInt();
            for(int i=0;i<n;i++){
                System.out.println("Nhập thông tin sinh viên UTT thứ: "+(i+1));
                System.out.println("-------------------------------");
                SinhVienUTT nv = new SinhVienUTT();
                nv.nhapThongTin();
                oos.writeObject(nv);
            }
            oos.flush();
            oos.close();
            outputStream.close();
        }catch (Exception e){

        }
    }
    public ArrayList<SinhVienUTT> docDuLieu(){
        ArrayList<SinhVienUTT> arrayList = new ArrayList<>();
        try{
            InputStream inputStream = new FileInputStream("svutt.obj");
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Object o=null;
            SinhVienUTT sinhVienUTT=null;
            while ((o=ois.readObject())!=null){
                sinhVienUTT = (SinhVienUTT) o;
                arrayList.add(sinhVienUTT);
            }
        }catch (Exception e){

        }
        return  arrayList;
    }
}
