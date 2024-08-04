package dtos;

public class SinhVien {
    private String maSV;
    private String ho;
    private String ten;
    private String maLop;
    private boolean phai;
    private String ngaySinh;
    private String diaChi;
    private boolean dangNghiHoc;
    private String tenTaiKhoan;

    public SinhVien() {
    }

    public SinhVien(String maSV, String ho, String ten, String maLop, boolean phai, String ngaySinh, String diaChi, boolean dangNghiHoc, String tenTaiKhoan) {
        this.maSV = maSV;
        this.ho = ho;
        this.ten = ten;
        this.maLop = maLop;
        this.phai = phai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.dangNghiHoc = dangNghiHoc;
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public boolean isPhai() {
        return phai;
    }

    public void setPhai(boolean phai) {
        this.phai = phai;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isDangNghiHoc() {
        return dangNghiHoc;
    }

    public void setDangNghiHoc(boolean dangNghiHoc) {
        this.dangNghiHoc = dangNghiHoc;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }
}

