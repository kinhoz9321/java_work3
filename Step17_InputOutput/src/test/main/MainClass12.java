package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 1. c:/myFolder/memo.txt 파일을 만들고
 * 2. "김구라" "해골" "원숭이" "주뎅이" "덩어리" 문자열을 파일에 출력하기
 */

public class MainClass12 {
	public static void main(String[] args) {
		
		//*c:/myFolder/memo.txt 에 access 할 수 있는* File 객체 생성해서 참조값을 f에 담기
		File f=new File("c:/myFolder/memo.txt");
		
		try {
			if(f.exists()) {//만약 f가 존재한다면
				
				//새로운 파일 생성 (memo.txt)
				f.createNewFile();
				
				/*
				 * createNewFile()
				 * 
				 * boolean 값을 리턴하는 메소드
				 * true 면 새로운 파일을 생성하고
				 * false 면 이미 존재하는 파일이라 생성 실패
				 */
				
				System.out.println("memo.txt 파일을 생성했습니다.");
				
			}//if 끝
			
			//file로 지정된 파일(f)에 대한 출력 스트림을 생성한다.
			FileWriter fw=new FileWriter(f);
			
			fw.write("김구라");
			fw.write("\r\n");
			fw.write("해골");
			fw.write("\r\n");
			fw.write("원숭이");
			fw.write("\r\n");
			fw.write("주뎅이");
			fw.write("\r\n");
			fw.write("덩어리");
			
			fw.flush();//방출. 출력.
			fw.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
