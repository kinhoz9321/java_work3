package test.main;

import test.mypac.RealWeapon;
import test.mypac.Weapon;

public class MainClass03_2 {
	
	//내부 클래스에 한해서 필요하다면 static 예약어를 붙일 수 있다.
	static class AirPlane extends Weapon{

			@Override
			public void attack() {
				System.out.println("공중에서 공격을 해요!");
			}
			
		}
	
	public static void main(String[] args) {
		
		//static 메소드 안에서 만들어졌기 때문에 static 필요없음
		class Sword extends Weapon{

			@Override
			public void attack() {
				System.out.println("칼로 공격을 해요!");
			}
		}
		
		//Sword 객체를 생성해서 참조값을 Weapon type으로 받기
		Weapon w1=new Sword();
		useWeapon(w1);
		/*
		 useWeapon에 static이 없으면 new MainClass03();
		 */
		
		//AirPlane 객체를 생성해서 참조값을 Weapon type으로 받기
		Weapon w2=new AirPlane();
		useWeapon(w2);
		/*
		 static class AirPlane에 static이 없으면 new AirPlane();은 오류가 난다. 
		 static 클래스 안에서는 static 자원만 참조가 가능하기 때문이다.
		 */
		
		//RealWeapon 객체를 생성해서 참조값을 Weapon type으로 받기
		Weapon w3=new RealWeapon();
		useWeapon(w3);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}

