package test.mypac;

public class MyUtil {
	public static void draw() {
		System.out.println("5초 동안 그림을 그려요.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void send() throws InterruptedException {
		System.out.println("5초 동안 전송을 해요!");
		Thread.sleep(5000);//try catch로 묶지 않고 throws 함
		System.out.println("전송을 완료 했습니다.");
	}
}
