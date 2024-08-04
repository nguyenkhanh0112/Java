/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5bai2;

import java.util.Scanner;

/**
 *
 * @author PhuongVA
 */
public class ThiSinhKhoiA extends ThisSinh {
    private float toan;
    private float ly;
    private float hoa;

    public ThiSinhKhoiA() {
    }

    public ThiSinhKhoiA(float toan, float ly, float hoa, String sbd, String hten, String diachi, int uutien) {
        super(sbd, hten, diachi, uutien);
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public float getToan() {
        return toan;
    }

    public float getLy() {
        return ly;
    }

    public float getHoa() {
        return hoa;
    }

    @Override
    public String toString() {
        return super.toString()+"-"+this.toan+"-"+this.ly+"-"+this.hoa;
    }
  
    public void input(){
        super.input();
        System.out.print("Nhap diem toan: ");
        this.setToan(new Scanner(System.in).nextFloat());
        System.out.print("Nhap diem ly: ");
        this.setLy(new Scanner(System.in).nextFloat());
        System.out.print("Nhap diem hoa: ");
        this.setHoa(new Scanner(System.in).nextFloat());
    }
    
    
}
