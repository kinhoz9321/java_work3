package test.mypac;

/*
 * 클래스 안에 정의할 수 있는 멤버?
 * 1. 생성자
 * 2. 필드
 * 3. 메소드
 * 4. 클래스
 */

public class Test {
	
	//Inner Class=class 안에 정의하는 class
	public class A{
		
	}
	
	public class B{
		
	}
	
	/*
	 * 메소드 안에 정의할 수 있는 것?
	 * 
	 * 1. 지역변수 (Local Variable)
	 * 2. 지역 내부 클래스 (Local Inner Class)
	 */
	
	//메소드
	public void test1() {
		class C{ //(지역 내부 클래스로) default class 생성
			public void merong() {
				System.out.println("복잡하지롱!");
			}
		}
		
		//지역 내부 클래스 생성 및 메소드 호출
		C a=new C();
		a.merong();
	}
}
