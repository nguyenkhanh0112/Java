package LopHoc;

import java.util.Scanner;

public class Student extends Person {
	private String className;
	
	public Student() {}
	
	public Student(String name, String address, String department, String className) {
		super(name,address,department);
		this.className = className;
	}
	
	public String getclassName() {
		return className;
	}
	
	public void setclassName(String className) {
		this.className = className;
	}
	
	
	public void print() {
		super.print();
		System.out.println(" - "+className);
	}
	
	public void Input() {
		super.Input();
//		System.out.print("Nhap ten lop: ");
//		this.setclassName(new Scanner(System.in).nextLine());
	}
}
