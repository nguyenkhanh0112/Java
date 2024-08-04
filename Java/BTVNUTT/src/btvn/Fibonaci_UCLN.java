package btvn;

import java.util.Scanner;

public class Fibonaci_UCLN {
    public static int gcd(int a,int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b,a%b);
    }
    public static int fibonaci(int n){
        int f0=0;
        int f1=1;
        int fn=1;
        if(n<=1)
            return 1;
        for(int i=2;i<=n;i++){
            f0=f1;
            f1=fn;
            fn=f1+f0;
        }
        return fn;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n=sc.nextInt();
        System.out.println("UCLN = "+gcd(a,b));
        System.out.println("Fibonaci = "+fibonaci(n));
    }
}
