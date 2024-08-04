package btvn.lab7.cau1;

public class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;
    public TapChi(String maTaiLieu, String tenNhaSX, int soBanPhatHanh, int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, tenNhaSX, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }
    public  TapChi(){}
    public int getSoPhatHanh() {
        return soPhatHanh;
    }
    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }
    public int getThangPhatHanh() {
        return thangPhatHanh;
    }
    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("Nhập Số Phát Hành: ");
        this.soPhatHanh = sc.nextInt();
        do {
            System.out.print("Nhập Tháng Phát Hành(>=1 || <=12): ");
            this.thangPhatHanh = sc.nextInt();
        }while(thangPhatHanh<1 || thangPhatHanh>12);
    }

    @Override
    public String toString() {
        return "TapChi{"+super.toString()+
                "soPhatHanh=" + soPhatHanh +
                ", thangPhatHanh=" + thangPhatHanh +
                '}';
    }
}
