package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		
		System.out.println("main 메소드가 시작 되었습니다.");
		
		float num1=10.1f;
		double num2=10.2d;
		
		/* 
		 * 범위가 double type 보다 작은 float type 변수에 담긴 값을
		 * double type 변수에 담는것은 가능하다. 
		 */
		
		double a=num1;
		
		/* 
		 * double type 변수에 있는 값을 float type 에 담을 때는
		 * 강제 Casting 이 필요하다.
		 */
		
		float b=(float)num2; 
	}
}







