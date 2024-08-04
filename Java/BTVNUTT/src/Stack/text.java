package Stack;

import java.util.Scanner;
import java.util.Stack;

public class text {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stackChuoi = new Stack<String>();
        //stackChuoi.push("Gia Tri");==> dua ra tri vao stack;
        //stackChuoi.pop()=>lay gia tri ra,xoa khoi stack;
        //stackChuoi.peek()=> lay gia tri ra , nhung ko xoa khoi stack
        //stackChuoi.clear();=>xoa tat ca cac phan tu trong stack;
        //stackChuoi.contains("Gia tri");=> xac dinh gia tri co ton tai trong stack hay ko

        // vi du dao nguoc chuoi
        System.out.println("Nhap vao chuoi: ");
        String S=sc.nextLine();
        for(int i=0;i< S.length();i++){
            stackChuoi.push(S.charAt(i)+"");
        }
        System.out.println("Chuoi dao nguoc: ");
        for(int i=0;i<S.length();i++){
            System.out.print(stackChuoi.pop());
        }
        System.out.println();
        // chuyen tu he thap phan sang he nhi phan
        System.out.println("Nhap so thap phan can chuyen:  ");
        int x = sc.nextInt();
        Stack<Integer> sonhiphan = new Stack<Integer>();
        while(x>0){
            int d=x%2;
            sonhiphan.push(d);
            x/=2;
        }
        int n=sonhiphan.size();
        for(int i=0;i<n;i++){
            System.out.print(sonhiphan.pop());
        }
    }
}
