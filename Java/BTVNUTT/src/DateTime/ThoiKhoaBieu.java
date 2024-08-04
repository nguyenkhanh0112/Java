package DateTime;

public class ThoiKhoaBieu {
    private Day thu;
    private String cacMonHoc;
    public ThoiKhoaBieu(Day thu,String cacMonHoc){
        this.thu=thu;
        this.cacMonHoc=cacMonHoc;
    }
    public ThoiKhoaBieu(){};
    public Day getThu() {
        return thu;
    }

    public void setThu(Day thu) {
        this.thu = thu;
    }

    public void setCacMonHoc(String cacMonHoc) {
        this.cacMonHoc = cacMonHoc;
    }

    public String getCacMonHoc() {
        return cacMonHoc;
    }

    @Override
    public String toString() {
         return "Thoi Khoa Bieu [thu = " + thu + ",cacMonhoc = "+cacMonHoc+" ]";
    }
}
