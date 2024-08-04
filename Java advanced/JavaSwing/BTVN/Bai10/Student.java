package JavaSwing.BTVN.Bai10;

public class Student {
    private String msv;
    private String hoten;
    private int tuoi;
    public Student(){

    }

    public Student(String msv, String hoten, int tuoi) {
        this.msv = msv;
        this.hoten = hoten;
        this.tuoi = tuoi;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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
