package dtos;

public class LopHocPhan {
    private int maLHP;
    private String nienKhoa;
    private int hocKy;
    private String maMH;
    private String maGV;
    private String maCN;
    private boolean huyLop;

    public LopHocPhan() {
    }

    public int getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(int maLHP) {
        this.maLHP = maLHP;
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

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public boolean isHuyLop() {
        return huyLop;
    }

    public void setHuyLop(boolean huyLop) {
        this.huyLop = huyLop;
    }
}

