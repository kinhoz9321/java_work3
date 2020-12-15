package test.mypac;

/* 
 * [ 메소드를 만들 때 고려해야 하는 것 ]
 * 
 * 1. 접근 지정자 (public, protected, default, private)
 * public - 어디서든지 접근 가능한. 공개.
 * private - 객체 혹은 클래스 안에서만. 비공개.
 * 
 * 2. static or non static 
 * static - 메소드가 하나만 있으면 된다.
 * non static - 객체마다 메소드가 하나씩 필요하다.
 * 
 * 3. return type 
 * - void는 어떤 data type도 리턴하지 않는다는 의미.
 * - 자바스크립트는 함수를 호출하면 어떤 값이든 돌려주지만 자바는 돌려주지 않을 수도 있다. 
 * (ex.void 사용시)
 * - return type을 돌려 받으려면 정확히 명시하기.
 * (void, int, double, boolean, String... 등 return type을 정확히 명시해야 한다.)
 * 
 * 4. Method명
 * - 영문자 소문자로 시작하고 예약어가 아니면 된다.
 * 
 * 5. Method에 전달하는 인자의 개수와 데이터 type
 * - 필요하면 적고 아니면 비워둔다.
 * 
 * <Method가 끝날 때>
 * 1. 실행하다가 return이라는 예약어를 만났을 때.
 * 2. 더 이상 수행할 게 없을 때.
 */

public class MyObject {
	
	//어떤 값도 리턴하지 않는 메소드
	public void walk() {
		System.out.println("걸음을 걸어요");
	}
	
	//int type을 리턴하는 메소드
	public int getNumber() {
		int num=0; //변수 타입으로 리턴할 수도 있다. 
		return num; //int type을 리턴하기로 했으면 반드시 int type을 리턴해야 한다.
	}
	
	//String type을 리턴하는 메소드
	public String getGreeting() {
		String greet="안녕하세요";
		return greet;
	}
	
	//House type을 리턴하는 메소드
	public House getHouse() {
		House h1=new House();
		return h1; //or return new house();
	}
	
	//phone type을 전달받는 메소드
	public void usePhone(Phone p) {
		p.call();
	}
	
	/* 
	 * Phone type을 전달받는 static method
	 * static이 붙었을 때는 .을 찍어서 호출하고
	 * non static은 new 해서 호출한다.
	 */
	public static void callPhone(Phone p) {
		p.call();
	}
	
	//House type을 리턴해주는 static 메소드
	public static House buyHouse() {
		return new House();
	}
}
/*
 * 같은 패키지 안에 있는 class 또는 인터페이스는 import하지 않아도 사용할 수 있다.
 */
