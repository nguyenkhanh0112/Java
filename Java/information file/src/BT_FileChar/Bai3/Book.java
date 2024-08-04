package BT_FileChar.Bai3;

import java.util.Scanner;

public class Book {
    private String id;
    private String authors;
    private String title;
    private String  category;

    public Book() {
    }

    public Book(String id, String authors, String title, String category) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap id: ");
        this.id = sc.nextLine();
        System.out.println("nhap authors(tac gia): ");
        this.authors =sc.nextLine();
        System.out.println("nhap title(tieu de): ");
        this.title = sc.nextLine();
        System.out.println("nhap category(the loai)- tap chi,KHXH,KHTN: ");
        this.category=sc.nextLine();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", authors='" + authors + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
