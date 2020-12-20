package test.main;

import java.util.Scanner;

public class MainClass01_1 {
	public static void main(String[] args) {
		
		//키보드로 입력받는 코드
		Scanner scan=new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		
		//숫자를 문자열 형식으로 입력 받는다. "10", "20" 등...
		String inputNum=scan.nextLine();
		
		//입력한 숫자를 실제 숫자로 바꾸기 (산술연산을 가능하게 해주는 메소드)
		double num=Double.parseDouble(inputNum);
		
		double result=num+100;
		System.out.println("입력한 숫자+100 :"+result);
	}
}
