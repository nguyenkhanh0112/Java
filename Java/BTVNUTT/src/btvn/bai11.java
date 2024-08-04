package btvn;

import java.util.Scanner;

public class bai11 {
    public static boolean check(int n) {
        if(n==1||n==0)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      while (true){
          System.out.print("nhap n: ");
          int n = sc.nextInt();
          if(check(n)==true){
              System.out.println(n+" la so nguyen to ");
          }else
              System.out.println(n+" khong la so nguyen to ");
      }
    }
}
