package btvn;

import java.util.Scanner;


public class Bai4_PTB2 {
    // giai pt bac 2 1 an
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Nhap a = "); int a =sc.nextInt();
            System.out.print("Nhap b = ");int b = sc.nextInt();
            System.out.print("Nhap c = ");int c =sc.nextInt();
            if(a==0){
                if(b==0) {
                    if (c == 0)
                        System.out.println("PTVSN");
                    else
                        System.out.println("PTVN");
                }
                else{
                    float x = -(float)b/c;
                    System.out.println("PT co 1 nghiem x = -b/a = "+x);
                }
            }else{
                double denta = Math.pow(b,2) - 4*a*c;
                if(denta<0)
                    System.out.println("PTVN");
                else if(denta==0){
                    float x = -(float)b/(2*a);
                    System.out.println("PT co nghiem kep x = -b/2a = "+x);
                }else{
                    double x1 = (-b- Math.sqrt(denta))/(2*a);
                    double x2 = (-b+ Math.sqrt(denta))/(2*a);
                    System.out.println("PT co 2 nghiem ");
                    System.out.println("x1 = "+x1);
                    System.out.println("x2 = "+x2);
                }
            }
            if(a==0&&b==0&&c==0)
                break;
        }
    }
}
