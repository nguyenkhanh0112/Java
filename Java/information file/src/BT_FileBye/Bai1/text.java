package BT_FileBye.Bai1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class text {


    public void nhapDuLieu(ArrayList<NhanVien> arrayList){
        try{
            OutputStream outputStream = new FileOutputStream("nhanvien.dat");
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            for (NhanVien nv :arrayList) {
                oos.writeObject(nv);
            }
            oos.flush();
            outputStream.close();
            oos.close();
        }catch (Exception e){
        }
    }
    public ArrayList<NhanVien> docDuLieu(){
        ArrayList<NhanVien> nvArrary = new ArrayList<>();
        try{
            InputStream inputStream = new FileInputStream("nhanvien.dat");
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Object object;
            NhanVien nv;
            while ((object=ois.readObject())!=null){
                nv = (NhanVien)object;
                nvArrary.add(nv);
            }
            ois.close();
            inputStream.close();
        }catch (Exception e){

        }
        return nvArrary;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        text text = new text();
        ArrayList<NhanVien>nhanVienArrayList = new ArrayList<>();
        while(true){
            System.out.println("1. Nhập dữ liệu");
            System.out.println("2. Đọc dữ liệu");
            System.out.println("3. copy nội dung sang file khác");
            int luachon = sc.nextInt();
            sc.nextLine();
            if(luachon==1){
                System.out.println("Nhập số lượng nhân viên ");
                int n = sc.nextInt();
                sc.nextLine();
                for (int i=0;i<n;i++) {
                    System.out.println("Nhập thông tin nhân viên thứ: " + (i + 1));
                    System.out.println("-------------------------------------");
                    NhanVien nv = new NhanVien();
                    nv.nhapThongTin();
                    nhanVienArrayList.add(nv);
                }
                    text.nhapDuLieu(nhanVienArrayList);
            }else if(luachon==2){
                ArrayList<NhanVien> arrayList =  text.docDuLieu();

                for (NhanVien nv : arrayList) {
                    System.out.println(nv);
                }
                try{
                    OutputStream outputStream = new FileOutputStream("nhanvien.obj");
                    ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                    for (NhanVien nv :arrayList) {
                        oos.writeObject(nv);
                    }
                    oos.flush();
                    outputStream.close();
                    oos.close();
                }catch (Exception e){

                }
            }else if(luachon==3){
                System.out.println("chọn tên file cần copy: ");
                String tenFile = sc.nextLine();
                Path path = Path.of("nhanvien.dat");
                Path path1 = Path.of(tenFile);
                try{
                    Files.copy(path,path1, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("File đã được sao chép thành công!");

                }catch (Exception e){

                }
            }
        }
    }

}
