package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * HashSet 클래스는 Set 인터페이스를 구현한 클래스이다.
 * - 저장된 데이터를 순서없이 무작위로 관리한다.
 * - key 값도 없다.
 * - 중복을 허용하지 않는다. (같은 값이 2개 이상 존재할 수 없다.)
 * - 어떤 data를 묶음(집합)으로 관리하고자 할 때 사용한다.
 * - 중복된 데이터를 제거할 때도 유용하다.
 */

public class MainClass09 {
	public static void main(String[] args) {
		
		//정수(Integer) 값을 저장할 수 있는 HashSet 객체
		Set<Integer> set1=new HashSet<Integer>();
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(30);
		set1.add(30);
		//값을 중복되게 집어넣어도 1개만 남는다. ex)20,30
		
		//어떤 data가 set에 있는지 여부를 리턴하는 메소드
		boolean result1=set1.contains(10);
		boolean result2=set1.contains(50);
		
		//Set가 비어있는지 여부를 리턴
		boolean result3=set1.isEmpty();
		
		//Set의 size 리턴
		int size=set1.size();
		
		//Iterator (반복자) - Set안에 들어있는 아이템을 일렬로 세우는 것. 데이터를 얻어내는 것.
		Iterator<Integer> it=set1.iterator();
		
		//hasNext 메소드 [true=무한반복, false=반복그만]
		while(it.hasNext()) {
			Integer tmp=it.next();
			System.out.println(tmp);
		}
		
		/*
		 * 데이터와 커서가 있는데 커서 앞에 데이터가 있으면 true
		 * true면 데이터를 옆으로 넘기고 커서가 옮겨간다. 반복.
		 * 데이터가 커서 앞에 없으면 hasNext는 false를 말하고 끝남.
		 */
		
	}
}
//Set은 많이 쓰이지는 않지만 간혹 중복을 제거하기 위해 쓰인다.