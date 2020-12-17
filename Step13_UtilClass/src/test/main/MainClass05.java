package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		
		/* 
		 * 1. 문자열을 저장할 수 있는 ArrayList 객체를 생성하고
		 * 2. Scanner 객체를 이용해서 친구 이름을 반복문 돌면서 5개 입력 받아서
		 * 위에서 생성한 ArrayList 객체에 순서대로 저장을 하세요.
		 * 3. ArrayList 객체에 저장된 내용을 반복문 돌면서 순서대로 아래와 같은 형식으로 콘솔창에 출력해보세요.
		 * 
		 * 
		 * 0 번째 친구 이름 : 김구라
		 * 1 번째 친구 이름 : 해골
		 * 2 번째 친구 이름 : 원숭이
		 * 3 번째 친구 이름 : 주뎅이
		 * 4 번째 친구 이름 : 덩어리
		 */
		
		List<String> names=new ArrayList<String>();
		
		//계속 쓰이니까 변수 안에 넣어두고 사용하기
		Scanner scan=new Scanner(System.in);
		
		for(int i=0; i<5 ; i++) {
			
			//이 안에다 스캐너 객체를 생성하는 건 하나를 입력하고 버리는 것. (일회용)
			System.out.println("이름입력 : ");
			String print=scan.nextLine();
			names.add(print);
		}
		
		for(int i=0; i<names.size(); i++) {
			System.out.println(i+" 번째 친구 이름 : "+names.get(i));
		}
	}
}
/*
 * 눈여겨 봐야할 점 *
 1. 왜 1번 for문에서 i<5여야 하는가? 
 - names의 배열에 들어갈 방의 크기가 정해져 있지 않기 때문에 for문에서 정해서 값을 집어넣어야 한다.
 2. 2번 for문에서 i<names.length(); 가 아니라 i<names.size();를 사용할 것! 자바에서 방의 크기는 size();로 표현한다.
 3. 2번 for문에서 names[i]=names.get(i); 기억할 것!
*/