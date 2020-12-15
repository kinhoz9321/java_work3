package test.main;

/*
 *  [ java 참조 데이터 type ]
 *  
 *  String type
 *  
 *  - 문자열을 다룰때 사용하는 데이터 type 이다.
 *  - 참조 데이터 type 변수에는 참조값(id) 값이 들어 있다.
 */

public class MainClass07 {
	public static void main(String[] args) {
		
		System.out.println("main 메소드가 시작 되었습니다.");
		
		// "김구라" 라는 String type 참조값을 name 이라는 지역변수에 대입 
		String name="김구라";
		
		// name 안에 들어 있는 참조값을 myName 이라는 새로운 변수에 대입
		String myName=name;
		
		/* 
		 * "원숭이" 라는 String type 참조값을 name 에 덮어쓰기(새로대입)
		 * 디버그를 돌려보면 name의 참조값이 바뀜을 알 수 있다.
		 */
		name="원숭이";
		
		// String type 참조값이 들어 갈수 있는 지역변수 name 을 빈상태로 만들기 
		name=null;
		
		// null 은 참조 데이터 type 이 들어 갈수 있는 빈 공간을 의미한다. 
	}
}
/*
 * 결과
 * name=null;
 * myName="김구라";
 * 
 * 종이의 복사와 사물함 키 복사의 차이를 잊지말기.
 * 이건 종이의 복사
 * 
 * 변수 myName의 값에 변수 name의 값이 복제된 것.
 * 둘은 서로 다른 종이이다.
 * 그러므로 종이 하나(name)의 값이 바뀌어도 다른 하나(myName)는 값이 변하지 않는다.
 * 
 *  name과 myName이 같아지는 key값의 복사는 무엇이지? 같은 곳을 바라보는 것.
 */







