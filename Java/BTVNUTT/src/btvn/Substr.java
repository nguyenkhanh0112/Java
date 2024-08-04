package btvn;

import java.util.Scanner;

public class Substr {
    public static void substr(String s1,String s2){
        if(s1.contains(s2)==true)
            System.out.println("vi tri cua s2 trong s1 la: "+s1.indexOf(s2));
        else
            System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap chuoi s1: ");
        String s1=sc.nextLine();
        System.out.println("nhap chuoi s2: ");
        String s2=sc.nextLine();
        substr(s1,s2);
        String s3=s1.concat(s2);
        System.out.println("chuoi moi la: "+s3+" vi tri cua chuoi lien ket: "+(s1.length()+1));
    }
}
