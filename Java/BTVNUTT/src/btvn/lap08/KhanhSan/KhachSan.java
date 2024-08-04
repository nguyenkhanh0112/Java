package btvn.lap08.KhanhSan;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.util.ArrayList;
import java.util.Scanner;

public class KhachSan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số khách trọ: ");
        int n = sc.nextInt();
        ArrayList<KhachTro> listKhachSan = new ArrayList<KhachTro>();
        for(int i=0;i<n;i++){
            System.out.println("Nhập thông tin vào khách trọ thứ: "+(i+1));
            KhachTro khachTro1 = new KhachTro();
            khachTro1.NhapThongtin();
            listKhachSan.add(khachTro1);
        }

        System.out.println("Thông tin các khách trọ vừa nhập: ");
        for (KhachTro khachTro:listKhachSan) {
            khachTro.xuatThongTin();
        }

    }
}
