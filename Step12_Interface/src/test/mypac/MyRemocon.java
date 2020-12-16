package test.mypac;

public class MyRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("볼륨을 올려요");
	}

	@Override
	public void down() {
		System.out.println("볼륨을 내려요");
	}
	
}
/*
 interface = implements (구현)
 class = extends (상속)
 
 인터페이스도 다형성에 참여를 한다.
 클래스는 아니지만 부모타입의 역할을 할 수 있다.
 */
