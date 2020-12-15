package test.main;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		// void는 어떤 값도 리턴해주지 않는다 못박아두는 것.
		
		// MemberDto 객체 생성해서 참조값을 dto1 이라는 이름의 지역변수에 담기 
		MemberDto dto1=new MemberDto(1, "김구라", "노량진");
		MemberDto dto2=new MemberDto(2, "해골", "행신동");
		
		// dto1.num=1;
		dto1.setNum(999); //setter 메소드를 이용해서 객체에 값 전달하기
		/*
		 * setter 메소드는 수정용으로 사용한다.
		 * field를 비공개로 해놓았지만 setter 메소드를 이용해서 값을 수정할 수 있다.
		 */
		
		
		// int num=dto1.num; 
		int num=dto1.getNum(); //getter 메소드를 이용해서 객체로부터 값 받아오기 
		
		//dto1.name="이정호";
		dto1.setName("이정호");
		
		//String name=dto1.name;
		String name=dto1.getName(); //getName은 String type을 리턴해주니, 받을 때 String type으로 받아야 한다. 
		
		//dto1.addr="아현동";
		dto1.setAddr("아현동");
		
		//String addr=dto1.addr;
		String addr=dto1.getAddr();
	}
}

/*
 * 초기화 작업을 할 게 있을 때, 준비 작업이 필요하면 생성자에서 준비를 하면 된다.
 * 생성자가 어떤 값을 전달 받으려면 전달 받을 준비가 되어있어야 한다.
 * 생성자의 매개변수를 정의할 수 있다.
 * 
 * <알아두기!>
 * set 수정할 때 사용
 * get 참조할 때 사용
 */










