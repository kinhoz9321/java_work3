package test.mypac;

import java.util.Set;

/*
 *  아래와 같이 설계된 클래스를 Dto (Data Transfer Object) 라고 한다.
 *  
 *  [ 만드는 방법 ]
 *  
 *  1. 필드의 접근 지정자는 private 로 지정
 *  2. 기본생성자와, 필드에 모든값을 전달받는 생성자 2개가 있어야 한다.
 *  3. 필드의 접근 메소드 setter, getter 메소드가 형식에 맞게 정의 되어 있어야 한다.
 */

public class MemberDto {
	
	/* 
	 * 필드의 접근 지정자를 private 로 하면 객체 '내부에서만 접근 가능 ' 하고
	 * '외부에서는 접근 불가능' 하다
	 * 디버깅 모드에서 확인할 수 있다.
	 */
	private int num;
	private String name;
	private String addr;
	
	/* 
	 * 기본(default) 생성자를 명시적으로 정의하기. 비워놓을지언정 만들어둬야 한다.
	 * 생성자는 얼마든지 다중 정의할수 있다. (객체의 생성자는 여러개 정의할 수 있다.)
	 * 다중 정의를 overloading 이라고 한다.
	 */
	
	public MemberDto() {}
	/*
	 * new MemberDto(){}
	 * new MemberDto(); 호출 시 이 생성자가 호출됨. 값이 0, null로 들어감.
	 */

	
	/*
	 * 객체를 new 할 때 호출되는 생성자.
	 * 메소드가와 똑같이 생겼지만 생성자(Constructor)이다.
	 * 
	 * [ 생성자의 특징 ]
	 * void가 없고, 클래스명과 동일하게 작성해야 한다.
	 * 생성자를 하나라도 만들면 기본 생성자(default)는 없어진다.
	 */
	
	//class명과 동일하게 생성자명 만들기. 다르면 오류남. 생성과 동시에 값이 들어간다.
	public MemberDto(int num,String name,String addr) {
		System.out.println("MemberDto() 생성자가 호출됨!");
		//생성자로 전달 받은 값을 필드에 저장하기
		this.num=num;
		this.name=name;
		this.addr=addr;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
//	필드의 num값을 리턴하는 getter 메소드
//	public int getNum() {
//		return num;
//	}
//
//	필드에 num값을 수정하는 setter 메소드
//	public void setNum(int num) {
//		this.num = num;
//	}
//	set, get 필드명의 첫글자는 대문자.
}

/* 
 * java는 매개변수를 정의할 때 데이터 타입을 선언해야 한다.
 * 
 * Class - field, Method, Constructor(생성자) 로 정의된다.
 * 
 * Dto(Data transfer object) 작성규약에 대해 알아두기.
 * setter, getter는 세트.
 * 
 * <물건을 예시로 객체 이해하기>
 * 객체 = 리모컨
 * 메소드 = 리모컨 버튼
 * 필드 = 리모컨의 부품 (필요에 따라 공개하는 필드 = 건전지)
 */







