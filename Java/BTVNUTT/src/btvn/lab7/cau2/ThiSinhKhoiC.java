package btvn.lab7.cau2;

public class ThiSinhKhoiC extends ThiSinh{
    private float Van;
    private float Su;
    private float  Dia;

    public ThiSinhKhoiC() {
    }
    public ThiSinhKhoiC(String SBD, String hoTen, String diaChi, String uuTien, float van, float su, float dia) {
        super(SBD, hoTen, diaChi, uuTien);
        Van = van;
        Su = su;
        Dia = dia;
    }
    public float getVan() {
        return Van;
    }

    public void setVan(float van) {
        Van = van;
    }

    public float getSu() {
        return Su;
    }

    public void setSu(float su) {
        Su = su;
    }

    public float getDia() {
        return Dia;
    }

    public void setDia(float dia) {
        Dia = dia;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.println("Nhập điểm Văn: ");
        this.Van = sc.nextFloat();
        System.out.println("Nhập điểm Sử: ");
        this.Su = sc.nextFloat();
        System.out.println("Nhập điểm Địa: ");
        this.Dia = sc.nextFloat();
    }

    @Override
    public String toString() {
        return "ThiSinhKhoiC{"+ super.toString() +
                "Van=" + Van +
                ", Su=" + Su +
                ", Dia=" + Dia +
                '}';
    }
}
