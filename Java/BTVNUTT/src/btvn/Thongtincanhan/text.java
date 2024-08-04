package btvn.Thongtincanhan;

import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        DanhSachThongTinSinhVien dSTTSV = new DanhSachThongTinSinhVien();
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        while(true){
            System.out.println("Menu---------------------------");
            System.out.println("1.Them Sinh Vien Vao Danh Sach");
            System.out.println("2.In Danh SAch Sinh Vien ");
            System.out.println("0.Thoat");
            luachon=Integer.parseInt(sc.nextLine());
            if(luachon==1){
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.nhapThongTin();
                dSTTSV.addSinhVien(sv);
            }else if(luachon==2){
                dSTTSV.inDanhSachSv();
            }else if(luachon==0){
                break;
            }
        }
    }
}
