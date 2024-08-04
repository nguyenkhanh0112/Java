package JavaSwing.BTVN.Bai12;

public class Staff {
    private String manv;
    private String hoten;
    private String phai;
    private int tuoi;

    public Staff(){

    }
    public Staff(String manv, String hoten, String phai, int tuoi) {
        this.manv = manv;
        this.hoten = hoten;
        this.phai = phai;
        this.tuoi = tuoi;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return  hoten;
    }
}
