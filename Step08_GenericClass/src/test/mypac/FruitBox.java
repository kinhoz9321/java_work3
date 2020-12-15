package test.mypac;

public class FruitBox<T> {
	
	/*
	 * Generic class (포괄 클래스)
	 * - 어떤 타입이든 받아 줄 수 있다.
	 * - T에 Apple 타입을 넣겠다고 하면 Apple 타입이 들어가고,
	 * Banana type 을 넣겠다고 하면 Banana 타입이 들어간다.
	 * - Type 이라는 의미에서 T로 많이 쓴다.
	 * - <> 안에 들어가는 이름은 아무거나 상관없다.
	 * - FruitBox<T1,T2> 이렇게 여러개를 쓸 수도 있다.
	 * - class 안에서 <T> 는 전부 Type(미정)이라는 뜻. 내가 <T>에 무엇을 넣느냐에 따라 달라진다. 
	 */
	
	//필드
	public T item;
	
	//리턴 값이 없는 메소드
	public void setItem(T item) {
		this.item=item;
	}
	
	//리턴 값이 있는 메소드
	public T getItem() {
		return this.item;
	}
}
/* 
 * Generic class를 설계할 일은 거의 없다.
 * 다만, 사용할 일은 아주 많다.
 * 설계에 대해 배우는 이유는 설계를 익혀야 사용도 할 수 있기 때문이다.
 * 
 * Generic class는 하나의 문법이다.
 * 클래스를 하나만 만들어두고 용도에 따라 변형해서 사용할 수 있는 문법.
 * <T>를 익히면 된다. 
 */
