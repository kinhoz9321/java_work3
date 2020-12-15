package test.main;

import test.mypac.MyObject;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		
		//MyObject 클래스에 있는 usePhone()메소드를 호출해보세요.
		
		/* 1 */
		//1. MyObject 객체 생성. 참조값을 얻어낸다.
		MyObject m1=new MyObject();
		
		//2. Phone 객체를 생성. 조건을 맞춘다. (매개변수)
		Phone p1=new Phone();
		//usePhone(Phone p)
		
		//3. usePhone()메소드를 호출한다.
		m1.usePhone(p1);
		
		/* 2 */
		//위와 동일한 작업을 2줄의 코딩으로 한다면?
		MyObject m2=new MyObject();
		m2.usePhone(new Phone());
		// 직접 생성해서 전달
		
		/* 3 */
		//위와 동일한 작업을 1줄의 코딩으로 한다면?
		new MyObject().usePhone(new Phone());
		
		/* 일회성 코딩. 한번 쓰고 말 코드라면 변수에 담을 필요가 없다.
		 * 이 줄 전체는 void. 타입이 없다. 
		 * 타입이 없다는 건 변수를 설정할 수 없어서 담을 수가 없다는 것. 
		 */
	}
}
