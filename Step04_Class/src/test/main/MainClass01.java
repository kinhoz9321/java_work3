package test.main;

import test.mypac.Car;

/* Car.java를 import 해 온 것.
 * 
 * 같은 프로젝트 안에서 다른 패키지에 있는 class를 import 할 수 있다.
 * 
 * <import 생성하는 법>
 * import 하고싶은 class명 뒤에 (ex.Car) 커서를 갖다놓고 Ctrl+spacebar 치기.
 * 그리고 class 선택하면 import가 생성된다.
 * 
 * import를 해야 생성된 class로 data type을 만들 수 있다. 
 */

public class MainClass01 {
	public static void main(String[] args) {
		
		//Car type 의 참조값을 담을수 있는 빈 지역 변수 car1 만들기 
		Car car1=null;
		
		/*
		 * car1 이라는 지역 변수 만들어서 null(빈 공간)담기
		 * 
		 * 오늘 우리가 배워야 할 key point!
		 * Car type이 뭘까?
		 * 
		 * car1=10;
		 * car1=true;
		 * car1="kim";
		 * 
		 * 아무것도 car1에 담기지 않는다.
		 * Car data type이 뭘 담을 수 있는지 모르기 때문?
		 */
		
		String a=null;
		
		/* a=10;
		 * a=true;
		 */
		a="kim";
		
		/*
		* String type은 ""을 사용한 문자열을 집어넣어야 하기 때문에 
		* a에 들어갈 수 있는 값은 문자열 "kim" 뿐이다.
		*/
		
		//Car 클래스로 객체를 생성(new)하고 그 생성된 객체의 참조값을 car1 에  대입하기
		car1=new Car();
		
		/*
		 * <객체 생성>
		 * 지역변수명 = new(예약어) class명();
		 * 
		 * 참조값을 지역변수에 담아두는 이유
		 * - 나중에 사용하기 위해서.
		 * 
		 * .을 찍어서 기능을 호출하거나 저장소를 정의하는 것으로 쓰인다.
		 * 
		 * <알아두기>
		 * - 지역변수는 stack 영역에 만들어진다.
		 * (car1은 stack 영역에 만들어진다.)
		 */
		
		//car1 지역 변수에 있는 참조값을 이용해서 메소드 호출하기 
		car1.drive();
		car1.hotHip();
		
		/*
		 * car1.
		 * class는 정의만 해도 기본 기능이 9개가 생긴다. 
		 * object class를 상속받게 되어있기 때문.
		 * 하지만 그 외에도 우리가 기능(field)을 만들어내서 추가할 수 있다.
		 * ex. drive();, hothip();
		 */
		
//		boolean isEnd=true;
//		if(isEnd) {
//			.return;
//		}
//		
//		* Method는 더 이상 수행할 것이 없으면 자신이 시작했던 곳 (호출했던 곳)으로 리턴한다.
//		return 위치를 따로 지정하려면 return이라는 예약어를 이용해야한다.
	}
}

/*
 * Q. 객체는 함수인가요?
 * - 객체는 함수가 아닙니다.
 * - 객체는 object. 자바스크립트의 object와 비슷하다고 생각하면 된다.
 * 
 * class = 객체의 설계도 역할. 객체가 어떤 field와 method를 가질지 정의하는 것. 정의는 개발자가 한다. 
 * *** 객체 안에는 field(저장소)와 method(기능)가 있음. ***
 * 
 * 하나의 class에 객체 여러개가 필요할 때가 있다. 그러면 하나의 class에서 new해서 여러개를 만들어서 쓰면 된다.
 * *** class명의 첫글자는 대문자로, package명의 첫글자는 소문자로 짓는 것이 관례! ***
 */



