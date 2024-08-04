package JavaSwing.BTVN.Bai9;

import JavaSwing.BTVN.Bai9.Category;

import java.io.*;

public class MyFile {

    public void LuuFile(Category obj){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("data1.data");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(obj);
            oos.close();
            fileOutputStream.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public Category DocFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("data1.data");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            Category category =(Category) ois.readObject();
            ois.close();
            fileInputStream.close();
            return category;
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
