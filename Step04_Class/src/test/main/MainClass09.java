package test.main;

import test.mart.Computer;
import test.mart.Cpu;
import test.mart.HardDisk;
import test.mart.Memory;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 *  [ 프로그래밍의 목적 ]
		 *  
		 *  test.mart 페키지 안에 있는 클래스를 활용해서...
		 *  
		 *  1. 게임을 한다.
		 *  2. oli999@naver.com 으로 이메일을 보낸다.
		 */
		
//		Cpu cpu=new Cpu();
//		Memory mem=new Memory();
//		HardDisk hd=new HardDisk();
//		
//		//non static method이기 때문에 new를 해서 메소드를 호출한다.
//		Computer com1=new Computer(cpu, mem, hd);
//		com1.playGame();
//		com1.sendEmail("oli999@naver.com");
		
		// 강사님 풀이 1 (1회성으로 사용할 때)
		Computer com1=new Computer(new Cpu(), new Memory(), new HardDisk());
		com1.playGame();
		com1.sendEmail("oli999@naver.com");
		
		// 강사님 풀이 2
		Cpu cpu=new Cpu();
		Memory memory=new Memory();
		HardDisk hardDisk=new HardDisk();
		
		Computer com2=new Computer(cpu, memory, hardDisk);
		com2.playGame();
		com2.sendEmail("kbs-tv@daum.net");
	}
}












