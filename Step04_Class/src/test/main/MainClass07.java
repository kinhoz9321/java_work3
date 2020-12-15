package test.main;

import test.mypac.MemberDto;

public class MainClass07 {
	public static void main(String[] args) {
		//객체 생성과 동시에 필드에 저장할 값 전달하기 
		MemberDto dto1=new MemberDto(1, "김구라", "노량진");
		
		/*
		 * 생성자에 들어가야 할 값의 순서가 맞아야 하는데,
		 * 만약 전달할 값이 10개가 넘는다면 일일이 기억하기가 어려울 것이다.
		 * 그 와중에 우연히 같은 타입의 잘못된 값을 집어넣는다면 잘못된 내용이 들어가고 찾아내는 것도 어려울 것이다.
		 * 그럴 때 기본 메소드를 정의해서 set을 이용해 내용을 집어넣는다? 
		 */
		
		MemberDto dto2=new MemberDto(); 
		//기본 메소드를 정의해서 set을 이용해 내용을 집어넣는 일을 많이 한다.
		dto2.setNum(2);
		dto2.setName("해골");
		dto2.setAddr("행신동");
	}
}
/*
 * 나중에 해볼 작업 DB에서 셀렉트된 로우 하나에 dto를 담는다.
 * SELECT num, name, addr FROM member WHERE num=1;
 */







