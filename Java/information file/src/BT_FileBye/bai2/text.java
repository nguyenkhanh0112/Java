package BT_FileBye.bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        SinhVienHTTT sinhVienHTTT = new SinhVienHTTT();
        SinhVienUTT sinhVienUTT = new SinhVienUTT();
        while(true){
            System.out.println("1. Nhâp danh sách dữ liệu sinh viên UTT");
            System.out.println("2. Nhâp danh sách dữ liệu sinh viên HTTT");
            System.out.println("3. Dọc dữ liệu cả danh sahcs UTT,HTTT ");
            System.out.println("0. Thoát");
            int luachon = new Scanner(System.in).nextInt();
            if(luachon==1){
                sinhVienUTT.nhapDuLieu();
            }else if(luachon==2){
                sinhVienHTTT.nhapDuLieu();
            }else if(luachon==3){
                ArrayList<SinhVienHTTT> arrayListHTTT1 = sinhVienHTTT.docDuLieu();
                ArrayList<SinhVienUTT> arrayListUTT2 = sinhVienUTT.docDuLieu();
                System.out.println("Danh sách sinh viên HTTT");
                for (SinhVienHTTT sinhVienHTTT1:arrayListHTTT1) {
                    System.out.println(sinhVienHTTT1);
                }
                System.out.println("------------------------------------");
                System.out.println("Danh sách sinh viên UTT");
                for(SinhVienUTT sinhVienUTT1:arrayListUTT2){
                    System.out.println(sinhVienUTT1);
                }

            }else if(luachon==0){
                break;
            }
        }
    }
}
