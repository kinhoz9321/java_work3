package test.mypac;

public class HandPhone extends Phone{
	
	//디폴트 생성자
	public HandPhone() {
		System.out.println("HandPhone() 생성자 호출됨");
	}
	
	//이동중에 전화를 걸어요 메소드
	public void mobilecall() {
		System.out.println("이동중에 전화를 걸어요");
	}
	
	//사진을 찍는 메소드
	public void takePicture() {
		System.out.println("30만 화소의 사진을 찍어요");
	}
}
/*
 * extends Object
 * public HandPhone(){}
 * 
 * 보이지 않아도 있는 것들
 */
