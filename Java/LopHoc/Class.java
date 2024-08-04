package LopHoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class {	
	private String name;
	List<Student> studentList = new ArrayList<>(); 
	private int numOfStudents;
	private Teacher advisor;
	
	
	public Class() {}
	public Class(String name, List<Student> studentList, int numOfStudents, Teacher advisor) {
		this.name = name;
		this.studentList = studentList;
		this.numOfStudents = numOfStudents;
		this.advisor = advisor;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public int getNumOfStudens() {
		return numOfStudents;
	}
	
	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}
	
	public Teacher getAdvisor() {
		return advisor;
	}
	
	public void setAdvisor(Teacher advisor) {
		this.advisor = advisor;
	}
	
	
	public void Input() {
		System.out.print("Nhap ten lop: ");
		this.setName(new Scanner(System.in).nextLine());
		System.out.print("Nhap so luong sinh vien: ");
		this.setNumOfStudents(new Scanner(System.in).nextInt());
		Student st = null;
		for(int i = 0; i < this.getNumOfStudens();i++) {
			st = new Student();
			st.Input();
			st.setclassName(this.getName());
			studentList.add(st);
		}
		System.out.println("---Nhap thong tin giao vien chu nhiem---");
		Teacher tc  = new Teacher();
		tc.Input();
		this.setAdvisor(tc);
		
	}
	
	public void print() {
		System.out.println("---------------------------------------------");
		System.out.println("\tTen lop: "+this.getName()+"\tSo luong: "+this.numOfStudents);
		System.out.print("Thong tin GVCN: ");
		this.getAdvisor().print();
		System.out.println();
		System.out.println("-----------Danh sach sinh vien lop-----------");
		Student st = null;
		for(int i = 0; i < studentList.size(); i++) {
			st = studentList.get(i);
			System.out.print(i+1+") ");
			st.print();
		}
	}	
}
