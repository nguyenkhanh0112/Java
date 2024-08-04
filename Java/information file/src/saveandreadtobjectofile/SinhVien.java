package saveandreadtobjectofile;



import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class SinhVien implements Comparable<SinhVien>, Serializable {
    private String maSinhVien;
    private String hoVaten;
    private float diemTB;
    private int namSinh;

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getHoVaten() {
        return hoVaten;
    }

    public void setHoVaten(String hoVaten) {
        this.hoVaten = hoVaten;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }


    public SinhVien(){};

    public SinhVien(String maSinhVien, String hoVaten, float diemTB, int namSinh) {
        this.maSinhVien = maSinhVien;
        this.hoVaten = hoVaten;
        this.diemTB = diemTB;
        this.namSinh = namSinh;
    }

    public SinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinhVien sinhVien)) return false;
        return Objects.equals(maSinhVien, sinhVien.maSinhVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSinhVien);
    }

    public void nhapSinhVien(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap ma Sinh vien: ");
        maSinhVien=sc.nextLine();
        System.out.println("Nhap ho va ten: ");
        hoVaten=sc.nextLine();
        System.out.println("Nhap nam Sinh: ");
        namSinh=sc.nextInt();
        System.out.println("Nhap diem Tb: ");
        diemTB=sc.nextFloat();
    }
    @Override
    public String toString() {
        return "SinhVien{" + "maSinhVien='" + maSinhVien + '\'' + ", hoVaten='" + hoVaten + '\'' + ", diemTB=" + diemTB + ", namSinh=" + namSinh + '}';
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.maSinhVien.compareTo(o.maSinhVien);
    }

}
