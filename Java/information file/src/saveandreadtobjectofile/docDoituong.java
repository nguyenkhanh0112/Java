package saveandreadtobjectofile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class docDoituong {
    public static void main(String[] args) {
        try{
            File file = new File("\\D:\\Java\\information file\\docc.txt");
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            SinhVien st =(SinhVien) ois.readObject();
            System.out.println(st.getHoVaten());
            System.out.println(st);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}


