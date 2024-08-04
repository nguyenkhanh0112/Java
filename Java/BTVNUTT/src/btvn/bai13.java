package btvn;

import java.util.Scanner;

public class bai13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap row ");
        int n =sc.nextInt();
        System.out.println("nhap col ");
        int m =sc.nextInt();
        int [][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print("arr["+i+"]["+j+"] = ");
                arr[i][j]= sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int min = arr[0][0];
        int oddmax = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(min>arr[i][j])
                    min = arr[i][j];
                if(oddmax<arr[i][j]&&arr[i][j]%2==1)
                    oddmax = arr[i][j];
            }
        }
        System.out.println("Phan tu nho nhat = "+min);
        System.out.println("Phan tu le lon nhat = "+oddmax);
        int temp=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=arr[i][j];
            }
            if(temp<sum)
                temp = sum;
        }
        System.out.println("row co tong lon nhat la = "+temp);
    }
}
