package BT_FileChar.Bai1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Admin
 */
public class NhanVien extends Person {
    private String phongban;
    private double hesoluog;
    private double thamniem;
    private double luongcoban;

    public NhanVien(String phongban, double hesoluog, double thamniem, double luongcoban, String hotenString, String ngaysinh, String diachi, String gioitinhString) {
        super(hotenString, ngaysinh, diachi, gioitinhString);
        this.phongban = phongban;
        this.hesoluog = hesoluog;
        this.thamniem = thamniem;
        this.luongcoban = luongcoban;
    }

    public NhanVien() {
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public double getHesoluog() {
        return hesoluog;
    }

    public void setHesoluog(double hesoluog) {
        this.hesoluog = hesoluog;
    }

    public double getThamniem() {
        return thamniem;
    }

    public void setThamniem(double thamniem) {
        this.thamniem = thamniem;
    }

    public double getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(double luongcoban) {
        this.luongcoban = luongcoban;
    }
    public double luongthuclinh(){
        return this.luongcoban * this.hesoluog*(1+((double)this.thamniem)/100);
    }

    @Override
    public String toString() {
        return  super.toString() + phongban + hesoluog  + thamniem  + luongcoban + luongthuclinh();
    }

}

