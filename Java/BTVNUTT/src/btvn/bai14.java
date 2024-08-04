package btvn;

import java.util.Random;
import java.util.Scanner;

public class bai14 {
    public  void maxIndex(int[][] arr,int n,int m){
        int max = 0;
        int index1=0,index2=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(max<arr[i][j]){
                    max=arr[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println("max = "+max);
        System.out.println("index = ["+index1+"]["+index2+"]");
    }
    public  boolean check(int n){
        if(n<2)
            return false;
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public void editArr(int[][] arr,int n,int m){
        System.out.println("Cac so nguyen to trong mang ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(check(arr[i][j])==true){
                    System.out.print(arr[i][j]+" ");
                }else
                    arr[i][j]=0;
            }
        }
    }
    public void export(int[][] arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    // ton time zl
    public  void sapXep(int [][]arr,int n,int m){
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                for(int k = 0;k < n;k++){
                    for(int p = 0;p < m;p++){
                        if(arr[j][i]>arr[p][k]){
                            int temp = arr[j][i];
                            arr[j][i] = arr[p][k];
                            arr[p][k] = temp;
                        }
                    }
                }
            }
        }
    }
    // doi tu 2 chieu sang 1 chieu => sap xep tang dan => doi 1 chieu sang 2 chieu
    public  void doi2sang1(int[][]arr,int n,int m,int[] arr1){
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr1[k++]=arr[i][j];
            }
        }
    }
    public  void sapxeptang(int[] arr1){
        for(int i=0;i<arr1.length;i++){
            for(int j =i+1;j< arr1.length;j++){
                if(arr1[i]>arr1[j]){
                    int temp = arr1[i];
                    arr1[i]=arr1[j];
                    arr1[j]=temp;
                }
            }
        }
    }
    public  void doi1sang2(int[][]arr,int n,int m ,int[] arr1){
        int k =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[j][i]=arr1[k++];
            }
        }
    }
    public  void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap row: ");
        int n = sc.nextInt();
        System.out.println("Nhap col: ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j = 0; j<m;j++){
                arr[i][j] = rand.nextInt(101);
                //arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("mang vua nhap ");
        export(arr,n,m);
        maxIndex(arr,n,m);
        System.out.println("mang sau khi dc sap xep ");
        int[] arr1 = new int[n*m];
        doi2sang1(arr,n,m,arr1);
        sapxeptang(arr1);
        doi1sang2(arr,n,m,arr1);
        export(arr,n,m);
        editArr(arr,n,m);
        System.out.println();
        export(arr,n,m);
    }
}
