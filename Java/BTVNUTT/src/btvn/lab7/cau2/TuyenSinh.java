package btvn.lab7.cau2;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh {
    public static void main(String[] args) {
        ThiSinh thisinh;
        ArrayList<ThiSinh> listThiSinh = new ArrayList<ThiSinh>();
        Scanner sc = new Scanner(System.in);
        int luachon=0;
        while (true){
            System.out.println("1. Nhập thông tin về các thứ sinh dự thi ");
            System.out.println("2. Hiển thị thông tin về thí sinh  ");
            System.out.println("3. Tìm kiếm thí sinh theo số báo danh ");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn: ");
            luachon = sc.nextInt();
            if(luachon==1){
                int luachon1=0;
                while (true){
                    System.out.println("1. Nhập thông tin thí sinh khối A ");
                    System.out.println("2. Nhập thông tin thí sinh khối B ");
                    System.out.println("3. Nhập thông tin về thí sinh khối C ");
                    System.out.println("0. Thoát");
                    System.out.println("Nhập lựa chọn: ");
                    luachon1 = sc.nextInt();
                    if(luachon1==1){
                        thisinh = new ThiSinhKhoiA();
                        thisinh.nhapThongTin();
                        listThiSinh.add(thisinh);
                    }else if(luachon1==2){
                        thisinh= new ThiSinhKhoiB();
                        thisinh.nhapThongTin();
                        listThiSinh.add(thisinh);
                    }else if(luachon1==3){
                        thisinh = new ThiSinhKhoiC();
                        thisinh.nhapThongTin();
                        listThiSinh.add(thisinh);
                    }else if(luachon1==0){
                        break;
                    }
                }
            }else if(luachon==2){
                System.out.println("Thông tin các thí sinh vừa nhập");
                for (ThiSinh thiSinh:listThiSinh) {
                    System.out.println(thiSinh);
                }

            } else if(luachon==3){
                sc.nextLine();
                System.out.println("Nhập SBD của thí sinh cần tìm: ");
                String sbd = sc.nextLine();
                for (ThiSinh thiSinh:listThiSinh) {
                    if(thiSinh.getSBD().equalsIgnoreCase(sbd))
                        System.out.println(thiSinh);
                }
            }
        }
    }
}
