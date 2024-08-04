package saveandreadtobjectofile;



import java.io.File;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DanhSachSinhVien dsSV=new DanhSachSinhVien();
        int luachon;
        while(true){
            System.out.println("-------------Menu------------");
            System.out.println("1. Them sinh vien vap danh sach.");
            System.out.println("2. In danh sach sinh vien ra man hinh");
            System.out.println("3. kiem tra danh sach co rong hay khong.");
            System.out.println("4. Lay ra so luong sinh vien trong danh sach.");
            System.out.println("5. Lam rong danh sach sinh vien.");
            System.out.println("6. Kiem tra sinh vien co ton tai trong danh sach hay khong, dua tren ma sinh vien.");
            System.out.println("7. Xoa mot sinh vien ra khoi danh sach dua tren ma sinh vien.");
            System.out.println("8. Tim kiem tst ca sinh vien dua tren ten duoc nhap tu ban phim.");
            System.out.println("9. xuat ra danh sach sinh vien co diem tu cao den thap.");
            System.out.println("10.Luu danh sach thong tin xuong tap tin");
            System.out.println("11.Doc danh sahc xinh vien tu tap tin ");
            System.out.println("0. Thoat");
            luachon =Integer.parseInt(sc.nextLine());
            System.out.println("--------------------------------");
            if(luachon==1){
                SinhVien sv = new SinhVien();
                sv.nhapSinhVien();
                dsSV.themSinhVien(sv);
            }else if(luachon==2){
                dsSV.inDanhSachSinhVien();
            }else if(luachon==3){
                System.out.println("Danh sach sv co rong hay khong: "+dsSV.kiemTraDanhSachRong());
            }else if(luachon==4){
                System.out.println("so luong sinh vien trong danh sach: "+dsSV.laySoLuongSinhVien());
            }else if(luachon==5){
                dsSV.lamRongDanhSach();
                System.out.println("Danh sach da duoc lam rong ");
            }else if(luachon==6){
                System.out.print("Nhap ma Sinh vien: ");
                String maSinhVien = sc.nextLine();
                SinhVien sv = new SinhVien(maSinhVien);
                System.out.println("kiem tra sih vien co trong danh sach: "+dsSV.kiemTraTonTai(sv));
            }else if(luachon==7){
                System.out.print("Nhap ma sinh vien: ");
                String maSinhVien = sc.nextLine();
                SinhVien sv = new SinhVien(maSinhVien);
                System.out.println("xoa sinh vien co trong danh sach: "+dsSV.xoaSinhVien(sv));
            }else if(luachon==8){
                System.out.println("Nhap ho ten Sinh vien: ");
                String hoTenSV = sc.nextLine();
                System.out.println("ket qua can tim la: ");
                dsSV.timSinhVien(hoTenSV);
            }else if(luachon==9){
                System.out.println("Danh Sach SV sau khi duoc sap xep ");
                dsSV.sapXepSinhVienGiamGian();
                dsSV.inDanhSachSinhVien();
            }else if(luachon==10){
                System.out.println("Nhap ten File: ");
                String tenFile =sc.nextLine();
                File f = new File(tenFile);
                dsSV.ghiDuLieuXuongFile(f);
            }else if(luachon==11){
                System.out.println("Nhap ten File: ");
                String tenFile = sc.nextLine();
                File f = new File(tenFile);
                dsSV.docDuLieuTuFile(f);
            }
            if(luachon==0){
                break;
            }
        }
    }
}

