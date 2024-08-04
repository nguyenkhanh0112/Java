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
public class ThiSinhKhoiB extends ThisSinh{
    private float toan1;
    private float hoa2;
    private float sinh;

    public ThiSinhKhoiB() {
    }

    public ThiSinhKhoiB(float toan1, float hoa2, float sinh, String sbd, String hten, String diachi, float uutien) {
        super(sbd, hten, diachi, uutien);
        this.toan1 = toan1;
        this.hoa2 = hoa2;
        this.sinh = sinh;
    }

    public float getToan1() {
        return toan1;
    }

    public void setToan1(float toan1) {
        this.toan1 = toan1;
    }

    public float getHoa2() {
        return hoa2;
    }

    public void setHoa2(float hoa2) {
        this.hoa2 = hoa2;
    }

    public float getSinh() {
        return sinh;
    }

    public void setSinh(float sinh) {
        this.sinh = sinh;
    }

    @Override
    public String toString() {
        return super.toString()+"-"+this.toan1+"-"+hoa2+"-"+sinh;
    }
    public void input(){
        super.input();
        System.out.print("Nhap diem toan: ");
        this.setToan1(new Scanner(System.in).nextFloat());
        System.out.print("Nhap diem hoa: ");
        this.setHoa2(new Scanner(System.in).nextFloat());
        System.out.print("Nhap diem sinh: ");
        this.setSinh(new Scanner(System.in).nextFloat());
    }
}
