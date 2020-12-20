package test.main;

import java.util.Scanner;

public class MainClass02_1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("나눌 수 입력 : ");
		String inputNum1=scan.nextLine();
		System.out.println("나누어지는 수 입력 : ");
		String inputNum2=scan.nextLine();
		
		//입력한 숫자 형식의 문자열을 실제 정수로 바꾸기
		int num1=Integer.parseInt(inputNum1);
		int num2=Integer.parseInt(inputNum2);
		
		//정수를 정수로 나누면 소수점은 짤리고 정수만 남는다. (나는 몫만 구해진다.)
		int result1=num1/num2;
		int result2=num1%num2;//나머지 값 구하기
		
		System.out.println(num2+" 를"+num1+" 으로 나눈 몫은"+result1);
		System.out.println(num2+" 를"+num1+" 으로 나눈 나머지는"+result2);
	}
}
/*
발생할 수 있는 예외
1. ArithmeticException
- 0을 넣으면 발생하는 익셉션

2. NumberFormatException
- 숫자 대신 한글을 넣으면 발생하는 익셉션
*/