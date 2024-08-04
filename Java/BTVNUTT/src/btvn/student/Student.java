package btvn.student;

import java.util.Scanner;

public class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void getInfo(){
        String s= "name: "+this.name+"\n"+
                "id: "+this.id+"\n"+
                "group: "+this.group+"\n"+
                "email: "+this.email+"\n";
        System.out.println(s);
    }

    public Student(){
        this.name = "Student";
        this.id="000";
        this.group="K72HT21";
        this.email="K72HT21@gmail.com";
    }
    public Student(String name,String id,String group,String email){
        this.name = name;
        this.email=email;
        this.group = group;
        this.id=id;
    }
    public Student(Student student){
            this.name= student.name;
            this.id=student.id;
            this.group=student.group;
            this.email=student.email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
