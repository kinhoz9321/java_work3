package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass03 {

	public static void main(String[] args) {
		
		//SmartPhone 객체를 생성해서 참조값을 부모 type 지역 변수에 대입
		Object p1=new SmartPhone();
//		p1.call(); / call();을 호출할 수 없음.
		
		//대입연산자의 우측을 Phone type으로 casting (형변환) 해서 p1 안에 있는 참조값을 Phone type 변수 p2에 대입하기
		Phone p2=(Phone)p1; //casting
		p2.call();
		
		//대입연산자의 우측을 HandPhone type으로 casting (형변환) 해서 p1 안에 있는 참조값을 HandPhone type 변수 p3에 대입하기
		HandPhone p3=(HandPhone)p1;
		p3.mobilecall();
		p3.takePicture();
		
		//대입연산자의 우측을 SmartPhone type으로 casting (형변환) 해서 p1 안에 있는 참조값을 SmartPhone type 변수 p4에 대입하기
		SmartPhone p4=(SmartPhone)p1;
		p4.doInternet();
		p4.takePicture();
		
		/*
		p1=Object type, p2=Phone type
		타입의 상속이 이루어지고 있는 경우에만 이런 casting이 가능하다.
		*/
	}
}

/*
 casting은 상당히 자주 하는 작업 중 하나
 */
