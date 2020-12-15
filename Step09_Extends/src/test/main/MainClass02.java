package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass02 {
		
	/*
	 [ 다형성 ] polymorphism
	 
	 - 객체는 여러가지 type을 가질 수 있다.
	 - 상속 관계에 따라서 여러가지 type이 된다.
	 - 아래의 HandPhone 객체는 3가지 type을 가진다.
	 */
	
	public static void main(String[] args) {
		
		//HandPhone 객체를 생성해서 참조값을 HandPhone type변수에 담기
		HandPhone h1=new HandPhone();
		
		//HandPhone 객체를 생성해서 참조값을 Phone type변수에 담기
		Phone h2=new HandPhone(); 
		//Phone 클래스 안의 기능만 사용가능
		
		//HandPhone 객체를 생성해서 참조값을 Object type변수에 담기
		Object h3=new HandPhone();
		//Object 클래스 안의 기능만 사용가능
	}
}
/* 
 ex) Phone h2=new HandPhone();
 - 객체는 HandPhone이지만 원한다면 부모타입 Phone으로 받을수도 있다.
 - 이때는 객체 자체는 HandPhone이지만 그것의 참조값이 담긴 h2의 사용 설명서가 Phone. 
 - 사용설명서가 기능을 모두 담지 못해서 기능을 전부 쓸 수가 없다. 그래서 부모 타입인 Phone 타입에 명시된 것만 쓸 수 있다.
 
 다형성
 - 자바의 특징 중 하나.
 - 어떤 객체는 다양한 타입을 가질 수 있다.
 
 <상속(Extends)의 핵심!>
 
 new HandPhone을 하면 Heap영역에
 
 1. Object
 2. Phone
 3. HandPhone
 의 순서대로 객체가 전부 만들어진다.
 
 1,2,3이 하나로 뭉쳐서 (하나의 사물함에 들어감) 하나의 참조값으로 관리가 된다.
 
 그러면 이때는 하나의 객체를 여러개의 타입으로 받을 수 있는 다형성이 나타난다.
 */
