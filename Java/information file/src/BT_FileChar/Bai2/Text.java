package BT_FileChar.Bai2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Text {
    private ArrayList<SinhvienHTTT> sinhvienHTTTArrayList = new ArrayList<SinhvienHTTT>();
    private ArrayList<SinhvienUTTT> sinhvienUTTTArrayList = new ArrayList<SinhvienUTTT>();

    public void nhapDuLieuSinhVienHTTT(){
        try {
            FileWriter fileWriter = new FileWriter("svhttt.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            SinhvienHTTT sinhvienHTTT = new SinhvienHTTT();
            sinhvienHTTT.nhapThongTin();
            bufferedWriter.write(sinhvienHTTT.toString());
            bufferedWriter.newLine();
            sinhvienHTTTArrayList.add(sinhvienHTTT);
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void nhapDuLieuSinhVienUTTT(){
        try{
            FileWriter fileWriter = new FileWriter("svuttt.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            SinhvienUTTT sinhvienUTTT = new SinhvienUTTT();
            sinhvienUTTT.nhapThongTin();
            bufferedWriter.write(sinhvienUTTT.toString());
            bufferedWriter.newLine();
            sinhvienUTTTArrayList.add(sinhvienUTTT);
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void docDulieuSinhVien(){
        for (int i = 0; i < sinhvienUTTTArrayList.size(); i++) {
            System.out.println(sinhvienUTTTArrayList.get(i).toString());
        }
        for (int i = 0; i < sinhvienHTTTArrayList.size(); i++) {
            System.out.println(sinhvienHTTTArrayList.get(i).toString());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Text text = new Text();
        while (true){
            System.out.println("1.nhap du lieu  ");
            System.out.println("2.doc du lieu ");
            System.out.println("3.copy sang file khac nhap tu ban phim");
            System.out.println("0.thoat");
            System.out.println("nhap lua chon: ");
            int luachon =sc.nextInt();
            if(luachon==1){
                while(true){
                    System.out.println("1.nhap du lieu sinh vien UTTT");
                    System.out.println("2.nhap du lieu sinh vien HTTT");
                    System.out.println("3.copy du lieu sinh vien UTTT");
                    System.out.println("4.copy du lieu sinh vien HTTT");
                    System.out.println("0.thoat");
                    System.out.println("nhap lua chon: ");
                    int luachon1 = sc.nextInt();
                    sc.nextLine();
                    if(luachon1==1){
                        System.out.println("nhap so luong sinh vien UTTT");
                        int n = sc.nextInt();
                        for(int i=0;i<n;i++){
                            System.out.println("nhap thong tin sinh vien UTTT thu: "+(i+1));
                            text.nhapDuLieuSinhVienUTTT();
                        }
                    }else if(luachon1==2){
                        System.out.println("nhap so luong sinh vien HTTT");
                        int n = sc.nextInt();

                        for(int i=0;i<n;i++){
                            System.out.println("nhap thong tin sinh vien HTTT thu: "+(i+1));
                            text.nhapDuLieuSinhVienHTTT();
                        }

                    }else if(luachon1==3){
                        System.out.println("nhap ten file can chuyen ");
                        String tenfile = sc.nextLine();
                        Path path1 = Path.of("svuttt.txt");
                        Path path2 = Path.of(tenfile+".txt");
                        try{

                            Files.copy(path1,path2, StandardCopyOption.REPLACE_EXISTING);
                        }catch (Exception e){
                        }
                    }else if(luachon1==4){
                        System.out.println("nhap ten file can chuyen ");
                        String tenfile = sc.nextLine();
                        Path path1 = Path.of("svhttt.txt");
                        Path path2 = Path.of(tenfile+".txt");
                        try{
                            Files.copy(path1,path2, StandardCopyOption.REPLACE_EXISTING);
                        }catch (Exception e){
                        }
                    }
                    else if(luachon1==0){
                        break;
                    }
                }
            }else if(luachon==2){
                System.out.println("Du lieu cua  sinh vien 2 truong UTTT va HTTT ");
                text.docDulieuSinhVien();
            }else if(luachon==0){
                break;
            }
        }

    }
}
