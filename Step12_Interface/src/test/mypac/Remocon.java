package test.mypac;

/*
 [ interface ]
 - 추상 클래스와 거의 유사하다.
 - 생성자가 없다. (단독 객체 생성 불가) : new Remocon(); 할 수 없다는 말.
 - 구현된 메소드는 가질 수 없다. (추상 메소드만 가능)
 - 필드는 static final 상수(항상 같은 값)만 가질 수 있다.
 - data type의 역할을 할 수 있다. (참조값을 담는 타입의 역할을 할 수 있다.)
 - interface type의 참조값이 필요하다면 구현 (implements) 클래스를 이용해서 객체 생성을 해야한다.
 - 클래스는 단일 상속(extends)이지만 인터페이스는 다중 구현 (implements)가 가능하다
 - 사용할 일이 많다. 
 */

public interface Remocon {
	
	//필드
	public static final String COMPANY="LG";
	
	//메소드 (추상메소드만 가능 : abstract 는 interface에서 자동 설정이 되기 때문에 생략이 가능하다)
	public abstract void up();
	
	public void down();
}
/* 
 <알아두기!>
 - final 예약어가 필드나 지역변수에 붙으면 값이 수정 불가하다.
 - final 필드나 지역변수의 이름은 관례상 모두 대문자로 지정한다.
 - static final 은 생략이 가능하다 (*생략해도 자동으로 static final 이 된다.*)
 */

/* 
우리가 자바에서 주로 만드는 것

class : public class Car { } -> Car.java
abstract : public abstract class Weapon { } -> Weapon.java
interface : public interface Remocon { } -> Remocon.java

- class, abstract, interface 는 xxx.java로 저장이 된다.
- interface는 abstract보다 많이 사용된다.
- interface는 메소드의 모양을 추상메소드로 강제한다.
*/