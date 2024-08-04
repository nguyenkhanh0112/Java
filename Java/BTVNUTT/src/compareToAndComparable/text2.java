package compareToAndComparable;

import java.util.Arrays;

public class text2 {
    public static void main(String[] args) {
        String s = "Xin chao cac ban, tui la nguyen van khanh ";
        String[] a = s.split(" ");
        System.out.println(Arrays.toString(a));

        String[] b = s.split(",");
        System.out.println(Arrays.toString(b));

        String s2= "Xin chao,minh la nguyen van khanh. minh la lap trinh vien!";
        String[] c=s2.split("\\.|\\,");
        System.out.println(Arrays.toString(c));

        String s3 = "Nguyen Van khanh";
        String[] d= s3.split(" ");
        System.out.println(Arrays.toString(d));
        System.out.println("ten: "+d[d.length-1]);
    }
}
