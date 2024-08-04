package dtos;

public class GiangVien {
    private String maGV;
    private String maKhoa;
    private String ho;
    private String ten;
    private String hocHam;

     
    public GiangVien() {
    }

    public GiangVien(String maGV, String maKhoa, String ho, String ten, String hocHam) {
        this.maGV = maGV;
        this.maKhoa = maKhoa;
        this.ho = ho;
        this.ten = ten;
        this.hocHam = hocHam;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
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

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }
}

