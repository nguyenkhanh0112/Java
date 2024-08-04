package btvn.lab7.cau2;

public class ThiSinhKhoiB extends ThiSinh{
    private float Toan;
    private float Hoa;
    private float Sinh;

    public ThiSinhKhoiB(String SBD, String hoTen, String diaChi, String uuTien, float toan, float hoa, float sinh) {
        super(SBD, hoTen, diaChi, uuTien);
        Toan = toan;
        Hoa = hoa;
        Sinh = sinh;
    }
    public ThiSinhKhoiB(){

    }

    public float getToan() {
        return Toan;
    }

    public void setToan(float toan) {
        Toan = toan;
    }

    public float getHoa() {
        return Hoa;
    }

    public void setHoa(float hoa) {
        Hoa = hoa;
    }

    public float getSinh() {
        return Sinh;
    }

    public void setSinh(float sinh) {
        Sinh = sinh;
    }
    public void nhapThongTin(){
        super.nhapThongTin();
        System.out.println("Nhập điểm Toán: ");
        this.Toan  = sc.nextFloat();
        System.out.println("Nhập điểm Hóa: ");
        this.Hoa = sc.nextFloat();
        System.out.println("Nhập điểm Sinh: ");
        this.Sinh   = sc.nextFloat();
    }

    @Override
    public String toString() {
        return "ThiSinhKhoiB{"+super.toString() +
                "Toan=" + Toan +
                ", Hoa=" + Hoa +
                ", Sinh=" + Sinh +
                '}';
    }
}
