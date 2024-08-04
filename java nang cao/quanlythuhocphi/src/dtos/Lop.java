package dtos;

public class Lop {
    private String maLop;
    private String maCN;

    public Lop() {
    }

    public Lop(String maLop, String maCN) {
        this.maLop = maLop;
        this.maCN = maCN;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }
}

