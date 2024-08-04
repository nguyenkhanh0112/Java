package dtos;

public class PhieuThu {
    private int maPT;
    private String maSV;
    private String nienKhoa;
    private int hocKy;

    public PhieuThu() {
    }

    public PhieuThu(int maPT, String maSV, String nienKhoa, int hocKy) {
        this.maPT = maPT;
        this.maSV = maSV;
        this.nienKhoa = nienKhoa;
        this.hocKy = hocKy;
    }

    public int getMaPT() {
        return maPT;
    }

    public void setMaPT(int maPT) {
        this.maPT = maPT;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }
}

