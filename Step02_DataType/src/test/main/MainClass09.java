package test.main;

public class MainClass09 {
	public static void main(String[] args) {
		
		/*
		 * 변수를 미리 만들어 두고 값을 나중에 대입해서 사용할거라면 기본값을 대입해 두는것이 좋다.
		 * 정수형과 실수형의 기본값 = 0
		 */
		
		int num1=0;
		
		for(int i=0; i<10; i++) {
			num1 = num1+1;
		}
		
		System.out.println(num1); //10
		
		//참조 데이터 type 이 담길수 있는 빈 공간은 null 을 이용해서 만든다. 
		String str=null;
		
		str="블라블라";
		
		System.out.println(str); //str 출력
	}
}




