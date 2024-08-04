package String;

public class TimChuoiJava{
    public static void main(String[] args) {
        String s1 = "Xin chao co chu, xin chao cac ban! Xin chao";
        String s2 ="Xin chao";
        String s3 = ":D";

        // ham indexOf
        s1.indexOf(s2);
        System.out.println("vi tri cua s2 trong s1: "+s1.indexOf(s2));
        System.out.println("vi tri cua s3 trong s1: "+s1.indexOf(s3));

        // su dung vi tri bat dau
        System.out.println("vi tri cua s2 trong s1: "+s1.indexOf(s2,2));

        // ham lastIndexof==> tim kiem tu phiasang trai
        System.out.println("vi tri cua s2 trong s1(tu phai sang trai): "+s1.lastIndexOf(s2));

    }
}
