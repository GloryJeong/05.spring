package model.domain;

import lombok.Data;

@Data
public class Customer {
	private String name;
	private int age;
	public int getAge() {
		System.out.println(age);
		return age;
	}
	
}
