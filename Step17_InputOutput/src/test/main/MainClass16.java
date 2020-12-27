package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
 * FileInputStream 객체를 이용해서
 * c:/myFolder/1.jpg 에서 byte 데이터를 읽어들여서
 * 
 * FileOutputStream 객체를 이용해서
 * c:/myFolder/copied.jpg 파일에 출력하기
 */

public class MainClass16 {
	public static void main(String[] args) {
		
		//FileInputStream type 의 참조값을 담을 지역변수 미리 만들기
		FileInputStream fis=null;
		//FileOutputStream type 의 참조값을 담을 지역변수 미리 만들기 
		FileOutputStream fos=null;
		
		try {
			//파일로 부터 byte 알갱이를 읽어들일수 있는 객체 생성
			fis=new FileInputStream(new File("c:/myFolder/1.jpg"));
			//파일에 byte 알갱이를 출력할수 있는 객체 생성 
			fos=new FileOutputStream(new File("c:/myFolder/copied.jpg"));
			
			//byte를 1024개씩 담을 수 있는 배열 객체 생성
			byte[] buffer=new byte[1024];
			
			while(true) {
				//1024byte 읽어들이기
				int readedcount=fis.read(buffer);
				if(readedcount==-1) {//더이상 읽을 데이터가 없으면
					break;//while 반복문 탈출
				}
				fos.write(buffer, 0, readedcount);
				/*
				 * fos.write(b, off, len);
				 * 입력 스트림으로부터 b[]크기의 자료를 
				 * off 인덱스부터 len 개수만큼 읽음, 
				 * 읽은 자료의 바이트 수 반환
				 */
			}
			System.out.println("파일을 성공적으로 복사했습니다.");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			}catch (Exception e) {}
		}
	}
}
/*
[알아두기!]

byte[] buffer=new byte[1024];
이 때 buffer byte 배열이 읽어들이는 방식은 한번에 1024개를 담는 것이 아니다.
하나하나씩 1024개를 담는 것이다. (배구 경기 스코어 넘기듯)
그래서 만약 마지막 1024번째 바이트를 담고 나면 남은 칸에는 그 전의 1024개의 나머지 byte 값이 담겨있다.
그렇게 되면 이미지 파일이 깨진다.

그러므로 fos.write(b, off, len);
메소드를 통해서 담을 byte의 갯수를 지정(len)해주어야 한다.
byte가 타라라라 바뀌다가 더 이상 옮겨올 데이터가 없으면 멈춘다.
-1이 되면서 반복문 탈출!
*/