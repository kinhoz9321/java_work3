package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Cat;
import test.mypac.Zoo.Monkey;

public class MainClass01 {
	public static void main(String[] args) {
		
		/*
		 *  Zoo 클래스에 있는 getMonkey() 메소드를 호출해서
		 *  리턴되는 참조값을 m1 이라는 지역 변수에 담아 보세요.
		 */
		
		Zoo z1=new Zoo();
		Monkey m1=z1.getMonkey();
		m1.say();
		
		Monkey m2=new Zoo().getMonkey();
		m2.say();
		
		Zoo z2=new Zoo();
		Cat c1=z2.getCat();
		c1.say();
		
		Cat c2=new Zoo().getCat();
		c2.say();
	}
}
