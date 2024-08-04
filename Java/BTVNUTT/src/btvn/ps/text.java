package btvn.ps;

import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        PS ps1 = new PS(3,4);
        PS ps2 = new PS(5,6);
        PS ps3 = new PS();
        System.out.println("nhap tu va mau cho ps3 ");
        int tu =sc.nextInt();
        int mau = sc.nextInt();
        ps3.setTu(tu);
        ps3.setMau(mau);
        ps1.congPS(ps2);
        ps2.truPS(ps3);
        ps3.chiaPS(ps2);


    }

}
