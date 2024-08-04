package text;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;


public class Point {

    public static void main(String[] args) {
        /*
        Scanner sc =new Scanner(System.in);
        double n = sc.nextDouble();
        Locale[] locales = {Locale.US,new Locale("en","IN"),Locale.CHINA,Locale.FRANCE};
        String[] place ={"US","India","China","France"};
        for(int i=0;i<locales.length;i++){
            String money = NumberFormat.getCurrencyInstance(locales[i]).format(n);
            System.out.println(place[i]+": "+money);
        }*/
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        int count = s.length() + s1.length();
        System.out.println(count);
        if(s.compareTo(s1)>0)
            System.out.println("YES");
        else
            System.out.println("No");
        String s3 = s.substring(0,1).toUpperCase()+ s.substring(1);
        String s4 = s1.substring(0,1).toUpperCase()+s1.substring(1);
        System.out.println(s3+" "+s4);
    }
}
