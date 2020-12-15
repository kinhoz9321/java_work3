package test.main;

public class MainClass10 {
	public static void main(String[] args) {
		
		//기본 데이터 type
		int num1=10;
		double num2=10.1;
		char ch1='a';
		
		//참조 데이터 type
		String str="abcde12345";
		
		// length() 메소드는 문자열의 길이를 리턴한다. 
		int size=str.length(); //10
		
		//charAt() 메소드는 index로 주어진 값에 해당하는 문자를 리턴한다.
		char ch=str.charAt(5); //str의 5번째 index 값 = 1
		
		//소문자를 모두 대문자로 변환한 문자열 얻어내기
		String result=str.toUpperCase(); //ABCDE12345
	}
}







