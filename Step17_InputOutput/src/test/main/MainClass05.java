package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		//콘솔창에 출력할 수 있는 객체의 참조값을 ps라는 지역 변수에 담기
		PrintStream ps=System.out;
		//학습을 위해서 PrintStream 객체를 부모 type OutputStream 변수에 담기
		OutputStream os=ps;
		//OutputStream-OutputStreamWriter 로 기능 업 시키기(2byte 처리)
		OutputStreamWriter osw=new OutputStreamWriter(os);
		
		try {
			osw.write("안녕하세요!");
			osw.write("\r\n");//개행기호
			osw.write("어쩌구");
			osw.write("\r\n");
			//개행기호 둘중에 하나만 써도 되는데 어떤 곳에서는 \r\n둘다 써야하는 곳도 있다. 그래서 둘 다 붙여쓰면 더 좋음.
			osw.write("저쩌구");
			os.flush();//방출. flush() 하는 시점에 출력된다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
