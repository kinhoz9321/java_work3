package test.main;

import test.mypac.MyUtil;

public class MainClass03 {
	public static void main(String[] args) {
		
		MyUtil Util=new MyUtil();
		
		//MyUtil 클래스에 정의된 static 메소드 호출하기
		MyUtil.playMusic();
		
		//MyUtil 클래스에 정의된 static 필드 참조해서 값 대입하기 
		MyUtil.owner="김구라";
		
		System.out.println("hello!");
	}
}
/*
 * static을 붙이면 .만 찍어도 Method를 호출할 수 있다.
 * new로 객체를 생성할 필요가 없음. static = only one. 오직 한개만 있어야 한다.
 */










