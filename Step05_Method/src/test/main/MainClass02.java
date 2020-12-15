package test.main;

import test.mypac.House;

public class MainClass02 {
	public static void main(String[] args) {
		//House 클래스를 이용해서 여러분들이 집에서 편안하게 3번 쉬어보세요.
		//1. 새로운 객채 h1 생성.
		House h1=new House();
		
		//2. 객체 h1을 참조해서 relax 메소드 호출.
		h1.relax("홍주");
		h1.relax("홍주");
		h1.relax("홍주");
		
		//2-1. 반복문 for문 사용.
		for(int i=0; i<3; i++) {
			h1.relax("홍주");
		}
		
		//홍주가 100번 쉬려면?
		//1. 새로운 객체 h2 생성.
		House h2=new House();
		
		//2. 반복문 for문 사용. relax 메소드 호출.
		for(int i=0; i<100; i++) {
			h2.relax("홍주");
		}
	}
}
