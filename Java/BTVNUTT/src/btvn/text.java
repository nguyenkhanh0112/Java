package btvn;

import java.util.Scanner;

public class text {

    public static void show(String[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>3)
                System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        show(arr);
    }
    /*
    public  void main(String[] args) {
        Fibonaci_UCLN fu = new Fibonaci_UCLN();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("UCLN = "+fu.gcd(a,b));
    }

     */
}
