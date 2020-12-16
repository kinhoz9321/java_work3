package test.main;

import test.mypac.Remocon;

public class MainClass04 {

	public static void main(String[] args) {
		
		//implements Remocon { } 익명의 클래스 생성.
		Remocon r1=new Remocon() {
			//오버라이드를 강제시킴
			@Override
			public void up() {
				System.out.println("볼륨을 올려요");
			}
			
			@Override
			public void down() {
				System.out.println("볼륨을 내려요");
			}
		};
		
		//r1 지역변수에 담긴 값을 1번 사용해보기
		useRemocon(r1);
		
		//Remocon type의 참조값을 한번만 (일회성)으로 사용하기
		useRemocon(new Remocon() {
			
			@Override
			public void up() {
				System.out.println("커튼을 올려요");
			}
			
			@Override
			public void down() {
				System.out.println("커튼을 내려요");
			}
		});
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
