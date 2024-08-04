/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5bai2;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author PhuongVA
 */
public class TuyenSinh {
    public static void main(String[] args){
        ArrayList<ThisSinh> list = new ArrayList<ThisSinh>();
        ThisSinh thisinh;
        int cn;
        do {
            System.out.println("1. Nhap thong tin thi sinh du thi");
            System.out.println("2. Nhap theo so bao danh");
            System.out.println("3. Hien thi thong tin ve danh sach thi sinh");
            System.out.println("0. Thoat");
            System.out.print("Moi ban chon chuc nang!");
            cn=new Scanner(System.in).nextInt();
            switch (cn) {
                case 1:
                    int cn1;
                    do {
                        System.out.println("1. Nhap thong tin thi sinh du thi khoi A");
                        System.out.println("2. Nhap thong tin thi sinh du thi khoi B");
                        System.out.println("3. Nhap thong tin thi sinh du thi khoi C");
                        System.out.println("0. Thoat");
                        cn1=new Scanner(System.in).nextInt();
                        switch (cn1) {
                            case 1:
                                System.out.println("Nhap thong tin thi sinh du thi khoi A");
                                thisinh = new ThiSinhKhoiA();
                                thisinh.input();
                                list.add(thisinh);
                                break;
                            case 2:
                                System.out.println("Nhap thong tin thi sinh du thi khoi B");
                                thisinh = new ThiSinhKhoiB();
                                thisinh.input();
                                list.add(thisinh);
                                break;
                            case 3:
                                System.out.println("Nhap thong tin thi sinh du thi khoi C");
                                thisinh = new ThiSinhKhoiC();
                                thisinh.input();
                                list.add(thisinh);
                                break;
                            
                        }
                    } while (cn1 !=0);
                    
                    break;
                case 2:
                    System.out.println("Thuc hien chuc nang tim kiem");
                    System.out.println("Nhap so bao danh can tim: ");
                    String sobaodanh=new Scanner(System.in).nextLine();
                    ThisSinh ts;
                    for(Object object : list){
                        ts = (ThisSinh)object;
                        if(ts.getHten().equalsIgnoreCase(sobaodanh)){
                           System.out.println(ts);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thuc hien chuc nang hien thi danh sach ");
                    for(Object object : list){
                        if(object instanceof ThiSinhKhoiA){
                            ThiSinhKhoiA a = (ThiSinhKhoiA)object;
                            System.out.println(a);
                        }else if(object instanceof ThiSinhKhoiB){
                            ThiSinhKhoiB b = (ThiSinhKhoiB)object;
                            System.out.println(b);
                        }else if(object instanceof ThiSinhKhoiC){
                            ThiSinhKhoiC c = (ThiSinhKhoiC)object;
                            System.out.println(c);
                        }
                    }
                    break;
            }
        } while (cn !=0);
        System.out.println("Chuong trinh da ket thuc");
        
    }
}
