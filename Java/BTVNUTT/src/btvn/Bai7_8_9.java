package btvn;

import java.util.Scanner;

public class Bai7_8_9 {

    public static int giaiThua(int n){
        if(n==0||n==1)
            return 1;
        return n*giaiThua((n-1));
    }
    public int Fibonaci(int n){
        int f0 = 1;
        int f1 = 1;
        int fn = 2;
        if(n<=1)
            return 1;
        else{
            for(int i=2 ;i<n;i++){
                f0 = f1;
                f1 = fn;
                fn = f0+f1;
            }
        }
        return fn;
    }
    // cach nay ko hieu qua se cham dan khi minh ++n len
    public static int nFibonaci(int n){
        if(n==0||n==1)
            return 1;
        return nFibonaci(n-1)+nFibonaci(n-2);
    }
    public static double tongNghichDao(int n){
        if(n==1)
            return 1;
        return (double)1/giaiThua(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap n = ");
        int n = sc.nextInt();
        //System.out.println(n+"! = "+giaiThua(n));
        System.out.println("so fibonaci thu "+n+" la = "+nFibonaci(n));
        System.out.println("so fibonaci thu "+n+" la = "+nFibonaci(n));
        System.out.println("Tong nghich dao = "+tongNghichDao(n));
    }
}
