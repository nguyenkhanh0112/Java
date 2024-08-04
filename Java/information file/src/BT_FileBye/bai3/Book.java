package BT_FileBye.bai3;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private String id;
    private String authors;
    private String title;
    private String category;

    public Book(){

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
    public void themSach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id: ");
        this.id = sc.nextLine();
        System.out.println("Nhập authors(tác giả): ");
        this.authors =sc.nextLine();
        System.out.println("Nhập title(tiêu đề): ");
        this.title = sc.nextLine();
        System.out.println("Nhập category(thể loại) - tạp chí,KHXH,KHTN,Luận văn: ");
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
