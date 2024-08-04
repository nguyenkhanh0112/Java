package btvn.lap08.KhanhSan;

import java.util.Scanner;

public class Nguoi {
    private String hovaten;
    private int tuoi;
    private int namsinh;
    private String soCCCD;
    Scanner sc = new Scanner(System.in);
    public Nguoi(String hovaten, int tuoi, int namsinh, String soCCCD) {
        this.hovaten = hovaten;
        this.tuoi = tuoi;
        this.namsinh = namsinh;
        this.soCCCD = soCCCD;
    }
    public Nguoi(){

    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }
    public void NhapThongTin(){
        System.out.println("Nhập họ và tên: ");
        this.hovaten = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        this.tuoi= sc.nextInt();
        System.out.println("Nhập năm sinh: ");
        this.namsinh=sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập số CCCD: ");
        this.soCCCD = sc.nextLine();
    }
    @Override
    public String toString() {
        return "Nguoi{" +
                "hovaten='" + hovaten + '\'' +
                ", tuoi='" + tuoi + '\'' +
                ", namsinh=" + namsinh +
                ", soCCCD='" + soCCCD + '\'' +
                '}';
    }


}
