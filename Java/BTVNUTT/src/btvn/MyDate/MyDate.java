package btvn.MyDate;

import java.util.Scanner;

public class MyDate {
    Scanner sc=new Scanner(System.in);
    private int day;
    private int month;
    private int year;

    public MyDate(){}

    public MyDate(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public void nhap(){
        System.out.println("nhap ngay: ");
        this.day= sc.nextInt();;
        System.out.println("nhap thang: ");
        this.month= sc.nextInt();;
        System.out.println("nhap nam: ");
        this.year= sc.nextInt();;
        do{
            if(this.day<=0||this.day>31) {
                System.out.println("loi nhap lai ngay di !!1");
                this.day=sc.nextInt();
            }
            if(this.month<=0||this.month>12) {
                System.out.println("loi nhap lai di !!!");
                this.month=sc.nextInt();
            }
            if(this.year<1) {
                System.out.println("loi nhap lai di !!!");
                this.year=sc.nextInt();
            }
        }while((this.day<=0||this.day>31)||(this.month<=0||this.month>12)||this.year<1);
    }
    public void xuat(){
        System.out.println("day "+this.day+" month "+this.month+" year "+this.year+" ");
    }
}
