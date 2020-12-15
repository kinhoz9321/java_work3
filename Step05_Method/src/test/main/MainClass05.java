package test.main;

import test.mypac.House;
import test.mypac.MyObject;
import test.mypac.Phone;

public class MainClass05 {
	public static void main(String[] args) {
		
		//1. MyObject 클래스의 callPhone() 메소드를 호출해보세요.
		MyObject.callPhone(new Phone());
		
		/*
		callPhone()은 static이라서 .으로 바로 호출.
		Phone 객체는 non static이라서 new 참조값이 필요함.
		*/
		
		//2. MyObject 클래스의 buyHouse() 메소드를 호출하고 리턴되는 참조값을 myHome이라는 이름의 지역변수에 담아보세요.
		House myHome=MyObject.buyHouse();
		
		/*
		 buyHouse()는 House type, static이라서 
		 .으로 호출하고 House type에 담아준다.
		 */
	}
}
