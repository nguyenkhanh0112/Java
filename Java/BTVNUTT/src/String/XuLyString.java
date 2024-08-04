package String;

public class XuLyString {
    public static void main(String[] args) {
        String s1 = "Nguyen van ";
        String s2="Khanh";
        String s3=s1 +s2;
        // ham concat => noi chuoi
        String s4 = s1.concat(s2);
        System.out.println("s3 = "+s3);
        System.out.println("s4 = "+s4);

        // ham replace => thay the
        String s5 = "Nguyen Van Khanh";
        String s6;
        s6=s5.replace(" ","");
        System.out.println(s6);

        //toLowerCase ==> ham chuyen viet thuong
        //toUperCase ==> ham chuyen viet hoa
        s3= s3.toLowerCase();
        s4=s4.toUpperCase();
        System.out.println("s3 = "+s3);
        System.out.println("s4 = "+s4);

        //trim() => xoa khoang trang du thua o dau chuoi
        String s9 = "   Xin chao cac ban, minh la nguyen van khanh dep trai cu te xiu  ";
        System.out.println(s9.trim());

        //subString => cat chuoi con
        String s10 = "Xin chao cac ban, Minh la nguyen van khanh dpe trai";
        String s11=s10.substring(0,16);
        String s12=s10.substring(16);
        System.out.println(s11);
        System.out.println(s12);
    }
}
