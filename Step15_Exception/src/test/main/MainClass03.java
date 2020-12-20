package test.main;

/*
 * Exception의 종류는 크게 두 가지이다.
 * 
 * 1.RuntimeException 을 상속 받아서 만든, 실행중에 발생하는 Exception
 * 2.RuntimeException 을 상속 받지 않아서 만든, 컴파일 (문법체크 중) 중에 발생하는 Exception
 */

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		try {
			
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
	}
}
/*
 * try catch를 선택적으로 사용할 수 있는 게 있는가 하면, 
 * 강제적으로 묶어야 하는 것도 있다.
 * (RuntimeException을 상속받지 않은 경우.)
 * 
 * 눈에 보이지 않는 실행의 흐름. 
 * 작업단위 Thread(스레드)
 * 
 * Thread.sleep(); - Thread를 일정시간 잠깐 재워두는 것.
 * try catch 문법을 꼭 사용해야 한다.
 * 
 */