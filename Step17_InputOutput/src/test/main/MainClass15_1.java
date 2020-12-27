package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
 * 15_1,15_2 내용은 똑같은데 주석이 다름.
 * 
 * FileInputStream 객체를 이용해서
 * c:/myFolder/1.jpg 에서 byte 데이터를 읽어들여서
 * 
 * FileOutputStream 객체를 이용해서
 * c:/myFolder/copied.jpg 파일에 출력하기
 */

public class MainClass15_1 {
	public static void main(String[] args) {
		
		/*
		 * FileInputStream(File file)
		 * - 주어진 File 객체가 가리키는 파일을 바이트 스트림으로 읽기 위한
		 * FileInputStream 객체를 생성 (빈공간 만들어두기)
		 */
		FileInputStream fis=null;
		
		//FileOutputStream 파일로 바이트 단위의 출력을 내보내는 클래스
		FileOutputStream fos=null;
		
		try {
			//"c:/myFolder/1.jpg" 파일 바이트로 읽어오기
			fis=new FileInputStream(new File("c:/myFolder/1.jpg"));
			//"c:/myFolder/1.jpg" 파일 바이트로 출력하기
			fos=new FileOutputStream(new File("c:/myFolder/copied.jpg"));
			
			while(true) {//무한루프 수행
				int data=fis.read();
				System.out.println(data);
				
				/*
				 * //read() 메소드는 더이상 읽을 데이터가 없어서 
				 * -1 을 리턴하면 반복문 탈출. 
				 */
				
				if(data==-1) {
					break;
				}
				
				fos.write(data);//읽어온 data 출력준비
				fos.flush();//방출
			}
			
			System.out.println("파일을 성공적으로 복사 했습니다.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
			/* 
			 * [finally block]
			 * Exception이 일어나든 안나든 
			 * 꼭 해줘야 하는 일을 실행 
			 * ex)close();
			 */
		}finally {
			
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
