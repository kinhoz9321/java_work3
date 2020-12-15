package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass11 {

	public static void main(String[] args) {
		
		/* 
		 * 콘솔창을 확인해서 부모객체가 미리 만들어지는 것을 확인하세요.
		 */
		
		System.out.println("main  메소드가 시작되었습니다.");
		
		Phone p1=new Phone();
		System.out.println("--------------");
		Phone p2=new HandPhone();
		System.out.println("--------------");
		Object p3=new SmartPhone();
		System.out.println("--------------");
		Phone p4=new SmartPhone();
		System.out.println("--------------");
		SmartPhone p5=new SmartPhone();
		System.out.println("--------------");
		
		System.out.println("main 메소드가 종료되었습니다.");
		
		
	}

}
/* 
호출의 순서가 
Phone 
HandPhone
SmartPhone 
순서.

부모객체가 먼저 만들어진다는 소리.
 */