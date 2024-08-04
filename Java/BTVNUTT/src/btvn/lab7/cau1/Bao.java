package btvn.lab7.cau1;

public class Bao extends TaiLieu{
    private int ngayPhatHanh;

    public Bao(String maTaiLieu, String tenNhaSX, int soBanPhatHanh, int ngayPhatHanh) {
        super(maTaiLieu, tenNhaSX, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }
    public Bao(){}
    public int getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(int ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }
    public void nhapThongTin(){
        super.nhapThongTin();
        do{
            System.out.print("Nhập Ngày Phát Hành (>1 && <31): ");
            this.ngayPhatHanh = sc.nextInt();
        }while (this.ngayPhatHanh<1 || ngayPhatHanh >31);
    }

    @Override
    public String toString() {
        return "Bao{" + super.toString() +
                "ngayPhatHanh=" + ngayPhatHanh +
                '}';
    }
}
