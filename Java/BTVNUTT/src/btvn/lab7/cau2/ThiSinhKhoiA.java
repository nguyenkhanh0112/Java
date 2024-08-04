package btvn.lab7.cau2;

public class ThiSinhKhoiA extends ThiSinh {
    private float Toan;
    private float Ly;
    private float Hoa;

    public ThiSinhKhoiA(String SBD, String hoTen, String diaChi, String uuTien, float toan, float ly, float hoa) {
        super(SBD, hoTen, diaChi, uuTien);
        Toan = toan;
        Ly = ly;
        Hoa = hoa;
    }
    public ThiSinhKhoiA(){}

    public float getToan() {
        return Toan;
    }

    public void setToan(float toan) {
        Toan = toan;
    }

    public float getLy() {
        return Ly;
    }

    public void setLy(float ly) {
        Ly = ly;
    }

    public float getHoa() {
        return Hoa;
    }

    public void setHoa(float hoa) {
        Hoa = hoa;
    }
    public void nhapThongTin(){
        super.nhapThongTin();
        System.out.println("Nhập điểm toán: ");
        this.Toan = sc.nextFloat();
        System.out.println("Nhập điểm Lý: ");
        this.Ly=sc.nextFloat();
        System.out.println("Nhập điểm Hóa: ");
        this.Hoa=sc.nextFloat();
    }

    @Override
    public String toString() {
        return "ThiSinhKhoiA{" + super.toString() +
                "Toan=" + Toan +
                ", Ly=" + Ly +
                ", Hoa=" + Hoa +
                '}';
    }
}
