package dtos;

import java.util.Date;

public class CTPhieuThu {
    private int MACTPT;
    private int MAPT;
    private Date NgayDong;
    private float SoTienDong;

    public CTPhieuThu(int MACTPT, int MAPT, Date NgayDong, float SoTienDong) {
        this.MACTPT = MACTPT;
        this.MAPT = MAPT;
        this.NgayDong = NgayDong;
        this.SoTienDong = SoTienDong;
    }

    public int getMACTPT() {
        return MACTPT;
    }

    public void setMACTPT(int MACTPT) {
        this.MACTPT = MACTPT;
    }

    public int getMAPT() {
        return MAPT;
    }

    public void setMAPT(int MAPT) {
        this.MAPT = MAPT;
    }

    public Date getNgayDong() {
        return NgayDong;
    }

    public void setNgayDong(Date NgayDong) {
        this.NgayDong = NgayDong;
    }

    public float getSoTienDong() {
        return SoTienDong;
    }

    public void setSoTienDong(float SoTienDong) {
        this.SoTienDong = SoTienDong;
    }
}
