package BT_FileBye.bai3;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class text {
    public void ghiDuLieu(ArrayList<Book> bookArrayList){
        try {
            OutputStream outputStream = new FileOutputStream("books.dat");
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            for (Book book:bookArrayList) {
                oos.writeObject(book);
            }
            oos.flush();
            oos.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Book> docDuLieu(){
        ArrayList<Book>books = new ArrayList<>();
        try{
            InputStream inputStream = new FileInputStream("books.dat");
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Object o;
            Book book;
            while((o = ois.readObject())!=null){
                book = (Book) o;
                books.add(book);
            }
            ois.close();
        }catch (Exception e){
        }
        return  books;
    }
    public void backUpFile(String dirpath){
        try {
            OutputStream outputStream = new FileOutputStream(dirpath+"/books-backUp.dat");
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);


            InputStream outputStream1 = new FileInputStream("books.dat");
            ObjectInputStream ois = new ObjectInputStream(outputStream1);


            Object o;
            Book book;
            while((o = ois.readObject())!=null){
                book = (Book) o;
                oos.writeObject(book);
            }
            oos.flush();
            oos.close();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        text text = new text();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1. ghi dữ liệu");
            System.out.println("2. đọc dữ liệu");
            System.out.println("3. xóa file và backup dữ liệu ");
            System.out.println("0. thoát");
            int luachon = sc.nextInt();
            sc.nextLine();
            if(luachon==1){
                ArrayList<Book> books = new ArrayList<>();
                Book book = new Book();
                book.themSach();
                books.add(book);
                text.ghiDuLieu(books);
            }else if(luachon==2){
                ArrayList<Book>books=text.docDuLieu();
                System.out.println("Dữ liệu ");
                System.out.println("-------------------------");
                for (Book book:books) {
                System.out.println(book);
                }
            }else if(luachon==3){
                File file = new File("books.dat");
                System.out.println("Nhập đường dẫn cần back up sang: ");
                String parth = sc.nextLine();
                text.backUpFile(parth);
                file.delete();
                if(file.exists())
                    System.out.println("Xóa file không thành công !");
                else
                    System.out.println("Xóa file thành công! ");
            }else if(luachon==0){
                break;
            }
        }
    }
}
