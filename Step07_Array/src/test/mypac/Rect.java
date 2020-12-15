package test.mypac;

public class Rect {

	//필드 (width=폭, height=넓이)
	private int width;
	private int height;
	
	//생성자
	//생성자의 인자로 width와 height를 전달 받아서 필드에 저장하는 생성자를 정의해보세요. 
	public Rect(int width, int height) {
		
		//필드=지역변수;
		this.width=width;
		this.height=height;
	}
	
	//메소드
	//필드에 저장된 width와 height를 이용해서 사각형의 넓이를 리턴하는 메소드를 정의해보세요. 메소드명은 getArea()로 해서 만들어보세요.
	public int getArea() {
		
		return this.width*this.height;
		//this 생략 가능
	}
}
/* 
 * Rect 클래스
 * 
 * public(공개) - 생성자, 메소드
 * private(비공개) - 필드
 */