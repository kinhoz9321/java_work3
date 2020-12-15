package test.main;

import test.war.Marine;
import test.war.Pentagon;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 *  [ 프로그래밍의 목적 ]
		 *  
		 *  1. 사령부에서 전쟁을 선언하고
		 *  2. 마린을 움직여서
		 *  3. 마린으로 공격하고
		 *  4. 사령부에서 전쟁을 종료 
		 */
		
		//1. static은 new 하지 않는다. 바로 불러옴.
		Pentagon.startWar();
		
		// void는 객체를 생성한 뒤에 불러올 수 있다. 참조값을 생성.
		Marine m1=new Marine();
		//2.
		m1.move();
		//3.
		m1.attack();
		
		//4. 
		Pentagon.endWar();
	}
}
/* 
 * <알아두기!>
 * 자바는 수많은 클래스와 객체의 도움을 받아서 프로그램을 완성시킨다.
 * 어떤 클래스에 어떤 메소드가 필요한지를 배워서 그것들을 적당히 조합시켜야 한다.
 */



