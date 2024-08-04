package btvn;

import java.util.Scanner;

public class Bai10 {
    // tinh tong cac so chua 1 so nguyen bat ki
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       while (true){
           System.out.println("nhap n ");
           int n = sc.nextInt();
           int sum = 0;
           while(n>0){
               sum +=n%10;
               n/=10;
           }
           System.out.println("tong = "+sum);
       }
    }
}
