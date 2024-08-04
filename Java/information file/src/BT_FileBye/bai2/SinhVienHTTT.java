package BT_FileBye.bai2;

import BT_FileBye.Bai1.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienHTTT extends SinhVien{
    private int hocPhi;

    public SinhVienHTTT(String maSV, String hoTen, String ngaySinh, String gioiTinh, double DTB, int hocPhi) {
        super(maSV, hoTen, ngaySinh, gioiTinh, DTB);
        this.hocPhi = hocPhi;
    }

    public SinhVienHTTT() {
    }

    @Override
    public String toString() {
        return "SinhVienHTTT{" + super.toString() +
                "hocPhi=" + hocPhi +
                '}';
    }
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        super.nhapThongTin();
        System.out.println("Nhập học phí: ");
        this.hocPhi = sc.nextInt();
    }
    public void nhapDuLieu(){
        try{
            OutputStream outputStream = new FileOutputStream("svhttt.obbj");
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            System.out.println("Nhập số lượng sinh viên HTTT: ");
            int n  = new Scanner(System.in).nextInt();
            for(int i=0;i<n;i++){
                System.out.println("Nhập thông tin sinh viên HTTT thứ: "+(i+1));
                System.out.println("-------------------------------");
                SinhVienHTTT nv = new SinhVienHTTT();
                nv.nhapThongTin();
                oos.writeObject(nv);
            }
            oos.flush();
            oos.close();
            outputStream.close();
        }catch (Exception e){

        }
    }
    public ArrayList<SinhVienHTTT> docDuLieu(){
        ArrayList<SinhVienHTTT> arrayList = new ArrayList<>();
        try{
            InputStream inputStream = new FileInputStream("svhttt.obbj");
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Object o = null;
            SinhVienHTTT sinhVienHTTT=null;
            while ((o=ois.readObject())!=null){
                sinhVienHTTT = (SinhVienHTTT) o;
                arrayList.add(sinhVienHTTT);
            }
        }catch (Exception e){

        }
        return  arrayList;
    }
}
