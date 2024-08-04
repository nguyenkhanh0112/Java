package String;

public class SoSanh_String {
    public static void main(String[] args) {
        String s1 ="khanhdan:))";
        String s2 = "KHANHDAN:))";
        String s3 ="khanhdan:))";
        // ham equals => so sanh 2 chuoi giong nhau,co phan biet hoa thuong
        System.out.println("s1 equals s2: "+s1.equals(s2));
        System.out.println("s1 equals s3: "+s1.equals(s3));
        // ham equalsIgnoreCase, so sanh ko phan biet hoa thuong
        System.out.println("s1 equalsIgnoreCase s2: "+s1.equalsIgnoreCase(s2));
        System.out.println("s1 equalsIgnoreCase s3: "+s1.equalsIgnoreCase(s3));

        // ham compareTo ==> so sanh > < =
        String sv1 = "Nguyen van A";
        String sv2 = "Nguyen Van B";
        String sv3 = "Nguyen Van";
        String sv4 = "Nguyen van A";
        System.out.println("sv1 compareTo sv4: "+sv1.compareTo(sv4));
        System.out.println("sv1 compareTo sv3: "+sv1.compareTo(sv3));
        System.out.println("sv1 compareTo sv2: "+sv1.compareTo(sv2));

        // ham compareToIgnoreCase ==> tuong tu ham compareTo,khong phan biet chu thuong
        // ham regionMatches => so sanh mot doan
        String r1 = "TITV.vn";
        String r2 = "TV.v";
        boolean check = r1.regionMatches(2,r2,0,4);
        System.out.println(check);

        // ham startwith => Ham kiem tra chuoi bat dau bang ......
        String sdt = "037456789";
        System.out.println(sdt.startsWith("037"));
        System.out.println(sdt.startsWith("034"));

        // ham endWith ==> ham kiem tra chuoi ket thuc bang ......
        String tenFile = "my love forever.JPG";
        String tenFile2 = "hoc java.PDF";
        if(tenFile.endsWith(".JPG")){
            System.out.println("File 1 la hinh anh");
        }else if(tenFile.endsWith(".PDF")){
            System.out.println("File 1 la file PDF!");
        }

    }
}