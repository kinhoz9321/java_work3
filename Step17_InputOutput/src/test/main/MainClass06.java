package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		//콘솔창에 출력할 수 있는 객체의 참조값을 ps라는 지역 변수에 담기
		PrintStream ps=System.out;
		//학습을 위해서 PrintStream 객체를 부모 type OutputStream 변수에 담기
		OutputStream os=ps;
		//OutputStream-OutputStreamWriter 로 기능 업 시키기(2byte 처리)
		OutputStreamWriter osw=new OutputStreamWriter(os);
		//기능을 좀 더 up 시키면
		BufferedWriter bw=new BufferedWriter(osw);
		
		try {
			
			bw.write("안녕하세요");
			bw.newLine();//개행기호를 출력해주는 기능이 있다.
			bw.write("어쩌구");
			bw.newLine();
			bw.write("저쩌구");
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
