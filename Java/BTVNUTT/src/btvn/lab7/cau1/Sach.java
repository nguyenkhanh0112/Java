package btvn.lab7.cau1;

public class Sach extends TaiLieu{
    private String tenTacGia;
    private int soTrang;
    public Sach(){}
    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public Sach(String maTaiLieu, String tenNhaSX, int soBanPhatHanh, String tenTacGia, int soTrang) {
        super(maTaiLieu, tenNhaSX, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }
    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
    public void nhapThongTin(){
        super.nhapThongTin();
        System.out.print("Nhập Tên Tác Giả: ");
        this.tenTacGia = sc.nextLine();
        System.out.print("Nhập số trang: ");
        this.soTrang = sc.nextInt();
    }

    @Override
    public String toString() {
        return "Sach{" + super.toString() +
                "tenTacGia='" + tenTacGia + '\'' +
                ", soTrang=" + soTrang +
                '}';
    }
}
