package btvn.lap08.KhuPho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhuPho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hộ dân: ");
        int n = sc.nextInt();
        List<HoDan> hoDanList = new ArrayList<HoDan>();
        for(int i=0;i<n;i++){
            System.out.println("Nhập thông tin về hộ dân thứ: "+(i+1));
            HoDan hoDan = new HoDan();
            hoDan.nhapThongTin();
            hoDanList.add(hoDan);
        }
        System.out.println("Thông tin các hộ dân vừa nhập: ");
        for (HoDan hoDan:hoDanList) {
            hoDan.xuatThongTin();
        }
    }
}
