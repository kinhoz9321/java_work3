package test.main;

import test.mypac.Weapon;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 Weapon 추상 클래스를 상속받은 익명의 local inner 클래스(어나니머스 클래스)를 이용해서 
		 Weapon type의 참조값을 얻어내서 w1이라는 Weapon type의 지역변수에 담기
		 
		 - 원래 추상 클래스는 단독으로 객체 생성이 불가능하다. 
		 하지만 어나니머스 클래스를 만들어줌으로써 추상 클래스를 바로 오버라이드 할 수 있다. 
		 - 이미 만들어져있는 클래스를 호출하기 위한 간략한 방법.
		 */
		
		Weapon w1=new Weapon() {
			
			@Override
			public void attack() {
				
				System.out.println("그냥 공격!");
				
			}
		};
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
/*
Ctrl+Space = 어나니머스 클래스 자동 생성

1. 어나니머스 클래스 (익명의 클래스)
2. extends Weapon 클래스
3. new Weapon()은 이름 없는 클래스의 생성자를 호출했다고 간주한다.

<알아두기!>
어나니머스 클래스 = 일회용 클래스
객체를 생상할 때 { }를 붙이면 무조건 다 생성되는 것. 일반 클래스에서도 생긴다.
설계도 역할을 한번 하고 끝남.
*/