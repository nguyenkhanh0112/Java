package JavaSwing.BTVN.Bai11;

import java.io.Serializable;
import java.util.ArrayList;

public class Class {
    private String nameClass;
    private ArrayList<Student> studentArrayList;

    public Class() {
    }

    public Class(String nameClass) {
        this.nameClass = nameClass;
        this.studentArrayList = new ArrayList<>();
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    public Class(String nameClass,ArrayList<Student>arrayList){
        this.nameClass = nameClass;
        this.studentArrayList = arrayList;

    }
    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }
    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }
    public void addStudentArrayList(Student student){
        this.studentArrayList.add(student);
    }
    public void removeStudentArrayList(int i){
        this.studentArrayList.remove(i);
    }
    public void updateStudentArrayList(int i , Student student){
        this.studentArrayList.set(i,student);
    }
    public int sizeStudentArrayList(){
        return this.studentArrayList.size();
    }

    @Override
    public String toString() {
        return  nameClass;

    }
}
