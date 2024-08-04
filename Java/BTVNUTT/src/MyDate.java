import java.util.Scanner;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(){}

    public MyDate(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void fullDay(){
        System.out.println("day "+ day + " month "+month+ " year "+year);
    }

    public static void main(String[] args) {
        MyDate myDate = new MyDate();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ngay: ");
        int day = sc.nextInt();
        System.out.println("nhap thang: ");
        int month = sc.nextInt();
        System.out.println("nhap nam: ");
        int year = sc.nextInt();
        myDate.setDay(day);
        myDate.setMonth(month);
        myDate.setYear(year);
        myDate.fullDay();

    }
}
