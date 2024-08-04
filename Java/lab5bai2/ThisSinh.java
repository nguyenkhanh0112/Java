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
public class ThisSinh extends Object{
    private String sbd;
    private String hten;
    private String diachi;
    private float uutien;

    public ThisSinh() {
    }

    public ThisSinh(String sbd, String hten, String diachi, float uutien){
        this.sbd = sbd;
        this.hten = hten;
        this.diachi = diachi;
        this.uutien = uutien;
    }

    public String getSbd() {
        return sbd;
    }

    public String getHten() {
        return hten;
    }

    public String getDiachi() {
        return diachi;
    }

    public float uutien(){
        return uutien;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public void setHten(String hten) {
        this.hten = hten;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setUutien(float uutien){
        this.uutien = uutien;
    }

    @Override
    public String toString() {
        return sbd + "-"+ hten + "-"+ diachi + "-"+ uutien;
    }
    public void input(){
        System.out.print("Nhap so bao danh: ");
        this.setSbd(new Scanner(System.in).nextLine());
        System.out.print("Nhap ho ten: ");
        this.setHten(new Scanner(System.in).nextLine());
        System.out.print("Nhap dia chi: ");
        this.setDiachi(new Scanner(System.in).nextLine());
        System.out.print("Nhap uu tien: ");
        this.setUutien(new Scanner(System.in).nextFloat());
    }
    
}
