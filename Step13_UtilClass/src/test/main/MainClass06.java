package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 MemberDto 객체의 참조값을 담을 수 있는 ArrayList 객체를 생성해서
		 ArrayList 객체의 참조값을 List type 지역변수 members에 담기
		 */
		
		List<MemberDto> members=new ArrayList<MemberDto>();
		
		//3명의 회원 정보를 members 배열에 담아보세요. (3가지 타입 알아두기)
		
		/* 1 */
		MemberDto mem1=new MemberDto();
		mem1.setNum(1);
		mem1.setName("김구라");
		mem1.setAddr("노량진");
		members.add(mem1);
		
		/* 2 */
		MemberDto mem2=new MemberDto(2, "해골", "행신동");
		members.add(mem2);
		
		/* 3 */
		members.add(new MemberDto(3, "원숭이", "상도동"));
		
		/*
		 * members에 들어있는 참조값을 이용해서
		 * 반복문 돌면서 아래와 같은 형식으로 회원정보를 출력해보세요.
		 * 
		 * 번호는 1 이름은 김구라 주소는 노량진
		 * 번호는 2 이름은 해골 주소는 행신동
		 * 번호는 3 이름은 원숭이 주소는 상도동
		 */
		
		//일반 for 문 사용
		for (int i=0; i<members.size(); i++) {
			System.out.println(
					"번호는 "+members.get(i).getNum()+
					" 이름은 "+members.get(i).getName()+
					" 주소는 "+members.get(i).getAddr()
					);
		}
		
		//확장 for문 사용 
		for(MemberDto tmp:members) {
			System.out.println(
					"번호는 "+tmp.getNum()+
					" 이름은 "+tmp.getName()+
					" 주소는 "+tmp.getAddr()
					);
		}
		
		//[i]가 필요없을 때 확장 포문을 쓴다. 익숙해지기.
	}
}
/*
 * 핵심!
 * members.get(0) = mem1 이라는 것 알기.
 * 
 * 한 객체의 참조값이 여러군데 있을 수 있다.
 * 
 * ArrayList 안에는 index의 참조값이 배열로 관리된다.
 */