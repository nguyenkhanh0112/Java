package saveandreadtobjectofile;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien implements  Serializable{
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
    public void ghiDuLieuXuongFile(File file){
        try{
            OutputStream  os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (SinhVien sinhVien:danhSach) {
                oos.writeObject(sinhVien);
            }
            oos.flush();
            oos.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void docDuLieuTuFile(File file){
        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois =new ObjectInputStream(is);
            SinhVien sv=null;
            while(true){
                sv=(SinhVien)ois.readObject();
                if(sv!=null){
                    this.danhSach.add(sv);
                }
                if(sv==null)
                    break;
            }
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
