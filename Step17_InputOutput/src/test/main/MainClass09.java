package test.main;

import java.io.File;

public class MainClass09 {
	public static void main(String[] args) {
		
		//c:/myFolder 파일 객체 생성 myFile에 참조값 담기
		File myFile=new File("c:/myFolder");
		
		if(!myFile.exists()) {//만약 myFolder가 존재하지 않는다면
			
			myFile.mkdir();//myFolder directory 생성
			System.out.println("c:/myFolder를 생성했습니다.");
			
		}else {//만약 myFolder가 존재 한다면
			
			System.out.println("c:/myFolder는 이미 존재합니다.");
			
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
