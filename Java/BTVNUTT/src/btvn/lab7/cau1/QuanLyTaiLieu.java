package btvn.lab7.cau1;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTaiLieu {
    public static void main(String[] args) {
        TaiLieu taiLieu;
        ArrayList<TaiLieu> listTaiLieu = new ArrayList<TaiLieu>();
        ArrayList<TaiLieu> listBao = new ArrayList<TaiLieu>();
        ArrayList<TaiLieu> listTapChi = new ArrayList<TaiLieu>();
        ArrayList<TaiLieu> listSach = new ArrayList<TaiLieu>();
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        while (true) {
            System.out.println("1. Nhap thong tin ve cac tai lieu ");
            System.out.println("2. Hien thi thong tin ve cac tai lieu ");
            System.out.println("3. Tim kiem tai lieu theo loai ");
            System.out.println("0. thoat");
            System.out.println("Nhap lua chon: ");
            luachon = sc.nextInt();
            if (luachon == 1) {
                while (true) {
                    System.out.println("1.Nhap thong tin ve bao ");
                    System.out.println("2.Nhap thong tin ve sach ");
                    System.out.println("3.Nhap thong tin ve tap chi ");
                    System.out.println("0. Thoat ");
                    System.out.println("Nhap lua chon: ");
                    int luachon1 = sc.nextInt();
                    if (luachon1 == 1) {
                        taiLieu = new Bao();
                        taiLieu.nhapThongTin();
                        listTaiLieu.add(taiLieu);
                        listBao.add(taiLieu);
                    } else if (luachon1 == 2) {
                        taiLieu = new Sach();
                        taiLieu.nhapThongTin();
                        listTaiLieu.add(taiLieu);
                        listSach.add(taiLieu);
                    } else if (luachon1 == 3) {
                        taiLieu = new TapChi();
                        taiLieu.nhapThongTin();
                        listTaiLieu.add(taiLieu);
                        listTapChi.add(taiLieu);
                    } else if (luachon1 == 0) {
                        break;
                    }
                }
            } else if (luachon == 2) {
                System.out.println("THÔNG TIN CÁC TÀI LIỆU VỪA NHẬP");
                for (TaiLieu taiLieu1 : listTaiLieu) {
                    System.out.println(taiLieu1);
                }
            } else if (luachon == 3) {
                System.out.println("TÌM KIẾM TÀI LIỆU THEO LOẠI ");
                int luachon2 = 0;
                while (true) {
                    System.out.println("1. Báo ");
                    System.out.println("2. Tạp Chí ");
                    System.out.println("3. Sách ");
                    System.out.println("0. Thoát");
                    System.out.println("Nhập lựa chọn: ");
                    luachon2 = sc.nextInt();
                    if (luachon2 == 1) {
                        for (TaiLieu object : listBao) {
                            System.out.println(object);
                        }
                    }
                    if (luachon2 == 2) {
                        for (TaiLieu object : listBao) {
                            System.out.println(object);
                        }
                    }
                    if (luachon2 == 3) {
                        Sach sach = new Sach();
                        for (TaiLieu object : listSach) {
                            System.out.println(object);
                        }
                    }
                }
            }
        }
    }
}
