package JavaSwing.BTVN.Bai11.File;

import JavaSwing.BTVN.Bai11.Student;

import java.io.*;
import java.util.ArrayList;

public class MyFile {
    public void WriteFile(String name,ArrayList<Student> obj){
        try{
            FileOutputStream fileOutputStream = new  FileOutputStream ("D:\\Java advanced\\JavaSwing\\BTVN\\Bai11\\File\\"+name);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            for (int i=0;i<obj.size();i++){
                oos.writeObject(obj.get(i));
                oos.reset();
            }
            oos.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Student> ReadFile(String name){
        try{
            ArrayList<Student> students = new ArrayList<>();
            FileInputStream fileInputStream = new FileInputStream("D:\\Java advanced\\JavaSwing\\BTVN\\Bai11\\File\\"+name);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            while (true) {
                try {
                    Student s = (Student) ois.readObject();
                    students.add(s);
                } catch (EOFException e) {
                    // Đã đọc hết dữ liệu, thoát khỏi vòng lặp
                    break;
                }
            }
            ois.close();
            fileInputStream.close();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public MyFile() {
    }
}
