package step02.model.domain;

import lombok.Data;

@Data
public class Car {
	// Bean 조건 : 기본 생성자, private, getter/setter
	private int carNo;
	private String carName;
	
	public Car() {
		System.out.println("Car 기본 생성자");
	}
	public Car(int carNo,String carName) {
		this.carNo = carNo;
		this.carName = carName;
		
	}
}
