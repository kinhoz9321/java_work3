package test.main;

import test.mypac.RealWeapon;
import test.mypac.Weapon;

public class MainClass03_1 {
	
	//Inner Class
	static class AirPlane extends Weapon{

		@Override
		public void attack() {
			System.out.println("공중에서 공격을 해요!");
		}
		
	}
	
	//main 메소드
	public static void main(String[] args) {
		
		//Local Inner Class
		class Sword extends Weapon{

			@Override
			public void attack() {
				System.out.println("칼로 공격을 해요!");
			}
		}
		
		Weapon w1=new Sword();
		MainClass03_1.useWeapon(w1);
		
		Weapon w2=new AirPlane();
		useWeapon(w2);//MainClass03_1 생략
		
		//External Class
		Weapon w3=new RealWeapon();
		useWeapon(w3);//MainClass03_1 생략
	}
	
	//static 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
/*
 Weapon 타입 참조값을 얻어내기 위한 3가지 방법 (번거로움)
 1. Local Inner Class
 2. Inner Class
 3. External Class
 */
