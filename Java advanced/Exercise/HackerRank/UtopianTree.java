package Exercise.HackerRank;

import java.util.Scanner;

public class UtopianTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            int th = sc.nextInt();
            System.out.println(cycle(th));
        }
    }
    public static int cycle(int n){
        int cycle = 1;
        for (int i=0;i<n;i++){
            if(i%2==0){
                cycle*=2;
            }else if(i%2==1){
                cycle+=1;
            }
        }
        return cycle;
    }
}
