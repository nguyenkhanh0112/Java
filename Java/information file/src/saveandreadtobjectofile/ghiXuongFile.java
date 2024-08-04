package saveandreadtobjectofile;
import java.io.*;


public class ghiXuongFile  {
    public static void main(String[] args) {
        String data ="Hello, world!";
       try{
           File file = new File ("D:\\Java\\information file\\doc.txt");
           FileOutputStream os = new FileOutputStream(file);
           ObjectOutputStream oos = new ObjectOutputStream(os);

           SinhVien sv = new SinhVien("72DCHT20020","Adonis Feed",2003,10);
           oos.writeObject(data);
           oos.flush();
           oos.close();
           os.close();
           System.out.println("Dữ liệu đã thêm thanành công ");
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }
}
