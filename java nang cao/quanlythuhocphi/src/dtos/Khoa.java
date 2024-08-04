package dtos;

public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private float donGia;

    public Khoa() {
    }

    public Khoa(String maKhoa, String tenKhoa, float donGia) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.donGia = donGia;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
}

