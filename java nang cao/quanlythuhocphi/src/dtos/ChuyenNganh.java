package dtos;

public class ChuyenNganh {
    private String maCN;
    private String tenCN;
    private String maKhoa;

    public ChuyenNganh() {
    }

    public ChuyenNganh(String maCN, String tenCN, String maKhoa) {
        this.maCN = maCN;
        this.tenCN = tenCN;
        this.maKhoa = maKhoa;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getTenCN() {
        return tenCN;
    }

    public void setTenCN(String tenCN) {
        this.tenCN = tenCN;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
}

