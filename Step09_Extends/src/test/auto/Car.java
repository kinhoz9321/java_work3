package test.auto;

//class의 접근 지정자 public
public class Car {
	
	//protected 접근 지정자를 가진 필드
	protected Engine engine;
	
	//Engine type을 인자로 전달받는 생성자
	public Car(Engine engine) {
		this.engine=engine;
	}
	
	/* 
	 * 생성자의 인자로 전달한 것은 필드에 저장 했다가 메소드에서 사용한다.
	 * 필드는 메소드에서 사용되는 부품들을 많이 담고 있다.
	 */
	
	// 메소드
	public void drive() {
		
		if(this.engine==null) {
			System.out.println("Engine 이 없어서 달릴 수가 없어요!");
			return;
			
		}
		System.out.println("달려요!");
	}
}
/*
class의 접근 지정자 
- import 가능 여부를 지정해주는 것.
- 종류 2가지. (public, default)
- 대부분 public을 사용한다. import를 해야 해당 class를 사용할 수 있기 때문에.
- default는 상당히 드문 경우.

<필드, 메소드, 생성자의 접근 지정자의 종류 4가지>

public > protected > default > private

1. public (전체공개)
- 어디에서든 접근할 수 있다.

2. protected (부분공개)
- 같은 패키지 혹은 다른 패키지이지만 상속관계일 경우 공개하는 지정자.

3. default (부분공개)
- 지정자를 아무것도 작성하지 않았을 때 디폴트 지정자가 생성된다. 
- 같은 패키지 일때만 공개. 

4. private (비공개)
- Object(생성 객체)와 자신의 Class 내부에서만 공개. 
*/
