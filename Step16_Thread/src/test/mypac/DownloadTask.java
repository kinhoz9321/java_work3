package test.mypac;

/*
 *  새로운 작업단위(스레드) 를 만드는 방법 2
 *  
 *  1. Runnable 인터페이스를 구현한 클래스를 정의한다 
 *  
 *  2. Runnable 인터페이스의 추상메소드 run() 메소드를 오버라이드 한다.
 *  
 *  3. 해당클래스로 생성한 객체의 참조값을 Thread객체를 생성하면서 생성자의 인자로 전달한다.
 *  
 *  4. 생성된 Thread 객체의 start() 메소드를 호출하면 새로운 스레드가 시작된다. 
 *  
 *     새로운 작업단위에서 할 작업은 run() 메소드 안에 코딩하면 됩니다.
 */

public class DownloadTask implements Runnable{//1.

	@Override
	public void run() {//2.
		
		System.out.println("다운로드를 시작 합니다.");
		
		try {
			
			for(int i=1; i<=100; i++) {
				System.out.println(i+" %");
				Thread.sleep(100);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("다운로드를 완료 했습니다.");
		
	}

}
/*
 * Runnable 인터페이스는 구현할 메소드가 run() 하나 뿐인 함수형 인터페이스
 * (메소드가 run 하나 뿐이기 때문에 람다식 사용 가능)
 * 
 * 스레드를 실행시키는 2가지 방법(Thread 상속받기, Runnable 인터페이스 사용하기)으로 작성한 클래스의 스레드 실행 방법이 약간 다르다. 
 * 두 가지 클래스 모두 Thread 클래스의 start() 메소드를 통해서 실행시킬 수 있다. 
 * Thread를 확장한 MyThread 클래스의 경우, 
 * 해당 객체에 start() 메소드를 직접 호출할 수 있다. 
 * 반면에 Runnable을 구현한 MyRunnable 클래스의 경우에는, 
 * * Runnable 형 인자를 받는 생성자를 통해 * 별도의 Thread 객체를 생성 후 start() 메소드를 호출해야 합니다.
 */
