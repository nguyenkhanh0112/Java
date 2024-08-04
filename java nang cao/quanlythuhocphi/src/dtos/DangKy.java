package dtos;

public class DangKy {
    private int MADK;
    private int HocKy;
    private String MASV;

    public DangKy(int MADK, int HocKy, String MASV) {
        this.MADK = MADK;
        this.HocKy = HocKy;
        this.MASV = MASV;
    }

    public int getMADK() {
        return MADK;
    }
    public void setMADK(int MADK) {
        this.MADK = MADK;
    }

    public int getHocKy() {
        return HocKy;
    }
    public void setHocKy(int HocKy) {
        this.HocKy = HocKy;
    }

    public String getMASV() {
        return MASV;
    }
    public void setMASV(String MASV) {
        this.MASV = MASV;
    }
}

