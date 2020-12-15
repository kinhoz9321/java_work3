package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		
		System.out.println("main 메소드가 시작 되었습니다.");
		
		//int type 변수 선언과 동시에 값 대입하기
		int num1=10;
		
		//int type 변수 선언만 하고  (지역 변수는 선언만하면 만들어 지지 않는다)
		int num2; //= 지역 변수
		
		//값은 나중에 대입하기( * 값이 대입되는 시점에 변수가 만들어 진다 * )
		num2=20;
		
		/*
		 *  정수의 표현 가능한 범위 순서
		 *  byte < short < int < long
		 */
		
		int myInt=100;
		byte myByte=100;
		
		// int type 변수에 있는 값을 int type 변수에 대입 (가능)
		int a=myInt;
		
		// byte type 변수에 있는 값을 int type 변수에 대입 (가능)
		int b=myByte;
		
		// int type  변수에 있는 값을 byte type 변수에 대입 (문법 오류)
		//byte c=myInt;
		
		/*
		 *  표현 가능한 범위가 더 넓은 변수(ex.int)에 담긴 내용을 
		 *  표현 가능한 범위가 더 적은 변수(ex.byte)에 대입하려면 
		 *  프로그래머가 대입을 해도 * 문제가 없다는 것을 확인 * 하고
		 *  명시적으로 'casting' 하면 대입이 가능하다 
		 *  ( 개발자 : myInt 안에 있는 숫자는 byte 범위를 절대 넘어가지 않아 ! )
		 */
		
		byte c=(byte)myInt;  //강제 casting 을 하면 대입 가능 
		
		//100 이 저장되어 있는 변수에 200 을 대입하고 
		myInt=200;
		
		//강제 casting 해서 대입 한다면? 
		byte d=(byte)myInt;  //원래 값과 다른 값이 대입된다 (-56)
		
		/*
		 * byte = -128 ~ 127
		 * myInt = 200
		 * 
		 * myInt는 byte가 감당할 수 있는 숫자의 범위를 넘어간다.
		 * 그런 상태에서 강제로 casting을 하면 전혀 다른 숫자가 결과값으로 나타난다.
		 * 이 때 발생하는 결과에 대해서는 개발자의 책임이 된다.
		 * <casting은 정말 * 확실한 경우 * 에만 사용해야 한다.>
		 */
	}
}














