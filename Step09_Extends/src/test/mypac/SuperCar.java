package test.mypac;

import test.auto.Car;
import test.auto.Engine;

public class SuperCar extends Car {
	
	//Engine type을 전달받는 생성자 (부모 클래스 Car type에 필요)
	//상속 받을 때 오류가 난다면 오류에 마우스를 올려보자. 
	//자식 클래스는 부모의 필드와 메소드를 얼마든지 호출할 수 있다.
	public SuperCar(Engine engine) {
		super(engine);
	}
	
	/* 
	 super();
	 부모 생성자에게 필요한 값을 자식 생성자가 받아서 전달해주는 문법.
	 부모 생성자를 호출하는 표현식. 
	 */
	
	//빨리 달리는 메소드
	public void driveFast() {
		
		if(this.engine==null) {
			
			System.out.println("Engine 객체가 없어서 달릴 수가 없어요");
			return; //메소드 끝내기
			
		}
		System.out.println("엄청 빨리 달려요!");
	}
}

/*
<알아두기> - 클래스 명에 대하여

 SuperCar = test.mypac.SuperCar (풀네임)
 
 전세계에는 동일한 클래스명이 많다.
 동일한 클래스명을 구분짓기 위해 패키지명까지 함께 말해준다.
 패키지 명에는 주로 회사명이 들어간다.
 ex) 
 com.acon.car.SuperCar
 net.daum.car.SuperCar
 
  - 그러므로 임포트 할 때 패키지명까지 꼭 확인을 해야한다!
 */
