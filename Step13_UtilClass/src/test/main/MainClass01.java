package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("입력 : ");
		
		//nextLine() 메소드는 Enter를 치기 전까지 쓴 문자열을 모두 리턴한다.
		String line=scan.nextLine();
		System.out.println("앵무새 : "+line);
	}
}
