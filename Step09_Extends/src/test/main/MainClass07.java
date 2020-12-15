package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass07 {

	public static void main(String[] args) {
		MainClass07.usePhone(new Phone());
		MainClass07.usePhone(new HandPhone());
		MainClass07.usePhone(new SmartPhone());
	}
	
	public static void usePhone(Phone p) {
		p.call();
		
		if(p instanceof HandPhone) {
			HandPhone p2=(HandPhone)p;
			p2.mobilecall();
		}
		
		/* 
		 if문 해석
		 - p 안에 들어있는 것이 HandPhone 타입이 맞다면 
		 p를 핸드폰 타입으로 캐스팅해서 p2에 대입시킨 다음 
		 mobilecall();을 호출하겠다.
		 */
	}
}
/*
 instanceof (연산자)
 - true / false 로 결과값을 받음.
 - p instanceof HandPhone = 만일 p안에 있는 값이 HandPhone type이 맞다면
 - 객체(p)가 특정 클래스(HandPhone)에 속하는지 아닌지를 확인할 수 있다. 
 - instanceof는 상속 관계도 확인해준다.
 */
