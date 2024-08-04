package btvn.student;

import btvn.Qunalisv.SinhVien;

import java.lang.reflect.Array;
import java.util.*;

public class StudenManagement {
    public static boolean sameGroup(Student st1, Student st2){
        if(st1.getGroup().equals(st2.getGroup())){
            return true;
        }
    return false;
    }
    public static void inDanhSachSinhVien(Student[] st,int n){
        for(int i=0;i<n;i++){
            System.out.println(st[i]);
        }
    }
    public  static  void studenByGroup( ArrayList<Student> st){
        Map<String ,ArrayList<Student>> classMap = new HashMap<>();
        for (Student students: st) {
            if(!classMap.containsKey(students.getGroup())){
                classMap.put(students.getGroup(),new ArrayList<>());
            }
            classMap.get(students.getGroup()).add(students);
        }
        for (String clazz: classMap.keySet()) {
            System.out.println("Group(class): "+clazz);
            for (Student student:classMap.get(clazz)) {
                System.out.println(student);
            }
        }
    }
    public static void inDanhSachSinhVien(ArrayList<Student>students){
        System.out.println("Danh sách sinh viên chưa được sắp xếp theo lớp ");
        for (Student student:students) {
            System.out.println(student);
        }
    }
    public static void removeStudent( ArrayList<Student> st,String s){
        for(int i=0;i<st.size();i++){
            if(st.get(i).getId().equals(s)==true){
                st.remove(i);
            }
        }
        System.out.println("Danh Sach Sinh Vien Sau khi xoa");
        for (Student student:st) {
            //student.getInfo();
            System.out.println(student);
        }
    }

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> st = new ArrayList<Student> ();
        st.add(new Student("Nguyen van khanh","72DCHT20021","72DCHT21","nguyenkhanh1122003@gmail.com"));
        st.add(new Student("Phe bung","72DCHT20023","72DCHT22","phebung1122003@gmail.com"));
        st.add(new Student("Adonis Feed","72DCHT20022","72DCHT22","Adonisfeed1122003@gmail.com"));
        st.add(new Student("3699999","72DCHT20020","72DCHT22","369999@gmail.com"));
        inDanhSachSinhVien(st);
        System.out.println();
        System.out.println("Danh sách sinh viên sắp xếp theo lớp là  ");
        studenByGroup(st);
        System.out.println("nhap id sinh vien can xoa");
        String s = sc.nextLine();
        removeStudent(st,s);

    }
}
/*
        Map<String, List<Student>> classMap = new HashMap<>();
        for (Student student : students) {
            if (!classMap.containsKey(student.getClazz())) {
                classMap.put(student.getClazz(), new ArrayList<>());
            }
            classMap.get(student.getClazz()).add(student);
        }

        // In ra danh sách sinh viên theo từng lớp
        for (String clazz : classMap.keySet()) {
            System.out.println("Class " + clazz + ":");
            for (Student student : classMap.get(clazz)) {
                System.out.println("- " + student.getFirstName() + " " + student.getLastName());
            }
            System.out.println();
        }
    }
 */