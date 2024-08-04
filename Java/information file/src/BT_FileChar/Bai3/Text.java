package BT_FileChar.Bai3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Text {
    ArrayList<Book> arrayList = new ArrayList<Book>();
    public void nhapThongTinSach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so luong sach: ");

        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            Book book= new Book();
            System.out.println("nhap thong tin sach thu: "+(i+1));
            book.nhapThongTin();
            arrayList.add(book);
            System.out.println(book.toString());
        }
        try{
            FileWriter fw = new FileWriter("books.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Book book:arrayList) {
                bw.write(book.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Xoa_BackUp(){
        System.out.println("nhap duong dan den thu muc can luu");
        String duongdan = new Scanner(System.in).nextLine();
        System.out.println("Nhap ten file back up: ");
        String tenfile =new Scanner(System.in).nextLine();
        File file =new File (duongdan+"\\"+tenfile+".txt");
        File file1 = new File("D:\\Java\\information file\\books.dat");
        try{

            Files.copy(file1.toPath(),file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("back up du lieu thanh cong!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Bach up du lieu that bai!");
        }
        file1.delete();
        if(file1.exists()){
            System.out.println("file con ton tai!");
        }else
            System.out.println("file ko ton tai, xoa file thanh cong!");
    }

    public static void main(String[] args) {
        Text text = new Text();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. nhap thong tin sach va luu  chu");
            System.out.println("2. xoa file books.dat va back up sang file khac");
            System.out.println("3. nhap chuong trinh");
            int luachon = sc.nextInt();
            if(luachon==1){
                text.nhapThongTinSach();
            }else if(luachon==2){
                text.Xoa_BackUp();
            }else if(luachon==0){
                break;
            }
        }
    }
}
