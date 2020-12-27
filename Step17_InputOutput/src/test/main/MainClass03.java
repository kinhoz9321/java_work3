package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		//키보드로 문자 입력받기
		InputStream kbd=System.in;
		//InputStream - InputStreamReader 로 기능 업 시키기
		InputStreamReader isr=new InputStreamReader(kbd);
		//inputStreamReader - BufferedReader 로 기능 업 시키기
		BufferedReader br=new BufferedReader(isr);
		
		try {
			
			System.out.println("문자열 입력(문장 가능):");
			String line=br.readLine();
			System.out.println("code:"+line);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
		
	}
}
/* 
 * BufferedReader(Reader) 리더는 인풋스트림 리더의 어미타입
 * 
 * Scanner BufferedReader와 똑같은 효과를 내지만 트라이캐치로 묶지 않아도 됨.
 */