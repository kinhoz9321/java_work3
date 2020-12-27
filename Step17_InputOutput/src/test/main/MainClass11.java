package test.main;

import java.io.File;

public class MainClass11 {
	public static void main(String[] args) {
		//*c:/myFolder 에 access 할 수 있는* File 객체 생성해서 참조값을 f에 담기
		File f=new File("c:/myFolder");
		
		//f("c:/myFolder") 참조값 안에 있는 파일목록 배열에 담기
		File[] files=f.listFiles();
		
		for(File tmp:files) {
			//반복문 돌면서 myFolder 파일 안에 있는 모든 파일 삭제하기
			tmp.delete();
		}
		
		System.out.println("c:myFolder 하위에 있는 모든 내용을 삭제 했습니다.");
	}
}
