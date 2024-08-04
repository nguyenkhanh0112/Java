package String;

import java.util.Scanner;

public class method_String {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s;
        System.out.println("nhap vao chuoi ");
        s =sc.nextLine();
        System.out.println("------------");
        // ham length()=>> lay do dai cua chuoi
        System.out.println(s.length());
        int doDai=s.length();
        // ham charAt(vitri)==> lay ra 1 ky tu tai vi tri
        for (int i = 0; i < doDai; i++) {
            System.out.println("vi tri "+i+" la: "+s.charAt(i));
        }
        // hàm getchars(begin,end,arr,vitri bat dau)
        char[] arrChar = new char[5];
        s.getChars(2,4,arrChar,0);
        for(int i=0;i< arrChar.length;i++){
            System.out.println("Gia tri cua mang tai "+i+" la: "+arrChar[i]);
        }
        // ham getbytes => co 3 canh lay, lay ra gias tri cua cac ky tu
        byte[] arrayBytes = s.getBytes();
        for (byte b:arrayBytes) {
            System.out.println(b);
        }
    }
}