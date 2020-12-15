package test.main;

import test.mypac.Phone;

public class MainClass08 {

	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		Phone p1=null;//nullpointerException 발생
		Phone p2=new Phone();
		
		MainClass08.usePhone(p1);
		
		System.out.println("main 메소드가 종료되었습니다.");
	}
	
	//여기에서 NullPointerException 을 방지하는 방법이 있을까요?
	public static void usePhone(Phone p) {
		
		if(p != null) {
			p.call();
		}
		
	}
}
