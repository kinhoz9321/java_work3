package test.mypac;

public class SmartPhone extends HandPhone{
	
	public SmartPhone() {
		System.out.println("SmartPhone() 생성자 호출됨");
	}
	
	public void doInternet() {
		System.out.println("인터넷을 해요!");
	}
	
	public void takePicture() {
		super.takePicture(); //부모 클래스의 takePicture을 호출
//		this.takePicture();
		System.out.println("1000만 화소의 사진을 찍어요!");
	}
}
/*
override(오버라이드)
- 부모 클래스에서 상속을 받지만 어떤 메소드는 자식 클래스에서 재정의 하겠다. 
- 오버라이드해서 우리가 원하는 기능을 직접 구현할 수 있다. 
- 오버라이드는 많이 쓰이는 기능 
 */