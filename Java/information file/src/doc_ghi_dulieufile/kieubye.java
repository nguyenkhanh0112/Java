package doc_ghi_dulieufile;

import java.io.*;

public class kieubye {

    public static void main(String[] args) {

        studen s = new studen("nguyen van khanh",21,9.5);
        String s3 = "Nguyen  van khanh 1122003@gmail.com";
       // Object object = new studen("khanh",21,7.5);
       // String data = object.toString();
       /* try{
            OutputStream outputStream = new FileOutputStream("Data1.txt");
           // BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            //oos.write(s3.getBytes());
           // bos.write(data.getBytes());
            oos.writeObject(s);
            oos.writeObject(s3);
            oos.flush();
            outputStream.close();
            oos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
*/
        try{
            InputStream inputStream = new FileInputStream("Data1.txt");
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            studen studen = (studen) ois.readObject();
            System.out.println("Dữ liệu đọc từ file "+s);
        }catch (Exception e){

        }

    }
}
