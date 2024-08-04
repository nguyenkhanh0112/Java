package dtos;

public class CTDangKy {
    private int maCTDK;
    private int maLHP;
    private int maDK;

    public CTDangKy() {
    }

    public CTDangKy(int maCTDK, int maLHP, int maDK) {
        this.maCTDK = maCTDK;
        this.maLHP = maLHP;
        this.maDK = maDK;
    }

    public int getMaCTDK() {
        return maCTDK;
    }

    public void setMaCTDK(int maCTDK) {
        this.maCTDK = maCTDK;
    }

    public int getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(int maLHP) {
        this.maLHP = maLHP;
    }

    public int getMaDK() {
        return maDK;
    }

    public void setMaDK(int maDK) {
        this.maDK = maDK;
    }
}

