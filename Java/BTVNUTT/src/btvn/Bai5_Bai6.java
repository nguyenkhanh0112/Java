package btvn;

import java.util.Scanner;

public class Bai5_Bai6 {
    public static int sum1(int n){
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public static double sumnghich(int n){
        double sum=0;
        for(int i=1 ;i <n;i++){
            sum+=(double)1/i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println("Tong = "+sum1(n));
        System.out.println("Tong nghich dao = "+sumnghich(n));
    }
}
