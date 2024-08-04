package BT_FileChar.Bai1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Person {
    private String hotenString;
    private String ngaysinh;
    private String diachi;
    private String gioitinhString;

    public Person() {
    }

    public Person(String hotenString, String ngaysinh, String diachi, String gioitinhString) {
        this.hotenString = hotenString;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinhString = gioitinhString;
    }

    public String getHotenString() {
        return hotenString;
    }

    public void setHotenString(String hotenString) {
        this.hotenString = hotenString;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinhString() {
        return gioitinhString;
    }

    public void setGioitinhString(String gioitinhString) {
        this.gioitinhString = gioitinhString;
    }

    @Override
    public String toString() {
        return  hotenString +  ngaysinh  + diachi + gioitinhString ;
    }

}
