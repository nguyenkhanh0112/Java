package main;

import java.io.File;
import java.io.IOException;

public class ViDuTaoTapTinVaThuMuc {
    public static void main(String[] args) {
        // lưu ý :
        //MS windows:\=>>\\ | vi du "C:\\Thu Muc 1\\Thu Muc \\ Ten Tap tin.xxx";
        //Liunx, MacOs: / Vi du: Thu Muc 1/Thu muc 2 / Ten tap tin.xxx";
        File folder1 = new File("\\D:\\Java\\java02");
        File folder2 = new File("\\D:\\Java\\java03");


        System.out.println("Kiem tra folder1 co ton tai hay ko "+folder1.exists());
        System.out.println("Kiem tra folder1 co ton tai hay ko "+folder2.exists());

        // tao thu muc
        // Phuong thuc  mkdir() => Tao 1 thu muc
        File d1 = new File("\\D:\\Java\\java02\\Directory_1");
        d1.mkdir();

        // phuong thuc mkdis() = > tao nhieu thu muc
        File d2 = new File("\\D:\\Java\\java02\\Directory_2\\Directory_3\\Directory_4");
        d2.mkdirs();

        // tao tap tin (co phan mo rong:.exe, .txt, .doc, .xls ...);
        File file1 = new File("\\D:\\Java\\java02\\Directory_1\\Vidu.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            // khoong co quyen tao tap tin
            // o cung stack overflow
            // duong dan sai
            throw new RuntimeException(e);
        }

    }
}