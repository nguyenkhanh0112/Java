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
public class ThiSinhKhoiC extends ThisSinh {
    private float van;
    private float su;
    private float dia;

    public ThiSinhKhoiC() {
    }

    public ThiSinhKhoiC(float van, float su, float dia, String sbd, String hten, String diachi, float uutien) {
        super(sbd, hten, diachi, uutien);
        this.van = van;
        this.su = su;
        this.dia = dia;
    }

    public float getVan() {
        return van;
    }

    public void setVan(float van) {
        this.van = van;
    }

    public float getSu() {
        return su;
    }

    public void setSu(float su) {
        this.su = su;
    }

    public float getDia() {
        return dia;
    }

    public void setDia(float dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return super.toString()+"-"+van+"-"+su+"-"+dia;
    }
    public void input(){
        System.out.print("Nhap diem van: ");
        this.setVan(new Scanner(System.in).nextFloat());
        System.out.print("Nhap diem su: ");
        this.setSu(new Scanner(System.in).nextFloat());
        System.out.print("Nhap diem dia: ");
        this.setDia(new Scanner(System.in).nextFloat());
    }
    
}
