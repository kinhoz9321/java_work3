package test.main;

import java.util.Scanner;

public class MainClass02_4 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("나눌 수 입력 : ");
		String inputNum1=scan.nextLine();
		System.out.println("나누어지는 수 입력 : ");
		String inputNum2=scan.nextLine();
		
		try {
			
			//입력한 숫자 형식의 문자열을 실제 정수로 바꾸기
			int num1=Integer.parseInt(inputNum1);
			int num2=Integer.parseInt(inputNum2);
			
			//정수를 정수로 나누면 소수점은 짤리고 정수만 남는다. (나는 몫만 구해진다.)
			int result1=num1/num2;
			int result2=num1%num2;//나머지 값 구하기
			
			System.out.println(num2+" 를"+num1+" 으로 나눈 몫은"+result1);
			System.out.println(num2+" 를"+num1+" 으로 나눈 나머지는"+result2);
		
		}catch (NumberFormatException nfe) {
			
			nfe.printStackTrace();
			System.out.println("숫자 형식에 맞게 입력하세요.");
			
		}catch (ArithmeticException ae) {
			
			ae.printStackTrace();
			System.out.println("0 이외의 숫자를 입력 하세요.");
			
		}catch (Exception e) {
			
			//모든 종류의 예외를 한번에 처리하겠다. 상속
			e.printStackTrace();
			
		}finally {
			
			System.out.println("마무리 작업을 합니다.");
			
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
/* 
 * [try catch finally문법의 완성]
 * - Exception finally 추가
 * - finally 를 쓸 때도 try 가 있어야 한다. 
 * 
 * [가능한 try 문법]
 * try...catch
 * try...finally
 * try...catch...finally
 * 
 * [try]
 * 기본적으로 맨 먼저 실행되는 코드(예외가 발생할지도 모를 코드를 정의하는 역할)
 * 여기에서 발생한 예외는 catch 블록에서 처리
 * 
 * [catch]
 * 예외가 발생할 경우 호출되는 문장 블록
 * try 블록에서 발생한 예외 코드나 예외 객체를 인수로 전달받아 그 처리를 담당
 * 다른 제어문과는 달리 예외 처리문은 중괄호({})를 생략할 수 없습니다.
 * 
 * [finally]
 * 앞서 try 블록에서 일어난 일에 관계없이 
 * 항상 실행이 보장되어야 할 뒷정리용 코드가 포함되는 블록.
 * 이 블록은 try 블록에서 예외가 발생하건 안 하건 맨 마지막에 무조건 실행
 * finally에는 데이터베이스와의 연결을 끊어주는 코드를 주로 삽입.
 */