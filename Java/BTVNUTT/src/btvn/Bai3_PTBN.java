package btvn;

import java.util.Scanner;

public class Bai3_PTBN {
    // pt bac nhat 1 an
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap a = ");
        int a = sc.nextInt();
        System.out.print("Nhap b = ");
        int b = sc.nextInt();
        if(a==0){
            if(b==0)
                System.out.println("PTVSN");
            else
                System.out.println("PTVN");
        }else {
            float x = -(float)b/a;
            System.out.println("PT co 1 nghiem x = -b/a = " +x);
        }

    }
}
