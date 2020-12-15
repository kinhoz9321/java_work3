package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass01 {
	public static void main(String[] args) {
		
		/*
		Weapon w1=new Weapon();
		
		참조값이 없는데 호출을 하려면 오류가 뜬다.
		w1.prepare();
		w1.attack();
		*/
		
		/*
		추상 클래스 단독으로는 객체 생성 불가!
		미완성의 클래스이지만 타입 역할은 할 수 있다.
		
		객체는 오버라이드한 자식 클래스로 생성하고
		타입은 추상클래스 (부모역할)로 받는다.
		추상 클래스는 설명서 역할에 충실하다.
		
		Weapon w1=new Weapon();
		*/ 
		
		Weapon w1=new MyWeapon();
		
		w1.prepare();
		w1.attack();
	}
}

/* 
 * 추상 클래스-연두색 동그라미 A
 */
