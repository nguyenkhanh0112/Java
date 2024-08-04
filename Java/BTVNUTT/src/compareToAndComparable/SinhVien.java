package compareToAndComparable;

public class SinhVien implements Comparable<SinhVien>{
    private int maSinhVien;
    private String hoVaTen;
    private String tenLop;
    private double diemTrungBinh;
    public SinhVien(int maSinhVien,String hoVaTen,String tenLop,double diemTrungBinh){
        this.diemTrungBinh=diemTrungBinh;
        this.maSinhVien=maSinhVien;
        this.hoVaTen=hoVaTen;
        this.tenLop=tenLop;
    }

    @Override
    public int compareTo(SinhVien o) {
        //<0
        //=0
        //>0
        return this.maSinhVien-o.maSinhVien;
    }
}