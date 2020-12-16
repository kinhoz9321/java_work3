package test.main;

import test.mypac.Drill;

public class MainClass05 {

	public static void main(String[] args) {
		
		useDrill(new Drill() {
			
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 3개 뚫어요");
			}
		});
		
		//useDrill(()->{}); : 에로우 표현식(메소드가 하나인 경우에만 사용가능)
		
		useDrill(()->{
			System.out.println("천장에 구멍을 3개 뚫어요");
		});
		
		/*
		 아래의 줄임 표현
		 new Drill() {
			
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 3개 뚫어요");
			}
		}
		 */
		
		//인터페이스의 에로우 표현식
		Drill d1=()->{
			System.out.println("아무데나 뚫어요!");
		};
		useDrill(d1);
	}
	
	public static void useDrill(Drill d) {
		d.hole();
	}
}
/*
 자바는 메소드를 호출하면서 메소드를 전달할 수 없다.
 참조값을 전달해야 한다. 
 */
