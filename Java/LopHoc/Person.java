package LopHoc;

import java.util.Scanner;

public class Person {
	private String name;
	private String address;
	private String department;
	
	
	public Person() {}
	
	public Person(String name, String address, String department) {
		this.name = name;
		this.address = address;
		this.department = department;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	public void print() {
		System.out.print(name+" - "+address+" - "+department);
	}
	
	public void Input() {
		System.out.print("Nhap ho va ten: ");
		this.setName(new Scanner(System.in).nextLine());
		
		System.out.print("Nhap dia chi: ");
		this.setAddress(new Scanner(System.in).nextLine());
		
		System.out.print("Nhap phong ban: ");
		this.setDepartment(new Scanner(System.in).nextLine());
		
	}
}
