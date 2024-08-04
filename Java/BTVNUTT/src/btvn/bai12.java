package btvn;

import java.util.Scanner;

public class bai12 {
    public static boolean check(int n){
        if(n<2)
            return false;
        for(int i=2 ; i<Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void QuickSort(int[] arr,int L,int R){
        int x = arr[(L+R)/2],i=L,j=R;
        do{
            while(arr[i]<x)i++;
            while(arr[j]>x)j--;
            if(i<=j){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]= temp;
                    i++;j--;
            }
        }while(i<=j);
        if(i<R) QuickSort(arr,i,R);
        if(j>L) QuickSort(arr,L,j);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu cua mang = ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i< arr.length;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        int max=arr[0],min=arr[0];
        for(int i=1;i< arr.length;i++){
            if(max<arr[i])
                max=arr[i];
            if(min>arr[i])
                min=arr[i];
        }
        System.out.println("max = "+max);
        System.out.println("min = "+min);
        int cnt = 0;
        System.out.println("cac so nguyen to trong arr:");
        for(int i=0;i < arr.length;i++){
            if(i%2==0)
                cnt++;
            if(check(arr[i])==true)
                System.out.print(arr[i]+" ");
        }
        System.out.println("So phan tu la so chan : "+cnt);
        QuickSort(arr,0,arr.length-1);
        System.out.println("mang sau khi spa xep tang dan ");
        for (int i:arr) {
            System.out.print(i+" ");
        }
        int x = sc.nextInt();
        for (int i:arr) {
            if(i==x){
                System.out.println("Phan tu "+x+"co trong mang ");
                break;
            }
        }

    }
}
