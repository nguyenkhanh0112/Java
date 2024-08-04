package JavaSwing.BTVN.Bai8;

public class student {
    private String Masv;
    private String Hovaten;
    private int Tuoi;

    public student(){

    }
    public student(String masv, String hovaten, int tuoi) {
        Masv = masv;
        Hovaten = hovaten;
        Tuoi = tuoi;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String masv) {
        Masv = masv;
    }

    public String getHovaten() {
        return Hovaten;
    }

    public void setHovaten(String hovaten) {
        Hovaten = hovaten;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }

    @Override
    public String toString() {
        return Hovaten;
    }
}
