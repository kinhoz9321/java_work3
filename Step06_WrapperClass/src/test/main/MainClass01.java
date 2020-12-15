package test.main;

/*
 * [ 기본 데이터 type에 대응되는 참조 data type ]
 * 
 * 기본 데이터 타입 : 참조 데이터 타입
 * byte : Byte
 * short : Short
 * int : Integer ***
 * long : Long
 * 
 * float : Float
 * double : Double
 * 
 * char : character ***
 * boolean : Boolean
 * 
 * 참조 데이터 타입이지만 기본 데이터 타입처럼 쓸 수 있다.
 * 단지 기능만 갖고 있을 뿐이다.
 */

public class MainClass01 {
	public static void main(String[] args) {
		
		//기본 데이터 타입 int
		int num1=10;
		
		/*
		 * 기본 데이터 타입은 참조값이 없기 때문에 .을 찍어도 기능이 나오지 않는다.
		 */
		
		//참조 데이터 타입 String
		String name="kim";
		
		/*
		 * 참조 데이터 타입은 참조값이 있기 때문에 기능이 나온다.
		 */
		
		//참조 데이터 타입 Integer
		Integer num2=10;
		
		/*
		 * int의 참조데이터 타입 Integer
		 * 참조 데이터 타입이기 때문에 .을 찍으면 기능이 나온다.
		 * 
		 * <알아두기!>
		 * Wrapper Class - 8개의 기본 타입에 해당하는 데이터를 객체로 포장해 주는 클래스.
		 */
		
		int result1=num2+1; //11
		int result2=num1+num2; //20
		Integer result3=num1+num2; //20
		
		/*
		 * integer type의 메소드를 이용해서
		 * 10 => "10" 문자열로 바꾸기
		 */
		String result4=num2.toString();
		
		/*
		 * Integer 클래스의 static 메소드를 이용해서
		 * "999" => 999 정수로 바꾸기
		 */
		int result5=Integer.parseInt("999"); //많이 쓰이는 메소드
	}
}
