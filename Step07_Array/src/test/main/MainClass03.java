package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		
		String[] names= {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};
		
		//names에 저장된 문자열을 순서대로 콘솔창에 출력하기
		
		//나의 풀이
//		for(int i=0; i<names.length; i++) {
//			System.out.println(names[i]);
//		}
		
		//강사님의 자세한 풀이
		for(int i=0; i<names.length; i++) {
			//names 배열의 타입이 String 이기 때문에 String 타입으로 받아준다.
			String tmp=names[i];
			System.out.println(tmp);
		}
	}
}
/*
 * tmp = "Temporary(일시적인, 임시적인)"
 * 
 * syso를 적어주지 않으면 숫자만 쌓이다가 사라진다.
 * 디버그에서도 마찬가지, 아무 일도 일어나지 않음.
 */
