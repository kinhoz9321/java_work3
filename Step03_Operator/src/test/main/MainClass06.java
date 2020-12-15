package test.main;
/*
 *  6. 3항 연산자 테스트
 */
public class MainClass06 {
	public static void main(String[] args) {
		
		boolean isWait=false;
		
		//1
		String result = isWait ? "기다려요" : "기다리지 않아요";
		System.out.println(result);
		
		/*
		 * 삼항 연산자는 콜론(:)의 좌측이나 우측에 있는 연산자가 결과로 남는다.
		 * true = 좌측, false = 우측
		 * 둘 중 하나의 값을 얻어내고 싶을 때 삼항 연산자를 사용한다.
		 * (1)isWait ? (2)"기다려요" : (3)"기다리지 않아요";
		 */
		
		//2
		String result2=null;
		if(isWait) {
			result2="기다려요";
		}else {
			result2="기다리지 않아요";
		}
		System.out.println(result2);
		
		/*
		 * 1,2 두개의 로직은 똑같다.
		 * 다만 if문을 간단히 쓰고 싶을 때 삼항 연산자를 사용한다.
		 */
		
		double result3=isWait ? 10.12 : 99.5;
		// 소수점 뒤에 아무것도 안붙이면 자동으로 double data type으로 인식된다.
		
		float result4=(float)(isWait ? 10.12 : 99.5);
		
		/*
		 * double type을 강제로 float type으로 만들고 싶다면?
		 * float type으로 casting 하기
		 * 삼항의 데이터 타입을 선언할 때는! 내부에 어떤 데이터가 있는지 * 확인 *을 하고 선언하기.
		 */
	}
}









