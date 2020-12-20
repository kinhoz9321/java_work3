package test.main;

import test.mypac.MyUtil;

public class MainClass06 {
	public static void main(String[] args) {
		MyUtil.draw();
		
		try {
			MyUtil.send();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/*
 * MyUtil 클래스에서 send 메소드를 throw 했기 때문에
 * MainClass06에서 send 메소드를 호출하면서 try catch로 묶어주게 되었다.
 * throws하게 되면 결국 어디에선가 묶어주어야만 한다.
 * 
 * draw(), send()
 * static 을 사용했기 때문에 클래스명.메소드 호출
 * 
 * static main 안에서 쓰기 위해 static 메소드로 만든 것 같다.
 * 
 * 만약 static을 사용하지 않았다면 
 * 새로운 MyUtil 객체를 생성 후 메소드를 호출.
 * 
 * MyUtil mu=new MyUtil();
 * mu.draw();
 */ 
