package test.main;

import java.util.Random;

/* 
 * 프로그래머가 직접 예외 클래스를 정의하고
 * 필요한 시점에 예외를 발생 시킬수도 있을까?
 * 
 * Exception or RuntimeException 클래스를 상속 받으면 가능하다!
 */

public class MainClass05 {
	//random 객체에 대입할 num 배열 생성 (콘솔에 숫자를 확인하기 위한 용도)
	static int[] num= {0,1,2};
	
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		//랜덤 객체 생성
		Random ran=new Random();
		int ranNum=ran.nextInt(3);
		
		//우연히 0이 나오면 throw 예약어를 이용해서 HeadacheException 발생 시키기
		if(ranNum==0) {
			throw new HeadacheException("머리 아퍼!");
			//"머리 아퍼!" = String msg
		}
		
		//HeadacheException 이 발생하지 않음을 확인하기 위한 용도
		int three=num[ranNum];
		
		System.out.println(three);
		System.out.println("main 메소드가 종료 됩니다.");
		
	}
	
	//머리 아픈 Exception 클래스 생성
	static class HeadacheException extends RuntimeException{
		
		//예외 메세지를 String type 으로 전달 받는 생성자
		public HeadacheException(String msg) {
			
			//부모 생성자에게 전달해야 한다.
			super(msg);
		}
	}
}
/*
static 메소드 안에서 class를 사용하려면 
외부클래스에 한해서 static이 붙어있어야 한다.
*/