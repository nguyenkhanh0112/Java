package btvn;

import java.util.Scanner;

public class Bai1_3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap a = ");
        int a =sc.nextInt();
        System.out.print("nhap b = ");
        int b = sc.nextInt();
        int tong = a+b;
        int hieu = a-b;
        int tich = a*b;
        float thuong = (float)a/b;
        System.out.println("Tong = a + b = "+tong);
        System.out.println("Hieu = a - b = "+hieu);
        System.out.println("Tich = a * b = "+tich);
        System.out.println("Thuong = a / b = "+thuong);
    }
}