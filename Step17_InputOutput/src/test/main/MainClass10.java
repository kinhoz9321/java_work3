package test.main;

import java.io.File;

public class MainClass10 {
	public static void main(String[] args) {
		
		//myFolder 파일 안에 gura 파일 100개 생성
		for(int i=0; i<100; i++) {
			File tmp=new File("c:/myFolder/gura"+i);
			tmp.mkdir();
		}
		System.out.println("오예!");
	}
}
