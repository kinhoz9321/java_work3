package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		//*c:/에 access 할 수 있는* File 객체 생성해서 참조값을 myFile에 담기
		File myFile=new File("c:/");
		
		//c:/하위의 파일목록을 파일 배열로 얻어내기
		File[] files=myFile.listFiles();
		
		//확장 for문 사용하기
		for(File tmp:files) {
			if(tmp.isDirectory()) {//파일 디렉토리가 존재한다면
				System.out.println("[" +tmp.getName()+" ]");
			}else {//그렇지 않다면
				System.out.println(tmp.getName());
			}
		}
	}
}
