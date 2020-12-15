package test.main;

import test.mypac.RealWeapon;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		
		/* 
		 * 여러분이 직접 Weapon 추상클래스를 상속받은 클래스를 정의해서
		 * 객체 생성을 하고 해당 참조값을 이용해서 
		 * 아래의 useWeapon 메소드를 호출해보세요.
		 * (단, 클래스 명은 MyWeapon말고 다른걸로~)
		 */
		
		//사용하고자 하는 타입으로 받는 게 가장 바람직하다.
		Weapon w1=new RealWeapon();
		MainClass02.useWeapon(w1);
		//MainClass02는 생략이 가능하다.
		
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		
		/*
		 * Weapon 을 import 해왔기 때문에 
		 * w.prepare();
		 * w.attack();을 호출할 수 있다.
		 */
		
	}
}
