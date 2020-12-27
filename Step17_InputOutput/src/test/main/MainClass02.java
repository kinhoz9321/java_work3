package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		//키보드로 문자 입력받기
		InputStream kbd=System.in;
		//InputStream - InputStreamReader 로 기능 업 시키기
		InputStreamReader isr=new InputStreamReader(kbd);
		
		try {
			
			System.out.println("1글자 입력(한글 가능):");
			int code=isr.read();//read() try catch 묶기
			System.out.println("code:"+code);
			char ch=(char)code;
			System.out.println("ch"+ch);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
		
	}
}
/* 
 * InputStreamReader 는 한글도 가능. 기능을 업시켰다. 
 * 하지만 String 타입을 리턴해주지는 않는다. 
 */