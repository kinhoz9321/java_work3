package test.main;

/* 
 * 스레드를 이용해서 1초마다 숫자가 출력되게 만들기
 */

public class MainClass04 {
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			
			try {
				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			System.out.println(i);
		}
	}
}
