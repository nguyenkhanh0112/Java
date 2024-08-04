package BT_FileChar.Bai1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Text {
    private ArrayList<NhanVien> arrayListNV = new ArrayList<NhanVien>();
    public void PhanA(){
        try {

            FileReader fr = new FileReader("C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Nhanvien.dat");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while((line =br.readLine())!=null){
                String[] txt = line.split("\\$");
                String hoten = txt[0];
                String ngaysinh = txt[1];
                String diachi= txt[2];
                String gioitinhString=txt[3];
                String phongban =txt[4];
                double hesoluong = Double.parseDouble(txt[5]);
                double thamniem = Double.parseDouble(txt[6]);
                double luongcoban = Double.parseDouble(txt[7]);
                arrayListNV.add(new NhanVien(phongban,hesoluong,thamniem,luongcoban,hoten,ngaysinh,diachi,gioitinhString));
            }
            fr.close();
            br.close();
        } catch (Exception e) {
        }
    }
    public void PhanB(){
        try {
            FileWriter fw = new FileWriter("Nhanvien.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < arrayListNV.size(); i++) {
                System.out.println(arrayListNV.get(i).toString());
                bw.write(arrayListNV.get(i).toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void PhanC(){
        System.out.println("nhap ten file copy : ");
        String tenFile = (new Scanner(System.in).nextLine());
        Path path1 = Path.of("Nhanvien.txt");
        Path path2 = Path.of(tenFile);
        try {
            Files.copy(path1,path2,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {

        }

    }
    public static void main(String[] args) {
        int luachon = 0;
        Text text = new Text();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Doc du lieu tu file Nhanvien.dat");
            System.out.println("2.Hien thi danh sach va luu vao file Nhanvien.txt");
            System.out.println("3.Copy noi dung sang file khac ten file nhap tu ban phim");
            System.out.println("0.Thoat chuong trinh");
            luachon = sc.nextInt();
            if(luachon==1){
                text.PhanA();
            }else if(luachon==2){
                text.PhanB();
            }else if(luachon==3){
                text.PhanC();
            }else if(luachon==0){
                break;
            }
        }
    }
}
