package btvn;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*
moi nguoi chs co 1 tai khoan. quyen dat ten so tien it hon hoac bang so tien ho dang co
luat chs nhuw sau:
co 3 vien xucs sac  . moi vien xuc sac co 6 mat co gia tri tu 1 den 6
moi lan lac se ra 1 ket qua. ket qua = x1 + x2 +x3;
tong = 3 hoac 18 =>> cai an het ,nguoi chs thua
2. tong = (4->10)<=> neu nguoi ch dat xiu nguoi chs thang,nguoc laij nguoi chs thua
3. net tong = (11-17) <-> tai=> neu nguoi ch datj xiu thi nguoi chs thang ,nguoc lai nguoi chs thua

 */
public class Tai_Xiu {
    public static void main(String[] args) {
        double taikhoangnguoichs =5000000;
        Scanner sc = new Scanner(System.in);
        int luachon ;
        do{
            System.out.println("-----------HELLO,XIN CHAO DEN VOI GAME CUA TOI---------------");
            System.out.println("=>Neu ban muon choi hay chon so 1 de tiep tuc ");
            System.out.println("Ban muon thoat game hay nhan phim 0");
            luachon=sc.nextInt();
            Locale lc = new Locale("vi","VN");
            NumberFormat numf= NumberFormat.getCurrencyInstance(lc);
            //NumberFormat numf= NumberFormat.getNumberInstance(lc);
            if(luachon==1){
                System.out.println("Chao mung ban den voi cho chs ca cuoc tai xiu cua minh,h chung ta cung bat dau luon nhe ^_^ ");
                System.out.println("*****Tai khoan cua ban hien co: "+numf.format(taikhoangnguoichs)+" ban muon cuoc bao nhieu? ");
                double datCuoc=0;
                do{
                    System.out.print("Nhap so tien ban muon dat cuoc: ");
                    datCuoc=sc.nextDouble();
                    if(datCuoc>taikhoangnguoichs){
                        System.out.println("so tien ban cuoc hien chua du,hay nhap so tien nho hon ");
                    }
                    if(datCuoc<=0){
                        System.out.println("so tien cua ban da het,hay nap them tien de tiep tuc");
                        break;
                    }
                }while(datCuoc>taikhoangnguoichs);
                int luachontaixiu=0;
                do{
                    System.out.println("***** Chon: 1 <=> Xiu Hoac 2<=> Tai");
                    luachontaixiu=sc.nextInt();
                    if(luachontaixiu!=1&&luachontaixiu!=2)
                        System.out.println("ban nhap sai lua chon roi, hay nhap lai giup minh nhe ");
                }while(luachontaixiu!=1&&luachontaixiu!=2);

                // tung xuc xac
                Random xucXac1 = new Random();
                Random xucXac2 = new Random();
                Random xucXac3 = new Random();
                int giaTri1=xucXac1.nextInt(5)+1;
                int giaTri2=xucXac2.nextInt(5)+1;
                int giaTri3=xucXac3.nextInt(5)+1;

                // tinh toan kequa;
                int tong = giaTri3+giaTri1+giaTri2;
                System.out.println("ket qua: "+giaTri1+"-"+giaTri2+"-"+giaTri3);
                if(tong == 3 || tong ==18){
                    taikhoangnguoichs-=datCuoc;
                    System.out.println("***tong la: "+tong+"=>nha cai an het,ban thua roi!");
                    System.out.println("****tai khoan cua ban con: "+numf.format(taikhoangnguoichs));
                }else if(tong>=4&&tong<=10){
                    if(luachontaixiu==1){
                        taikhoangnguoichs+=datCuoc;
                        System.out.println("*****chuc mung ban, ban da thang!");
                        System.out.println("*****so tien cua ban la "+numf.format(taikhoangnguoichs));
                    }else{
                        taikhoangnguoichs-=datCuoc;
                        System.out.println("*****rat tiec, ban da thua chuc ban may man lan sau!");
                        System.out.println("*****so tien cua ban la "+numf.format(taikhoangnguoichs));
                    }
                }else{
                    if(luachontaixiu==2){
                        taikhoangnguoichs+=datCuoc;
                        System.out.println("*****chuc mung ban, ban da thang!");
                        System.out.println("*****so tien cua ban la "+numf.format(taikhoangnguoichs));
                    }else{
                        taikhoangnguoichs-=datCuoc;
                        System.out.println("*****rat tiec, ban da thua chuc ban may man lan sau!");
                        System.out.println("*****so tien cua ban la "+numf.format(taikhoangnguoichs));
                    }
                }
            }
        }while(luachon==1);
    }
}
