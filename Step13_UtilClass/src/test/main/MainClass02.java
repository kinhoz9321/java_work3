package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass02 {
	public static void main(String[] args) {
		//한명의 회원정보라고 가정하자.
		int num=1;
		String name="김구라";
		String addr="노량진";
		boolean isMan=true;
		
		//동일한 회원정보를 HashMap 객체를 생성해서 담을 수도 있다. 
		//HashMap 객체를 생성해서 Map 인터페이스로 받은 모습
		Map<String, Object> map1=new HashMap<String, Object>();
		
		/*
		 * new HashMap<String, Object>(); -> String, Ojbect 생략 가능. 
		 * //제네릭은 타입을 받아줄 때만 잘 받으면 된다.
		 */
		
		map1.put("num", num);
		map1.put("name", name);
		map1.put("addr", addr);
		map1.put("isMan", isMan);
		
		//map1 을 이용해서 "num"이라는 키 값으로 저장된 int 불러오기
		int a=(int)map1.get("num");
		
		//map1 을 이용해서 "name"이라는 키 값으로 저장된 String 불러오기
		String b=(String)map1.get("name");
		
		//map1 을 이용해서 "addr"이라는 키 값으로 저장된 String 불러오기
		String c=(String)map1.get("addr");
		
		//map1 을 이용해서 "isMan"이라는 키 값으로 저장된 boolean 불러오기
		boolean d=(boolean)map1.get("isMan");
		
		//size=저장된 아이템의 갯수
		int size=map1.size(); //4
		
		//"addr"로 저장된 아이템 삭제하기
		map1.remove("addr");
		
		//모든 아이템 삭제하기
		map1.clear();
	}
}
